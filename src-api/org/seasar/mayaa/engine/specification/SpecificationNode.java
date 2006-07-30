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
package org.seasar.mayaa.engine.specification;

import java.util.Iterator;

/**
 * �ݒ�XML�̍\�����B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface SpecificationNode
        extends NodeTreeWalker, Namespace, PrefixAwareName {

    /**
     * �r���h���ɁA�X�y�b�N���Ń��j�[�N�ɍ̔Ԃ����l��ݒ肷��B
     * @param sequenceID �X�y�b�N���̃��j�[�N�l�B
     */
    void setSequenceID(int sequenceID);

    /**
     * �X�y�b�N���Ń��j�[�N�ɐݒ肳�ꂽ�l���擾����B
     * @return �X�y�b�N���̃��j�[�N�l�B
     */
    int getSequenceID();

    /**
     * �m�[�h�����̒ǉ��B
     * @param qName �������B
     * @param value �����l�B
     */
    void addAttribute(QName qName, String value);

    /**
     * �m�[�h�����̒ǉ��B
     * @param qName �������B
     * @param originalName ������(qName�ɂ���O�̃I���W�i��)
     * @param value �����l�B
     */
    void addAttribute(QName qName, String originalName, String value);

    /**
     * �����̎擾�B
     * @param qName �擾���鑮����QName�B
     * @return �����I�u�W�F�N�g�B
     */
    NodeAttribute getAttribute(QName qName);

    /**
     * �����̃C�e���[�g�B
     * @return �����i<code>NodeAttribute</code>�j�̃C�e���[�^�B
     */
    Iterator iterateAttribute();

    /**
     * �����̍폜�B
     * @param qName �폜���鑮����QName�B
     * @return �ݒ肵�Ă����I�u�W�F�N�g�B���݂��Ȃ������ꍇ�̓k����Ԃ��B
     */
    NodeAttribute removeAttribute(QName qName);
    
    /**
     * ������S�č폜����B
     */
    void clearAttributes();

    /**
     * �����̃R�s�[�𐶐����ĕԂ��B�������A�e�m�[�h�͐ݒ肳��Ă��Ȃ��B
     * @return �����̃R�s�[�B
     */
    SpecificationNode copyTo();

    /**
     * �t�B���^�t���Ŏ����̃R�s�[�𐶐����ĕԂ��B�������A�e�m�[�h�͐ݒ肳��Ă��Ȃ��B
     * @param filter �R�s�[���t�B���^�B
     * @return �����̃R�s�[�B
     */
    SpecificationNode copyTo(CopyToFilter filter);

}
