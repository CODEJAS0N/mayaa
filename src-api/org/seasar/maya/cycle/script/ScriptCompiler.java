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
package org.seasar.maya.cycle.script;

import org.seasar.maya.cycle.script.resolver.ScriptResolver;
import org.seasar.maya.provider.Parameterizable;

/**
 * �X�N���v�g�R���p�C���B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface ScriptCompiler extends Parameterizable {

    /**
     * ���[�g�̃X�N���v�g���]���o�̎擾�B
     * @return �X�N���v�g���]���o�B
     */
    ScriptResolver getScriptResolver();
    
    /**
     * �����ꕶ����̊J���N�I�[�g������̐ݒ�B
     * @param blockStart �J���N�I�[�g������B
     */
    void setBlockStart(String blockStart);
    
    /**
     * �����ꕶ����̕��N�I�[�g������̐ݒ�B
     * @param blockEnd ���N�I�[�g������B
     */
    void setBlockEnd(String blockEnd);
    
    /**
     * ����������R���p�C������B
     * @param script �X�N���v�g�B
     * @param expectedType ���҂��錋�ʌ^�BVoid.class�̏ꍇ�A���^�[���͂Ȃ��B
     * @return �R���p�C���ς݃X�N���v�g�I�u�W�F�N�g�B
     */
    CompiledScript compile(String script, Class expectedType);

}
