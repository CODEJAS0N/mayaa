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
package org.seasar.maya.engine;

import org.seasar.maya.engine.processor.TemplateProcessor.ProcessStatus;

/**
 * �e���v���[�g��`�悷��I�u�W�F�N�g�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface TemplateRenderer {
	
	/**
     * �w��e���v���[�g��`�悷��B
     * @param topLevelPage  �`��g�b�v���x���̃y�[�W�B
     * @param template �`�悷��e���v���[�g�B
     * @return �e���v���[�g�v���Z�b�T�̃v���Z�X�X�e�[�g�t���O�B
     */
    ProcessStatus renderTemplate(Page topLevelPage, Template template);

	/**
	 * �w��e���v���[�g���f�R�[�h����B
     * @param topLevelPage  �`��g�b�v���x���̃y�[�W�B
     * @param template �`�悷��e���v���[�g�B
	 */
    void decodeTemplate(Page topLevelPage, Template template);
    
}
