/*
 * Copyright (c) 2004-2005 the Seasar Foundation and the Others.
 *
 * Licensed under the Seasar Software License, v1.1 (aka "the License");
 * you may not use this file except in compliance with the License which
 * accompanies this distribution, and is available at
 *
 *     http://www.seasar.org/SEASAR-LICENSE.TXT
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package org.seasar.maya.source;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;

import org.seasar.maya.provider.Parameterizable;

/**
 * �e���v���[�g�t�@�C����ݒ�XML�t�@�C���̃f�B�X�N���v�^�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface SourceDescriptor extends Serializable, Parameterizable {

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

    /**
     * �\�[�X�̕t�������̎擾�B
     * @param name �������B
     * @return �����l�B
     */
    String getAttribute(String name);
    
}
