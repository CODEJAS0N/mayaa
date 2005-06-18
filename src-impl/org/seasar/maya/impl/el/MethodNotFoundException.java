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
package org.seasar.maya.impl.el;

/**
 * Expression�e���\�b�h�ŁA�����̃��\�b�h�����݂��Ȃ��Ƃ��ɔ��������O�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public class MethodNotFoundException extends ExpressionException {
    
    private Object _target;
    private String _methodName;
    private Object[] _args;
    private boolean _staticCall;
    
    /**
     * @param target ���\�b�h��������Ȃ������^�[�Q�b�g�I�u�W�F�N�g�A�������̓N���X�^�B
     * @param methodName ������Ȃ��������\�b�h���B
     */
    public MethodNotFoundException(Object target, 
            String methodName, Object[] args, boolean staticCall) {
        _target = target;
        _methodName = methodName;
        if(_args != null) {
            _args = args;
        } else {
            _args = new Object[0];
        }
        _staticCall = staticCall;
    }
    
    /**
     * �^�[�Q�b�g�I�u�W�F�N�g�̎擾�B
     * @return �^�[�Q�b�g�I�u�W�F�N�g�A�������̓N���X�^�B
     */
   public Object getTarget() {
        return _target;
    }
    
   /**
    * ������Ȃ��������\�b�h�̎擾�B
    * @return ���\�b�h���B
    */
    public String getMethodName() {
        return _methodName;
    }
    
    /**
     * ������Ȃ��������\�b�h�R�[���̈����B
     * @return �����̔z��B
     */
    public Object[] getArgs() {
        return _args;
    }
    
    /**
     * static���\�b�h�R�[�����ǂ����B
     * @return true����static�ȃ��\�b�h�R�[���B
     */
    public boolean isStaticCall() {
        return _staticCall;
    }
    
}
