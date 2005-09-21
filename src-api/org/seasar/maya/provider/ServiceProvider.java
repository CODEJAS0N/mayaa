/*
 * Copyright 2004-2005 the Seasar Foundation and the Others.
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
package org.seasar.maya.provider;

import org.seasar.maya.builder.SpecificationBuilder;
import org.seasar.maya.builder.TemplateBuilder;
import org.seasar.maya.builder.library.LibraryManager;
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
     * ���C�u�����}�l�[�W���[���擾����B
     * @return ���C�u�����}�l�[�W���[�B
     */
    LibraryManager getLibraryManager();

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
     * @param requestContext �J�����g�̃��N�G�X�g�I�u�W�F�N�g�B
     * @param responseContext �J�����g�̃��X�|���X�I�u�W�F�N�g�B
     */
    void initialize(Object requestContext, Object responseContext);
    
    /**
     * �T�[�r�X�T�C�N���̎擾
     * @return �J�����g�X���b�h�ł̃T�[�r�X�T�C�N���B
     */
    ServiceCycle getServiceCycle();
    
}
