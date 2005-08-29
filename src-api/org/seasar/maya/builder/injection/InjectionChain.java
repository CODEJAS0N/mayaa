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
package org.seasar.maya.builder.injection;

import org.seasar.maya.engine.Template;
import org.seasar.maya.engine.specification.SpecificationNode;

/**
 * �e���v���[�g�ɋL�q���ꂽHTML�^�O�ɁA�ǉ��I�ȏ���ێ�����m�[�h��
 * �C���W�F�N�V�������郌�]���o�`�F�[���B���̃C���^�[�t�F�C�X�̎����I�u�W�F�N�g��
 * �G���W�����񋟂���B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface InjectionChain {

    /**
     * �e���v���[�g��̃I���W�i���ȃm�[�h�ɃC���W�F�N�V��������m�[�h�����肷��ۂ�
     * �`�F�[�����\�b�h�B
     * @param template �e���v���[�g�B
     * @param original �e���v���[�g��̃I���W�i���ȃm�[�h�B
     * @return �C���W�F�N�V��������m�[�h��������null�B
     */
    SpecificationNode getNode(Template template, SpecificationNode original);
    
}
