/*
 * Copyright (c) 2004-2005 the Seasar Project and the Others.
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
package org.seasar.maya.provider;

/**
 * PageContext�̃`���[�j���O�ݒ�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface PageContextSetting {

    /**
     * ����PageContext�����I�v�V�����B�w�肵�Ȃ��ꍇ�A�T�[�u���b�g�R���e�i�ɂ܂�����B
     * @return �G���[�������Ƀt�H���[�h����y�[�WURL�B
     */
    String getErrorPageURL();

    /**
     * ����PageContext�����I�v�V�����B�f�t�H���g�ł́u8192�v�B
     * @return �����o���o�b�t�@�̃T�C�Y�B
     */
    int getBufferSize();
    
    /**
     * ����PageContext�����I�v�V�����B�f�t�H���g�ł́ufalse�v
     * @return �����Z�b�V���������̗L���B
     */
    boolean isNeedSession();

    /**
     * ����PageContext�����I�v�V�����B�f�t�H���g�ufalse�v�B
     * @return �����t���b�V�����邩�ǂ����B
     */
    boolean isAutoFlush();    

}
