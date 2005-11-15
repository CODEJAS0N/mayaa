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
package org.seasar.mayaa.builder.library;

import java.util.Iterator;

import org.seasar.mayaa.engine.processor.TemplateProcessor;
import org.seasar.mayaa.engine.specification.SpecificationNode;

/**
 * MLD��processor�G�������g�̃��f���I�u�W�F�N�g�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface ProcessorDefinition extends PropertySet {
    
    /**
     * class�����Ŏw�肵���ATemplateProcessor�̎����N���X���S�C�����B
     * @return �����N���X���B
     */
    Class getProcessorClass();

    /**
     * �o�^�v���p�e�B�Z�b�g�̃C�e���[�^�B
     * @return �v���p�e�B�Z�b�g�C�e���[�^�B
     */
    Iterator iteratePropertySets();
    
    /**
     * ���Y�ݒ���A�e���v���[�g�v���Z�b�T�𐶐�����B 
     * @param injected �C���W�F�N�V��������X�y�b�N�m�[�h�B
     * @return �e���v���[�g�v���Z�b�T�B
     */
    TemplateProcessor createTemplateProcessor(SpecificationNode injected);
    
}
