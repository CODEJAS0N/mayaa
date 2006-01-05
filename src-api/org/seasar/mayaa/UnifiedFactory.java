/*
 * Copyright 2004-2006 the Seasar Foundation and the Others.
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
package org.seasar.mayaa;

import java.io.Serializable;

/**
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface UnifiedFactory
    extends ContextAware, ParameterAware, Serializable {

    /**
     * �t�@�N�g���̏������B�쐬����T�[�r�X�Ώۂ̎����N���X�̐ݒ�B
     * @param serviceClass �T�[�r�X�Ώێ����N���X�^�B
     */
    void setServiceClass(Class serviceClass);

    /**
     * �쐬����T�[�r�X�Ώێ����N���X�̎擾�B
     * @return �T�[�r�X�Ώێ����N���X�^�B
     */
    Class getServiceClass();

}
