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

/**
 * ���O���URI�ƃ��[�J�����̑g�ݍ��킹��ێ����鎯�ʃI�u�W�F�N�g�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public class QName {

    private String _namespaceURI;
    private String _localName;
    
    /**
     * �f�t�H���g�̖��O��ԁihttp://maya.seasar.org�j��QName�B 
     * @param localName ���[�J�����B
     */
    public QName(String localName) {
        this("http://maya.seasar.org", localName);
    }
    
    /**
     * @param namespaceURI ���O���URI�B
     * @param localName ���[�J�����B
     */
    public QName(String namespaceURI, String localName) {
        if(namespaceURI == null || namespaceURI.length() == 0 ||
                localName == null || localName.length() == 0) {
            throw new IllegalArgumentException();
        }
        _namespaceURI = namespaceURI;
        _localName = localName;
    }
    
    /**
     * ���O���URI�̎擾�B
     * @return ���O���URI�B
     */
    public String getNamespaceURI() {
        return _namespaceURI;
    }
    
    /**
     * ���[�J�����̎擾�B
     * @return ���[�J�����B
     */
    public String getLocalName() {
        return _localName;
    }
    
    public String toString() {
        return "{" + getNamespaceURI() + "}" + getLocalName();
    }
    
    public boolean equals(Object test) {
        if(test instanceof QName) {
            QName qName = (QName)test;
            return _namespaceURI.equals(qName.getNamespaceURI()) &&
            	_localName.equalsIgnoreCase(qName.getLocalName());
        }
        return false;
    }
    
    public int hashCode() {
        return toString().hashCode();
    }

}
