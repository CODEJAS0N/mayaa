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
package org.seasar.maya.cycle.el.resolver;

import org.seasar.maya.cycle.ServiceCycle;
import org.seasar.maya.provider.Parameterizable;

/**
 * ���]�����]���o�B�A�v���P�[�V�����X�R�[�v�ɂċ��L�����̂ŁA
 * �X���b�h�Z�[�t�Ɏ������邱�Ƃ����߂���B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface ExpressionResolver extends Parameterizable {

    /**
     * �l�̎擾�̂��߂̃��]���o���\�b�h�B���������ꍇ�́AExpressionContext
     * ��propertyResolved�v���p�e�B��true���Z�b�g����B
     * @param cycle �T�[�r�X�T�C�N���R���e�L�X�g�B
     * @param base �]���̃x�[�X�ƂȂ�I�u�W�F�N�g�B
     * @param property �l�擾����v���p�e�B�B������������̓C���f�b�N�X�l�B
     * @param chain ���̃��]���o�ւ̃G���g���[�ƂȂ�`�F�[���B
     * @return �]�����ʁB
     */
    Object getValue(ServiceCycle cycle, 
            Object base, Object property, ExpressionChain chain);

    /**
     * �l�ݒ�̂��߂̃��]���o���\�b�h�B���������ꍇ�́AExpressionContext
     * ��propertyResolved�v���p�e�B��true���Z�b�g����B
     * @param cycle �T�[�r�X�T�C�N���R���e�L�X�g�B
     * @param base �]���̃x�[�X�ƂȂ�I�u�W�F�N�g�B
     * @param property �l�ݒ肷��v���p�e�B�B������������̓C���f�b�N�X�l�B
     * @param value �ݒ�l�B
     * @param chain ���̃��]���o�ւ̃G���g���[�ƂȂ�`�F�[���B
     */
    void setValue(ServiceCycle cycle, 
            Object base, Object property, Object value, ExpressionChain chain);
    
}
