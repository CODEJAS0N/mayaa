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
package org.seasar.maya;

import java.util.Iterator;

/**
 * �I�u�W�F�N�g�̃`���[�j���O�ݒ�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface ParameterAware extends PositionAware {

	/**
	 * ���[�U�[�ݒ�̎󂯓��ꃁ�\�b�h�B
	 * @param name �ݒ薼�B
	 * @param value �ݒ�l�B
	 */
	void setParameter(String name, String value);

	/**
	 * �ݒ�p�����[�^�̎擾�B
	 * @param name �ݒ薼�B
	 * @return �ݒ�l�B
	 */
	String getParameter(String name);
	
	/**
	 * �ݒ�p�����[�^�����C�e���[�g����B
	 * @return �ݒ�p�����[�^���C�e���[�^�B
	 */
	Iterator iterateParameterNames();

}
