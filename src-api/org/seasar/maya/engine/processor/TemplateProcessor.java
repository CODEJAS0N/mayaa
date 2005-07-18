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

import org.seasar.maya.cycle.ServiceCycle;

/**
 * �e���v���[�g����HTML�^�O����������Ϗ��N���X�B����TemplateProcessor�̃c���[���Ȃ킿
 * Template�ƂȂ�B����TemplateProcessor�����N�G�X�g�ɑ΂��ăX�e�[�g���X�łȂ���΂Ȃ�Ȃ��B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface TemplateProcessor extends Serializable {

    /**
     * ���^�[���t���O�BdoStartProcess()�����̒l��Ԃ��ƁA�v���Z�b�T�{�f�B���o�͂��Ȃ��B
     */
    ProcessStatus SKIP_BODY = new ProcessStatus();
    
    /**
     * ���^�[���t���O�BdoStartProcess()�����̒l��Ԃ��ƁA
     * �v���Z�b�T�{�f�B���o�b�t�@�����O�����ŏo�͂���B
     */
    ProcessStatus EVAL_BODY_INCLUDE = new ProcessStatus();
    
    /**
     * ���^�[���t���O�BdoEndProcess()�����̒l��Ԃ��ƁA�ȍ~�̏o�͂��������ɒ��~����B
     */
    ProcessStatus SKIP_PAGE = new ProcessStatus();
    
    /**
     * ���^�[���t���O�BdoEndProcess()�����̒l��Ԃ��ƁA�ȍ~�̃v���Z�b�T�o�͂𑱂���B
     */
    ProcessStatus EVAL_PAGE = new ProcessStatus();
    
    /**
     * �m�[�h�̏��������s���B���̃��\�b�h�́ATemplateBuilder#build�̒��ŌĂ΂��B
     * @param parent �eTemplateProcessor
     * @param index �eTemplateNode���ł̎q�Ƃ��ẴC���f�b�N�X�l�B
     */
    void setParentProcessor(TemplateProcessor parent, int index);

    /**
     * �qTemplateProcessor��ǉ�����B���̃��\�b�h�́ATemplateBuilder#build�̒��ŌĂ΂��B
     * @param child �qTemplateProcessor
     */
    void addChildProcessor(TemplateProcessor child);

    /**
     * �eTemplateProcessor���ł̎q�Ƃ��ẴC���f�b�N�X�l
     * @return �C���f�b�N�X�l
     */
    int getIndex();

    /**
     * �eTemplateProcessor���擾����B
     * @return �eTemplateProcessor
     */
    TemplateProcessor getParentProcessor();

    /**
     * �qTemplateNode�̐����擾����B
     * @return �qTemplateNode�̐�
     */
    int getChildProcessorSize();

    /**
     * �w��C���f�b�N�X�̎qTemplateNode���擾����B
     * @param index �w��index�B
     * @return �w��index�̎qTemplateProcessor�B
     */
    TemplateProcessor getChildProcessor(int index);

    /**
     * �J���^�O�̏o�́B�e���v���[�g�e�L�X�g��WhiteSpace�̏ꍇ���A���̃��\�b�h�ŏo�͂���B
     * @param cycle �T�[�r�X�T�C�N���R���e�L�X�g�B
     * @return �q�v���Z�b�T����������ꍇ�ɂ�EVAL_BODY_INCLUDE�A
     * �q�v���Z�b�T�̏������X�L�b�v����ꍇ�ɂ�SKIP_BODY��Ԃ��B
     */
    ProcessStatus doStartProcess(ServiceCycle cycle);

    /**
     * ���^�O�̏o�́B
     * @param cycle �T�[�r�X�T�C�N���R���e�L�X�g�B
     * @return �y�[�W�̂��̃^�O�ȍ~����������ꍇ�ɂ�EVAL_PAGE�A
     * �ȍ~�̏������X�L�b�v����ꍇ�ɂ�SKIP_PAGE�B
     */
    ProcessStatus doEndProcess(ServiceCycle cycle);

    /**
     * �v���Z�b�T����ɂď�ԑJ�ڂ������X�e�[�^�X�B
     */
    public class ProcessStatus implements Serializable {

		private static final long serialVersionUID = 473586899180314059L;

		protected ProcessStatus() {
    	}
    	
    }
    
}