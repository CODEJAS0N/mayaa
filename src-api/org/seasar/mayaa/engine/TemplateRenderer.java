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
package org.seasar.mayaa.engine;

import org.seasar.mayaa.engine.processor.ProcessStatus;

/**
 * �e���v���[�g��`�悷��I�u�W�F�N�g�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface TemplateRenderer {

    /**
     * �w��e���v���[�g��`�悷��B
     * @param topLevelPage  �`��g�b�v���x���̃y�[�W�B
     * @param templates �`�悷��e���v���[�g�B���C�A�E�g���p�̏ꍇ�A
     * �C���f�b�N�X0�ɕ`��e���v���[�g�A1,2,3,...�Ɛe�̃e���v���[�g���ς݂��܂��B
     * @return �e���v���[�g�v���Z�b�T�̃v���Z�X�X�e�[�g�t���O�B
     */
    ProcessStatus renderTemplate(Page topLevelPage, Template[] templates);

}
