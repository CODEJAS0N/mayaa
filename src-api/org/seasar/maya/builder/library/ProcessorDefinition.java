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

import java.util.Iterator;

import org.seasar.maya.engine.processor.TemplateProcessor;
import org.seasar.maya.engine.specification.SpecificationNode;

/**
 * MLD��processor�G�������g�̃��f���I�u�W�F�N�g�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface ProcessorDefinition {
    
    /**
     * �������C�u�����̏�񃂃f���擾�B
     * @return ���C�u�������B
     */
    LibraryDefinition getLibraryDefinition();
    
    /**
     * �v���Z�b�T���̎擾�B
     * @return �v���Z�b�T���B
     */
    String getName();
    
    /**
     * class�����Ŏw�肵���ATemplateProcessor�̎����N���X���S�C�����B
     * @return �����N���X���B
     */
    Class getProcessorClass();
    
    /**
     * �v���Z�b�T�ւ̃o�C���f�B���O��񃂃f���iPropertyDefinition�j�I�u�W�F�N�g�̃C�e���[�g�B
     * @return �o�C���f�B���O���C�e���[�^�[�B
     */
    Iterator iteratePropertyDefinition();        
    
    /**
     * ���Y�ݒ���A�e���v���[�g�v���Z�b�T�𐶐�����B 
     * @param injected �C���W�F�N�V��������X�y�b�N�m�[�h�B
     * @return �e���v���[�g�v���Z�b�T�B
     */
    TemplateProcessor createTemplateProcessor(SpecificationNode injected);
    
}
