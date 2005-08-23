/*
 * Copyright (c) 2004-2005 the Seasar Foundation and the Others.
 * 
 * Licensed under the Seasar Software License, v1.1 (aka "the License");
 * you may not use this file except in compliance with the License which 
 * accompanies this distribution, and is available at
 * 
 *     http://www.seasar.org/SEASAR-LICENSE.TXT
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either 
 * express or implied. See the License for the specific language governing 
 * permissions and limitations under the License.
 */
package org.seasar.maya.impl.engine.error;

import org.seasar.maya.cycle.ServiceCycle;
import org.seasar.maya.engine.Engine;
import org.seasar.maya.engine.Page;
import org.seasar.maya.engine.error.ErrorHandler;
import org.seasar.maya.impl.builder.PageNotFoundException;
import org.seasar.maya.impl.util.CycleUtil;
import org.seasar.maya.impl.util.SpecificationUtil;
import org.seasar.maya.impl.util.StringUtil;

/**
 * ��O�N���X���ɉ������e���v���[�g�ɂ���ė�O����\������B
 * folder�p�����[�^�l�̎����t�H���_�����ɒu���ꂽ�A��O�N���X���y�[�W�𗘗p����B
 * ���Ƃ��΁A/WEB-INF/errorPage/java.lang.IllegalArgumentException.html �ȂǁB
 * �e���v���[�g�y�[�W���ł́A�y�[�W�X�R�[�v�̃I�u�W�F�N�g�uTHROWABLE�v�Ŕ�������
 * ��O���擾���邱�Ƃ��ł���B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public class TemplateErrorHandler  implements ErrorHandler {

    public static final String THROWABLE = "THROWABLE";
    
    private String _folder = "/"; 
    
    private String getPageName(Class throwableClass) {
        String name = throwableClass.getName();
    	return StringUtil.preparePath(_folder) + StringUtil.preparePath(name);
    }
    
    public void setParameter(String name, String value) {
        if("folder".equals(name)) {
        	if(StringUtil.isEmpty(value)) {
        		throw new IllegalArgumentException();
        	}
            _folder = value;
        }
    }
    
    public void doErrorHandle(Throwable t) {
        if(t == null) {
            throw new IllegalArgumentException();
        }
        ServiceCycle cycle = CycleUtil.getServiceCycle();
        cycle.setAttribute(THROWABLE, t);
        Engine engine = SpecificationUtil.getEngine();
        try {
            for(Class throwableClass = t.getClass(); 
            		throwableClass != null; 
            		throwableClass = throwableClass.getSuperclass()) {
                try {
                    String pageName = getPageName(throwableClass);
                	Page page = engine.getPage(pageName, "html");
                    page.doPageRender();
    	            break;
                } catch(PageNotFoundException ignore) {
                }
            }
        } finally {
            cycle.removeAttribute(THROWABLE);
        }
    }
    
}
