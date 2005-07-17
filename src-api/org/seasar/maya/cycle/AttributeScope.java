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
     * �g�ݍ��݃I�u�W�F�N�g�̃X�R�[�v�B
     */
    Scope SCOPE_IMPLICIT = new Scope("implicit");
    
    /**
     * �y�[�W�X�R�[�v�B
     */
    Scope SCOPE_PAGE = new Scope("page");
    
    /**
     * ���N�G�X�g�X�R�[�v�B
     */
    Scope SCOPE_REQUEST = new Scope("request");
    
    /**
     * �Z�b�V�����X�R�[�v�B
     */
    Scope SCOPE_SESSION = new Scope("session");
    
    /**
     * �A�v���P�[�V�����X�R�[�v�B
     */
    Scope SCOPE_APPLICATION = new Scope("application");

    /**
     * �X�R�[�v���ʂ̎擾���s���⏕���\�b�h�B
     * @return �X�R�[�v���ʁB
     */
    Scope getScope();
    
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

    /**
     * �X�R�[�v���ʁB
     */
    public class Scope {

        private String _scopeName;
        
        /**
         * @param scopeName �X�R�[�v���B
         */
        public Scope(String scopeName) {
            _scopeName = scopeName;
        }
        
        /**
         * �X�R�[�v���̎擾�B
         * @return �X�R�[�v���B
         */
        public String getScopeName() {
            return _scopeName;
        }
        
        public String toString() {
            return getScopeName();
        }
        
        public boolean equals(Object test) {
            if(test instanceof Scope) {
                return _scopeName.equals(((Scope)test).getScopeName());
            }
            return false;
        }
        
    }
    
}
