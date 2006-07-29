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

import java.util.Map;

import org.seasar.mayaa.ParameterAware;
import org.seasar.mayaa.engine.error.ErrorHandler;
import org.seasar.mayaa.engine.specification.Specification;

/**
 * �����^�C���G���W���B�z�X�g�T�[�u���b�g����service()���Ăяo�����B
 * ���N�G�X�g�ɑ΂��āA�X�e�[�g���X�Ɏ����B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface Engine extends ParameterAware, Specification {

    /**
     * �G���[�n���h���̐ݒ�B
     * @param errorHandler �G���[�n���h���B
     */
    void setErrorHandler(ErrorHandler errorHandler);

    /**
     * �G���[�n���h���̎擾�B
     * @return �G���[�n���h���B
     */
    ErrorHandler getErrorHandler();

    /**
     * Page�I�u�W�F�N�g�̃C���X�^���X��Ԃ��B
     * @param pageName �y�[�W���B
     * @return Page�I�u�W�F�N�g�B
     */
    Page getPage(String pageName);

    /**
     * �T�[�r�X���\�b�h�B
     * @param pageFlush �e���v���[�g�o�͂������Ńt���b�V�����邩�ǂ����B
     * @deprecated
     */
    void doService(boolean pageFlush);

    /**
     * �T�[�r�X���\�b�h�B
     * @param pageScopeValues PAGE�X�R�[�v�̃g�b�v�Ɋ܂߂���́B
     * @param pageFlush �e���v���[�g�o�͂������Ńt���b�V�����邩�ǂ����B
     */
    void doService(Map pageScopeValues, boolean pageFlush);

    /**
     * �G���[�n���h���y�[�W�̕\���B
     * @param t ����������O�B
     * @param pageFlush �e���v���[�g�o�͂������Ńt���b�V�����邩�ǂ����B
     */
    void handleError(Throwable t, boolean pageFlush);

    /**
     * �y�[�W�̃C���X�^���X�𐶐����ĕԂ��B
     * @param pageName �y�[�W��
     * @return �y�[�W
     */
    Page createPageInstance(String pageName);

    /**
     * �e���v���[�g�̃C���X�^���X�𐶐����ĕԂ��B
     * @param page �y�[�W
     * @param suffix �e���v���[�g�̐ڔ��q�B
     * @param extension �y�[�W�̊g���q�B
     * @return �e���v���[�g
     */
    Template createTemplateInstance(Page page, String suffix, String extension);

}
