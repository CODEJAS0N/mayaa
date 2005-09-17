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

import org.seasar.maya.engine.error.ErrorHandler;
import org.seasar.maya.engine.specification.Specification;
import org.seasar.maya.provider.Parameterizable;

/**
 * �����^�C���G���W���B�z�X�g�T�[�u���b�g����service()���Ăяo�����B 
 * ���N�G�X�g�ɑ΂��āA�X�e�[�g���X�Ɏ����B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface Engine extends Parameterizable, Specification, Serializable {

    /**
     * �J�X�^���ݒ荀�ڂ̎擾���\�b�h�B
     * @param name �ݒ薼�B
     * @return �ݒ肳�ꂽ���ځB
     */
    String getParameter(String name);
    
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
     */
    void doService();
    
}