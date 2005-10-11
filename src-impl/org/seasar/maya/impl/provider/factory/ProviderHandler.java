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
package org.seasar.maya.impl.provider.factory;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.seasar.maya.impl.CONST_IMPL;
import org.seasar.maya.impl.source.ClassLoaderSourceDescriptor;
import org.seasar.maya.impl.util.xml.TagHandlerStack;
import org.seasar.maya.provider.ServiceProvider;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author Masataka Kurihara (Gluegent, Inc.)
 * TODO util�ɋ��ʉ�
 */
public class ProviderHandler extends DefaultHandler
        implements CONST_IMPL {

    private static Log LOG = LogFactory.getLog(ProviderHandler.class); 
    
    private TagHandlerStack _stack;
    private Locator _locator;
    
    public ServiceProvider getResult() {
        return ((ServiceTagHandler)_stack.getRoot()).getServiceProvider();
    }
    
    public ProviderHandler(
            ServletContext context, ServiceProvider unmarshall) {
        if(context == null) {
            throw new IllegalArgumentException();
        }
        ServiceTagHandler handler = new ServiceTagHandler(unmarshall);
        _stack = new TagHandlerStack(handler);
    }
    
	public InputSource resolveEntity(String publicId, String systemId) {
        if(PUBLIC_PROVIDER10.equals(publicId)) {
            ClassLoaderSourceDescriptor source = 
            	new ClassLoaderSourceDescriptor();
            source.setSystemID("maya-provider_1_0.dtd");
            source.setNeighborClass(ProviderHandler.class);
            if(source.exists()) {
                return new InputSource(source.getInputStream());
            }
        }
        return null;
    }
    
	public void setDocumentLocator(Locator locator) {
		_locator = locator;
	}

	protected String getSystemID() {
		if(_locator != null) {
			return _locator.getSystemId();
		}
		return null;
	}

	protected int getLineNumber() {
		if(_locator != null) {
			return _locator.getLineNumber();
		}
		return 0;
	}

    public void startElement(String namespaceURI, 
            String localName, String qName, Attributes attributes) {
        _stack.startElement(
        		localName, attributes, getSystemID(), getLineNumber());
    }
    
    public void endElement(
    		String namespaceURI, String localName, String qName) {
        _stack.endElement();
    }

    public void fatalError(SAXParseException e) {
        error(e);
    }

    public void error(SAXParseException e) {
        throw new RuntimeException(e);
    }
    
    public void warning(SAXParseException e) {
        if(LOG.isWarnEnabled()) {
            LOG.warn(e.getMessage(), e);
        }
    }
    
}
