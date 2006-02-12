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
package org.seasar.mayaa.builder.library;

import org.seasar.mayaa.ParameterAware;
import org.seasar.mayaa.engine.specification.QName;
import org.seasar.mayaa.engine.specification.SpecificationNode;

/**
 * �e���v���[�g�̑����l���擾����B
 *
 * @author Koji Suga (Gluegent, Inc.)
 */
public interface TemplateAttributeReader extends ParameterAware {

    /**
     * �e���v���[�g����w�肵��QName�̑�����ǂ݁A���̒l��Ԃ��B
     * ���݂��Ȃ����null��Ԃ��B
     *
     * @param qName �ΏۂƂ���J�X�^���^�O��QName
     * @param attributeName �擾���鑮����LocalName
     * @param original �e���v���[�g�̃m�[�h
     * @return qName�ɑΉ����鑮���l
     */
    String getValue(QName qName, String attributeName, SpecificationNode original);

    /**
     * �������鑮����ǉ�����B
     *
     * @param qName �ΏۂƂ���v���Z�b�T�^�O��QName
     * @param attributeName �ΏۂƂ��鑮����LocalName
     */
    void addIgnoreAttribute(String qName, String attributeName);

    /**
     * �v���Z�b�T�^�O�̑����Ƀe���v���[�g��̈قȂ閼�O�̑������Z�b�g����w���
     * �ǉ�����B
     *
     * @param qName �ΏۂƂ���v���Z�b�T�^�O��QName
     * @param attributeName �ΏۂƂ��鑮����LocalName
     * @param templateAttributeName �e���v���[�g��̑�����
     */
    void addAliasAttribute(
            String qName, String attributeName, String templateAttribute);

}
