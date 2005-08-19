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
package org.seasar.maya.impl.engine.processor;

import javax.servlet.jsp.tagext.Tag;

import org.seasar.maya.impl.util.ObjectUtil;
import org.seasar.maya.impl.util.collection.AbstractSoftReferencePool;

/**
 * ����J�X�^���^�O�̃C���X�^���X���v�[������.
 * @author suga
 * @author higa (original)
 */
public class TagPoolEntry {
    /** �J�X�^���^�O�̃v�[�� */
    private JspCustomTagPool _jspCustomTagPool;

    /**
     * �R���X�g���N�^.
     * @param tagClass �J�X�^���^�O�̃N���X�B
     */
    public TagPoolEntry(Class tagClass) {
        if(tagClass == null) {
            throw new IllegalArgumentException();
        }
        _jspCustomTagPool = new JspCustomTagPool(tagClass);
    }

    /**
     * �J�X�^���^�O�̃C���X�^���X���擾����.
     * �v�[���ɂ���Ȃ炻����A������ΐV�����C���X�^���X���쐬���ĕԂ�.
     * @return �^�O�̃C���X�^���X
     */
    public Tag request() {
        return _jspCustomTagPool.borrowTag();
    }

    /**
     * �J�X�^���^�O�̃C���X�^���X���v�[���ɖ߂�.
     * @param tag �v�[���ɖ߂��J�X�^���^�O�̃C���X�^���X
     */
    public void release(Tag tag) {
        _jspCustomTagPool.returnTag(tag);
    }

    /** �J�X�^���^�O�̃v�[�� */
    private class JspCustomTagPool extends AbstractSoftReferencePool {
        /** �J�X�^���^�O�̃N���X */
        private Class _tagClass;

        /**
         * �R���X�g���N�^.
         * @param tagClass �J�X�^���^�O�̃N���X�B
         */
        protected JspCustomTagPool(Class tagClass) {
            _tagClass = tagClass;
        }

        protected Object createObject() {
            return ObjectUtil.newInstance(_tagClass);
        }

        protected boolean validateObject(Object object) {
            return object instanceof Tag;
        }
        
        Tag borrowTag() {
            return (Tag)borrowObject();
        }
        
        void returnTag(Tag tag) {
            returnObject(tag);
        }
        
    }
    
}
