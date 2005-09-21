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
package org.seasar.maya.provider.factory;

import java.io.Serializable;

import org.seasar.maya.provider.ServiceProvider;

/**
 * �A�v���P�[�V�����T�[�r�X�v���o�C�_�̃t�@�N�g���N���X
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public abstract class ProviderFactory implements Serializable {

	private static ProviderFactory _factory;
	private static Object _context;
	
	/**
	 * �t�@�N�g���̃J�X�^�}�C�Y�p�B 
	 * @param factory �J�X�^�}�C�Y�����t�@�N�g���B
	 */
	public static void setDefaultFactory(ProviderFactory factory) {
	    if(factory == null) {
	        throw new IllegalArgumentException();
	    }
		_factory = factory;
	}
	
	/**
     * �R���e�L�X�g�I�u�W�F�N�g�ݒ�B
	 * @param context �J�����g�A�v���P�[�V�����̃R���e�L�X�g�I�u�W�F�N�g�B
	 */
	public static void setContext(Object context) {
	    if(context == null) {
	        throw new IllegalArgumentException();
	    }
	    _context = context;
	}
	 
	/**
	 * �T�[�r�X�v���o�C�_�̎擾�B
	 * @return �T�[�r�X�v���o�C�_�B
	 */
	public static ServiceProvider getServiceProvider() {
	    if(_factory == null || _context == null) {
	        throw new IllegalStateException();
	    }
		return _factory.getServiceProvider(_context);
	}
	
	/**
	 * �T�[�r�X�v���o�C�_�̎擾�B�����������̓L���b�V�����Ă���v���o�C�_�����o���B
	 * @param context �R���e�L�X�g�I�u�W�F�N�g�B
	 * @return �T�[�r�X�v���o�C�_�B
	 */
	protected abstract ServiceProvider getServiceProvider(Object context);
	
}
