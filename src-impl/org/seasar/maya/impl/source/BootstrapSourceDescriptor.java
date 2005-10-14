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

import org.seasar.maya.impl.cycle.web.ApplicationScopeImpl;

/**
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public class BootstrapSourceDescriptor
        extends CompositeSourceDescriptor {

    private static final long serialVersionUID = -7436518426506691163L;
    private Object _context;

    public void setContext(Object context) {
        if(context == null) {
            throw new IllegalArgumentException();
        }
        _context = context;
    }
    
    public void setSystemID(String systemID) {
        if(_context == null) {
            throw new IllegalStateException();
        }
        super.setSystemID(systemID);
        ApplicationSourceDescriptor appSource = new ApplicationSourceDescriptor();
        appSource.setRoot(ApplicationSourceDescriptor.WEB_INF);
        appSource.setSystemID(systemID);
        ApplicationScopeImpl application = new ApplicationScopeImpl();
        application.setUnderlyingContext(_context);
        appSource.setApplicationScope(application);
        addSourceDescriptor(appSource);
        ClassLoaderSourceDescriptor loader = new ClassLoaderSourceDescriptor();
        loader.setRoot(ClassLoaderSourceDescriptor.META_INF);
        loader.setSystemID(systemID);
        addSourceDescriptor(loader);
    }

}
