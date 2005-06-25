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
 *
 * Created on 2005/03/26
 */
package org.seasar.maya.standard.engine.processor.jstl.fmt;

import org.seasar.maya.engine.Template;
import org.seasar.maya.impl.MayaException;

/**
 * �l�C�e�B�u JSTL �^�O�ɃZ�b�g�����������s���ȗ�O�B
 * @author suga
 */
public class IllegalTagAttributeException extends MayaException {
    /** ������������Ȃ������e���v���[�g */
    private Template _template;
    /** �Ώۂ̃^�O�̖��O */
    private String _tagName;
    /** �s���Ȓl���n���ꂽ�����̖��O */
    private String _attributeName;
    /** �s���Ȓl */
    private Object _attributeValue;
    /** ���������͗�Ȃǂ̃��b�Z�[�W */
    private String _message;

    public IllegalTagAttributeException(
            Template template, String tagName,
            String attributeName, Object attributeValue, String message) {
        _template = template;
        _tagName = tagName;
        _attributeName = attributeName;
        _attributeValue = attributeValue;
        _message = message;
    }

    public String getAttributeName() {
        return _attributeName;
    }

    public Object getAttributeValue() {
        return _attributeValue;
    }

    public String getMessage() {
        return _message;
    }

    public String getTagName() {
        return _tagName;
    }

    public Template getTemplate() {
        return _template;
    }

    public void setTemplate(Template template) {
        _template = template;
    }
}
