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
 * 	設定XMLの構成物の属性。
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface NodeAttribute extends QNameable {
    
    /**
     * 所属するノードを取得する。
     * @return 所属ノード。
     */
    SpecificationNode getNode();
    
    /**
     * 属性の値。
     * @return 属性の値。ゼロ長文字列もありえる。
     */
    String getValue();

}
