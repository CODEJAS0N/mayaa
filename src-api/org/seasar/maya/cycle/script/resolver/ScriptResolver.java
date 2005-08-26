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
package org.seasar.maya.cycle.script.resolver;

import org.seasar.maya.provider.Parameterizable;

/**
 * �X�N���v�g�]�����]���o�B�A�v���P�[�V�����X�R�[�v�ɂċ��L�����̂ŁA
 * �X���b�h�Z�[�t�Ɏ������邱�Ƃ����߂���B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface ScriptResolver extends Parameterizable {

    /**
     * �l�擾�̂��߂̃��]���o���\�b�h�B
     * @param name �擾����l�̖��O������B
     * @return �]�����ʂ������́AUNDEFINED�B
     */
    Object getVariable(String name);
    
    /**
     * �l�ݒ�̂��߂̃��]���o���\�b�h�B
     * @param name �ݒ肷��l�̖��O������B
     * @param value �ݒ肷��l�B
     * @return �l�ݒ���s�����ۂɁAtrue�B�����������Ȃ�Ȃ���false��Ԃ��B
     */
    boolean setVariable(String name, Object value);
    
}
