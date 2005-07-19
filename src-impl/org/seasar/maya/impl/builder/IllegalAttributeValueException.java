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

import org.seasar.maya.engine.Template;
import org.seasar.maya.engine.specification.SpecificationNode;

/**
 * �e���v���[�g��ݒ�XML�Ɏw�肳�ꂽ�����l���s���ȏꍇ�̗�O�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public class IllegalAttributeValueException extends NodeNotResolvedException {

	private static final long serialVersionUID = -530046431089771029L;

	private String _attributeName;
	private String _attributeValue;
	
	/**
	 * @param template �e���v���[�g�t�@�C�����������́A���ߍ��݃y�[�W���B
	 * @param node ��O�����ӏ��m�[�h�B
	 * @param attributeName �s���Ȓl���Z�b�g���ꂽ�������B 
	 * @param attributeValue �s���ȑ����l�B
	 */
	public IllegalAttributeValueException(Template template, 
			SpecificationNode node, String attributeName, String attributeValue) {
	    super(template, node);
		_attributeName = attributeName;
		_attributeValue = attributeValue;
    }
	
	/**
	 * ���������擾����B
	 * @return �s���Ȓl�̑������B
	 */
	public String getAttributeName() {
		return _attributeName;
	}
	
	/**
	 * �����l���擾����B
	 * @return �s���ȑ����l�B
	 */
	public String getAttributeValue() {
	    if(_attributeValue == null) {
	        return "(null)";
	    }
		return _attributeValue;
	}
	
}
