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
package org.seasar.mayaa.source;

import java.util.Iterator;

import org.seasar.mayaa.source.SourceDescriptor;

/**
 * �\�[�X�f�B�X�N���v�^���i�[���Ă��郍�P�[�V����
 * @author Taro Kato (Gluegent, Inc.)
 */
public interface SourceHolder {

    /**
     * systemID�̃C�e���[�^��ԋp����B
     * �K�w�\�����g���[�X���A/ �ŋ�؂�ꂽ���̂�ԋp����B
     * 
     * @param filters �s���I�h�Ə�������1�ȏ�̘A���̏ꍇ�͊g���q���A
     *                 ����ȊO�͐��K�\���Ńt�@�C�����̃}�b�`�������̂�ԋp����B
     * @return ���݂���systemID�C�e���[�^
     */
    Iterator iterator(String[] filters);
    
    /**
     * �\�[�X�f�B�X�N���v�^��ێ�����_���I�ȊJ�n�ʒu��ݒ肷��
     * @param root �i�[�J�n�ʒu
     */
    void setRoot(String root);

    /**
     * �\�[�X�f�B�X�N���v�^��ێ�����
     * �_���I�ȊJ�n�ʒu��ԋp����
     * @return �i�[�J�n�ʒu
     */
    String getRoot();

    /**
     * �\�[�X�f�B�X�N���v�^�𐶐�����
     * 
     * @param systemID
     *            �V�X�e��ID
     * @return �\�[�X�f�B�X�N���v�^
     */
    SourceDescriptor getSourceDescriptor(String systemID);

}
