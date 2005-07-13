/*
 * Copyright (c) 2004-2005 the Seasar Project and the Others.
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

import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;

/**
 * TODO ServiceCycle
 * 
 * TemplateProcessor�̊g���C���^�[�t�F�C�X�B�q�v�f�̕]���̋@�\�����B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface ChildEvaluationProcessor extends IterationProcessor {

    /**
     * �{�f�B�̃X�^�b�N�]�����s������Ԃ��BJSP��BodyTag���z�X�g���Ă���ꍇ��
     * ���p����B�f�t�H���g�ł�false��Ԃ��Btrue���ƁAsetBodyContent()���\�b�h
     * �����doInitChildProcess()���\�b�h���R���e�i���Ăяo�����B
     * @param context �v���Z�X���̃X�e�[�g�t���ȏ���ێ�����R���e�L�X�g�B
     * @return �{�f�B�̃X�^�b�N�]��������ꍇ�Atrue�B���ʂ�false�B
     */
    boolean isChildEvaluation(PageContext context);
    
    /**
     * �{�f�B�̃X�^�b�N�]�����s���ꍇ�A�X�^�b�N�������s��ꂽJSP��BodyContent��
     * �R���e�i���Z�b�g����B
     * @param context �v���Z�X���̃X�e�[�g�t���ȏ���ێ�����R���e�L�X�g�B
     * @param bodyContent �X�^�b�N�ɐς܂ꂽBodyContent�B
     */
    void setBodyContent(PageContext context, BodyContent bodyContent);

    /**
     * �{�f�B�̃X�^�b�N�]�����s���ꍇ�A�]���O�Ɉ�x�A�R���e�i���Ăяo�����B
     * @param context �v���Z�X���̃X�e�[�g�t���ȏ���ێ�����R���e�L�X�g�B
     */
    void doInitChildProcess(PageContext context);

}