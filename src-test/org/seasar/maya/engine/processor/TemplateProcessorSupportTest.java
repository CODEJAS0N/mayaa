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
package org.seasar.maya.engine.processor;

import junit.framework.TestCase;

/**
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public class TemplateProcessorSupportTest extends TestCase {

    private TemplateProcessorSupport _processor;
    private TemplateProcessorSupport _parent;
    
    public TemplateProcessorSupportTest(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        _parent = new TemplateProcessorSupport();
        _processor = new TemplateProcessorSupport();
        _processor.setParentProcessor(_parent, 0);
    }

    public void testAddChild() throws Exception {
        // addChild(TemplateProcessor)�ɂĒǉ������q�v���Z�b�T�̃��X�g���A
        // getChildren()�Ŕz��Ƃ��Ď擾�ł���B
        TemplateProcessorSupport child = new TemplateProcessorSupport();
        _processor.addChildProcessor(child);
        assertEquals(1, _processor.getChildProcessorSize());
        assertEquals(child, _processor.getChildProcessor(0));
        assertEquals(_processor, child.getParentProcessor());
        assertEquals(0, child.getIndex());
        try {
            // addChild(TemplateProcessor)�ɂĈ���null��n���ƁA
            // NullPointerException�����B
            _processor.addChildProcessor(null);
            fail();
        } catch(IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    public void testGetParent() throws Exception {
        // init(..., TemplateProcessor, ...)�ɂĐݒ肵���e�v���Z�b�T���A
        // getParent()�Ŏ擾�ł���B
        assertEquals(_parent, _processor.getParentProcessor());
    }

    public void testDoStartProcess() throws Exception {
        // doStartProcess(MayaContext)�̃f�t�H���g�̕Ԓl�́AEVAL_BODY_INCLUDE�ƂȂ�B
//        TestPageContext context = new TestPageContext();
//        assertEquals(Tag.EVAL_BODY_INCLUDE, _processor.doStartProcess(context));
    }

    public void testDoEndProcess() throws Exception {
        // doEndProcess(MayaContext)�̃f�t�H���g�̕Ԓl�́AEVAL_PAGE�ƂȂ�B
//        TestPageContext context = new TestPageContext();
//        assertEquals(Tag.EVAL_PAGE, _processor.doEndProcess(context));
    }

}
