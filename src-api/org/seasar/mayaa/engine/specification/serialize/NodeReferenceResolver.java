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

import org.seasar.mayaa.engine.specification.SpecificationNode;


/**
 * @author Taro Kato (Gluegent, Inc.)
 */
public interface NodeReferenceResolver {

    /**
     * �f�V���A���C�Y�����̍ۂɁA�m�[�h�Q�Ƃ������������Ƃ�
     * �ʒm���Ă��炤���߂̃��X�i��o�^����B
     * @param uniqueID �Ώۃm�[�h�̃��j�[�N���ʎq�BsystemID�{sequenceID
     * @param listener ���X�i
     */
    void registResolveNodeListener(
            String uniqueID, NodeResolveListener listener);

    /**
     * ���������v���Z�b�T�����]���o�ɒʒm����B
     * @param item �ۑ�����m�[�h
     */
    void nodeLoaded(SpecificationNode item);

}

