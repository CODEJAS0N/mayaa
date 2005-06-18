/*
 * Copyright (c) 2004-2005 the Seasar Project and the Others.
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
package org.seasar.maya.provider.factory;

import java.io.Serializable;

import javax.servlet.ServletContext;

import org.seasar.maya.provider.ModelProvider;
import org.seasar.maya.provider.ServiceProvider;

/**
 * �A�v���P�[�V�����T�[�r�X�v���o�C�_�̃t�@�N�g���N���X
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public abstract class ServiceProviderFactory implements Serializable {

	private static ServiceProviderFactory _factory;
	private static ServletContext _servletContext;
	
	/**
	 * �t�@�N�g���̃J�X�^�}�C�Y�p�B 
	 * @param factory �J�X�^�}�C�Y�����t�@�N�g���B
	 */
	public static void setDefaultFactory(ServiceProviderFactory factory) {
	    if(factory == null) {
	        throw new IllegalArgumentException();
	    }
		_factory = factory;
	}
	
	/**
	 * �T�[�u���b�g�R���e�L�X�g�̐ݒ�B
	 * @param servletContext �J�����g�̃T�[�u���b�g�R���e�L�X�g�B
	 */
	public static void setServletContext(ServletContext servletContext) {
	    if(servletContext == null) {
	        throw new IllegalArgumentException();
	    }
	    _servletContext = servletContext;
	}
	 
	/**
	 * �T�[�r�X�v���o�C�_�̎擾�B
	 * @return �T�[�r�X�v���o�C�_�B
	 */
	public static ServiceProvider getServiceProvider() {
	    if(_factory == null || _servletContext == null) {
	        throw new IllegalStateException();
	    }
		return _factory.getServiceProvider(_servletContext);
	}

	/**
	 * ���f�������p�̃t�@�N�g���I�u�W�F�N�g�̎擾�B
	 * @return ���f�������t�@�N�g���I�u�W�F�N�g�B
	 */
	public static ModelProvider getModelProvider() {
	    if(_factory == null || _servletContext == null) {
	        throw new IllegalStateException();
	    }
		return _factory.getModelProvider(_servletContext);
	}
	
	/**
	 * �T�[�r�X�v���o�C�_�̎擾�B������������ServletContext���ɃT�[�u���b�g����
	 * �L�[�Ƃ��ĕۑ����Ă���v���o�C�_�����o���B
	 * @param servletContext �T�[�u���b�g�R���e�L�X�g�B
	 * @return �G���W���J�X�^�}�C�Y�p�R���e�L�X�g�B
	 */
	protected abstract ServiceProvider getServiceProvider(ServletContext servletContext);
	
	/**
	 * ���f�������p�̃t�@�N�g���I�u�W�F�N�g�̎擾�B������������ServletContext���ɃT�[�u���b�g����
	 * �L�[�Ƃ��ĕۑ����Ă���v���o�C�_�����o���B
	 * @param servletContext �T�[�u���b�g�R���e�L�X�g�B
	 * @return ���f�������t�@�N�g���I�u�W�F�N�g�B
	 */
	protected abstract ModelProvider getModelProvider(ServletContext servletContext);
	
}
