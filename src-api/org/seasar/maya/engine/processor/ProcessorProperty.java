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
package org.seasar.maya.engine.processor;

import org.seasar.maya.cycle.ServiceCycle;
import org.seasar.maya.engine.specification.QName;

/**
 * �v���Z�b�T�ɐݒ肷��v���p�e�B�̃����^�C���I�u�W�F�N�g�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface ProcessorProperty {
    
    /**
     * �v���Z�b�T�ɃZ�b�g���ׂ��v���p�e�B�ƃe���v���[�g��ݒ�XML��̑����Ƃ̃o�C���f�B���O���B
     * @return �o�C���f�B���O���B
     */
    QName getQName();

    /**
     * ���O���URI�Ƀ}�b�s���O���ꂽ�v���t�B�b�N�X������̎擾�B
     * @return �v���t�B�b�N�X������B
     */
    String getPrefix();
    
    /**
     * �ÓI�ȃv���p�e�B�l�擾���s���B
     * @return �v���p�e�B�l�B
     */
    String getLiteral();
    
    /**
     * ���I�l���ǂ�����Ԃ��B
     * @return true���Ɠ��I�l�B
     */
    boolean isDynamic();
    
    /**
     * �v���Z�b�T�̎��s���ɁA�v���p�e�B�l�擾���s���B
     * @param cycle �T�[�r�X�T�C�N���R���e�L�X�g�B
     * @return �v���p�e�B�l�B
     */
    Object getValue(ServiceCycle cycle);
 
    /**
     * �v���Z�b�T�̎��s���Ƀ��f���ւ̒l�ݒ���s���B
     * @param cycle �T�[�r�X�T�C�N���R���e�L�X�g�B
     * @param value �ݒ�l�B
     */
    void setValue(ServiceCycle cycle, Object value);
    
}
