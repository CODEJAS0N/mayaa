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
package org.seasar.maya.provider;

import org.seasar.maya.builder.SpecificationBuilder;
import org.seasar.maya.builder.TemplateBuilder;
import org.seasar.maya.cycle.Application;
import org.seasar.maya.el.ExpressionFactory;
import org.seasar.maya.engine.Engine;
import org.seasar.maya.source.factory.SourceFactory;

/**
 * �A�v���P�[�V�����X�R�[�v�ł̃T�[�r�X�񋟃I�u�W�F�N�g�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface ServiceProvider {

    /**
     * �A�v���P�[�V�����R���e�L�X�g�̎擾�B
     * @return �A�v���P�[�V�����R���e�L�X�g�B
     */
    Application getApplication();
    
	/**
	 * �\�[�X�f�B�X�N���v�^�̃t�@�N�g���擾�B
	 * @return �\�[�X�f�B�X�N���v�^�̃t�@�N�g���I�u�W�F�N�g�B
	 */
	SourceFactory getSourceFactory(); 

    /**
     * �G���W���̐������s���B
     * @return	�G���W��
     */
    Engine getEngine();
    
    /**
     * ���]���G���W���̎擾
     * @return ���]���G���W���B
     */
    ExpressionFactory getExpressionFactory();
    
    /**
     * �ݒ�XML�̃r���_���擾����B
     * @return �ݒ�XML�r���_�B
     */
    SpecificationBuilder getSpecificationBuilder();
	
    /**
     * HTML�e���v���[�g�t�@�C���̃r���_���擾����B
     * @return �e���v���[�g�r���_�B
     */
    TemplateBuilder getTemplateBuilder();
    
}
