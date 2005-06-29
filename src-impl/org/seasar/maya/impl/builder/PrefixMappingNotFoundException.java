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
package org.seasar.maya.impl.builder;

import org.seasar.maya.engine.specification.Specification;
import org.seasar.maya.engine.specification.SpecificationNode;
import org.xml.sax.Locator;

/**
 * �v���t�B�b�N�X���疼�O���URI�������Ȃ������Ƃ��B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public class PrefixMappingNotFoundException extends SpecificationBuildException {

	private static final long serialVersionUID = -9114023056056051237L;

	private String _prefix;
    
    public PrefixMappingNotFoundException(
    		Specification specification, SpecificationNode node, String prefix) {
    	super(specification, node);
    	_prefix = prefix;
    }
    
    
    /**
	 * @param specification �e���v���[�g�t�@�C���������́A���ߍ��݃y�[�W�A�ݒ�XML�B
	 * @param locator ��O�����ӏ��B
     * @param namespaceURI �}�b�s���O�Ώۂ�������Ȃ������v���t�B�b�N�X�B
     */
    public PrefixMappingNotFoundException(
            Specification specification, Locator locator, String prefix) {
        super(specification, locator);
    	_prefix = prefix;
    }
    
    /**
     * �s���������v���t�B�b�N�X���擾����B
     * @return �s���ȃv���t�B�b�N�X�B
     */
    public String getPrefix() {
        return _prefix;
    }
    
}
