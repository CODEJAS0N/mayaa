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

import java.io.Serializable;

import org.seasar.mayaa.cycle.script.CompiledScript;
import org.seasar.mayaa.engine.processor.ProcessStatus;
import org.seasar.mayaa.engine.processor.TemplateProcessor;
import org.seasar.mayaa.engine.specification.Specification;

/**
 * �e���v���[�g�̃����_�����O�G���g���[�|�C���g�B�A�v���P�[�V�������\������
 * �e�y�[�W�̃��f���ł���A���N�G�X�g�ɑ΂��Ă̓X�e�[�g���X�ȃI�u�W�F�N�g�ł���B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface Page
        extends Serializable, Specification, TemplateRenderer {

    /**
     * �C���X�^���X��������������B
     * @param pageName �y�[�W���B
     */
    void initialize(String pageName);

    /**
     * �p�����y�[�W�̎擾�B
     * @return �p�����y�[�W��������null�B
     */
    Page getSuperPage();

    /**
     * �p�����e���v���[�g�ڔ����̎擾�B
     * @return �e���v���[�g�ڔ����B
     */
    String getSuperSuffix();

    /**
     * �p�����e���v���[�g�g���q�̎擾�B
     * @return �e���v���[�g�g���q�B
     */
    String getSuperExtension();
    
    /**
     * �y�[�W�̖��O���擾����B/context/hello.html�ł���΁A
     * �u/context/hello�v��Ԃ��B
     * @return �y�[�W���B
     */
    String getPageName();

    /**
     * �e���v���[�g�ڔ��������肷��R���p�C���ς݃X�N���v�g�B
     * @return �R���p�C���ς݃X�N���v�g�B
     */
    CompiledScript getSuffixScript();

    /**
     * �e���v���[�g�ڔ������K�؂�Template�I�u�W�F�N�g�����[�h���ĕԂ��B
     * @param suffix �e���v���[�g�ڔ����B
     * @param extension �e���v���[�g�g���q�B
     * @return �����_�����O����e���v���[�g�B
     */
    Template getTemplate(String suffix, String extension);
    
    /**
     * �e���v���[�g�����_�����O���s���B
     * @param requestedSuffix ���N�G�X�g���ꂽ�e���v���[�g�ڔ����B
     * @param extension �e���v���[�g�g���q�B
     * @return �v���Z�b�T�����X�e�[�^�X�B
     */
    ProcessStatus doPageRender(String requestedSuffix, String extension);

    /**
     * �g�b�v�y�[�W�̏ꍇ�ɁA�����_�����O�J�n���Ƀv���Z�b�T�ɑ΂���
     * �ʒm���s���悤�o�^����B
     * @param processor �ʒm���󂯂�v���Z�b�T�B
     * @return true=�o�^���� / false=���ɓo�^�ς�
     */
    boolean registBeginRenderNotifier(TemplateProcessor processor);
    
}
