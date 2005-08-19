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
package org.seasar.maya.builder.library;

import java.util.Iterator;


/**
 * MLD��library�G�������g�̃��f���I�u�W�F�N�g�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface LibraryDefinition {
    
    /**
     * ���Y���C�u�����̖��O���URI�Buri�����l�Ŏw�肳�ꂽ���́B
     * @return ���O���URI�B
     */
    String getNamespaceURI();
    
    /**
     * �A�v���P�[�V�����ŃA�T�C�����ꂽURI���擾����B
     * @return �A�T�C�����ꂽURI�B
     */
    String getAssignedURI();
    
    /**
     * �q��processor�m�[�h�̃C�e���[�^�B
     * @return �m�[�h�C�e���[�^�B
     */
    Iterator iterateProcessorDefinition();
    
    /**
     * �w��QName�ŊY������ProcessorDefinition�̎擾�B
     * @param localName �擾������ProcessorDefinition�̖��O�B
     * @return �Y��ProcessorDefinition��������null�B
     */
    ProcessorDefinition getProcessorDefinition(String localName);
    
}
