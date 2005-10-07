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
package org.seasar.maya.impl.builder.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.seasar.maya.builder.library.LibraryDefinition;
import org.seasar.maya.builder.library.ProcessorDefinition;
import org.seasar.maya.builder.library.PropertySet;
import org.seasar.maya.builder.library.converter.PropertyConverter;
import org.seasar.maya.impl.provider.UnsupportedParameterException;
import org.seasar.maya.impl.util.StringUtil;
import org.seasar.maya.impl.util.collection.NullIterator;

/**
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public class LibraryDefinitionImpl implements LibraryDefinition {

    private String _namespaceURI;
    private List _assignedURI = new ArrayList();
    private Map _converters;
    private Map _propertySets;
    private Map _processors;
    private String _systemID;
    
    public void setSystemID(String systemID) {
    	if(StringUtil.isEmpty(systemID)) {
    		throw new IllegalArgumentException();
    	}
    	_systemID = systemID;
    }
    
    public String getSystemID() {
		return _systemID;
	}

	public void setNamespaceURI(String namespaceURI) {
        if(StringUtil.isEmpty(namespaceURI)) {
            throw new IllegalArgumentException();
        }
        _namespaceURI = namespaceURI;
    }
    
    public String getNamespaceURI() {
        return _namespaceURI;
    }
    
    public void addAssignedURI(String assignedURI) {
        if(StringUtil.isEmpty(assignedURI)) {
            throw new IllegalArgumentException();
        }
        if(assignedURI.equals(_namespaceURI) == false && 
                _assignedURI.contains(assignedURI) == false) {
            _assignedURI.add(assignedURI);
        }
    }
    
    public Iterator iterateAssignedURI() {
        return _assignedURI.iterator();
    }

    public void addPropertyConverter(
    		String name, PropertyConverter converter) {
    	if(converter == null) {
    		throw new IllegalArgumentException();
    	}
    	if(StringUtil.isEmpty(name)) {
    		name = converter.getPropetyType().getName();
    	}
    	if(_converters == null) {
    		_converters = new HashMap();
    	}
        if(_converters.containsKey(name)) {
            //TODO �x���B
        } else {
            _converters.put(name, converter);
        }
    }
    
    public PropertyConverter getPropertyConverter(Class propertyType) {
    	if(propertyType == null) {
    		throw new IllegalArgumentException();
    	}
        if(_converters == null) {
            return null;
        }
    	for(Iterator it = _converters.values().iterator(); it.hasNext(); ) {
    		PropertyConverter converter = (PropertyConverter)it.next();
    		if(propertyType.equals(converter.getPropetyType())) {
    			return converter;
    		}
    	}
    	return null;
	}

	public PropertyConverter getPropertyConverter(String converterName) {
		if(StringUtil.isEmpty(converterName)) {
			throw new IllegalArgumentException();
		}
		return (PropertyConverter)_converters.get(converterName);
	}

	public Iterator iteratePropertyConverters() {
		if(_converters == null) {
			return NullIterator.getInstance();
		}
		return _converters.values().iterator();
	}

	public void addPropertySet(PropertySet propertySet) {
        if(propertySet == null) {
            throw new IllegalArgumentException();
        }
        String name = propertySet.getName();
        if(_propertySets == null) {
            _propertySets = new HashMap();
        }
        if(_propertySets.containsKey(name)) {
            //TODO �x���B
        } else {
            _propertySets.put(name, propertySet);
        }
    }

    public Iterator iteratePropertySets() {
        if(_propertySets == null) {
            return NullIterator.getInstance();
        }
        return _propertySets.values().iterator();
    }
    
    public PropertySet getPropertySet(String name) {
        if(StringUtil.isEmpty(name)) {
            throw new IllegalArgumentException();
        }
        if(_propertySets == null) {
            return null;
        }
        return (PropertySet)_propertySets.get(name);
    }

    public void addProcessorDefinition(ProcessorDefinition processor) {
        if(processor == null) {
            throw new IllegalArgumentException();
        }
        String name = processor.getName();
        if(_processors == null) {
            _processors = new HashMap();
        }
        if(_processors.containsKey(name)) {
            //TODO �x���B
        } else {
            _processors.put(name, processor);
        }
    }
    
    public Iterator iterateProcessorDefinitions() {
        if(_processors == null) {
            return NullIterator.getInstance();
        }
        return _processors.values().iterator();
    }
    
    public ProcessorDefinition getProcessorDefinition(String name) {
        if(StringUtil.isEmpty(name)) {
            throw new IllegalArgumentException();
        }
        if(_processors == null) {
            return null;
        }
        return (ProcessorDefinition)_processors.get(name);
    }

    // Parameterizable implements ------------------------------------
    
	public void setParameter(String name, String value) {
		throw new UnsupportedParameterException(getClass(), name);
	}

}
