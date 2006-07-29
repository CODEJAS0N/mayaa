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
package org.seasar.mayaa.cycle;

import java.io.Serializable;
import java.util.Iterator;

import org.seasar.mayaa.ParameterAware;
import org.seasar.mayaa.cycle.scope.ApplicationScope;
import org.seasar.mayaa.cycle.scope.AttributeScope;
import org.seasar.mayaa.cycle.scope.RequestScope;
import org.seasar.mayaa.cycle.scope.SessionScope;
import org.seasar.mayaa.engine.processor.ProcessorTreeWalker;
import org.seasar.mayaa.engine.specification.NodeTreeWalker;

/**
 * �T�[�r�X�̃��C�t�T�C�N���I�u�W�F�N�g�BHTTP���N�G�X�g�̊��ԁA
 * �T�[�r�X�̃R���e�L�X�g�ƂȂ�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface ServiceCycle
        extends ParameterAware, Serializable {

    /**
     * �A�v���P�[�V�������x���X�R�[�v�B
     */
    String SCOPE_APPLICATION = "application";

    /**
     * �Z�b�V�������x���X�R�[�v�B
     */
    String SCOPE_SESSION = "session";

    /**
     * ���N�G�X�g���x���X�R�[�v�B
     */
    String SCOPE_REQUEST = "request";

    /**
     * �y�[�W���x���X�R�[�v�B
     */
    String SCOPE_PAGE = "page";

    /**
     * �t�H���[�h���s���B
     * @param forwardPath �p�X������B
     */
    void forward(String forwardPath);

    /**
     * ���_�C���N�g���s���B
     * @param url ���_�C���N�g���s��URL������B
     */
    void redirect(String url);

    /**
     * �G���[���X�|���X��Ԃ��B
     * @param errorCode �G���[�R�[�h�B
     */
    void error(int errorCode);

    /**
     * ���b�Z�[�W����̃G���[���X�|���X��Ԃ��B
     * @param errorCode �G���[�R�[�h�B
     * @param message �G���[���b�Z�[�W�B
     */
    void error(int errorCode, String message);

    /**
     * �J�����g�̃y�[�W�X�R�[�v�ɂăX�N���v�g��ǂݍ��݁A���s����B
     * �\�[�X�G���R�[�f�B���O��UTF-8�Ƃ���B
     * @param systemID �X�N���v�g�\�[�X��SystemID�B
     */
    void load(String systemID);

    /**
     * �J�����g�̃y�[�W�X�R�[�v�ɂăX�N���v�g��ǂݍ��݁A���s����B
     * @param systemID �X�N���v�g�\�[�X��SystemID�B
     * @param encoding �\�[�X�G���R�[�f�B���O�B
     */
    void load(String systemID, String encoding);

    /**
     * �A�v���P�[�V�����X�R�[�v�I�u�W�F�N�g�̎擾�B
     * @return �A�v���P�[�V�����B
     */
    ApplicationScope getApplicationScope();

    /**
     * ���N�G�X�g�I�u�W�F�N�g�̎擾�B
     * @return ���N�G�X�g�B
     */
    RequestScope getRequestScope();

    /**
     * �Z�b�V�����̎擾�B
     * @return �Z�b�V�����I�u�W�F�N�g�B
     */
    SessionScope getSessionScope();

    /**
     * ���X�|���X�I�u�W�F�N�g�̎擾�B
     * @return ���X�|���X�B
     */
    Response getResponse();

    /**
     * �upage�v�X�R�[�v�I�u�W�F�N�g�̐ݒ�B
     * @param page �upage�v�X�R�[�v�B
     */
    void setPageScope(AttributeScope page);

    /**
     * �upage�v�X�R�[�v�I�u�W�F�N�g�̎擾�B
     * @return �upage�v�X�R�[�v�B
     */
    AttributeScope getPageScope();

    /**
     * �w��X�R�[�v��ێ����Ă��邩���e�X�g����B
     * @param scopeName �w��X�R�[�v���B
     * @return �e�X�g���ʁB�w��X�R�[�v��ێ����Ă���Ƃ�true�B
     */
    boolean hasAttributeScope(String scopeName);

    /**
     * �w��X�R�[�v���擾����B
     * @param scopeName �w��X�R�[�v���B
     * @return �w��X�R�[�v�B�X�R�[�v�������ꍇ�A��O�B
     */
    AttributeScope getAttributeScope(String scopeName);

    /**
     * �X�R�[�v���C�e���[�g����B
     * @return �X�R�[�v�iAttributeScope�j�̃C�e���[�^�B
     */
    Iterator iterateAttributeScope();

    /**
     * ���ݏ������̃e���v���[�g��m�[�h����ݒ肷��B
     * @param node �e���v���[�g�m�[�h�B
     */
    void setOriginalNode(NodeTreeWalker node);

    /**
     * ���ݏ������̃e���v���[�g��m�[�h���̎擾�B
     * @return �e���v���[�g�m�[�h�B
     */
    NodeTreeWalker getOriginalNode();

    /**
     * ���ݏ������̃C���W�F�N�V�������ꂽ�m�[�h���̐ݒ�B
     * @param node �C���W�F�N�g���ꂽ�m�[�h�B
     */
    void setInjectedNode(NodeTreeWalker node);

    /**
     * ���ݏ������̃C���W�F�N�V�������ꂽ�m�[�h���̎擾�B
     * @return �C���W�F�N�g���ꂽ�m�[�h�B
     */
    NodeTreeWalker getInjectedNode();

    /**
     * ���ݏ������̃v���Z�b�T�̐ݒ�B
     * @param processor �������̃v���Z�b�T�B
     */
    void setProcessor(ProcessorTreeWalker processor);

    /**
     * ���ݏ������̃v���Z�b�T�̎擾�B
     * @return �������̃v���Z�b�T�B��������null�B
     */
    ProcessorTreeWalker getProcessor();

    /**
     * �G���[�n���h�����ɎQ�Ƃ���A����������O���̎擾�B
     * @param t ����������O�B
     */
    void setHandledError(Throwable t);

    /**
     * �G���[�n���h�����ɁA����������O�����Q�Ƃ���B
     * @return ����������O�B��������null�B
     */
    Throwable getHandledError();

}
