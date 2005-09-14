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
package org.seasar.maya.engine.specification;

import java.util.Iterator;

/**
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface NodeTreeWalker {
    
    /**
     * �e�m�[�h�̐ݒ���Z�b�g����B
     * @param parentNode �e�m�[�h�B
     */
    void setParentNode(NodeTreeWalker parentNode);

    /**
     * �e�m�[�h���擾����B
     * @return �e�m�[�h�B
     */
    NodeTreeWalker getParentNode();
    
    /**
     * �q�m�[�h�̐ݒ���Z�b�g����B
     * @param childNode �q�m�[�h�B
     */
    void addChildNode(NodeTreeWalker childNode);

    /**
     * �q�m�[�h�̃C�e���[�^���擾����B
     * @return �q�m�[�h�i<code>NodeTreeWalker</code>�j��ێ������C�e���[�^�B
     */
    Iterator iterateChildNode();
    
}