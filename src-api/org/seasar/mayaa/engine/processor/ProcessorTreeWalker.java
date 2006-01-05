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

import java.io.Serializable;
import java.util.Map;

/**
 * �v���Z�b�T�c���[�𑀍삷��B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface ProcessorTreeWalker extends Serializable {

    /**
     * �v���Z�b�T���s�X�R�[�v�ɁA�o�^�X�N���v�g�ϐ���񋟂���B
     * @return �o�^�ϐ��̃}�b�v�B�L�[���ϐ����ƂȂ�B
     */
    Map getVariables();

    /**
     * �m�[�h�̏��������s���B���̃��\�b�h�́ATemplateBuilder#build�̒��ŌĂ΂��B
     * @param parent �eProcessorTreeWalker
     * @param index �eProcessorTreeWalker���ł̎q�Ƃ��ẴC���f�b�N�X�l�B
     */
    void setParentProcessor(ProcessorTreeWalker parent, int index);

    /**
     * �qProcessorTreeWalker��ǉ�����B���̃��\�b�h�́A
     * TemplateBuilder#build�̒��ŌĂ΂��B
     * @param child �qProcessorTreeWalker
     */
    void addChildProcessor(ProcessorTreeWalker child);

    /**
     * �eProcessorTreeWalker���ł̎q�Ƃ��ẴC���f�b�N�X�l
     * @return �C���f�b�N�X�l
     */
    int getIndex();

    /**
     * �eProcessorTreeWalker���擾����B
     * @return �eProcessorTreeWalker
     */
    ProcessorTreeWalker getParentProcessor();

    /**
     * �qProcessorTreeWalker�̐����擾����B
     * @return �qProcessorTreeWalker�̐�
     */
    int getChildProcessorSize();

    /**
     * �w��C���f�b�N�X�̎qProcessorTreeWalker���擾����B
     * @param index �w��index�B
     * @return �w��index�̎qProcessorTreeWalker�B
     */
    ProcessorTreeWalker getChildProcessor(int index);

}
