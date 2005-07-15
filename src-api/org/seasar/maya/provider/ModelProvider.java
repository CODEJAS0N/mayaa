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

import org.seasar.maya.cycle.ServiceCycle;

/**
 * �A�v���P�[�V�����X�R�[�v�ł̃��f���񋟃I�u�W�F�N�g�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface ModelProvider {

    /**
     * ���[�U�[��`�̃��f���I�u�W�F�N�g�擾���\�b�h�B
     * @param cycle �T�[�r�X�T�C�N���R���e�L�X�g�B
     * @param modelName �R���|�[�l���g���B
     * @param modelClass �R���|�[�l���g�N���X�^�B
     * @param modelScope �X�R�[�v�B
     * @return ���f���I�u�W�F�N�g�B
     */
    Object getModel(ServiceCycle cycle, 
            String modelName, Class modelClass, String modelScope);
    
}
