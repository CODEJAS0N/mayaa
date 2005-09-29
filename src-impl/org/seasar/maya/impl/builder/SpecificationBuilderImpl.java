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
package org.seasar.maya.impl.builder;

import java.io.InputStream;

import org.seasar.maya.builder.SpecificationBuilder;
import org.seasar.maya.engine.specification.Specification;
import org.seasar.maya.impl.CONST_IMPL;
import org.seasar.maya.impl.provider.UnsupportedParameterException;
import org.seasar.maya.impl.util.IOUtil;
import org.seasar.maya.impl.util.ObjectUtil;
import org.seasar.maya.impl.util.xml.XMLReaderPool;
import org.seasar.maya.source.SourceDescriptor;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

/**
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public class SpecificationBuilderImpl
        implements SpecificationBuilder, CONST_IMPL {

    private static final long serialVersionUID = 7852577574830768959L;

    private boolean _outputWhitespace = true;

    protected XMLReaderPool getXMLReaderPool(	String systemID) {
        return XMLReaderPool.getPool();
    }

    protected ContentHandler createContentHandler(
            Specification specification) {
        SpecificationNodeHandler handler =
            new SpecificationNodeHandler(specification);
        handler.setOutputWhitespace(_outputWhitespace);
        return handler;
    }

    protected String getPublicID() {
        return URI_MAYA + "/specification";
    }

    protected void afterBuild(Specification specification) {
    }

    public void build(Specification specification) {
        if(specification == null) {
            throw new IllegalArgumentException();
        }
        SourceDescriptor source = specification.getSource();
        if(source.exists()) {
            ContentHandler handler = createContentHandler(specification);
            XMLReaderPool pool = getXMLReaderPool(source.getSystemID());
            XMLReader xmlReader =
                pool.borrowXMLReader(handler, true, false, false);
            InputStream stream = source.getInputStream();
            InputSource input = new InputSource(stream);
            input.setPublicId(getPublicID());
            input.setSystemId(source.getSystemID());
            try {
                xmlReader.parse(input);
                afterBuild(specification);
            } catch(Throwable t) {
                specification.kill();
                if(t instanceof RuntimeException) {
                    throw (RuntimeException)t;
                }
                throw new RuntimeException(t);
            } finally {
                IOUtil.close(stream);
                pool.returnXMLReader(xmlReader);
            }
        }
    }

    public void setParameter(String name, String value) {
        if("outputWhitespace".equals(name)) {
            _outputWhitespace = ObjectUtil.booleanValue(value, true);
        } else {
            throw new UnsupportedParameterException(getClass(), name);
        }
    }

}
