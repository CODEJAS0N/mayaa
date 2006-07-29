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
package org.seasar.mayaa.builder.library;

import java.util.Iterator;

import org.seasar.mayaa.ParameterAware;

/**
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface PropertySet extends ParameterAware {

    /**
     * ��O�⃍�O�̃��b�Z�[�W�p�r�Ƃ��āA�t�@�C�����ł̍s�ԍ����擾����B
     * @return �s�ԍ��B
     */
    int getLineNumber();

    /**
     * �������C�u�����̏�񃂃f���擾�B
     * @return ���C�u�������B
     */
    LibraryDefinition getLibraryDefinition();

    /**
     * �v���p�e�B�Z�b�g���̎擾�B
     * @return �v���p�e�B�Z�b�g���B
     */
    String getName();

    /**
     * �v���Z�b�T�ւ̃o�C���f�B���O��񃂃f���iPropertyDefinition�j
     * �I�u�W�F�N�g�̃C�e���[�g�B
     * @return �o�C���f�B���O���C�e���[�^�[�B
     */
    Iterator iteratePropertyDefinition();

}
