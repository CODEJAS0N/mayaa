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
package org.seasar.maya.source.factory;

import org.seasar.maya.provider.Parameterizable;
import org.seasar.maya.source.SourceDescriptor;

/**
 * SourceDescriptor�̃t�@�N�g���N���X�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface SourceFactory extends Parameterizable {

    /**
     * �o�^����Ă���S�\�[�X�G���g���B
     * @return �G���g���̔z��B
     */
    SourceEntry[] getSourceEntries();
    
	/**
	 * �e���v���[�g��ݒ�XML�̃\�[�X�f�B�X�N���v�^�̎擾�B
	 * @param path �\�[�X�p�X�B�v���g�R���{SystemID�B
	 * @return �w��p�X�̃\�[�X�f�B�X�N���v�^�B��ɃC���X�^���X��V���ɐ�������B
	 */
	SourceDescriptor createSourceDescriptor(String path);
	
}
