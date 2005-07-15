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

import org.seasar.maya.cycle.ServiceCycle;
import org.seasar.maya.engine.processor.TemplateProcessor;
import org.seasar.maya.engine.specification.Specification;

/**
 * �e���v���[�g�I�u�W�F�N�g�BHTML���p�[�X�������ʂ́ATemplateProcessor�̃c���[�\�������B
 * ���g��TemplateProcessor�ł���B���N�G�X�g�ɑ΂��āA�X�e�[�g���X�ł���B �V���A���C�Y�\�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface Template extends Specification, TemplateProcessor, Serializable {

	/**
	 * �y�[�W�ւ̎Q�Ƃ��擾����B
	 * @return �y�[�W�B
	 */
	Page getPage();
	
    /**
     * �e���v���[�g�̐ڔ��q��Ԃ��Bhello_ja.html�ł���΁A�uja�v��Ԃ��Bhello.html�ł͋󔒕�����B
     * @return �e���v���[�g�̐ڔ��q�B
     */
    String getSuffix();

    /**
     * �e���v���[�g�������_�����O����B
     * @param cycle �T�[�r�X�T�C�N���R���e�L�X�g�B
     * @param renderRoot �`��̃��[�g�ƂȂ�v���Z�b�T�Bnull�̏ꍇ�͎��g�����[�g�Ƃ��ĕ`�悷��B
     * @return javax.servlet.jsp.tagext.Tag#doStartTag()/doAfterBody()/doEndTag()
     * 				�̕Ԓl�d�l�Ɠ����B
     */
    int doTemplateRender(ServiceCycle cycle, TemplateProcessor renderRoot);
    
}
