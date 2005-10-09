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
package org.seasar.maya.builder.library;

import java.util.Iterator;

import org.seasar.maya.builder.library.converter.PropertyConverter;
import org.seasar.maya.builder.library.scanner.SourceScanner;
import org.seasar.maya.engine.specification.QName;
import org.seasar.maya.provider.Parameterizable;

/**
 * MLD���f���I�u�W�F�N�g�̃��[�g�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface LibraryManager extends Parameterizable {

    /**
     * �v���p�e�B�^�R���o�[�^�̒ǉ��B
     * @param name �R���o�[�^���A��������null��󔒕�����B
     * @param propertyConverter �R���o�[�^�B
     */
    void addPropertyConverter(
    		String name, PropertyConverter propertyConverter);
    
    /**
     * �v���p�e�B�^�R���o�[�^�̎擾�B
     * @param converterName �R���o�[�^�o�^���B
     * @return �w�薼�̃R���o�[�^�A��������null�B
     */
    PropertyConverter getPropertyConverter(String converterName);

    /**
     * �v���p�e�B�^�R���o�[�^�̎擾�B
     * @param propertyClass �v���p�e�B�^�B
     * @return �R���o�[�^�B��������null�B
     */
    PropertyConverter getPropertyConverter(Class propertyClass);

    /**
     * �v���p�e�B�^�R���o�[�^�̃C�e���[�^�B
     * @return �R���o�[�^�C�e���[�^�B
     */
    Iterator iteratePropertyConverters();
    
    /**
     * ���C�u������`�\�[�X�X�L���i�̒ǉ��B
     * @param scanner ���C�u������`�\�[�X�X�L���i�B
     */
    void addSourceScanner(SourceScanner scanner);
    
    /**
     * ���C�u������`�r���_�̒ǉ��B
     * @param builder ���C�u������`�r���_�B
     */
    void addDefinitionBuilder(DefinitionBuilder builder);    
    
    /**
     * �SMLD�ݒ�i=<code>LibraryDefinition</code>�j�̃C�e���[�^�擾�B
     * @return MLD�ݒ�̃C�e���[�^�B
     */
    Iterator iterateLibraryDefinition();
    
    /**
     * �w��URI�ŊY������MLD�ݒ�̃C�e���[�^�擾�B
     * @param namespaceURI �擾������MLD�̖��O���URI�B
     * @return MLD�ݒ�̃C�e���[�^�B
     */
    Iterator iterateLibraryDefinition(String namespaceURI);
    
    /**
     * QName�ŊY������v���Z�b�T��`�i=<code>ProcessorDefinition</code>�j����������B
     * ��Ԃ͂��߂Ɍ����������̂�Ԃ��B
     * @param qName �擾�������v���Z�b�T��`�̎w��QName�B
     * @return �w��QName�̃v���Z�b�T��`�B������Ȃ��ꍇ��null�B
     */
    ProcessorDefinition getProcessorDefinition(QName qName);
    
}
