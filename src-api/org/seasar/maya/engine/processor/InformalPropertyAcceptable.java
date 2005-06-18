/*
 * Copyright (c) 2004-2005 the Seasar Project and the Others.
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

/**
 * ���炩���߁AMLD�iMaya Library Definition�j�t�@�C���ɋL�q����ĂȂ�
 * �v���p�e�B���󂯓����ꍇ�̃C���^�[�t�F�C�X�BMLD�L�q����Ă�v���p�e�B��
 * ���̃��\�b�h���o�R���Ȃ��ŁA���ځABean�v���p�e�B�A�N�Z�X�Őݒ肳���B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface InformalPropertyAcceptable extends TemplateProcessor {

    /**
     * �Z�b�g�����ׂ����O���URI�B
     * @return ���O���URI�B
     */
    String getInformalAttrituteURI(); 
    
	/**
	 * ��MLD�ȃC���t�H�[�}���v���p�e�B�̎󂯓��ꃁ�\�b�h�B
	 * @param property �C���t�H�[�}���v���p�e�B�B
	 */
	void addInformalProperty(ProcessorProperty property);
	
}
