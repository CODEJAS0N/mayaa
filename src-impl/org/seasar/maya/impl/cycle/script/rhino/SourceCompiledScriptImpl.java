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
package org.seasar.maya.impl.cycle.script.rhino;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.WrapFactory;
import org.mozilla.javascript.WrappedException;
import org.seasar.maya.impl.cycle.script.AbstractSourceCompiledScript;
import org.seasar.maya.source.SourceDescriptor;

/**
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public class SourceCompiledScriptImpl 
        extends AbstractSourceCompiledScript {

    private static final long serialVersionUID = 4793923040332838492L;
    
    private WrapFactory _wrap;
    private Script _rhinoScript;
    
    public SourceCompiledScriptImpl(
            SourceDescriptor source, String encoding, WrapFactory wrap) {
        super(source, encoding);
        _wrap = wrap;
    }
    
    protected void compileFromSource(
            Context cx, SourceDescriptor source) {
        if(source == null) {
            throw new IllegalArgumentException();
        }
        if(_rhinoScript == null) {
            if(source.exists() == false) {
                throw new RuntimeException(
                        new FileNotFoundException(source.getSystemID()));
            }
            InputStream stream = source.getInputStream();
            try {
                Reader reader = new InputStreamReader(stream, getEncoding());
                _rhinoScript = cx.compileReader(
                        reader, source.getSystemID(), 1, null);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Object execute(Object[] args) {
        Context cx = RhinoUtil.enter(_wrap);
        Object ret = null;
        try {
            compileFromSource(cx, getSource());
            Object jsRet = _rhinoScript.exec(cx, RhinoUtil.getScope());
            ret = RhinoUtil.convertResult(cx, getExpectedType(), jsRet);
        } catch(WrappedException e) {
            RhinoUtil.removeWrappedException(e);
        } finally {
            Context.exit();
        }
        return ret;
    }

}