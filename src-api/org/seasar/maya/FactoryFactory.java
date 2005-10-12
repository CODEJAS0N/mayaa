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
import java.util.HashMap;
import java.util.Map;

/**
 * �t�@�N�g���̃t�@�N�g���I�u�W�F�N�g�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public abstract class FactoryFactory 
		implements ParameterAware, Serializable {

    private static FactoryFactory _instance; 
    private static Object _context;
    private static Map _factories = new HashMap();
    
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
     * �t�@�N�g�����擾����B
     * @param �擾����t�@�N�g���̃C���^�[�t�F�C�X�B
     * @return �w��C���^�[�t�F�C�X�ɑΉ������t�@�N�g���B
     */
    public static UnifiedFactory getFactory(Class interfaceClass) {
        check();
        UnifiedFactory factory = (UnifiedFactory)_factories.get(interfaceClass);
        if(factory == null) {
            factory = _instance.createFactory(interfaceClass, _context);
            if(factory == null) {
            	throw new IllegalStateException();
            }
            _factories.put(interfaceClass, factory);
        }
        return factory;
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
     * �t�@�N�g���𐶐�����B
     * @param context �R���e�L�X�g�I�u�W�F�N�g�B
     * @return �t�@�N�g���B
     */
    protected abstract UnifiedFactory createFactory(
    		Class interfaceClass, Object context);
    
}
