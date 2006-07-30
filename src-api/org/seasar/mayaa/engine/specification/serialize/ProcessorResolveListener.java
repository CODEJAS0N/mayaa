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
 * �v���Z�b�T�̕�����ʒm����B
 * @author Taro Kato (Gluegent, Inc.)
 */
public interface ProcessorResolveListener {

    /**
     * �f�V���A���C�Y�ɕ������悤�Ƃ��Ă���v���Z�b�T�Q�Ƃ���������
     * �I���W�i���v���Z�b�T�����[�h���ꂽ�ۂɔ񓯊��ɒʒm����B
     * @processorSequenceID �v�����Ă����v���Z�b�TID
     * @param loadedInstance �������ꂽ�Ώۃv���Z�b�T�B�k���̏ꍇ�͌�����Ȃ��������Ƃ������B
     */
    void notify(String processorUniqueID, ProcessorTreeWalker loadedInstance);

    /**
     * �����������I������ۂɌĂяo�����B
     */
    void release();

}

