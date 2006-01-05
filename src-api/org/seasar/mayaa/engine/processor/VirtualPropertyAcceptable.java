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

import org.seasar.mayaa.engine.specification.PrefixAwareName;

/**
 * ���炩���߁AMLD�iMayaa Library Definition�j�t�@�C���ɋL�q����Ă��邪�A
 * �v���Z�b�T�ɌŗL�̃v���p�e�B�������ꍇ�i�o�[�`�����v���p�e�B�j
 * �̎󂯓�����s���C���^�[�t�F�C�X�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface VirtualPropertyAcceptable
        extends ProcessorTreeWalker {

    /**
     * �o�[�`�����v���p�e�B�ւ̒l�ݒ�B
     * @param name �v���p�e�B���B
     * @param property �v���p�e�B�l�B
     */
    void addVirtualProperty(PrefixAwareName name, Object property);

}
