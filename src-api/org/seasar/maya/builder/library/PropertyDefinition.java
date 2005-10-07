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

import org.seasar.maya.engine.specification.SpecificationNode;
import org.seasar.maya.provider.Parameterizable;

/**
 * MLD��property�m�[�h�̃��f���I�u�W�F�N�g�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface PropertyDefinition extends Parameterizable {
    
	/**
	 * ��O�⃍�O�̃��b�Z�[�W�p�r�Ƃ��āA�t�@�C�����ł̍s�ԍ����擾����B
	 * @return �s�ԍ��B
	 */
	int getLineNumber();
    
    /**
     * ��������v���p�e�B�Z�b�g�̎擾�B
     * @return �v���p�e�B�Z�b�g�B 
     */
    PropertySet getPropertySet();
    
    /**
     * MLD��name�����ł���v���p�e�B���B
     * �e���v���[�g��ݒ�XML��̑����ƁA�e���v���[�g�v���Z�b�T�̃v���p�e�B��
     * �o�C���f�B���O���閼�O�ƂȂ�B
     * @return �o�C���f�B���O���B 
     */
    String getName();
    
    /**
     * MLD��required�����ŋL�q���ꂽ�K�{�t���O�B�f�t�H���g��false�B
     * @return �K�{�t���O�B
     */
    boolean isRequired();
    
    /**
     * MLD��expectedType�����ŋL�q���ꂽ�����^�B
     * �f�t�H���g��java.lang.Object�B
     * @return �����^�B
     */
    Class getExpectedType();
    
    /**
     * MLD��default�����l�B�J�X�^�}�C�Y�œn���v���p�e�B�̃f�t�H���g�l�B
     * @return �J�X�^�}�C�Y�f�t�H���g�l�B
     */
    String getDefaultValue();

    /**
     * MLD��final�����l�BMLD�ɒ�`�����l�̓��[�U�[�A�v���ŏ㏑������Ȃ��B
     * @return �t�@�C�i���l�B
     */
    String getFinalValue();

    /**
     * MLD�w��̃v���p�e�B�l�R���o�[�^���B
     * @return �R���o�[�^���B
     */
    String getPropertyConverterName();
    
    /**
     * �v���p�e�B�I�u�W�F�N�g�𐶐�����B
     * @param processorDef �v���Z�b�T��`�B
     * @param injected �C���W�F�N�V��������m�[�h�B
     * @return �v���p�e�B�I�u�W�F�N�g�B
     */
    Object createProcessorProperty(
            ProcessorDefinition processorDef, SpecificationNode injected);
    
}
