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
package org.seasar.maya.cycle;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/**
 * ���N�G�X�g���x���̃X�R�[�v�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface Request extends Serializable, AttributeScope, Underlyable {
    
    /**
     * ���N�G�X�g���ꂽURI�p�X���擾����B
     * @return ���N�G�X�gURI�B
     */
    String getPath();
    
    /**
     * ���N�G�X�g�̃N�G���p�����[�^�̖��O�ꗗ�B
     * @return �N�G���p�����[�^���iString�j��ێ�����C�e���[�^�B
     */
    Iterator iterateParameterNames();
    
    /**
     * ���N�G�X�g�̃N�G���p�����[�^��ێ�����Map�B�G���g����String[]�^�ƂȂ�B
     * @return �N�G���p�����[�^��Map�B
     */
    Map getParameterMap();

    /**
     * �w�薼�̃��N�G�X�g�̃N�G���p�����[�^�l��Ԃ��B
     * �Y������N�G���p�����[�^���������ꍇ��null��Ԃ��B
     * @param name �w��N�G���p�����[�^���B
     * @return �w��N�G���p�����[�^�l�B
     */
    String[] getParameterValues(String name);

    /**
     * �w�薼�̃��N�G�X�g�̃N�G���p�����[�^�l��Ԃ��B
     * �Y������N�G���p�����[�^���������ꍇ��null��Ԃ��B
     * getParameterValues()[0]�Ɠ������ʂ�Ԃ��B
     * @param name �w��N�G���p�����[�^���B
     * @return �w��N�G���p�����[�^�l�B
     */
    String getParameter(String name);

    /**
     * ���N�G�X�g�̃��P�[����Ԃ��B
     * @return ���N�G�X�g���P�[���B
     */
    Locale getLocale();
    
}
