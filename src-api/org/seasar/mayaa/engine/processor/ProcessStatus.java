/*
 * Copyright 2004-2006 the Seasar Foundation and the Others.
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

import java.io.Serializable;

/**
 * �v���Z�b�T����ɂď�ԑJ�ڂ������X�e�[�^�X�B
 */
public class ProcessStatus implements Serializable {

    private static final long serialVersionUID = 473586899180314059L;

    private String _status;

    /**
     * @param status �X�e�[�^�X������B
     */
    public ProcessStatus(String status) {
        if(status == null) {
            throw new IllegalArgumentException();
        }
        _status = status;
    }

    /**
     * �X�e�[�^�X��������擾����B
     * @return �X�e�[�^�X������B
     */
    public String getStatus() {
        return _status;
    }

    public boolean equals(Object test) {
        if(test instanceof ProcessStatus) {
            ProcessStatus testStatus = (ProcessStatus)test;
            return testStatus.getStatus().equals(getStatus());
        }
        return false;
    }

    // values ------------------------------------------------------

    /**
     * ���^�[���t���O�BTemplateProcessor#doStartProcess()�����̒l��Ԃ��ƁA
     * �v���Z�b�T�{�f�B���o�͂��Ȃ��B
     */
    public static final ProcessStatus SKIP_BODY =
        new ProcessStatus("SKIP_BODY");

    /**
     * ���^�[���t���O�BTemplateProcessor#doStartProcess()�����̒l��Ԃ��ƁA
     * �v���Z�b�T�{�f�B���o�b�t�@�����O�����ŏo�͂���B
     */
    public static final ProcessStatus EVAL_BODY_INCLUDE  =
        new ProcessStatus("EVAL_BODY_INCLUDE");

    /**
     * ���^�[���t���O�BTemplateProcessor#doEndProcess()�����̒l��Ԃ��ƁA
     * �ȍ~�̏o�͂��������ɒ��~����B
     */
    public static final ProcessStatus SKIP_PAGE =
           new ProcessStatus("SKIP_PAGE");

    /**
     * ���^�[���t���O�BTemplateProcessor#doEndProcess()�����̒l��Ԃ��ƁA
     * �ȍ~�̃v���Z�b�T�o�͂𑱂���B
     */
    public static final ProcessStatus EVAL_PAGE =
        new ProcessStatus("EVAL_PAGE");

    /**
     * ���^�[���t���O�B���̒l��ItarateProcessor#doAfterChildProcess()
     * ���Ԃ��ƁA�ăC�e���[�g����B
     */
    public static final ProcessStatus EVAL_BODY_AGAIN =
        new ProcessStatus("EVAL_BODY_AGAIN");

    /**
     * ���^�[���t���O�B���̒l��ChildEvaluationProcessor#doStartProcess()
     * ���Ԃ��ƁA�v���Z�b�T�{�f�B���o�b�t�@�����O����B
     */
    public static final ProcessStatus EVAL_BODY_BUFFERED =
        new ProcessStatus("EVAL_BODY_BUFFERED");

}
