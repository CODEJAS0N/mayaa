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
package org.seasar.maya.cycle.script;

import java.io.Serializable;

/**
 * �R���p�C���ς݂̃X�N���v�g�I�u�W�F�N�g�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface CompiledScript extends Serializable {

    /**
     * �X�N���v�g�����s���Ēl���擾����B
     * @param root �X�N���v�g���s���́A���[�g�X�R�[�v�I�u�W�F�N�g�B
     * @return ���s���ʂ̒l�B
     */
    Object execute(Object root);
    
    /**
     * �X�N���v�g�̎擾�B
     * @return �X�N���v�g������B
     */
    String getText();
    
    /**
     * �X�N���v�g���s���ʂւ̊��Ҍ^�B
     * @return ���҂����N���X�^�B
     */
    Class getExpectedType();
 
    /**
     * ���e�����e�L�X�g���ǂ����B
     * @return �R���p�C�����ʂ��A���e������������true�B
     */
    boolean isLiteral();
    
}
