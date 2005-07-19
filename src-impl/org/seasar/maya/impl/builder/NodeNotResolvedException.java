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
import org.seasar.maya.impl.MayaException;

/**
 * �e���v���[�g��ɋL�q�����m�[�h����������Ȃ������Ƃ��̗�O�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public class NodeNotResolvedException extends MayaException {

	private static final long serialVersionUID = 4560512867759109674L;

	private Template _template;
	private SpecificationNode _specificationNode;
	
	/**
	 * @param template �e���v���[�g�t�@�C���������́A���ߍ��݃y�[�W�B
	 * @param locator ��O�����ӏ��B
	 * @param specificationNode �����ł��Ȃ������m�[�h�B
	 */
	public NodeNotResolvedException(
	        Template template, SpecificationNode specificationNode) {
	    _template = template;
	    _specificationNode = specificationNode;
    }

	/**
	 * ��������Ȃ������m�[�h�̏�������e���v���[�g���擾�B
	 * @return ��������Ȃ������m�[�h�̏�������e���v���[�g�B
	 */
	public Template getTemplete() {
	    return _template;
	}
	
	/**
	 * ��������Ȃ������m�[�h���擾����B
	 * @return ��������Ȃ������m�[�h�B
	 */
	public SpecificationNode getSpecificationNode() {
		return _specificationNode;
	}

	/**
	 * ��O������̎擾�B
	 * @return ��O�������������0�B
	 */
	public int getColumnNumber() {
		return _specificationNode.getLocator().getColumnNumber();
	}
	
	/**
	 * ��O�����s�̎擾�B
	 * @return ��O�����s��������0�B
	 */
	public int getLineNumber() {
		return _specificationNode.getLocator().getLineNumber();
	}
	
	/**
	 * �\�[�X��PublicID�̎擾�B
	 * @return �\�[�X��PublicID��������null�B
	 */
	public String getPublicID() {
		return _specificationNode.getLocator().getPublicId();
	}
	
	/**
	 * �\�[�X��SystemID�̎擾�B
	 * @return �\�[�X��SystemID��������null�B
	 */
	public String getSystemID() {
		return _specificationNode.getLocator().getSystemId();
	}
	
}
