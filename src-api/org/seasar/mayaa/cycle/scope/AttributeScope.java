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
package org.seasar.mayaa.cycle.scope;

import java.util.Iterator;

import org.seasar.mayaa.ParameterAware;

/**
 * ���O���ŃI�u�W�F�N�g��ۑ��ł���u�X�R�[�v�v�T�O�C���^�[�t�F�C�X�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface AttributeScope extends ParameterAware {

    /**
     * �X�R�[�v���ʂ̎擾���s���⏕���\�b�h�B
     * @return �X�R�[�v���ʁB
     */
    String getScopeName();

    /**
     * ���̃X�R�[�v�ɕۑ�����Ă��閼�O���C�e���[�g����B
     * @return ���O�iString�j�̓������C�e���[�^�B
     */
    Iterator iterateAttributeNames();

    /**
     * ���̃X�R�[�v���Ɏw�肳�ꂽ���O�ɑΉ������I�u�W�F�N�g�����邩���e�X�g����B
     * @param name �w��I�u�W�F�N�g���B
     * @return �e�X�g���ʁB
     */
    boolean hasAttribute(String name);

    /**
     * ���̃X�R�[�v������w�肳�ꂽ���O�ɑΉ������I�u�W�F�N�g��Ԃ��B
     * ���O������null�������͋󔒕�����A�������͊Y���I�u�W�F�N�g�������ꍇ�ɂ́A
     * UNDEFINED��Ԃ��B
     * @param name �w��I�u�W�F�N�g���B
     * @return �w��I�u�W�F�N�g�B
     */
    Object getAttribute(String name);

    /**
     * ���̃X�R�[�v���ɃI�u�W�F�N�g�̏������݂���э폜���ł��邩��Ԃ��B
     * @return �e�X�g���ʁB
     */
    boolean isAttributeWritable();

    /**
     * ���̃X�R�[�v���ɁA�w�薼�ŃI�u�W�F�N�g��ۑ�����B
     * @param name �w�薼�Bnull����ы󔒕����񂾂Ɖ������Ȃ��B
     * @param attribute �w��I�u�W�F�N�g�B
     */
    void setAttribute(String name, Object attribute);

    /**
     * ���̃X�R�[�v���̎w�薼�I�u�W�F�N�g���폜����B
     * @param name �w�薼�Bnull����ы󔒕����񂾂Ɖ������Ȃ��B
     */
    void removeAttribute(String name);

    /**
     * ���̃X�R�[�v���ɁA�w��N���X�^�̃I�u�W�F�N�g�𐶐�����B
     * ���łɓ������O�ňႤ�N���X�^�̃I�u�W�F�N�g�����݂���ꍇ�̏�����A
     * ���O��N���X�^�̈����`�F�b�N�̎d�l�͒�߂Ȃ��B�������̎d�l�ƂȂ�B
     * @param name �w�薼�B
     * @param attributeClass �w��N���X�^�B
     * @return �w��I�u�W�F�N�g�B
     */
    Object newAttribute(String name, Class attributeClass);

}
