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
public interface CompiledScript
        extends Serializable, ExpectedClassAware {

    /**
     * �R���p�C���\����у��e�������킸�A���̓e�L�X�g���擾����B
     * @return ���̓e�L�X�g�B
     */
    String getScriptText();
    
    /**
     * ���e�����e�L�X�g���ǂ����B
     * @return �R���p�C�����ʂ��A���e������������true�B
     */
    boolean isLiteral();

    /**
     * �X�N���v�g�����s���Ēl���擾����B
     * @param args null�������́A���s�������iJSF���~�h���E�F�A�Ή��j�B
     * @return ���s���ʂ̒l�B
     */
    Object execute(Object[] args);
    
    /**
     * JSF���̎�����l�����s�~�h���E�F�A�Ή��B
     * ������l���̃��\�b�h�R�[���̂��߂̈����^��ݒ肷��B 
     * @param methodArgClasses ���\�b�h�����^�z��B
     */
    void setMethodArgClasses(Class[] methodArgClasses);

    /**
     * JSF���̎�����l�����s�~�h���E�F�A�Ή��B
     * ������l���̃��\�b�h�R�[���̂��߂̈����^���擾����B 
     * @return ���\�b�h�����^�z��B
     */
    Class[] getMethodArgClasses();
    
    /**
     * JSF���̎�����l�����s�~�h���E�F�A�Ή��B
     * �X�N���v�g�u���b�N�̏�Ԃ𒲂ׁA�ǂݎ��݂̂��ǂ�����Ԃ��B
     * @return �R���p�C�����ʂ��A�l�ݒ�\�ł����true�B
     */
    boolean isReadOnly();

    /**
     * JSF���~�h���E�F�A�Ή��@�\�B 
     * �X�N���v�g�����s���Ēl�ݒ肷��B
     * @param value �ݒ肷��l�B
     */
    void assignValue(Object value);
    
}
