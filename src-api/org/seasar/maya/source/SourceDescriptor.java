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
import java.util.Iterator;

/**
 * �e���v���[�g�t�@�C����ݒ�XML�t�@�C���̃f�B�X�N���v�^�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface SourceDescriptor extends Serializable {
    
    /**
     * �\�[�X�̃p�X�BProtocol + SystemID�B
     * @return �\�[�X�p�X�B
     */
    String getPath();

    /**
     * �\�[�X�p�X���̃v���g�R�����B
     * @return �v���g�R�����B
     */
    String getProtocol();
    
    /**
     * �\�[�X�p�X����SystemID�B
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
     * �q�m�[�h�̃t�@�C���Q�����ׂăC�e���[�g����B
     * @return SourceDescriptor�̃C�e���[�^�B�q�m�[�h������������A
     * ���g���t�@�C�����Ɣ�null�[�����̃C�e���[�^��Ԃ��B
     */
    Iterator iterateChildren();

    /**
     * �w��g���q�̎q�m�[�h�t�@�C���Q�����ׂăC�e���[�g����B
     * @param extension �C�e���[�g����q�m�[�h�̎w��g���q�B
     * @return SourceDescriptor�̃C�e���[�^�B�q�m�[�h������������A
     * ���g���t�@�C�����Ɣ�null�[�����̃C�e���[�^��Ԃ��B
     */
    Iterator iterateChildren(String extension);

}
