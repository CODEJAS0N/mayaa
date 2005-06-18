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
package org.seasar.maya.impl.util;

import junit.framework.TestCase;

/**
 * @author suga
 */
public class StringUtilTest extends TestCase {

    public StringUtilTest(String name) {
        super(name);
    }

    public void testResolveEntity() {
        // ��������G���e�B�e�B�̂Ƃ�
        assertEquals("&", StringUtil.resolveEntity("&amp;"));
        assertEquals("<", StringUtil.resolveEntity("&lt;"));
        assertEquals(">", StringUtil.resolveEntity("&gt;"));
        assertEquals("\"", StringUtil.resolveEntity("&quot;"));

        // �ˋ�̃G���e�B�e�B���̂Ƃ�
        assertEquals("&abcdefg;", StringUtil.resolveEntity("&abcdefg;"));

        // �G���e�B�e�B�̕��Z�~�R�������Ȃ��Ƃ�
        assertEquals("&amp", StringUtil.resolveEntity("&amp"));

        // �����̂Ƃ�
        assertEquals("<\"&>", StringUtil.resolveEntity("&lt;&quot;&amp;&gt;"));

        // �G���e�B�e�B�̑O�Ɏ�������Ƃ�
        assertEquals("foo>", StringUtil.resolveEntity("foo&gt;"));

        // �G���e�B�e�B�̌�Ɏ�������Ƃ�
        assertEquals("<foo", StringUtil.resolveEntity("&lt;foo"));

        // �G���e�B�e�B�̊ԂɎ�������Ƃ�
        assertEquals("<foo>", StringUtil.resolveEntity("&lt;foo&gt;"));

        // �G���e�B�e�B�̑O��ƊԂɎ�������Ƃ�
        assertEquals("foo<bar>baz",
                StringUtil.resolveEntity("foo&lt;bar&gt;baz"));
    }
    
}
