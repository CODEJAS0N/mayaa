/*
 * Copyright (c) 2004-2005 the Seasar Project and the Others.
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
package org.seasar.maya.standard.engine.processor.jstl.fmt;

import javax.servlet.jsp.PageContext;

/**
 * Scope�̎��.
 * @author suga
 */
public class ContextScopeType {
    
    public static final ContextScopeType APPLICATION =
        new ContextScopeType(PageContext.APPLICATION_SCOPE, "application");
    public static final ContextScopeType SESSION =
        new ContextScopeType(PageContext.SESSION_SCOPE, "session");
    public static final ContextScopeType REQUEST =
        new ContextScopeType(PageContext.REQUEST_SCOPE, "request");
    public static final ContextScopeType PAGE =
        new ContextScopeType(PageContext.PAGE_SCOPE, "page");

    private int _value;
    private String _name;

    private ContextScopeType() {
    }

    private ContextScopeType(int value, String name) {
        _value = value;
        _name = name;
    }

    /**
     * �X�R�[�v�̒l���擾����B
     *
     * @return �X�R�[�v�̒l
     */
    public int getValue() {
        return _value;
    }

    /**
     * �X�R�[�v�����擾����B
     *
     * @return �X�R�[�v��
     */
    public String getName() {
        return _name;
    }

    /**
     * �����񂩂�ScopeType��Ԃ��B
     * ����`�l�̏ꍇ�ANESTED��Ԃ��B
     *
     * @param name �X�R�[�v��
     * @return ContextScopeType
     */
    public static ContextScopeType getByName(String name) {
        if (REQUEST._name.equalsIgnoreCase(name)) {
            return REQUEST;
        } else if (SESSION._name.equalsIgnoreCase(name)) {
            return SESSION;
        } else if (APPLICATION._name.equalsIgnoreCase(name)) {
            return APPLICATION;
        } else {
            return PAGE;
        }
    }

    /**
     * �l����ScopeType��Ԃ��B
     * ����`�l�̏ꍇ�ANESTED��Ԃ��B
     *
     * @param value �X�R�[�v�l
     * @return ContextScopeType
     */
    public static ContextScopeType getByValue(int value) {
        if (REQUEST._value == value) {
            return REQUEST;
        } else if (SESSION._value == value) {
            return SESSION;
        } else if (APPLICATION._value == value) {
            return APPLICATION;
        } else {
            return PAGE;
        }
    }
    
}
