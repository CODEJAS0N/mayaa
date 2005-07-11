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
package org.seasar.maya.cycle;

import java.util.Iterator;

/**
 * ���O���ŃI�u�W�F�N�g��ۑ��ł���u�X�R�[�v�v�T�O�C���^�[�t�F�C�X�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface AttributeScope {

    /**
     * �X�R�[�v���̎擾���s���⏕���\�b�h�B
     * @return �X�R�[�v���B
     */
    String getScopeName();
    
    /**
     * ���̃X�R�[�v�ɕۑ�����Ă��閼�O���C�e���[�g����B
     * @return ���O�iString�j�̓������C�e���[�^�B
     */
    Iterator iterateAttributeNames();
    
    /**
     * ���̃X�R�[�v������w�肳�ꂽ���O�ɑΉ������I�u�W�F�N�g��Ԃ��B
     * ���O������null�������̓[�����������͊Y���I�u�W�F�N�g�������ꍇ�ɂ́Anull��Ԃ��B
     * @param name �w��I�u�W�F�N�g���B
     * @return �w��I�u�W�F�N�g�B
     */
    Object getAttribute(String name);
    
    /**
     * ���̃X�R�[�v���ɁA�w�薼�ŃI�u�W�F�N�g��ۑ�����B
     * @param name �w�薼�B�󔒕����񂾂Ɖ������Ȃ��B
     * @param attribute �w��I�u�W�F�N�g�Bnull�̏ꍇ�́A�X�R�[�v���폜�����B
     */
    void setAttribute(String name, Object attribute);

}
