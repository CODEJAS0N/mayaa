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
package org.seasar.maya.engine.error;

import org.seasar.maya.provider.Parameterizable;

/**
 * �G���[�����̂��߂̃n���h���B���N�G�X�g�̍Ō�A�G���[��ʂ̏o�͂Ȃǂ��s���B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface ErrorHandler extends Parameterizable {

    /**
     * �G���[�������\�b�h�B
     * @param t �����Ώۂ�Throwable�B
     */
    void doErrorHandle(Throwable t);

}
