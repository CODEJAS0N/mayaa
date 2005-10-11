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
package org.seasar.maya;

import java.io.Serializable;

import org.seasar.maya.cycle.factory.CycleFactory;
import org.seasar.maya.provider.factory.ProviderFactory;
import org.seasar.maya.source.factory.SourceFactory;

/**
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public abstract class FactoryFactory 
		implements ParameterAware, Serializable {

    private static FactoryFactory _instance; 
    private static Object _context;
    private static ProviderFactory _providerFactory;
    private static CycleFactory _cycleFactory;
    private static SourceFactory _sourceFactory;
    
    /**
     * �t�@�N�g���̏������B 
     * @param instance �t�@�N�g���̃C���X�^���X�B
     */
    public static void setInstance(FactoryFactory instance) {
        if(instance == null) {
            throw new IllegalArgumentException();
        }
        _instance = instance;
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
    
    private static void check() {
        if(_instance == null || _context == null) {
            throw new IllegalStateException();
        }
    }
    
    /**
     * �T�[�r�X�v���o�C�_�̃t�@�N�g�����擾����B
     * @return �T�[�r�X�v���o�C�_�t�@�N�g���B
     */
    public static ProviderFactory getProviderFactory() {
        check();
        if(_providerFactory == null) {
            _providerFactory = _instance.createProviderFactory(_context);
        }
        return _providerFactory;
    }
    
    /**
     * �T�[�r�X�T�C�N���̃t�@�N�g�����擾����B
     * @return �T�[�r�X�T�C�N���t�@�N�g���B
     */
    public static CycleFactory getCycleFactory() {
        check();
        if(_cycleFactory == null) {
            _cycleFactory = _instance.createCycleFactory(_context);
        }
        return _cycleFactory;
    }
    
    /**
     * �\�[�X��`�̃t�@�N�g�����擾����B
     * @return �\�[�X��`�t�@�N�g���B
     */
    public static SourceFactory getSourceFactory() {
        check();
        if(_sourceFactory == null) {
            _sourceFactory = _instance.createSourceFactory(_context);
        }
        return _sourceFactory;
    }
    
    /**
     * �p�����[�^��ݒ肷��B
     * @param name �p�����[�^���B
     * @param value �p�����[�^�l�B
     */
    public static void setParameterToInstance(String name, String value) {
    	check();
    	_instance.setParameter(name, value);
    }
    
    /**
     * �T�[�r�X�v���o�C�_�̃t�@�N�g���𐶐�����B
     * @param context �R���e�L�X�g�I�u�W�F�N�g�B
     * @return �T�[�r�X�v���o�C�_�̃t�@�N�g���B
     */
    protected abstract ProviderFactory createProviderFactory(Object context);
    
    /**
     * �T�[�r�X�T�C�N���̃t�@�N�g���𐶐�����B
     * @param context �R���e�L�X�g�I�u�W�F�N�g�B
     * @return �T�[�r�X�T�C�N���̃t�@�N�g���B
     */
    protected abstract CycleFactory createCycleFactory(Object context);
    
    /**
     * �\�[�X��`�̃t�@�N�g���𐶐�����B
     * @param context �R���e�L�X�g�I�u�W�F�N�g�B
     * @return �\�[�X��`�̃t�@�N�g���B
     */
    protected abstract SourceFactory createSourceFactory(Object context);
    
}
