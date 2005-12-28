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
package org.seasar.mayaa.provider;

import java.io.Serializable;

import org.seasar.mayaa.ParameterAware;
import org.seasar.mayaa.builder.PathAdjuster;
import org.seasar.mayaa.builder.SpecificationBuilder;
import org.seasar.mayaa.builder.TemplateBuilder;
import org.seasar.mayaa.builder.library.LibraryManager;
import org.seasar.mayaa.cycle.script.ScriptEnvironment;
import org.seasar.mayaa.engine.Engine;

/**
 * �A�v���P�[�V�����X�R�[�v�ł̃T�[�r�X�񋟃I�u�W�F�N�g�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface ServiceProvider extends ParameterAware, Serializable {
    
    /**
     * �G���W����ݒ肷��B
     * @param engine �G���W���B
     */
    void setEngine(Engine engine);
    
    /**
     * �G���W�����擾����B
     * @return	�G���W��
     */
    Engine getEngine();
    
    /**
     * �X�N���v�g���s���̐ݒ�B
     * @param environment �X�N���v�g���s���B
     */
    void setScriptEnvironment(ScriptEnvironment environment);
    
    /**
     * �X�N���v�g���s���̎擾�B
     * @return �X�N���v�g���s���B
     */
    ScriptEnvironment getScriptEnvironment();

    /**
     * ���C�u�����}�l�[�W����ݒ肷��B
     * @param libraryManager ���C�u�����}�l�[�W���B
     */
    void setLibraryManager(LibraryManager libraryManager);
    
    /**
     * ���C�u�����}�l�[�W�����擾����B
     * @return ���C�u�����}�l�[�W���B
     */
    LibraryManager getLibraryManager();

    /**
     * �ݒ�XML�̃r���_��ݒ肷��B
     * @param specificationBuilder �ݒ�XML�r���_�B
     */
    void setSpecificationBuilder(SpecificationBuilder specificationBuilder);
    
    /**
     * �ݒ�XML�̃r���_���擾����B
     * @return �ݒ�XML�r���_�B
     */
    SpecificationBuilder getSpecificationBuilder();
	
    /**
     * HTML�e���v���[�g�t�@�C���̃r���_��ݒ肷��B
     * @param templateBuilder �e���v���[�g�r���_�B
     */
    void setTemplateBuilder(TemplateBuilder templateBuilder);
    
    /**
     * HTML�e���v���[�g�t�@�C���̃r���_���擾����B
     * @return �e���v���[�g�r���_�B
     */
    TemplateBuilder getTemplateBuilder();

    /**
     * HTML�^�O�����̑��΃p�X���΃p�X�ɒu������I�u�W�F�N�g��ݒ肷��B
     * @param pathAdjuster �p�X�A�W���X�^�B
     */
    void setPathAdjuster(PathAdjuster pathAdjuster);

    /**
     * HTML�^�O�����̑��΃p�X���΃p�X�ɒu������I�u�W�F�N�g���擾����B
     * @return �p�X�A�W���X�^�B
     */
    PathAdjuster getPathAdjuster();
    
}
