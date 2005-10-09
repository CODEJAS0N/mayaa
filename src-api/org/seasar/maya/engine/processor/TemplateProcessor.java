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
package org.seasar.maya.engine.processor;

import org.seasar.maya.builder.library.ProcessorDefinition;
import org.seasar.maya.engine.Page;
import org.seasar.maya.engine.specification.SpecificationNode;

/**
 * �e���v���[�g����HTML�^�O����������N���X�B
 * ���N�G�X�g�ɑ΂��ăX�e�[�g���X�Ȃ悤�Ɏ������Ȃ���΂Ȃ�Ȃ��B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface TemplateProcessor extends ProcessorTreeWalker {
    
    /**
     * �J���^�O�̏o�́B�e���v���[�g�e�L�X�g��WhiteSpace�̏ꍇ���A
     * ���̃��\�b�h�ŏo�͂���B
     * @param topLevelPage �`��g�b�v���x���̃y�[�W�B
     * @return �q�v���Z�b�T����������ꍇ�ɂ�EVAL_BODY_INCLUDE�A
     * �q�v���Z�b�T�̏������X�L�b�v����ꍇ�ɂ�SKIP_BODY��Ԃ��B
     */
    ProcessStatus doStartProcess(Page topLevelPage);

    /**
     * ���^�O�̏o�́B
     * @return �y�[�W�̂��̃^�O�ȍ~����������ꍇ�ɂ�EVAL_PAGE�A
     * �ȍ~�̏������X�L�b�v����ꍇ�ɂ�SKIP_PAGE�B
     */
    ProcessStatus doEndProcess();

    /**
     * �e���v���[�g��̊Y������m�[�h����ݒ肷��B
     * @param node �e���v���[�g�m�[�h�B
     */
    void setOriginalNode(SpecificationNode node);
    
    /**
     * �e���v���[�g��̊Y������m�[�h���̎擾�B
     * @return �e���v���[�g�m�[�h�B
     */
    SpecificationNode getOriginalNode();
    
    /**
     * �C���W�F�N�V�������ꂽ�m�[�h���̐ݒ�B
     * @param node �C���W�F�N�g���ꂽ�m�[�h�B
     */
    void setInjectedNode(SpecificationNode node);
    
    /**
     * �C���W�F�N�V�������ꂽ�m�[�h���̎擾�B
     * @return �C���W�F�N�g���ꂽ�m�[�h�B
     */    
    SpecificationNode getInjectedNode();

    /**
     * ���̃v���Z�b�T�̒�`�ւ̎Q�Ƃ�ݒ肷��B
     * @param definition �v���Z�b�T��`�B
     */
    void setProcessorDefinition(ProcessorDefinition definition);
    
    /**
     * ���̃v���Z�b�T�̒�`���擾����B
     * @return �v���Z�b�T��`�B
     */
    ProcessorDefinition getProcessorDefinition();
    
}