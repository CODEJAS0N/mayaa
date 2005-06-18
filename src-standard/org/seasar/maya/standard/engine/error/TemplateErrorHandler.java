/*
 * Copyright (c) 2004-2005 the Seasar Project and the Others.
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
package org.seasar.maya.standard.engine.error;

import java.io.IOException;

import javax.servlet.jsp.PageContext;

import org.seasar.maya.engine.Engine;
import org.seasar.maya.engine.error.ErrorHandler;
import org.seasar.maya.impl.builder.PageNotFoundException;
import org.seasar.maya.impl.util.EngineUtil;
import org.seasar.maya.impl.util.StringUtil;

/**
 * ��O�N���X���ɉ������e���v���[�g�ɂ���ė�O����\������B
 * errorTemplateRoot�l�̃t�H���_�����ɒu���ꂽ�A��O�N���X���y�[�W�𗘗p����B���Ƃ��΁A
 * /WEB-INF/error/java.lang.IllegalArgumentException.html �ȂǁB
 * �e���v���[�g�y�[�W���ł́A�y�[�W�X�R�[�v�̃I�u�W�F�N�g�uTHROWABLE�v
 * �Ŕ���������O���擾���邱�Ƃ��ł���B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public class TemplateErrorHandler  implements ErrorHandler {

    public static final String THROWABLE = "THROWABLE";
    
    private String _errorTemplateRoot = "/WEB-INF/error"; 
    
    private String getPageName(Class throwableClass) {
    	return _errorTemplateRoot + "/" + throwableClass.getName();
    }
    
    public void putParameter(String name, String value) {
        if("errorTemplateRoot".equals(name)) {
        	if(StringUtil.isEmpty(value)) {
        		throw new IllegalArgumentException();
        	}
            _errorTemplateRoot = StringUtil.preparePath(value);
        }
    }
    
    public void doErrorHandle(PageContext context, Throwable t) throws IOException {
        if(t == null || context == null) {
            throw new IllegalArgumentException();
        }
        context.setAttribute(THROWABLE, t);
        Engine engine = EngineUtil.getEngine(context);
        try {
            for(Class throwableClass = t.getClass(); 
            		throwableClass != null; 
            		throwableClass = throwableClass.getSuperclass()) {
                try {
                	String pageName = getPageName(throwableClass);
		            engine.doService(context, pageName, "", "html");
		            break;
                } catch(IOException e) {
                	throw e;
                } catch(PageNotFoundException ignore) {
                }
            }
        } finally {
            context.removeAttribute(THROWABLE);
        }
    }
    
}
