/*
 * Copyright 2004-2006 the Seasar Foundation and the Others.
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
package org.seasar.mayaa.cycle;

/**
 * ���N�G�X�g�T�C�N�����ŗL���ȓ��I�ϐ��𐧌䂷��B
 * @author Taro Kato (Gluegent, Inc.)
 */
public interface CycleLocalVariables {

    /**
     * �T�C�N�����ԓ��ŗL���ȃX���b�h���[�J���ȃO���[�o���I�u�W�F�N�g�̎擾�B
     * @param key �o�^�L�[�B
     * @param params �����ɕK�v�ȃp�����[�^�B
     * @return �I�u�W�F�N�g�B�o�^�L�[�̎����������I�u�W�F�N�g���o�^����Ă��Ȃ���΃G���[�B
     */
    Object getGlobalVariable(String key, Object[] params);
    
    /**
     * �T�C�N�����ԓ��ŗL���ȃX���b�h���[�J���ȃO���[�o���I�u�W�F�N�g�𖳌�������B
     * @param key �o�^�L�[�B
     */
    void clearGlobalVariable(String key);
    
    /**
     * �T�C�N�����ԓ��ŗL���ȃX���b�h���[�J���ȃO���[�o���I�u�W�F�N�g�ւ̐ݒ�B
     * @param key �o�^�L�[�B
     * @param value �ݒ�l�B
     */
    void setGlobalVariable(String key, Object value);
    
    /**
     * �T�C�N�����ԓ��ŗL���ȃX���b�h���[�J���ȃI�u�W�F�N�g�̎擾�B
     * @param key �o�^�L�[�B
     * @param owner ���L�ҁB
     * @return �I�u�W�F�N�g�B�o�^�L�[�̎����������I�u�W�F�N�g���o�^����Ă��Ȃ���΃G���[�B
     */
    Object getVariable(String key, Object owner, Object[] params);
    
    /**
     * �T�C�N�����ԓ��ŗL���ȃX���b�h���[�J���ȃI�u�W�F�N�g�𖳌�������B
     * @param key �o�^�L�[�B
     */
    void clearVariable(String key, Object owner);

    /**
     * �T�C�N�����ԓ��ŗL���ȃX���b�h���[�J���ȃI�u�W�F�N�g�ւ̐ݒ�B
     * @param key �o�^�L�[�B
     * @param value �ݒ�l�B
     */
    void setVariable(String key, Object owner, Object value);

}

