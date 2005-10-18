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
package org.seasar.maya.engine.processor;

/**
 * �`��O�ɁA�c���[�\����f�[�^�\���̕����������s���v���Z�b�T����������B
 * JSF���̃~�h���E�F�A�Ή��@�\�B
 * @author Masataka Kurihara (Gluegent, Inc)
 */
public interface DecodeTreeWalker extends ProcessorTreeWalker {

	/**
	 * �J���^�O�ɂ�����f�R�[�h�C�x���g�B
     * @param topLevelPage �`��g�b�v���x���̃y�[�W�B
	 * @param parentDecode ���߂̃f�R�[�h�B
	 */
	void doStartDecode(DecodeTreeWalker parentDecode);
	
	/**
	 * ���^�O�ɂ�����f�R�[�h�C�x���g�B
     * @param parentDecode ���߂̃f�R�[�h�B
	 */
	void doEndDecode(DecodeTreeWalker parentDecode);
	
}
