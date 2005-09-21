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
package org.seasar.maya.builder.library;

import org.seasar.maya.provider.Parameterizable;
import org.seasar.maya.source.SourceDescriptor;

/**
 * ���C�u������`�\�[�X�r���_�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface DefinitionBuilder extends Parameterizable {

    /**
     * ���C�u������`�\�[�X���烉�C�u�������r���h����B
     * @param source ���C�u������`�\�[�X�B
     * @return �r���h���ʁB�����ł��Ȃ������ꍇ�ɂ�null��Ԃ��B
     */
    LibraryDefinition build(SourceDescriptor source);
    
}
