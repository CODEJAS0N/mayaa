/*
 * Copyright 2004-2005 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.seasar.maya.engine.specification;

import java.util.Iterator;

/**
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface Namespace extends NodeObject {

    /**
     * �e���O��ԃX�R�[�v�̐ݒ�B 
     * @param parent �e�̖��O��ԃX�R�[�v�B
     */
    void setParentSpace(Namespace parent);

    /**
     * �e���O��ԃX�R�[�v�̎擾�B
     * @return �e�̖��O��ԃX�R�[�v�B
     */
    Namespace getParentSpace();
    
    /**
     * ���O��ԃ��f���̒ǉ��B
     * @param mapping ���O��ԃ��f���B
     */
    void addPrefixMapping(PrefixMapping mapping);
    
    /**
     * ���̃X�R�[�v�ɂāA���O��ԃ��f����ǉ��������ǂ����B
     * @return ���̃X�R�[�v�ɒǉ����f���������true�B
     */
    boolean addedMapping();
    
    /**
     * ���O��ԃ��f���̎擾�B
     * @param prefix �擾���������O��Ԃ̃v���t�B�b�N�X�B
     * @param all �e�X�R�[�v����������B
     * @return ���O��ԃ��f���B
     */
    PrefixMapping getMappingFromPrefix(String prefix, boolean all);

    /**
     * ���O��ԃ��f���̎擾�B
     * @param namespaceURI �擾���������O��Ԃ�URI�B
     * @param all �e�X�R�[�v����������B
     * @return ���O��ԃ��f���B
     */
    PrefixMapping getMappingFromURI(String namespaceURI, boolean all);
    
    /**
     * �K�p����閼�O��Ԃ̃C�e���[�g�B
     * @param all �e�X�R�[�v����������B 
     * @return �v���t�B�b�N�X�}�b�s���O�i<code>PrefixMapping</code>�j�̃C�e���[�^�B
     */
    Iterator iteratePrefixMapping(boolean all);

}
