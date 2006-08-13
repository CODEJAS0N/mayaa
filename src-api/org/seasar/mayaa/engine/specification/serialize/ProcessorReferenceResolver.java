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

import org.seasar.mayaa.engine.processor.ProcessorTreeWalker;

/**
 * @author Taro Kato (Gluegent, Inc.)
 */
public interface ProcessorReferenceResolver {

    /**
     * �f�V���A���C�Y�����̍ۂɁA�v���Z�b�T�Q�Ƃ������������Ƃ�
     * �ʒm���Ă��炤���߂̃��X�i��o�^����B
     * @param uniqueID �Ώۃv���Z�b�TID
     * @param listener ���X�i
     */
    void registResolveProcessorListener(
            String uniqueID, ProcessorResolveListener listener);

    /**
     * ���������v���Z�b�T�����]���o�ɒʒm����B
     * @param uniqueID �Ώۃv���Z�b�TID
     * @param item ���������v���Z�b�T
     */
    void processorLoaded(String uniqueID, ProcessorTreeWalker item);

}

