/*
 * Copyright (c) 2004-2005 the Seasar Foundation and the Others.
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
package org.seasar.maya.cycle;

import java.io.Serializable;
import java.util.Iterator;

/**
 * �T�[�r�X�̃��C�t�T�C�N���I�u�W�F�N�g�BHTTP���N�G�X�g�̊��ԁA�T�[�r�X�̃R���e�L�X�g�ƂȂ�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface ServiceCycle extends Serializable, AttributeScope {

    String SERVICE_CYCLE = "serviceCycle";
    String PARAM = "param";
    String PARAM_VALUES = "paramValues";
    String HEADER = "header";
    String HEADER_VALUES = "headerValues";

    String SCOPE_IMPLICIT = "implicit";
    String SCOPE_PAGE = "page";
    String SCOPE_REQUEST = "request";
    String SCOPE_SESSION = "session";
    String SCOPE_APPLICATION = "application";
    
    /**
     * �uapplication�v�X�R�[�v�I�u�W�F�N�g�̎擾�B
     * @return �uapplication�v�X�R�[�v�B 
     */
    Application getApplication();
    
    /**
     * �urequest�v�X�R�[�v�I�u�W�F�N�g�̎擾�B
     * @return �urequest�v�X�R�[�v�B
     */
    Request getRequest();
    
    /**
     * ���X�|���X�I�u�W�F�N�g�̎擾�B
     * @return ���X�|���X�B
     */
    Response getResponse();
    
    /**
     * �w��X�R�[�v���ɕۑ�����Ă��閼�O���C�e���[�g����B
     * @param scope �w��X�R�[�v���B
     * @return ���O�iString�j�̓������C�e���[�^�Bnull�������͋󔒕�����̂Ƃ���"page"�X�R�[�v�B
     */
    Iterator iterateAttributeNames(String scope);
    
    /**
     * �w��X�R�[�v�����w�薼�̃I�u�W�F�N�g���擾����B
     * �Y��������̂������ꍇ�Anull��Ԃ��B
     * @param name �w��I�u�W�F�N�g���B
     * @param scope �w��X�R�[�v���B
     * @return �Y���I�u�W�F�N�g��������null�Bnull�������͋󔒕�����̂Ƃ���"page"�X�R�[�v�B
     */
    Object getAttribute(String name, String scope);
    
    /**
     * �w��X�R�[�v���ɁA���O���w�肵�ăI�u�W�F�N�g��ۑ�����B
     * @param name �w��I�u�W�F�N�g���B
     * @param attribute �ۑ��I�u�W�F�N�g�B
     * @param scope �w��X�R�[�v���Bnull�������͋󔒕�����̂Ƃ���"page"�X�R�[�v�B
     */
    void setAttribute(String name, Object attribute, String scope);

    /**
     * �n���ꂽURL������ɁA�K�v�ł���΃Z�b�V����ID��t������B
     * @param url URL������B
     * @return �Z�b�V����ID��t������������B 
     */
    String encodeURL(String url);

    /**
     * �t�H���[�h���s���B
     * @param relativeUrlPath �p�X������B
     */
    void forward(String relativeUrlPath);
    
    /**
     * ���_�C���N�g���s���B
     * @param url ���_�C���N�g���s��URL������B
     */
    void redirect(String url);
    
    /**
     * �C���N���[�h���s���B
     * @param relativeUrlPath �p�X������B
     */
    void include(String relativeUrlPath);
    
}
