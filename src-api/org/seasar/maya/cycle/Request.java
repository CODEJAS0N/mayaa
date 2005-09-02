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
import java.util.Locale;

/**
 * ���N�G�X�g���x���̃X�R�[�v�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface Request extends Serializable, AttributeScope, Underlyable {

	/**
	 * ���N�G�X�g���ꂽ�p�X��������擾����B
	 * @return �p�X������B
	 */
	String getRequestedPath();
	
    /**
     * ���N�G�X�g���ꂽ�y�[�W�����擾����B
     * @return ���N�G�X�g�y�[�W���B
     */
    String getPageName();

    /**
     * ���N�G�X�g�ŋ��������y�[�W�ڔ������擾����B
     * @return ���N�G�X�g�ڔ����A��������null�B
     */
    String getRequestedSuffix();
    
    /**
     * ���N�G�X�g���ꂽ�y�[�W�g���q���擾����B
     * @return ���N�G�X�g�g���q�B
     */
    String getExtension();
    
    /**
     * ���N�G�X�g�p�����[�^���܂ރX�R�[�v���擾����B�����I�u�W�F�N�g��String�̔z��B
     * @return �N�G���p�����[�^�X�R�[�v�B
     */
    AttributeScope getParamValues();

    /**
     * ���N�G�X�g�w�b�_���܂ރX�R�[�v���擾����B�����I�u�W�F�N�g��String�̔z��B
     * @return �N�G���p�����[�^�X�R�[�v�B
     */
    AttributeScope getHeaderValues();

    /**
     * ���N�G�X�g�̃��P�[����Ԃ��B
     * @return ���N�G�X�g���P�[���B
     */
    Locale[] getLocales();

    /**
     * �t�H���[�h��̃p�X��ݒ肷��B
     * @param relativeUrlPath �R���e�L�X�g���΂̃p�X�B
     */
    void setForwardPath(String relativeUrlPath);
    
}
