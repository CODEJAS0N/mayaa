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

import org.seasar.maya.engine.specification.SpecificationNode;

/**
 * �T�[�r�X�̃��C�t�T�C�N���I�u�W�F�N�g�BHTTP���N�G�X�g�̊��ԁA�T�[�r�X�̃R���e�L�X�g�ƂȂ�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface ServiceCycle extends Serializable, AttributeScope {

    /**
     * �g�ݍ��݃I�u�W�F�N�g�擾�̂��߂̓��ʃX�R�[�v�B
     */
    String SCOPE_IMPLICIT = "implicit";
    
    /**
     * �y�[�W���x���X�R�[�v�B 
     */
    String SCOPE_PAGE = "page";
    
    /**
     * ���N�G�X�g���x���X�R�[�v�B
     */
    String SCOPE_REQUEST = "request";
    
    /**
     * �Z�b�V�������x���X�R�[�v�B
     */
    String SCOPE_SESSION = "session";
    
    /**
     * �A�v���P�[�V�������x���X�R�[�v�B
     */
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
     * �w��X�R�[�v�����݂��邩���e�X�g����B
     * @param scope �X�R�[�v����������null�Bnull�̏ꍇ�́upage�v�Ƃ���B
     * @return �w��X�R�[�v�̑��݃e�X�g���ʁB
     */
    boolean hasAttributeScope(String scope);
    
    /**
     * �X�R�[�v��ԃI�u�W�F�N�g�̎擾�B
     * @param scope �X�R�[�v����������null�Bnull�̏ꍇ�́upage�v�Ƃ���B
     * @return �X�R�[�v��ԃI�u�W�F�N�g�B
     */
    AttributeScope getAttributeScope(String scope);
    
    /**
     * �X�R�[�v��ԃI�u�W�F�N�g�̒ǉ��B�G���W���J�X�^�}�C�Y�p��API�B
     * @param scope �X�R�[�v���B��null�̂݋������B
     * @param attrScope �X�R�[�v��ԃI�u�W�F�N�g�B
     */
    void putAttributeScope(String scope, AttributeScope attrScope);

    /**
     * �y�[�W�X�R�[�v��Ԃ����Z�b�g����B
     */
    void resetPageScope();
    
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
     * ���ݏ������̃m�[�h��ݒ肷��B��O����f�o�b�O�ȂǂŊJ���҂ɒ񋟂�����B
     * @param node �������̃m�[�h�B
     */    
    void setCurrentNode(SpecificationNode node);
    
    /**
     * ���ݏ������̃m�[�h���擾����B��O����f�o�b�O�ȂǂŊJ���҂ɒ񋟂�����B
     * @return �������̃m�[�h�B
     */
    SpecificationNode getCurrentNode();
    
}
