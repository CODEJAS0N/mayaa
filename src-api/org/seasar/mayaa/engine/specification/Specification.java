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

import java.util.Date;

import org.seasar.mayaa.ParameterAware;
import org.seasar.mayaa.builder.SequenceIDGenerator;
import org.seasar.mayaa.source.SourceDescriptor;

/**
 * �X�y�b�N���ɃA�N�Z�X���邽�߂̃C���^�[�t�F�C�X
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface Specification
        extends NodeTreeWalker, SequenceIDGenerator, ParameterAware {

    /**
     * �ŏI�r���h�����擾����B
     * @return �r���h���B���r���h�̏ꍇnull��Ԃ��B
     */
    Date getTimestamp();

    /**
     * �ݒ�XML�̃\�[�X�ݒ�B
     * @param source �ݒ�XML�\�[�X�B
     */
    void setSource(SourceDescriptor source);

    /**
     * �ݒ�XML�̃\�[�X���擾����B
     * @return �ݒ�XML�\�[�X�B
     */
    SourceDescriptor getSource();

    /**
     * �X�y�b�N��񂪔p�~�ΏۂƂ��ă}�[�N����Ă��邩�ǂ�����Ԃ��B
     * �Â��\�[�X�Ńr���h����Ă���ꍇ�ƁA���g�p���Ԃ����̒�����
     * �������ꍇ�ɐ^�ƂȂ�B
     * ���̒l���^�̎��́A�m�[�h�\����m�[�h���e�͕ۏ؂���Ȃ��B
     * @return �p�~�ΏۂƂ��ă}�[�N����Ă���Ȃ�true
     */
    boolean isDeprecated();

    /**
     * �\�[�X�r���h���s���B
     */
    void build();

}
