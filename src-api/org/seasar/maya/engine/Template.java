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

import org.seasar.maya.engine.processor.ProcessorTreeWalker;
import org.seasar.maya.engine.processor.TemplateProcessor.ProcessStatus;
import org.seasar.maya.engine.specification.Specification;

/**
 * �e���v���[�g�I�u�W�F�N�g�BHTML���p�[�X�������ʂ́A
 * TemplateProcessor�̃c���[�\�������B
 * ���N�G�X�g�ɑ΂��āA�X�e�[�g���X�ł���B �V���A���C�Y�\�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface Template 
        extends Specification, ProcessorTreeWalker, Serializable {
    
	/**
	 * �y�[�W�ւ̎Q�Ƃ��擾����B
	 * @return �y�[�W�B
	 */
	Page getPage();
	
    /**
     * �e���v���[�g�̐ڔ��q��Ԃ��Bhello_ja.html�ł���΁A�uja�v��Ԃ��B
     * hello.html�ł͋󔒕�����B
     * @return �e���v���[�g�̐ڔ��q�B
     */
    String getSuffix();

    /**
     * �y�[�W�̊g���q��Ԃ��B/context/hello.html���ƁA�uhtml�v�B�h�b�g���܂܂Ȃ��B
     * @return �y�[�W�̊g���q�B
     */
    String getExtension();

    /**
     * �e���v���[�g�������_�����O����B
     * @return �e���v���[�g�v���Z�b�T�̃v���Z�X�X�e�[�g�t���O�B
     */
    ProcessStatus doTemplateRender();
    
}
