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
package org.seasar.maya.impl.util.xml;

import org.xml.sax.Locator;

/**
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public class NullLocator implements Locator {

    private static final Locator _instance = new NullLocator(); 
    
    public static Locator getInstance() {
        return _instance;
    }
    
    private NullLocator() {
    }
    
    public int getColumnNumber() {
        return 0;
    }

    public int getLineNumber() {
        return 0;
    }
    
    public String getPublicId() {
        return "";
    }
    
    public String getSystemId() {
        return "";
    }

}
