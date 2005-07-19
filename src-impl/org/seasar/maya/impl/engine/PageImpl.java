/*
 * Copyright (c) 2004-2005 the Seasar Foundation and the Others.
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

import org.seasar.maya.cycle.ServiceCycle;
import org.seasar.maya.cycle.el.CompiledExpression;
import org.seasar.maya.cycle.el.ExpressionFactory;
import org.seasar.maya.engine.Engine;
import org.seasar.maya.engine.Page;
import org.seasar.maya.engine.Template;
import org.seasar.maya.engine.processor.TemplateProcessor.ProcessStatus;
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

	private static final long serialVersionUID = -8688634709901129128L;

	private Engine _engine;
    private String _pageName;
    private String _extension;

    /**
     * @param parent 呼び出し元Engineもしくは埋め込み先テンプレート。
     * @param pageName ページ名。
     * @param extension ページ拡張子。
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

    protected String getTemplateSuffix(ServiceCycle cycle) {
        if(cycle == null) {
            throw new IllegalArgumentException();
        }
        String expression = SpecificationUtil.findAttributeValue(this, QM_TEMPLATE_SUFFIX);
        if(StringUtil.hasValue(expression)) {
            ServiceProvider provider = ServiceProviderFactory.getServiceProvider();
            ExpressionFactory expressionFactory = provider.getExpressionFactory();
            CompiledExpression action = 
                expressionFactory.createExpression(expression, String.class);
            return (String)action.getValue(cycle);
        }
        return "";
    }

    protected Template findTemplate(String suffix) {
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
     * テンプレート接尾辞より適切なTemplateオブジェクトをロードして返す。
     * テンプレート接尾辞に対応したTemplateが見つからない場合は、テンプレート接尾辞の無い、
     * 「デフォルトテンプレート」を返す。
     * @param suffix テンプレート接尾辞。
     * @return レンダリングするテンプレート。
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

    public Template getTemplate(ServiceCycle cycle, String requestedSuffix) {
        if(cycle == null) {
            throw new IllegalArgumentException();
        }
        String suffix;
        if(StringUtil.hasValue(requestedSuffix)) {
            suffix = requestedSuffix;
        } else {
            suffix = getTemplateSuffix(cycle);
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

    public ProcessStatus doPageRender(ServiceCycle cycle, String requestedSuffix) {
        if(cycle == null) {
            throw new IllegalArgumentException();
        }
    	EngineUtil.setPage(cycle, this);
        ExpressionUtil.execEvent(this, QM_BEFORE_RENDER, cycle);
        Template template = getTemplate(cycle, requestedSuffix);
        ProcessStatus ret = template.doTemplateRender(cycle, null);
        ExpressionUtil.execEvent(this, QM_AFTER_RENDER, cycle);
        EngineUtil.setPage(cycle, null);
        return ret;
    }

}
