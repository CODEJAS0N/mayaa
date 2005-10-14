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

import java.io.Serializable;

import org.seasar.maya.ParameterAware;
import org.seasar.maya.builder.SpecificationBuilder;
import org.seasar.maya.builder.TemplateBuilder;
import org.seasar.maya.builder.library.LibraryManager;
import org.seasar.maya.cycle.script.ScriptEnvironment;
import org.seasar.maya.engine.Engine;

/**
 * �A�v���P�[�V�����X�R�[�v�ł̃T�[�r�X�񋟃I�u�W�F�N�g�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface ServiceProvider extends ParameterAware, Serializable {
    
    /**
     * �G���W�����擾����B
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
    
}
