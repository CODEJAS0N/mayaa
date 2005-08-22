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
package org.seasar.maya.cycle;

import java.io.IOException;
import java.io.Writer;

/**
 * �l�X�g�����o�͍\��������Writer�I�u�W�F�N�g�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public abstract class CycleWriter extends Writer {

    /**
     * �R���X�g���N�^�œn���ꂽ�A��ʂ�Writer��Ԃ��Bnull�̏ꍇ�����肦��B
     * @return ��ʂ�Writer�B
     */
    public abstract CycleWriter getEnclosingWriter();
    
	/**
     * �o�b�t�@���N���A����B
	 */
    public abstract void clearBuffer();
	
	/**
     * �o�b�t�@�̓��e��String�Ŏ擾����B
     * @return �o�b�t�@���e�B
	 */
    public abstract String getString();
	
    /**
     * �w��Writer�Ƀo�b�t�@���e�������o���B
     * @param writer �����o�����Writer�B
     */
    public abstract void writeOut(Writer writer) throws IOException;
    
}
