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
package org.seasar.maya.impl.cycle.el;

/**
 * ���R���p�C�����̕��@��O�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public class SyntaxException extends ExpressionException {

	private static final long serialVersionUID = 4167069503212250014L;

	private String _expression;
    
    /**
     * @param expression ��������B
     */
    public SyntaxException(String expression) {
        _expression = expression;
    }
    
    /**
     * ���͎�������̎擾�B
     * @return ��������B
     */
    public String getExpression() {
        return _expression;
    }
    
}
