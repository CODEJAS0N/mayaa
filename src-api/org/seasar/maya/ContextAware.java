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

/**
 * �O���R���e�L�X�g�I�u�W�F�N�g��Proxy�C���^�[�t�F�C�X�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface ContextAware {
    
    /**
     * �z�X�g����R���e�L�X�g�I�u�W�F�N�g�̐ݒ胁�\�b�h�B
     * @param context �R���e�L�X�g�I�u�W�F�N�g�B
     */
    void setUnderlyingContext(Object context);
    
    /**
     * �z�X�g����R���e�L�X�g�I�u�W�F�N�g�̎擾���\�b�h�B
     * @return �R���e�L�X�g�I�u�W�F�N�g�B
     */
    Object getUnderlyingContext();
    
}
