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
package org.seasar.maya.engine;

import java.io.Serializable;

import org.seasar.maya.engine.processor.TemplateProcessor.ProcessStatus;
import org.seasar.maya.engine.specification.Specification;

/**
 * �e���v���[�g�̃����_�����O�G���g���[�|�C���g�B�A�v���P�[�V�������\������e�y�[�W�̃��f��
 * �ł���A���N�G�X�g�ɑ΂��Ă̓X�e�[�g���X�ȃI�u�W�F�N�g�ł���BEngine#doService(PageContext)
 * �ŁA�e���v���[�g����������������AdoTemplate(ProcessorContext)���Ă΂��B�܂��A
 * TemplateCustomTag#doStartTag()��doTemplate(ProcessorContext)���Ă΂��B
 * �V���A���C�Y�\�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface Page extends Specification, Serializable {

	/**
	 * �G���W���ւ̎Q�Ƃ��擾�B
	 * @return �G���W���B
	 */
	Engine getEngine();
	
    /**
     * �y�[�W�̖��O���擾����B/context/hello.html�ł���΁A�u/context/hello�v��Ԃ��B
     * @return �y�[�W���B
     */
    String getPageName();

    /**
     * �y�[�W�̊g���q��Ԃ��B/context/hello.html���ƁA�uhtml�v�B�h�b�g���܂܂Ȃ��B
     * @return �y�[�W�̊g���q�B
     */
    String getExtension();

    /**
     * �e���v���[�g�ڔ������K�؂�Template�I�u�W�F�N�g�����[�h���ĕԂ��B
     * @param suffix �y�[�W�ڔ����Bnull�ł��悢�B
     * @return �����_�����O����e���v���[�g�B
     */
    Template getTemplate(String suffix);
	
    /**
     * �e���v���[�g�����_�����O���s���B
     * @return �v���Z�b�T�����X�e�[�^�X�B
     */
    ProcessStatus doPageRender();

}
