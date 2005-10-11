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

import org.seasar.maya.ParameterAware;
import org.seasar.maya.builder.library.converter.PropertyConverter;


/**
 * MLD��library�G�������g�̃��f���I�u�W�F�N�g�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface LibraryDefinition extends ParameterAware {

	/**
	 * ��O�⃍�O�̃��b�Z�[�W�p�r�Ƃ��āA�t�@�C����SystemID���擾����B
	 * @return �t�@�C��SystemID�B
	 */
	String getSystemID();
    
    /**
     * ���Y���C�u�����̖��O���URI���擾����B
     * @return ���O���URI�B
     */
    String getNamespaceURI();
    
    /**
     * ���Y���C�u�����ɒǉ��A�T�C�����ꂽ���O���URI���C�e���[�g����B
     * @return �ǉ��A�T�C�����ꂽ���O���URI�̃C�e���[�^�B
     */
    Iterator iterateAssignedURI();
    
    /**
     * �o�^�R���o�[�^�̎擾�B
     * @param converterName �R���o�[�^�o�^���B
     * @return �w�薼�̃R���o�[�^�A��������null�B
     */
    PropertyConverter getPropertyConverter(String converterName);
    
    /**
     * �o�^�R���o�[�^�̃C�e���[�^�B
     * @return �R���o�[�^�C�e���[�^�B
     */
    Iterator iteratePropertyConverters();
    
    /**
     * �o�^�R���o�[�^�̎擾�B
     * @param propertyClass �R���o�[�g�Ώی^�B
     * @return �w��^�ɑΉ������R���o�[�^�A��������null�B
     */
    PropertyConverter getPropertyConverter(Class propertyClass);
    
    /**
     * �o�^�v���p�e�B�Z�b�g�̃C�e���[�^�B
     * @return �v���p�e�B�Z�b�g�C�e���[�^�B
     */
    Iterator iteratePropertySets();
    
    /**
     * �o�^�v���p�e�B�Z�b�g�̎擾�B
     * @param name �v���p�e�B�Z�b�g���B
     * @return �w�薼�̃v���p�e�B�Z�b�g�A��������null�B
     */
    PropertySet getPropertySet(String name);
    
    /**
     * �q��processor�m�[�h�̃C�e���[�^�B
     * @return �m�[�h�C�e���[�^�B
     */
    Iterator iterateProcessorDefinitions();
    
    /**
     * �w��QName�ŊY������ProcessorDefinition�̎擾�B
     * @param name �擾������ProcessorDefinition�̖��O�B
     * @return �Y��ProcessorDefinition��������null�B
     */
    ProcessorDefinition getProcessorDefinition(String name);
    
}
