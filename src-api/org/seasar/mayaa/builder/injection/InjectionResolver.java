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
package org.seasar.mayaa.builder.injection;

import org.seasar.mayaa.ParameterAware;
import org.seasar.mayaa.engine.specification.SpecificationNode;

/**
 * �e���v���[�g�ɋL�q���ꂽHTML�^�O�ɁA�ǉ��I�ȏ���ێ�����m�[�h��
 * �C���W�F�N�V�������郌�]���o�B���̃C���^�[�t�F�C�X���������ăG���W���̋���
 * ���J�X�^�}�C�Y���邱�Ƃ��ł���B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface InjectionResolver extends ParameterAware {

    /**
     * �e���v���[�g��̃I���W�i���ȃm�[�h�ɃC���W�F�N�V��������m�[�h�����肷��B
     * @param original �e���v���[�g��̃I���W�i���ȃm�[�h�B
     * @param chain ���̃��]���o�֏������Ϗ�����`�F�[���B
     * @return �C���W�F�N�V��������m�[�h�B
     */
    SpecificationNode getNode(SpecificationNode original, InjectionChain chain);

}
