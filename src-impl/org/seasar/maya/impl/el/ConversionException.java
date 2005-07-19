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
package org.seasar.maya.impl.el;

/**
 * �����������͎����s���ʂ̌^�ϊ����̗�O�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public class ConversionException extends ExpressionException {

	private static final long serialVersionUID = -485430528770416298L;

	private Class _expectedType;
    private Object _expressed;
    
    /**
     * @param expectedType ���҂��ꂽ�^�B
     * @param expressed �����s���ʌ^�B
     */
    public ConversionException(Class expectedType, Object expressed) {
        _expectedType = expectedType;
        _expressed = expressed;
    }
    
    /**
     * ���炩���ߓo�^�������҂̌^���擾����B
     * @return ���҂��ꂽ�^�B
     */
    public Class getExpectedType() {
        return _expectedType;
    }
    
    /**
     * �����s���ʃI�u�W�F�N�g�̎擾�B
     * @return �����s���ʁB
     */
    public Object getExpressed() {
        return _expressed;
    }
    
}
