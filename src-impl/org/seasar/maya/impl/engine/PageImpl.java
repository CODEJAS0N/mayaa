/*
 * Copyright (c) 2004-2005 the Seasar Project and the Others.
 *
 * Licensed under the Seasar Software License, v1.1 (aka "the License"); you may
 * not use this file except in compliance with the License which accompanies
 * this distribution, and is available at
 *
 *     http://www.seasar.org/SEASAR-LICENSE.TXT
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.seasar.maya.impl.engine;

import java.io.Serializable;
import java.util.Iterator;

import javax.servlet.jsp.PageContext;

import org.seasar.maya.el.CompiledExpression;
import org.seasar.maya.el.ExpressionFactory;
import org.seasar.maya.engine.Engine;
import org.seasar.maya.engine.Page;
import org.seasar.maya.engine.Template;
import org.seasar.maya.engine.specification.Specification;
import org.seasar.maya.impl.CONST_IMPL;
import org.seasar.maya.impl.builder.PageNotFoundException;
import org.seasar.maya.impl.engine.specification.SpecificationImpl;
import org.seasar.maya.impl.util.EngineUtil;
import org.seasar.maya.impl.util.ExpressionUtil;
import org.seasar.maya.impl.util.SpecificationUtil;
import org.seasar.maya.impl.util.StringUtil;
import org.seasar.maya.provider.EngineSetting;
import org.seasar.maya.provider.ServiceProvider;
import org.seasar.maya.provider.factory.ServiceProviderFactory;
import org.seasar.maya.source.SourceDescriptor;
import org.seasar.maya.source.factory.SourceFactory;

/**
 * @author Masataka Kurihara (Gluegent, Inc)
 */
public class PageImpl extends SpecificationImpl
        implements Page, Serializable, CONST_IMPL {

    private Engine _engine;
    private String _pageName;
    private String _extension;

    /**
     * @param parent �Ăяo����Engine�������͖��ߍ��ݐ�e���v���[�g�B
     * @param pageName �y�[�W���B
     * @param extension �y�[�W�g���q�B
     */
    public PageImpl(Specification parent, String pageName, String extension) {
        super(QM_PAGE, parent);
        if(StringUtil.isEmpty(pageName)) {
            throw new IllegalArgumentException();
        }
        if(parent instanceof Engine) {
            _engine = (Engine)parent;
        } else if(parent instanceof Template) {
            Template template = (Template)parent;
            _engine = template.getPage().getEngine();
        } else {
            throw new IllegalArgumentException();
        }
        _pageName = pageName;
        _extension = extension;
    }
    
    public String getKey() {
        return EngineUtil.createPageKey(getPageName(), getExtension());
    }
    
    public Engine getEngine() {
        return _engine;
    }

    public String getPageName() {
        return _pageName;
    }

    public String getExtension() {
        return _extension;
    }

    /**
     * �T�[�r�X���ׂ��e���v���[�g�ڔ����̎擾�B
     * @param context �X�e�[�g�t�������t�@�T�[�h�����R���e�L�X�g�B
     * @return �e���v���[�g�ڔ����������́A�[����������null�i�f�t�H���g�e���v���[�g�j�B
     */
    protected String getTemplateSuffix(PageContext context) {
        if(context == null) {
            throw new IllegalArgumentException();
        }
        String expression = SpecificationUtil.findAttributeValue(this, QM_TEMPLATE_SUFFIX);
        if(StringUtil.hasValue(expression)) {
            ServiceProvider provider = ServiceProviderFactory.getServiceProvider();
            ExpressionFactory expressionFactory = provider.getExpressionFactory();
            CompiledExpression action = 
                expressionFactory.createExpression(expression, String.class);
            return (String)action.getValue(context);
        }
        return "";
    }

    private Template findTemplate(String suffix) {
        String key = EngineUtil.createTemplateKey(suffix);
        for(Iterator it = iterateChildSpecification(); it.hasNext(); ) {
            Object obj = it.next();
            if(obj instanceof Template) {
	            Template template = (Template)obj;
	            if(key.equals(template.getKey())) {
	                return template;
	            }
            }
        }
        return null;
    }
    
    /**
     * �e���v���[�g�ڔ������K�؂�Template�I�u�W�F�N�g�����[�h���ĕԂ��B
     * �e���v���[�g�ڔ����ɑΉ�����Template��������Ȃ��ꍇ�́A�e���v���[�g�ڔ����̖����A
     * �u�f�t�H���g�e���v���[�g�v��Ԃ��B
     * @param suffix �e���v���[�g�ڔ����B
     * @return �����_�����O����e���v���[�g�B
     */
    protected synchronized Template getTemplate(String suffix) {
        if(suffix == null) {
            throw new IllegalArgumentException();
        }
        Template template = findTemplate(suffix);
        if(template == null) {
            StringBuffer name = new StringBuffer(_pageName);
            if(StringUtil.hasValue(suffix)) {
                EngineSetting setting = getEngine().getEngineSetting();
                name.append(setting.getSuffixSeparator());
                name.append(suffix);
            }
            String extension = getExtension();
            if(StringUtil.hasValue(extension)) {
                name.append(".").append(extension);
            }
            String path = PREFIX_PAGE + name.toString();
            ServiceProvider provider = ServiceProviderFactory.getServiceProvider();
	        SourceFactory factory = provider.getSourceFactory();
            SourceDescriptor source = factory.createSourceDescriptor(path);
            if(source.exists()) {
                template = new TemplateImpl(this, suffix);
                template.setSource(source);
                addChildSpecification(template);
            }
        }
        return template;
    }

    public Template getTemplate(PageContext context, String requestedSuffix) {
        if(context == null) {
            throw new IllegalArgumentException();
        }
        String suffix;
        if(StringUtil.hasValue(requestedSuffix)) {
            suffix = requestedSuffix;
        } else {
            suffix = getTemplateSuffix(context);
        }
        Template template = getTemplate(suffix);
        if(template == null && StringUtil.hasValue(suffix) &&
                StringUtil.isEmpty(requestedSuffix)) {
            template = getTemplate("");
        }
        if(template == null) {
            throw new PageNotFoundException(getKey());
        }
        return template;
    }

    public int doPageRender(PageContext context, String requestedSuffix) {
    	EngineUtil.setPage(context, this);
        ExpressionUtil.execEvent(this, QM_BEFORE_RENDER, context);
        Template template = getTemplate(context, requestedSuffix);
        int ret = template.doTemplateRender(context, null);
        ExpressionUtil.execEvent(this, QM_AFTER_RENDER, context);
        EngineUtil.removePage(context);
        return ret;
    }

}
