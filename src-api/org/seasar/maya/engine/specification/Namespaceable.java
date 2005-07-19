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

/**
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface Namespaceable extends NodeObject {

    /**
     * 名前空間モデルの追加。
     * @param prefix 名前空間プレフィックス。
     * @param namespaceURI 名前空間URI。
     */
    void addNamespace(String prefix, String namespaceURI);
    
    /**
     * 名前空間モデルの取得。
     * @param prefix 取得したい名前空間のプレフィックス。
     * @return 名前空間モデル。
     */
    NodeNamespace getNamespace(String prefix);
    
    /**
     * 適用される名前空間のイテレート。
     * @return 名前空間（<code>NodeNamespace</code>）のイテレータ。
     */
    Iterator iterateNamespace();

    /**
     * 適用される名前空間のイテレート。
     * @param namespaceURI 取得したい名前空間URI。
     * @return 指定名前空間URIのイテレータ。
     */
    Iterator iterateNamespace(String namespaceURI);
    
}
