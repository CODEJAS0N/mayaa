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
package org.seasar.maya.impl.builder;

import org.seasar.maya.impl.MayaException;

/**
 * �e���v���[�g��ݒ�XML�Ɏw�肳�ꂽ�m�[�h���⑮�������s���ȏꍇ�̗�O�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public class IllegalNameException extends MayaException {

	private static final long serialVersionUID = 2431120366863355234L;

	private String _qName;
	
	/**
	 * @param qName �s���ȃm�[�h���B 
	 */
	public IllegalNameException(String qName) {
		_qName = qName;
    }
	
	/**
	 * �m�[�h�����擾����B
	 * @return �s���ȃm�[�h���B
	 */
	public String getQName() {
		return _qName;
	}
	
}
