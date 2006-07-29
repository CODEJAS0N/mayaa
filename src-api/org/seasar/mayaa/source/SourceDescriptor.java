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
package org.seasar.mayaa.source;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;

import org.seasar.mayaa.ParameterAware;

/**
 * �e���v���[�g�t�@�C����ݒ�XML�t�@�C���̃f�B�X�N���v�^�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface SourceDescriptor extends Serializable, ParameterAware {

    /**
     * �\�[�XSystemID��ݒ肷��B
     * @param systemID
     */
    void setSystemID(String systemID);

    /**
     * �\�[�XSystemID���擾����B
     * @return SystemID�B
     */
    String getSystemID();

    /**
     * �\�[�X�����݂��邩�ǂ������擾����B
     * @return �t�@�C�������݂����true�B�������false�B
     */
    boolean exists();

    /**
     * �t�@�C���̃C���v�b�g�X�g���[�����擾����B
     * @return �X�g���[���B�����t�@�C���������ꍇ�́Anull�B
     */
    InputStream getInputStream();

    /**
     * �t�@�C���̓��t���擾����B
     * @return �t�@�C���̍ŏI�X�V���t�B�t�@�C���������ꍇ�́unew Date(0)�v��Ԃ��B
     */
    Date getTimestamp();

}
