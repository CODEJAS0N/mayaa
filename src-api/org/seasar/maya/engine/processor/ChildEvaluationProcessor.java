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

import org.seasar.maya.cycle.CycleWriter;
import org.seasar.maya.cycle.ServiceCycle;

/**
 * TemplateProcessor�̊g���C���^�[�t�F�C�X�B�q�v�f�̕]���̋@�\�����B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface ChildEvaluationProcessor extends IterationProcessor {

    /**
     * ���^�[���t���O�B���̒l��doStartProcess()���Ԃ��ƁA�v���Z�b�T�{�f�B���o�b�t�@�����O����B
     */
    ProcessStatus EVAL_BODY_BUFFERED = new ProcessStatus();
    
    /**
     * �{�f�B�̃X�^�b�N�]�����s������Ԃ��BJSP��BodyTag���z�X�g���Ă���ꍇ��
     * ���p����B�f�t�H���g�ł�false��Ԃ��Btrue���ƁAsetBodyContent()���\�b�h
     * �����doInitChildProcess()���\�b�h���R���e�i���Ăяo�����B
     * @param cycle �T�[�r�X�T�C�N���R���e�L�X�g�B
     * @return �{�f�B�̃X�^�b�N�]��������ꍇ�Atrue�B���ʂ�false�B
     */
    boolean isChildEvaluation(ServiceCycle cycle);
    
    /**
     * �{�f�B�̃X�^�b�N�]�����s���ꍇ�A�X�^�b�N�������s��ꂽ�{�f�B���̃o�b�t�@��
     * �R���e�i���Z�b�g����B
     * @param cycle �T�[�r�X�T�C�N���R���e�L�X�g�B
     * @param body �X�^�b�N�ɐς܂ꂽ�{�f�B���̃o�b�t�@�B
     */
    void setBodyContent(ServiceCycle cycle, CycleWriter body);

    /**
     * �{�f�B�̃X�^�b�N�]�����s���ꍇ�A�]���O�Ɉ�x�A�R���e�i���Ăяo�����B
     * @param cycle �T�[�r�X�T�C�N���R���e�L�X�g�B
     */
    void doInitChildProcess(ServiceCycle cycle);

}