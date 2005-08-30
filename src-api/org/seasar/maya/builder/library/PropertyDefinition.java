/*
 * Copyright (c) 2004-2005 the Seasar Foundation and the Others.
 *
 * Licensed under the Seasar Software License, v1.1 (aka "the License");
 * you may not use this file except in compliance with the License which
 * accompanies this distribution, and is available at
 *
 *     http://www.seasar.org/SEASAR-LICENSE.TXT
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package org.seasar.maya.builder.library;

import org.seasar.maya.engine.specification.SpecificationNode;

/**
 * MLD��property�m�[�h�̃��f���I�u�W�F�N�g�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface PropertyDefinition {
    
    /**
     * ��������v���Z�b�T��񃂃f���̎擾�B
     * @return �v���Z�b�T��񃂃f���B 
     */
    ProcessorDefinition getProcessorDefinition();
    
    /**
     * MLD��name�����A�ł���v���p�e�B���B
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
     * MLD��expectedType�����ŋL�q���ꂽ�����^�B�f�t�H���g��java.lang.Object�B
     * @return �����^�B
     */
    Class getExpectedType();
    
    /**
     * MLD��defaultValue�����l�B�J�X�^�}�C�Y�œn���v���p�e�B�̃f�t�H���g�l�B
     * @return �J�X�^�}�C�Y�f�t�H���g�l�B
     */
    String getDefaultValue();

    /**
     * �v���p�e�B�I�u�W�F�N�g�𐶐�����B
     * @param injected �C���W�F�N�V��������m�[�h�B
     * @return �v���p�e�B�I�u�W�F�N�g�B
     */
    Object createProcessorProperty(SpecificationNode injected);
    
}
