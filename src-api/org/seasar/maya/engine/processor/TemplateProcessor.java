/*
 * Copyright (c) 2004-2005 the Seasar Project and the Others.
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

import java.io.Serializable;

import javax.servlet.jsp.PageContext;

/**
 * �e���v���[�g����HTML�^�O����������Ϗ��N���X�B����TemplateProcessor�̃c���[���Ȃ킿
 * Template�ƂȂ�B����TemplateProcessor�����N�G�X�g�ɑ΂��ăX�e�[�g���X�łȂ���΂Ȃ�Ȃ��B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface TemplateProcessor extends Serializable {

    /**
     * �m�[�h�̏��������s���B���̃��\�b�h�́ATemplateBuilder#build�̒��ŌĂ΂��B
     * @param parent �eTemplateProcessor
     * @param index �eTemplateNode���ł̎q�Ƃ��ẴC���f�b�N�X�l�B
     */
    void setParentProcessor(TemplateProcessor parent, int index);

    /**
     * �qTemplateProcessor��ǉ�����B���̃��\�b�h�́ATemplateBuilder#build�̒��ŌĂ΂��B
     * @param child �qTemplateProcessor
     */
    void addChildProcessor(TemplateProcessor child);

    /**
     * �eTemplateProcessor���ł̎q�Ƃ��ẴC���f�b�N�X�l
     * @return �C���f�b�N�X�l
     */
    int getIndex();

    /**
     * �eTemplateProcessor���擾����B
     * @return �eTemplateProcessor
     */
    TemplateProcessor getParentProcessor();

    /**
     * �qTemplateNode�̐����擾����B
     * @return �qTemplateNode�̐�
     */
    int getChildProcessorSize();

    /**
     * �w��C���f�b�N�X�̎qTemplateNode���擾����B
     * @param index �w��index�B
     * @return �w��index�̎qTemplateProcessor�B
     */
    TemplateProcessor getChildProcessor(int index);

    /**
     * �J���^�O�̏o�́B�e���v���[�g�e�L�X�g��WhiteSpace�̏ꍇ���A���̃��\�b�h�ŏo�͂���B
     * @param context �v���Z�X���̃X�e�[�g�t���ȏ���ێ�����R���e�L�X�g�B
     * @return javax.servlet.jsp.tagext.Tag#doStartTag()�̕Ԓl�Ɠ����d�l�B
     */
    int doStartProcess(PageContext context);

    /**
     * ���^�O�̏o�́B
     * @param context �v���Z�X���̃X�e�[�g�t���ȏ���ێ�����R���e�L�X�g�B
     * @return javax.servlet.jsp.tagext.Tag#doEndTag()�̕Ԓl�Ɠ����d�l�B
     */
    int doEndProcess(PageContext context);

}