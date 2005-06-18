/*
 * Copyright (c) 2004-2005 the Seasar Project and the Others.
 * 
 * Licensed under the Seasar Software License, v1.1 (aka "the License"); you may
 * not use this file except in compliance with the License which accompanies
 * this distribution, and is available at
 * 
 *     http://www.seasar.org/SEASAR-LICENSE.TXT
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.seasar.maya.engine.error;

import javax.servlet.jsp.PageContext;

import org.seasar.maya.provider.Parameterizable;

/**
 * �G���[�����̂��߂̃n���h���B���N�G�X�g�̍Ō�A�G���[��ʂ̏o�͂Ȃǂ��s���B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface ErrorHandler extends Parameterizable {

    /**
     * �G���[�������\�b�h�B
     * @param context �J�����g�R���e�L�X�g�B
     * @param t �����Ώۂ�Throwable�B
     */
    void doErrorHandle(PageContext context, Throwable t) throws Throwable;

}
