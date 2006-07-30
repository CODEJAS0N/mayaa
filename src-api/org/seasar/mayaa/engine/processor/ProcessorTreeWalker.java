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

import org.seasar.mayaa.engine.specification.serialize.NodeReferenceResolverFinder;
import org.seasar.mayaa.engine.specification.serialize.ProcessorReferenceResolverFinder;

/**
 * �v���Z�b�T�c���[�𑀍삷��B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface ProcessorTreeWalker
        extends ProcessorReferenceResolverFinder,
                 NodeReferenceResolverFinder, Serializable {

    /**
     * �v���Z�b�T���s�X�R�[�v�ɁA�o�^�X�N���v�g�ϐ���񋟂���B
     * @return �o�^�ϐ��̃}�b�v�B�L�[���ϐ����ƂȂ�B
     */
    Map getVariables();

    /**
     * �m�[�h�̏��������s���B���̃��\�b�h�́ATemplateBuilder#build�̒��ŌĂ΂��B
     * @param parent �eProcessorTreeWalker
     */
    void setParentProcessor(ProcessorTreeWalker parent);

    /**
     * �qProcessorTreeWalker��ǉ�����B���̃��\�b�h�́A
     * TemplateBuilder#build�̒��ŌĂ΂��B
     * @param child �qProcessorTreeWalker
     */
    void addChildProcessor(ProcessorTreeWalker child);

    /**
     * �qProcessorTreeWalker���w�肵���ʒu�ɑ}�����Ēǉ�����B
     * @param index �C���f�b�N�X�l
     * @param child �qProcessorTreeWalker
     */
    void insertProcessor(int index, ProcessorTreeWalker child);
    
    /**
     * �qProcessorTreeWalker���폜����B
     * @param child �qProcessorTreeWalker
     * @return �폜�����ꍇ��true�B���݂��Ȃ������ꍇ��false��Ԃ��B
     */
    boolean removeProcessor(ProcessorTreeWalker child);

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

    /**
     * �qProcessorTreeWalker��S�č폜����B
     */
    void clearChildProcessors();

}
