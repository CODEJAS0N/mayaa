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
package org.seasar.maya.engine.processor;

/**
 * TemplateProcessor�̊g���C���^�[�t�F�C�X�B��O�����֘A�̃C�x���g��
 * �󂯎��@�\����������B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface TryCatchFinallyProcessor extends TemplateProcessor {

    /**
     * ��O��catch���邩�ǂ�����Ԃ��BJSP��TryCatchFinally���z�X�g���Ă���ꍇ��
     * ���p����B�f�t�H���g�ł�false��Ԃ��Btrue���ƁA��O��������
     * doCatchProcess�A��O�Ƃ͖��֌W��doFinallyProcess���R���e�i���Ăяo�����B
     * @return ��O��catch����ꍇ�Atrue�B���ʂ�false�B
     */
    boolean canCatch();

    /**
     * �v���Z�X���̗�O���L���b�`���čs�������B
     * @param t �v���Z�X���ɔ���������O
     */
    void doCatchProcess(Throwable t);

    /**
     * �v���Z�X���ɗ�O���N���Ă��s���㏈���B
     */
    void doFinallyProcess();

}