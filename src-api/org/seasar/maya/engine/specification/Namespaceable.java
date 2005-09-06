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
package org.seasar.maya.engine.specification;

import java.util.Iterator;

/**
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface Namespaceable extends NodeObject {

    /**
     * �e���O��ԃX�R�[�v�̐ݒ�B 
     * @param parent �e�̖��O��ԃX�R�[�v�B
     */
    void setParentScope(Namespaceable parent);

    /**
     * �e���O��ԃX�R�[�v�̎擾�B
     * @return �e�̖��O��ԃX�R�[�v�B
     */
    Namespaceable getParentScope();
    
    /**
     * ���O��ԃ��f���̒ǉ��B
     * @param prefix ���O��ԃv���t�B�b�N�X�B
     * @param namespaceURI ���O���URI�B
     */
    void addNamespace(String prefix, String namespaceURI);
    
    /**
     * ���̃X�R�[�v�ɂāA���O��ԃ��f����ǉ��������ǂ����B
     * @return
     */
    boolean added();
    
    /**
     * ���O��ԃ��f���̎擾�B
     * @param prefix �擾���������O��Ԃ̃v���t�B�b�N�X�B
     * @param all �e�X�R�[�v����������B
     * @return ���O��ԃ��f���B
     */
    NodeNamespace getNamespace(String prefix, boolean searchAll);
    
    /**
     * �K�p����閼�O��Ԃ̃C�e���[�g�B
     * @param all �e�X�R�[�v����������B 
     * @return ���O��ԁi<code>NodeNamespace</code>�j�̃C�e���[�^�B
     */
    Iterator iterateNamespace(boolean all);

}
