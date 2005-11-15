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
package org.seasar.maya.engine.processor;

import org.seasar.maya.cycle.script.CompiledScript;
import org.seasar.maya.engine.specification.PrefixAwareName;

/**
 * �v���Z�b�T�ɐݒ肷��v���p�e�B�̃����^�C���I�u�W�F�N�g�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface ProcessorProperty {
    
    /**
     * �v���Z�b�T�̃v���p�e�B���B
     * @return �v���p�e�B���B
     */
    PrefixAwareName getName();

    /**
     * �v���p�e�B�l�̃R���p�C���ς݃X�N���v�g�I�u�W�F�N�g���擾����B
     * @return �v���p�e�B�l�B
     */
    CompiledScript getValue();
    
}
