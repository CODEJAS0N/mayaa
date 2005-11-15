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
package org.seasar.mayaa.engine.processor;

import org.seasar.mayaa.cycle.CycleWriter;

/**
 * TemplateProcessor�̊g���C���^�[�t�F�C�X�B�q�v�f�̕]���̋@�\�����B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface ChildEvaluationProcessor extends IterationProcessor {

    /**
     * �{�f�B�̃X�^�b�N�]�����s������Ԃ��BJSP��BodyTag���z�X�g���Ă���ꍇ��
     * ���p����B�f�t�H���g�ł�false��Ԃ��Btrue���ƁAsetBodyContent()���\�b�h
     * �����doInitChildProcess()���\�b�h���R���e�i���Ăяo�����B
     * @return �{�f�B�̃X�^�b�N�]��������ꍇ�Atrue�B���ʂ�false�B
     */
    boolean isChildEvaluation();
    
    /**
     * �{�f�B�̃X�^�b�N�]�����s���ꍇ�A�X�^�b�N�������s��ꂽ�{�f�B���̃o�b�t�@��
     * �R���e�i���Z�b�g����B
     * @param body �X�^�b�N�ɐς܂ꂽ�{�f�B���̃o�b�t�@�B
     */
    void setBodyContent(CycleWriter body);

    /**
     * �{�f�B�̃X�^�b�N�]�����s���ꍇ�A�]���O�Ɉ�x�A�R���e�i���Ăяo�����B
     */
    void doInitChildProcess();

}
