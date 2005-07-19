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
package org.seasar.maya.impl.builder;

import org.seasar.maya.engine.specification.Specification;
import org.seasar.maya.engine.specification.SpecificationNode;
import org.seasar.maya.impl.MayaException;
import org.xml.sax.Locator;

/**
 * �e���v���[�g�r���h���̊�{�I�ȗ�O�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public class SpecificationBuildException extends MayaException {
    
	private static final long serialVersionUID = -5042681474924383369L;

	private Specification _specification;
	private Locator _locator;
	
	/**
	 * @param specification �r���h�����s�����e���v���[�g/�ݒ�XML�B
	 * @param node ��O�Ɋ֘A����m�[�h�B
	 */
	protected SpecificationBuildException(Specification specification, SpecificationNode node) {
		_specification = specification;
		if(node != null) {
			_locator = node.getLocator();
		}
	}
	
	/**
	 * @param specification �r���h�����s�����e���v���[�g/�ݒ�XML�B
	 * @param locator ��O�����ӏ��B
	 */
	protected SpecificationBuildException(Specification specification, Locator locator) {
		_specification = specification;
		_locator = locator;
    }
	
	/**
	 * �r���h�����s�����e���v���[�g/�ݒ�XML���擾����B
	 * @return �r���h�����s�����e���v���[�g/�ݒ�XML�B
	 */
	public Specification getSpecification() {
		return _specification;
	}

	/**
	 * ��O������̎擾�B
	 * @return ��O�������������0�B
	 */
	public int getColumnNumber() {
		return _locator.getColumnNumber();
	}
	
	/**
	 * ��O�����s�̎擾�B
	 * @return ��O�����s��������0�B
	 */
	public int getLineNumber() {
		return _locator.getLineNumber();
	}
	
	/**
	 * �\�[�X��PublicID�̎擾�B
	 * @return �\�[�X��PublicID��������null�B
	 */
	public String getPublicID() {
		return _locator.getPublicId();
	}
	
	/**
	 * �\�[�X��SystemID�̎擾�B
	 * @return �\�[�X��SystemID��������null�B
	 */
	public String getSystemID() {
		return _locator.getSystemId();
	}
	
}
