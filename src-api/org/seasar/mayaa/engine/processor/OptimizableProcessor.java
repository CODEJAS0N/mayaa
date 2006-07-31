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
package org.seasar.mayaa.engine.processor;

import org.seasar.mayaa.builder.SequenceIDGenerator;

/**
 * @author Taro Kato (Gluegent, Inc.)
 */
public interface OptimizableProcessor {

    /**
     * �q�v���Z�b�T�̍쐬�������_�ŌĂяo����A
     * ���g��ÓI�p�[�g�Ɠ��I�p�[�g�ɕ�������B
     * �Œ�ł����g�������P�v�f���ԋp�����B
     * @param �œK���ɂ���ĐV���ȃm�[�h���K�v�ȍۂɎg�p����sequenceID�W�F�l���[�^
     * @return �����v���Z�b�T�[�z��
     */
    ProcessorTreeWalker[] divide(SequenceIDGenerator sequenceIDGenerator);

}