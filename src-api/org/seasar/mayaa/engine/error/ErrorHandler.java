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
package org.seasar.mayaa.engine.error;

import org.seasar.mayaa.ParameterAware;

/**
 * �G���[�����̂��߂̃n���h���B���N�G�X�g�̍Ō�A�G���[��ʂ̏o�͂Ȃǂ��s���B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface ErrorHandler extends ParameterAware {

    /**
     * �G���[�������\�b�h�B
     * @param t �����Ώۂ�Throwable�B
     * @param pageFlush �e���v���[�g�o�͂������Ńt���b�V�����邩�ǂ����B
     */
    void doErrorHandle(Throwable t, boolean pageFlush);

}
