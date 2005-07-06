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
package org.seasar.maya.impl.cycle.servlet;

import java.io.BufferedReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;

import org.seasar.maya.impl.util.StringUtil;
import org.seasar.maya.impl.util.collection.IteratorEnumeration;

/**
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public class MockServletRequest implements ServletRequest {

    private Map _parameters = new HashMap();
    private Map _attributes = new HashMap();
    private Locale _locale;
    
    public Map getParameterMap() {
        return _parameters;
    }

    public Enumeration getParameterNames() {
        return new IteratorEnumeration(_parameters.keySet().iterator());
    }

    public String[] getParameterValues(String name) {
        if(StringUtil.isEmpty(name)) {
            throw new IllegalArgumentException();
        }
        return (String[])_parameters.get(name);
    }

    public String getParameter(String name) {
        if(StringUtil.isEmpty(name)) {
            throw new IllegalArgumentException();
        }
        String values[] = getParameterValues(name);
        if(values != null && values.length > 0) {
            return values[0];
        }
        return null; 
    }

    public void addParameter(String name, String value) {
        if(StringUtil.isEmpty(name) || value == null) {
            throw new IllegalArgumentException();
        }
        String[] values = (String[])_parameters.get(name);
        if(values == null) {
            _parameters.put(name, new String[] { value });
        } else {
            int len = values.length;
            String[] newValues = new String[len + 1];
            System.arraycopy(values, 0, newValues, 0, len);
            newValues[len] = value;
            _parameters.put(name, newValues);
        }
    }

    public Enumeration getAttributeNames() {
        return new IteratorEnumeration(_attributes.keySet().iterator());
    }
    
    public Object getAttribute(String name) {
        return _attributes.get(name);
    }

    public void setAttribute(String name, Object attribute) {
        _attributes.put(name, attribute);
    }

    public void removeAttribute(String name) {
        _attributes.remove(name);
    }

    public String getCharacterEncoding() {
        return null;
    }

    public int getContentLength() {
        return 0;
    }

    public String getContentType() {
        return null;
    }

    public void setCharacterEncoding(String encoding) {
    }

    public Locale getLocale() {
        if(_locale == null) {
            throw new IllegalStateException();
        }
        return _locale;
    }

    public void setLocale(Locale locale) {
        if(locale == null) {
            throw new IllegalArgumentException();
        }
        _locale = locale;
    }

    public Enumeration getLocales() {
        return null;
    }

    public ServletInputStream getInputStream() {
        return null;
    }

    public BufferedReader getReader() {
        return null;
    }

    public String getRealPath(String arg0) {
        throw new UnsupportedOperationException();
    }

    public RequestDispatcher getRequestDispatcher(String uri) {
        throw new UnsupportedOperationException();
    }

    public String getRemoteAddr() {
        return "127.0.0.1";
    }

    public String getRemoteHost() {
        return "localhost";
    }

    public String getScheme() {
        return "http";
    }

    public String getProtocol() {
        return "GET";
    }

    public String getServerName() {
        return "localhost";
    }

    public int getServerPort() {
        return 8080;
    }

    public boolean isSecure() {
        return false;
    }
    
}
