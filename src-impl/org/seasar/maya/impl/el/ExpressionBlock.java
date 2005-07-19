/*
 * Copyright (c) 2004-2005 the Seasar Foundation and the Others.
 * 
 * Licensed under the Seasar Software License, v1.1 (aka "the License"); you may
 * not use this file except in compliance with the License which accompanies
 * this distribution, and is available at
 * 
 *     http://www.seasar.org/SEASAR-LICENSE.TXT
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.seasar.maya.impl.el;

import org.seasar.maya.impl.util.StringUtil;

/**
 * ������u���b�N�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public class ExpressionBlock {

	private String _blockString;
	private boolean _literal; 

	/**
	 * @param blockString �u���b�N������B
	 * @param literal ���e���������񂩂ǂ����Btrue���ƃ��e�����Bfalse���ƕ]�����B
	 */
	public ExpressionBlock(String blockString, boolean literal) {
		if (StringUtil.isEmpty(blockString)) {
			throw new IllegalArgumentException();
		}
		_blockString = blockString;
		_literal = literal;
	}

	/**
	 * ���e���������񂩂ǂ����̃e�X�g�B
	 * @return true�Ń��e����������Bfalse���ƕ]�����B
	 */
	public boolean isLiteral() {
	    return _literal;
	}
	
	/**
	 * �u���b�N������̎擾�B
	 * @return �u���b�N������B
	 */
	public String getBlockString() {
	    if(_literal) {
	        return _blockString;
	    }
	    return StringUtil.resolveEntity(_blockString);	    
	}

}