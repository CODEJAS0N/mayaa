/*
 * Copyright (c) 2004-2005 the Seasar Foundation and the Others.
 *
 * Licensed under the Seasar Software License, v1.1 (aka "the License"); you may
 * not use this file except in compliance with the License which accompanies
 * this distribution, and is available at
 *
 *     http://www.seasar.org/SEASAR-LICENSE.TXT
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.seasar.maya.impl.builder.library.scanner;

import junit.framework.TestCase;

/**
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public class MLDHanderTest extends TestCase {

    public MLDHanderTest(String name) {
        super(name);
    }
    
    public void testCreateDefinitions() {
//        MLDHandler handler = new MLDHandler();
//        AttributesImpl attr = new AttributesImpl(); 
//        attr.addAttribute(null, "uri", "uri", null, "URI_LIBRARY");
//        LibraryDefinitionImpl library = handler.createLibraryDefinition(attr);
//        assertNotNull(library);
//        assertEquals("URI_LIBRARY", library.getNamespaceURI());
//        
//        attr = new AttributesImpl();
//        attr.addAttribute(null, "name", "name", null, "NAME_PROCESSOR");
//        attr.addAttribute(null, "class", "class", null, "org.seasar.maya.engine.processor.TemplateProcessorSupport");
//        ProcessorDefinitionImpl processor = handler.createProcessorDefinition(attr);
//        assertNotNull(processor);
//        assertNotNull(processor.getLibraryDefinition());
//        assertEquals("NAME_PROCESSOR", processor.getName());
//        assertEquals("org.seasar.maya.engine.processor.TemplateProcessorSupport", processor.getClassName());
//        
//        attr = new AttributesImpl();
//        attr.addAttribute(null, "name", "name", null, "NAME_PROPERTY");
//        attr.addAttribute(null, "required", "required", null, "false");
//        attr.addAttribute(null, "expectedType", "expectedType", null, "java.lang.String");
//        attr.addAttribute(null, "defaultValue", "defaultValue", null, "VALUE");
//        PropertyDefinitionImpl property = handler.createPropertyDefinition(attr);
//        assertNotNull(property);
//        assertNotNull(property.getProcessorDefinition());
//        assertEquals("NAME_PROPERTY", property.getName());
//        assertFalse(property.isRequired());
//        assertEquals("java.lang.String", property.getExpectedType());
//        assertEquals("VALUE", property.getDefaultValue());
//                
//        library = handler.getResult();
//        Iterator it = library.iterateProcessorDefinition();
//        ProcessorDefinition resultProc = (ProcessorDefinition)it.next();
//        assertFalse(it.hasNext());
//        it = resultProc.iteratePropertyDefinition();
//        assertNotNull(it.next());
//        assertFalse(it.hasNext());
    }

}
