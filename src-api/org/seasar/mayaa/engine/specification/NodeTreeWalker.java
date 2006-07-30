/*
 * Copyright 2004-2006 the Seasar Foundation and the Others.
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
package org.seasar.mayaa.engine.specification;

import java.util.Iterator;

import org.seasar.mayaa.PositionAware;
import org.seasar.mayaa.engine.specification.serialize.NodeReferenceResolverFinder;

/**
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface NodeTreeWalker extends PositionAware, NodeReferenceResolverFinder {

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
     * �q�m�[�h�̐ݒ���w��ʒu�ɑ}������B
     * @param index
     * @param childNode
     */
    void insertChildNode(int index, NodeTreeWalker childNode);
    
    /**
     * �q�m�[�h���폜����B
     * @param childNode �q�m�[�h�B
     */
    boolean removeChildNode(NodeTreeWalker childNode);

    /**
     * �q�m�[�h�̐���Ԃ��B
     * @return �q�m�[�h�̐�
     */
    int getChildNodeSize();
    
    /**
     * �w��C���f�b�N�X�̎q�m�[�h��Ԃ��B
     * @param index �C���f�b�N�X�l�B
     * @return �m�[�h�B
     */
    NodeTreeWalker getChildNode(int index);

    /**
     * �q�m�[�h�̃C�e���[�^���擾����B
     * @return �q�m�[�h�i<code>NodeTreeWalker</code>�j��ێ������C�e���[�^�B
     */
    Iterator iterateChildNode();

    /**
     * �C���X�^���X��j���ΏۂƂ��A�e�m�[�h��q�m�[�h�Ȃ�
     * �C���X�^���X���ێ����Ă������̃I�u�W�F�N�g�ւ̎Q�ƃ����N��؂�B
     */
    void kill();

    /**
     * �q�m�[�h���N���A����
     */
    void clearChildNodes();
}
