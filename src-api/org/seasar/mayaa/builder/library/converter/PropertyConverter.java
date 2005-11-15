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
package org.seasar.mayaa.builder.library.converter;

import org.seasar.mayaa.ParameterAware;
import org.seasar.mayaa.engine.specification.NodeAttribute;

/**
 * �v���Z�b�T�ݒ�̃v���p�e�B�l��ϊ��񋟂���R���o�[�^�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface PropertyConverter extends ParameterAware {

    /**
     * ���̃R���o�[�^���������s���v���p�e�B�̐ÓI�^���擾����B
     * @return �v���p�e�B�^�B
     */
    Class getPropetyClass();
    
    /**
     * �v���p�e�B�̕ϊ����s���B
     * @param attribute �ݒ葮���B
     * @param value �ϊ����镶����l�B
     * @param expectedClass ���I�l�̏ꍇ�Ɋ��҂��铮�I�^�B
     * @return �ϊ��l�B
     */
    Object convert(NodeAttribute attribute, String value, Class expectedClass);
    
}
