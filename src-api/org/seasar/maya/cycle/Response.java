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

import java.io.OutputStream;
import java.io.Serializable;

/**
 * ���X�|���X�̃C���^�[�t�F�C�X�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface Response extends Serializable, Underlyable  {
    
    /**
     * �R���e���c�^�C�v�̎w����s���B
     * @param mimeType �R���e���c�^�C�v�BMIME�^����уG���R�[�f�B���O���B
     */
    void setMimeType(String mimeType);
    
    /**
     * HTTP�X�e�[�^�X�R�[�h�̐ݒ�B
     * @param code �X�e�[�^�X�R�[�h�B�ʏ��200�B404�A500�ȂǁB
     */
    void setStatus(int code);
    
    /**
     * ���X�|���X�w�b�_�̏����o���B
     * @param name �w�b�_���B
     * @param value �w�b�_�̒l�B
     */
    void addHeader(String name, String value);
    
    /**
     * �����o���o�b�t�@�̃N���A���s���B
     */
    void clearBuffer();
    
    /**
     * �����o���o�b�t�@�̓��e���擾����B
     * @return �o�b�t�@���e�B
     */
    String getBuffer();
    
    /**
     * �o�b�t�@�ւ̏����o���B
     * @param b �����o���l�B
     */
    void write(int b);
    
    /**
     * �o�b�t�@�ւ̏����o���B
     * @param cbuf �����o���l�B
     */
    void write(char cbuf[]);
    
    /**
     * �o�b�t�@�ւ̏����o���B
     * @param cbuf �����o���l�B
     * @param off cbuf�̏����o���I�t�Z�b�g�B
     * @param len cbuf�̏����o�����B
     */
    void write(char cbuf[], int off, int len);
    
    /**
     * �o�b�t�@�ւ̏����o���B
     * @param str �����o���l�B
     */
    void write(String str);

    /**
     * �o�b�t�@�ւ̏����o���B
     * @param str �����o���l�B
     * @param off str�̏����o���I�t�Z�b�g�B
     * @param len str�̏����o�����B
     */
    void write(String str, int off, int len);
    
    /**
     * �o�b�t�@�̃t���b�V���B�J�����g�o�b�t�@���X�^�b�N�ɐς܂�Ă���ꍇ�́A
     * �ЂƂ�ʂ̃o�b�t�@�ɏ����o���B���[�g�̃o�b�t�@�ł���ꍇ�ɂ́A
     * ���ۂ̏o�̓X�g���[���ɏ����o���B
     */
    void flush();

    /**
     * �o�b�t�@���ꂽ���C�^���擾����B
     * @return �o�b�t�@���ꂽ���C�^�B
     */
    CycleWriter getWriter();
    
    /**
     * �o�b�t�@���ꂽ���C�^���X�^�b�N�ɐςށB
     * @return �ς񂾃o�b�t�@���ꂽ���C�^�B
     */
    CycleWriter pushWriter();
    
    /**
     * �X�^�b�N�ŏ�ʂ̃o�b�t�@���C�^����菜���B
     * @return ��菜�����o�b�t�@���C�^�B
     */
    CycleWriter popWriter();
    
    /**
     * ���ۂ̏o�̓X�g���[���̎擾�B
     * @return �o�̓X�g���[���B
     */
    OutputStream getUnderlyingOutputStream();
    
}
