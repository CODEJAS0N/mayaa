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

import junit.framework.TestCase;

/**
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public class ExpressionBlockTest extends TestCase {

    public ExpressionBlockTest(String name) {
        super(name);
    }

    public void testGetBlockString1() {
        // �������񒆂̃G���e�B�e�B����
        ExpressionBlock block = new ExpressionBlock("&amp;", false);
        assertFalse(block.isLiteral());
        assertEquals("&", block.getBlockString());
    }

    public void testGetBlockString2() {
        // �e�L�X�g�{�f�B���̃G���e�B�e�B����
        ExpressionBlock block = new ExpressionBlock("&amp;", true);
        assertTrue(block.isLiteral());
        assertEquals("&amp;", block.getBlockString());
    }

    public void testGetBlockString3() {
        // �G���e�B�e�B�̕��Z�~�R�������Ȃ��Ƃ�
        ExpressionBlock block = new ExpressionBlock("&amp", false);
        assertEquals("&amp", block.getBlockString());
    }

    public void testGetBlockString4() {
        // �G���e�B�e�B�̕��Z�~�R�����ƊJ�����̊֌W�����������Ƃ�
        ExpressionBlock block = new ExpressionBlock(";amp&", false);
        assertEquals(";amp&", block.getBlockString());
    }

    public void testGetBlockString5() {
        // �ˋ�̃G���e�B�e�B���̂Ƃ�
        ExpressionBlock block = new ExpressionBlock("&abcxyz;", false);
        assertEquals("&abcxyz;", block.getBlockString());
    }

    public void testGetBlockString6() {
        // �G���e�B�e�B�������܂܂��Ƃ�
        ExpressionBlock block = new ExpressionBlock("&lt;&gt;", false);
        assertEquals("<>", block.getBlockString());
    }

    public void testGetBlockString7() {
        // �G���e�B�e�B�������ƊԂɎ�������Ƃ�
        ExpressionBlock block = new ExpressionBlock("&lt;a&gt;", false);
        assertEquals("<a>", block.getBlockString());
    }

    public void testGetBlockString8() {
        // �G���e�B�e�B�������ƑO�Ɏ�������Ƃ�
        ExpressionBlock block = new ExpressionBlock("&lt;a", false);
        assertEquals("<a", block.getBlockString());
    }

    public void testGetBlockString9() {
        // �G���e�B�e�B�������ƌ�Ɏ�������Ƃ�
        ExpressionBlock block = new ExpressionBlock("a&gt;", false);
        assertEquals("a>", block.getBlockString());
    }
    
}
