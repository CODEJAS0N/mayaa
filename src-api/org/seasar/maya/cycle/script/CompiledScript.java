/*
 * Copyright 2004-2005 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
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
     * @return ���s���ʂ̒l�B
     */
    Object execute();
    
    /**
     * �X�N���v�g���s���ʂւ̊��Ҍ^�̎擾�B
     * @return ���s���ʂɊ��҂����N���X�^�B
     */
    Class getExpectedType();

    /**
     * �X�N���v�g���s���ʂւ̊��Ҍ^�̐ݒ�B
     * @param expectedType ���s���ʂɊ��҂���N���X�^�B
     */
    void setExpectedType(Class expectedType);
    
    /**
     * ���e�����e�L�X�g���ǂ����B
     * @return �R���p�C�����ʂ��A���e������������true�B
     */
    boolean isLiteral();
    
    /**
     * �X�N���v�g�\�[�X�R�[�h�̎擾�B�\�[�X���O���t�@�C���̏ꍇ�́ASystemID�B
     * @return �X�N���v�g�\�[�X�R�[�h�������͊O���\�[�X�R�[�h�t�@�C����SystemID�B
     */
    String getScript();
    
}
