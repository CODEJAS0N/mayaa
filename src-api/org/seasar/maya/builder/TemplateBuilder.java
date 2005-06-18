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
package org.seasar.maya.builder;

import org.seasar.maya.builder.library.LibraryManager;
import org.seasar.maya.builder.specification.InjectionResolver;

/**
 * HTML�e���v���[�g�̃r���_
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface TemplateBuilder extends SpecificationBuilder {
    
    /**
     * �C���W�F�N�V�������]���o�̃��[�g���擾����B
     * @return �C���W�F�N�V�������]���o�B
     */
    InjectionResolver getInjectionResolver();
    
    /**
     * ���C�u�����}�l�[�W���[���擾����B
     * @return ���C�u�����}�l�[�W���[�B
     */
    LibraryManager getLibraryManager();
    
}
