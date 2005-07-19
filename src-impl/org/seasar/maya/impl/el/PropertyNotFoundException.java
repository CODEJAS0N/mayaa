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
 * Expression�e���\�b�h�ŁA�����̃A�N�Z�X�v���p�e�B�����݂��Ȃ��Ƃ��ɔ��������O�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public class PropertyNotFoundException extends ExpressionException {
    
	private static final long serialVersionUID = -5888901658424559272L;

	private Object _target;
    private Object _property;
    
    /**
     * @param target �v���p�e�B��������Ȃ������^�[�Q�b�g�I�u�W�F�N�g�B
     * @param property ������Ȃ������v���p�e�B�B
     */
    public PropertyNotFoundException(Object target, Object property) {
        _target = target;
        _property = property;
    }
    
    /**
     * �^�[�Q�b�g�I�u�W�F�N�g�̎擾�B
     * @return �^�[�Q�b�g�I�u�W�F�N�g�B
     */
   public Object getTarget() {
        return _target;
    }
    
   /**
    * ������Ȃ������v���p�e�B�̎擾�B
    * @return �v���p�e�B�B������������̓C���f�b�N�X�l�B
    */
    public Object getProperty() {
        return _property;
    }
    
}
