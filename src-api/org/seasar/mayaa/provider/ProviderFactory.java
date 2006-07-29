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
package org.seasar.mayaa.provider;

import org.seasar.mayaa.UnifiedFactory;

/**
 * �A�v���P�[�V�����T�[�r�X�v���o�C�_�̃t�@�N�g��
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface ProviderFactory extends UnifiedFactory {

    /**
     * �T�[�r�X�v���o�C�_�̎擾�B
     * @return �T�[�r�X�v���o�C�_�B
     */
    ServiceProvider getServiceProvider();

}
