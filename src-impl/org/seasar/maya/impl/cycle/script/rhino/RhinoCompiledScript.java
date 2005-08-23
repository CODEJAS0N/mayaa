/*
 * Copyright (c) 2004-2005 the Seasar Foundation and the Others.
 * 
 * Licensed under the Seasar Software License, v1.1 (aka "the License");
 * you may not use this file except in compliance with the License which 
 * accompanies this distribution, and is available at
 * 
 *     http://homepage3.nifty.com/seasar/SEASAR-LICENSE.TXT
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either 
 * express or implied. See the License for the specific language governing 
 * permissions and limitations under the License.
 */
package org.seasar.maya.impl.cycle.script.rhino;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.JavaAdapter;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.Scriptable;
import org.seasar.maya.cycle.script.resolver.ScriptResolver;
import org.seasar.maya.impl.cycle.script.AbstractCompiledScript;
import org.seasar.maya.impl.cycle.script.ConversionException;
import org.seasar.maya.source.SourceDescriptor;

/**
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public class RhinoCompiledScript extends AbstractCompiledScript {

    private static final long serialVersionUID = 4793923040332838492L;
    private static ThreadLocal _scope = new ThreadLocal();
    private static Scriptable _standardObjects;
    
    private ScriptResolver _resolver;
    private Script _script;
    private String _sourceName;
    int _lineno;
    
    public RhinoCompiledScript(ScriptResolver resolver,
    		String text, Class expectedType, String sourceName, int lineno) {
        super(text, expectedType);
        if(resolver == null) {
            throw new IllegalArgumentException();
        }
        _resolver = resolver;
        _sourceName = sourceName;
        _lineno = lineno;
    }
    
    public RhinoCompiledScript(ScriptResolver resolver,
            SourceDescriptor source, String encoding, Class expectedType) {
        super(source, encoding, expectedType);
        if(resolver == null) {
            throw new IllegalArgumentException();
        }
        _resolver = resolver;
        _sourceName = source.getSystemID();
        _lineno = 1;
    }
    
    private Scriptable getScope(Context cx, Object root) {
        Scriptable scope = (Scriptable)_scope.get();
        if(scope == null) {
            if(_standardObjects == null) {
                _standardObjects = cx.initStandardObjects(null, true);
            }
            scope = new ResolverScope(_resolver);
            scope.setPrototype(_standardObjects);
            _scope.set(scope);
        }
        if(root != null) {
            Scriptable rootScope = cx.getWrapFactory().wrapAsJavaObject(
                    cx, scope, root, root.getClass());
            rootScope.setPrototype(scope);
            return rootScope;
        }
        return scope;
    }
    
    protected Script compile(Context cx) {
        if(usingSource()) {
            SourceDescriptor source = getSource();
            if(source.exists()) {
                InputStream stream = source.getInputStream();
                try {
                    Reader reader = new InputStreamReader(stream, getEncoding());
                    return cx.compileReader(reader, _sourceName, _lineno, null);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            // TODO JS�̃t�@�C�����݂���Ȃ���O�B
            throw new IllegalStateException();
        }
        return cx.compileString(getText(), _sourceName, _lineno, null);
    }
    
    public Object execute(Object root) {
        Object ret = null;
        Class expectedType = getExpectedType();
        Context cx = Context.enter();
        cx.setWrapFactory(new MayaWrapFactory());
        try {
            if(_script == null) {
                _script = compile(cx);
            }
            Object value = _script.exec(cx, getScope(cx, root));
            if(expectedType != Void.class) {
                ret = JavaAdapter.convertResult(value, expectedType);
            }
        } finally {
            Context.exit();
        }
        if(expectedType == Void.class || ret == null) {
            return null;
        } else if(expectedType.isAssignableFrom(ret.getClass())) {
            return ret;
        }
        throw new ConversionException(this, ret.getClass());
    }
    
}