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
package org.seasar.maya.provider;

/**
 * Engine�̃`���[�j���O�ݒ�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface EngineSetting {

    /**
     * �J�X�^���ݒ荀�ڂ̎擾���\�b�h�B
     * @param name �ݒ薼�B
     * @return �ݒ肳�ꂽ���ځB
     */
    String getParameter(String name);
    
    /**
     * Engine�̃I�v�V�����B
     * @return �e���v���[�g��ݒ�t�@�C���̕ۑ���������Ƀ`�F�b�N����ꍇ��true�B
     */
    boolean isCheckTimestamp();

    /**
     * �e���v���[�g��IgnorableWhitespace���o�͂��邩�ǂ����̎擾�B
     * @return IgnorableWhitespace�̏o�́Btrue�ŏo�͂���B
     */
    boolean isOutputWhitespace();    
    
	/**
	 * Engine�̃I�v�V�����B�f�t�H���g�́u$�v�B
	 * @return �e���v���[�g�ڔ����̋�؂蕶����B
	 */
	String getSuffixSeparator();
    
	/**
	 * Engine�̃I�v�V�����B�e���v���[�g���mayaID��������id�ŊY������m�[�h
	 * �������Ȃ������Ƃ��ɁA��O�𓊂��邩�ǂ������擾����B
	 * @return true�Ńm�[�h�������Ȃ������Ƃ��̗�O�X���[�Bfalse�Ŗ����B
	 */
	boolean isReportUnresolvedID();
	
}
