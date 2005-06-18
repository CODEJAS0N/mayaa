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
package org.seasar.maya.builder.processor;

import org.seasar.maya.engine.Template;
import org.seasar.maya.engine.processor.TemplateProcessor;
import org.seasar.maya.engine.specification.SpecificationNode;

/**
 * �e���v���[�g����HTML�^�O�̏�񂩂�ATemplateProcessor��񋟂���t�@�N�g���B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface ProcessorFactory {

    /**
     * �J�X�^�}�C�Y���ꂽ�v���Z�b�T�������s���ۂ̃I�v�V���i���ȃt�@�N�g��API�B
     * @param template �e���v���[�g�B
     * @param injected �C���W�F�N�g����m�[�h���B
     * @return �������Ϗ�����TemplateProcessor�B
     */
    TemplateProcessor createProcessor(Template template, SpecificationNode injected);
    
}
