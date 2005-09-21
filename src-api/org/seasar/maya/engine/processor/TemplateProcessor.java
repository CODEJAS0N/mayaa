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
package org.seasar.maya.engine.processor;


import java.io.Serializable;

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
     * @return �q�v���Z�b�T����������ꍇ�ɂ�EVAL_BODY_INCLUDE�A
     * �q�v���Z�b�T�̏������X�L�b�v����ꍇ�ɂ�SKIP_BODY��Ԃ��B
     */
    ProcessStatus doStartProcess();

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
     * �v���Z�b�T����ɂď�ԑJ�ڂ������X�e�[�^�X�B
     */
    class ProcessStatus implements Serializable {

        private static final long serialVersionUID = 473586899180314059L;

        protected ProcessStatus() {
        }
        
    }

    /**
     * ���^�[���t���O�BdoStartProcess()�����̒l��Ԃ��ƁA
     * �v���Z�b�T�{�f�B���o�͂��Ȃ��B
     */
    ProcessStatus SKIP_BODY = new ProcessStatus();
    
    /**
     * ���^�[���t���O�BdoStartProcess()�����̒l��Ԃ��ƁA
     * �v���Z�b�T�{�f�B���o�b�t�@�����O�����ŏo�͂���B
     */
    ProcessStatus EVAL_BODY_INCLUDE = new ProcessStatus();
    
    /**
     * ���^�[���t���O�BdoEndProcess()�����̒l��Ԃ��ƁA
     * �ȍ~�̏o�͂��������ɒ��~����B
     */
    ProcessStatus SKIP_PAGE = new ProcessStatus();
    
    /**
     * ���^�[���t���O�BdoEndProcess()�����̒l��Ԃ��ƁA
     * �ȍ~�̃v���Z�b�T�o�͂𑱂���B
     */
    ProcessStatus EVAL_PAGE = new ProcessStatus();

}