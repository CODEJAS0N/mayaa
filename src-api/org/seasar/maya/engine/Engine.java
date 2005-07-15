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
package org.seasar.maya.engine;

import java.io.Serializable;

import org.seasar.maya.cycle.ServiceCycle;
import org.seasar.maya.engine.error.ErrorHandler;
import org.seasar.maya.engine.specification.Specification;
import org.seasar.maya.provider.EngineSetting;
import org.seasar.maya.provider.Parameterizable;

/**
 * �����^�C���G���W���B�z�X�g�T�[�u���b�g����service()���Ăяo�����B 
 * ���N�G�X�g�ɑ΂��āA�X�e�[�g���X�Ɏ����B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface Engine extends Parameterizable, Specification, Serializable {
    
    /**
     * �G���[�n���h���̎擾�B
     * @return �G���[�n���h���B
     */
    ErrorHandler getErrorHandler();
    
    /**
     * �ݒ�̎擾�B
     * @return �ݒ�B
     */
    EngineSetting getEngineSetting();    

    /**
     * ���[�U�[���N�G�X�g���u/�v�ŏI���f�B���N�g���A�N�Z�X�̍ۂ�
     * �⊮����E�F���J���t�@�C�������擾����B
     * @return �E�F���J���t�@�C�����B
     */
    String getWelcomeFileName();
    
	/**
	 * Page�I�u�W�F�N�g�̃C���X�^���X��Ԃ��B
     * @param pageName �y�[�W���B
     * @param extension �y�[�W�g���q�B
	 * @return Page�I�u�W�F�N�g�B
	 */
    Page getPage(String pageName, String extension);

    /**
     * �T�[�r�X���\�b�h�B
     * @param cycle �T�[�r�X�T�C�N���R���e�L�X�g�B
     * @param pageName �y�[�W���B�u/WEB-INF�v�t�H���_���܂ނ��Ƃ��ł���B
     * @param requestedSuffix ���N�G�X�g�ŋ�������y�[�W�ڔ����Bnull�ł��悢�B
     * @param extension �y�[�W�g���q�B
     */
    void doService(ServiceCycle cycle, String pageName, 
    		String requestedSuffix, String extension);
    
}