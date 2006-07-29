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
 * ���炩���߁AMLD�iMayaa Library Definition�j�t�@�C���ɋL�q����ĂȂ�
 * �v���p�e�B���󂯓����ꍇ�̃C���^�[�t�F�C�X�BMLD�L�q����Ă�v���p�e�B��
 * ���̃��\�b�h���o�R���Ȃ��ŁA���ځABean�v���p�e�B�A�N�Z�X�Őݒ肳���B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface InformalPropertyAcceptable
        extends ProcessorTreeWalker {

    /**
     * ��MLD�ȃC���t�H�[�}���v���p�e�B�̎󂯓��ꃁ�\�b�h�B
     * @param name �v���p�e�B���B
     * @param property �C���t�H�[�}���v���p�e�B�B
     */
    void addInformalProperty(PrefixAwareName name, Object property);

    /**
     * addInformalProperty()�ɓn�����C���t�H�[�}���v���p�e�B�Ɋ��҂����^�B
     * @return �C���t�H�[�}���v���p�e�B�^�B
     */
    Class getPropertyClass();

    /**
     * �C���t�H�[�}���v���p�e�B�̗\�������^���擾����B
     * @return �C���t�H�[�}���v���p�e�B�̗\�������^�B
     */
    Class getExpectedClass();

}
