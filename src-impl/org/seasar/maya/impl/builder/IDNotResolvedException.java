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
 * �e���v���[�g���mayaID��������id�������ł��Ȃ������Ƃ��̗�O�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public class IDNotResolvedException extends NodeNotResolvedException {

	private static final long serialVersionUID = 4245540599314570281L;

	private String _mayaID;
    
    /**
	 * @param template �e���v���[�g�t�@�C���������́A���ߍ��݃y�[�W�B
	 * @param specificationNode ��O�����m�[�h�B
     * @param mayaID �����ł��Ȃ�����ID�B
     */
    public IDNotResolvedException(
            Template template, SpecificationNode specificationNode, String mayaID) {
        super(template, specificationNode);
    	_mayaID = mayaID;
    }
    
    /**
     * �����ł��Ȃ�����ID���擾����B
     * @return �����ł��Ȃ�����ID�B
     */
    public String getID() {
        return _mayaID;
    }
    
}
