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
package org.seasar.maya.engine.specification;

import java.util.Iterator;

import org.xml.sax.Locator;

/**
 * 	�ݒ�XML�̍\�����B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface SpecificationNode extends QNameable {
    
	/**
	 * �m�[�h�����̒ǉ��B
	 * @param qName �������B
	 * @param value �����l�B
	 */
    void addAttribute(QName qName, String value);
    
    /**
     * �����̎擾�B
     * @param qName �擾���鑮����QName�B
     * @return �����I�u�W�F�N�g�B
     */
    NodeAttribute getAttribute(QName qName);
    
    /**
     * �����̃C�e���[�g�B
     * @return �����i<code>NodeAttribute</code>�j�̃C�e���[�^�B
     */
    Iterator iterateAttribute();
    
    /**
     * �e�m�[�h�̐ݒ���Z�b�g����B
     * @param parent �e�m�[�h�B
     */
    void setParentNode(SpecificationNode parent);

    /**
     * �e�m�[�h���擾����B
     * @return �e�m�[�h�B
     */
    SpecificationNode getParentNode();
    
    /**
     * �q�m�[�h�̐ݒ���Z�b�g����B
     * @param child �q�m�[�h�B
     */
    void addChildNode(SpecificationNode child);

    /**
     * �q�m�[�h�̃C�e���[�^���擾����B
     * @return �q�m�[�h�i<code>SpecificationNode</code>�j��ێ������C�e���[�^�B
     */
    Iterator iterateChildNode();
    
    /**
     * �\�[�X��̈ʒu���擾�B
     * @return �ʒu���
     */
    Locator getLocator();
    
    /**
     * �����̃R�s�[�𐶐����ĕԂ��B�������A�e�m�[�h�͐ݒ肳��Ă��Ȃ��B
     * @return �����̃R�s�[�B
     */
    SpecificationNode copyTo();

    /**
     * �t�B���^�t���Ŏ����̃R�s�[�𐶐����ĕԂ��B�������A�e�m�[�h�͐ݒ肳��Ă��Ȃ��B
     * @param filter �R�s�[���t�B���^�B
     * @return �����̃R�s�[�B
     */
    SpecificationNode copyTo(CopyToFilter filter);

}
