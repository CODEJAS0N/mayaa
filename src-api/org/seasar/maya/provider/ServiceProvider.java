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
package org.seasar.maya.provider;

import org.seasar.maya.builder.SpecificationBuilder;
import org.seasar.maya.builder.TemplateBuilder;
import org.seasar.maya.cycle.Application;
import org.seasar.maya.cycle.ServiceCycle;
import org.seasar.maya.cycle.script.ScriptEnvironment;
import org.seasar.maya.engine.Engine;
import org.seasar.maya.source.SourceDescriptor;

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
     * �G���W���̐������s���B
     * @return	�G���W��
     */
    Engine getEngine();
    
    /**
     * �X�N���v�g���s���̎擾�B
     * @return �X�N���v�g���s���B
     */
    ScriptEnvironment getScriptEnvironment();
    
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

    /**
     * �e���v���[�g��ݒ�XML��ǂݏo���\�[�X�𐶐�����B
     * @param systemID �\�[�X��SystemID�B
     * @return �w��SystemID�̃\�[�X�B
     */
    SourceDescriptor getPageSourceDescriptor(String systemID);
    
    /**
     * ���N�G�X�g����у��X�|���X�̃R���e�L�X�g�I�u�W�F�N�g�ݒ�B
     * @param request �J�����g�̃��N�G�X�g�I�u�W�F�N�g�B
     * @param response �J�����g�̃��X�|���X�I�u�W�F�N�g�B
     */
    void initialize(Object request, Object response);
    
    /**
     * �T�[�r�X�T�C�N���̎擾
     * @return �J�����g�X���b�h�ł̃T�[�r�X�T�C�N���B
     */
    ServiceCycle getServiceCycle();

    /**
     * ���[�U�[��`�̃��f���I�u�W�F�N�g�擾���\�b�h�B
     * @param modelKey �R���|�[�l���g�L�[�B
     * @param modelScope �X�R�[�v�B
     * @return ���f���I�u�W�F�N�g�B
     */
    Object getModel(Object modelKey, String modelScope);
    
}
