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
 * �T�C�N�����X���b�h���[�J���I�u�W�F�N�g�����B
 * @author Taro Kato (Gluegent, Inc.)
 */
public interface CycleLocalInstantiator {

    /**
     * �I�u�W�F�N�g�𐶐�����B
     * �T�C�N�����L���ȊԁA�O���[�o���ȋ��L�I�u�W�F�N�g�ƂȂ�B
     * @param params �C���X�^���X�쐬�ɕK�v�ȃp�����[�^�B
     * @return �C���X�^���X�B
     */
    Object create(Object[] params);

    /**
     * ����I�u�W�F�N�g�̏��L���Ƃ��ăI�u�W�F�N�g�𐶐�����B
     * �T�C�N�����L���ȊԁA�t�B�[���h�I�ȃI�u�W�F�N�g�ƂȂ�B
     * @param owner ���L�҂ƂȂ�I�u�W�F�N�g�B
     * @param params �C���X�^���X�쐬�ɕK�v�ȃp�����[�^�B
     * @return �C���X�^���X�B
     */
    Object create(Object owner, Object[] params);

    /**
     * �I�u�W�F�N�g��j������B
     * @param instance create���ꂽ�I�u�W�F�N�g�B
     */
    void destroy(Object instance);

}

