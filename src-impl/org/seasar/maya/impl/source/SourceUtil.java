/*
 * Copyright 2004-2005 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.seasar.maya.impl.source;

import org.seasar.maya.FactoryFactory;
import org.seasar.maya.impl.util.StringUtil;
import org.seasar.maya.source.SourceDescriptor;
import org.seasar.maya.source.SourceFactory;

/**
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public class SourceUtil {
    
    private SourceUtil() {
        // no instantiate.
    }

    public static SourceDescriptor getSourceDescriptor(String systemID) {
        if(StringUtil.isEmpty(systemID)) {
            throw new IllegalArgumentException();
        }
        SourceFactory factory = FactoryFactory.getSourceFactory();
        return factory.getSourceDescriptor(systemID);
    }
    
}