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
package org.seasar.maya.engine.specification;

/**
 * QName���擾�ł���I�u�W�F�N�g�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface QNameable extends Namespace {

    /**
     * ���O���URI����у��[�J�����̑g�ݍ��킹�̎擾�B
     * @return ���O���URI����у��[�J�����̑g�ݍ��킹�B 
     */
    QName getQName();

    /**
     * �e���v���[�g��ݒ�XML�ɋL�q����Ă���v���t�B�b�N�X���擾�B
     * @return �v���t�B�b�N�X�������������null�B
     */
    String getPrefix();
    
}
