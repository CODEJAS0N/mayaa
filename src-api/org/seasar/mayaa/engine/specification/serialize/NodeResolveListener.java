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
package org.seasar.mayaa.engine.specification.serialize;

import org.seasar.mayaa.engine.specification.NodeTreeWalker;

/**
 * @author Taro Kato (Gluegent, Inc.)
 */
public interface NodeResolveListener {
    
    /**
     * �f�V���A���C�Y�ɕ������悤�Ƃ��Ă���m�[�h�Q�Ƃ���������
     * �I���W�i���̃m�[�h�����[�h���ꂽ�ۂɔ񓯊��ɒʒm����B
     * @param uniqueID �v�����Ă������j�[�NID
     * @param loadedInstance �������ꂽ�Ώۃm�[�h�B�k���̏ꍇ�͌�����Ȃ��������Ƃ������B
     */
    void notify(String uniqueID, NodeTreeWalker loadedInstance);
    
    /**
     * �����������I������ۂɌĂяo�����B
     */
    void release();

}

