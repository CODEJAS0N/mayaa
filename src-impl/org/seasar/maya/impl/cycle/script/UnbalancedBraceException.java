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
package org.seasar.maya.impl.cycle.script;

/**
 * ���u���b�N�̊J���E���̃o�����X�������Ƃ��̗�O�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public class UnbalancedBraceException extends ScriptException {

	private static final long serialVersionUID = 9098125536269480736L;

	private String _expression;
	private int _offset;
	
	/**
	 * @param expression ���̎�������B
	 * @param offset �A���o�����X�̔����ӏ��B
	 */
	public UnbalancedBraceException(String expression, int offset) {
		_expression = expression;
		_offset = offset;
	}
	
	/**
	 * ��������̎擾�B
	 * @return ��������B
	 */
	public String getExpression() {
		return _expression;
	}
	
	/**
	 * �A���o�����X�����ӏ��̎擾�B
	 * @return �����ӏ��I�t�Z�b�g�B
	 */
	public int getOffset() {
		return _offset;
	}
	
}
