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
package org.seasar.maya.impl.cycle.web;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.seasar.maya.cycle.Application;
import org.seasar.maya.cycle.AttributeScope;
import org.seasar.maya.impl.cycle.AbstractRequest;
import org.seasar.maya.impl.provider.UnsupportedParameterException;
import org.seasar.maya.impl.util.ScriptUtil;
import org.seasar.maya.impl.util.SpecificationUtil;
import org.seasar.maya.impl.util.StringUtil;
import org.seasar.maya.impl.util.collection.EnumerationIterator;

/**
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public class RequestImpl extends AbstractRequest {

    private static final long serialVersionUID = 8377365781441987529L;

    private HttpServletRequest _httpServletRequest;
    private Locale[] _locales;
    private ParamValuesScope _paramValues;
    private HeaderValuesScope _headerValues;
    
    public RequestImpl(Application application, 
            HttpServletRequest httpServletRequest) {
        super(application);
        if(httpServletRequest == null) {
            throw new IllegalArgumentException();
        }
        _httpServletRequest = httpServletRequest;
    }

    public String getRequestedPath() {
        String path = StringUtil.preparePath(_httpServletRequest.getServletPath()) +
            StringUtil.preparePath(_httpServletRequest.getPathInfo());
        if(StringUtil.isEmpty(path) || "/".equals(path)) {
            return SpecificationUtil.getEngineSetting(
                    WELCOME_FILE_NAME, "/index.html");
        }
        return path;
    }
    
    public Object getUnderlyingObject() {
        return _httpServletRequest;
    }

    public Locale[] getLocales() {
        if(_locales == null) {
            Enumeration locales = _httpServletRequest.getLocales();
            if(locales == null) {
                _locales = new Locale[0];
            } else {
                ArrayList list = new ArrayList(); 
                while(locales.hasMoreElements()) {
                	list.add(locales.nextElement());
                }
                _locales = (Locale[])list.toArray(new Locale[list.size()]);
            }
        }
        return _locales;
    }

    public AttributeScope getParamValues() {
        if(_paramValues == null) {
        	_paramValues = new ParamValuesScope(_httpServletRequest);
        }
        return _paramValues;
    }

    public AttributeScope getHeaderValues() {
        if(_headerValues == null) {
        	_headerValues = new HeaderValuesScope(_httpServletRequest);
        }
        return _headerValues;
    }
    
    public Iterator iterateAttributeNames() {
        return EnumerationIterator.getInstance(
        		_httpServletRequest.getAttributeNames());
    }

    public boolean hasAttribute(String name) {
        if(StringUtil.isEmpty(name)) {
            return false;
        }
        for(Enumeration e = _httpServletRequest.getAttributeNames();
        		e.hasMoreElements(); ) {
			if(e.nextElement().equals(name)) {
				return true;
			}
		}
		return false;
	}

	public Object getAttribute(String name) {
        if(StringUtil.isEmpty(name)) {
            return null;
        }
        return ScriptUtil.convertFromScriptObject(
                _httpServletRequest.getAttribute(name));
    }

    public void setAttribute(String name, Object attribute) {
        if(StringUtil.isEmpty(name)) {
            return;
        }
        _httpServletRequest.setAttribute(name, attribute);
    }
    
    public void removeAttribute(String name) {
        if(StringUtil.isEmpty(name)) {
            return;
        }
        _httpServletRequest.removeAttribute(name);
    }
    
    public void setParameter(String name, String value) {
        throw new UnsupportedParameterException(getClass(), name);
    }

}
