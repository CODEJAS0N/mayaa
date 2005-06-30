/*
 * Copyright (c) 2004-2005 the Seasar Project and the Others.
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
package org.seasar.maya.impl.util.xml;

import java.util.HashMap;
import java.util.Map;

import org.seasar.maya.impl.util.StringUtil;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.AttributesImpl;

/**
 * @author suga
 */
public class TagHandler {
    
    protected static final AttributesImpl NULL_ATTR = new AttributesImpl();
    private static TagHandler NULL_HANDLER = new TagHandler();
    
    private Map _children = new HashMap();
    private boolean _valid = true;
    private StringBuffer _buffer = new StringBuffer();

    /**
     * �q�m�[�h�̃n���h����o�^����B
     * @param name �q�m�[�h�̖��O�B
     * @param child �q�m�[�h�̃n���h���B
     */
    protected void putHandler(String name, TagHandler child) {
        if(StringUtil.isEmpty(name) || child == null) {
            throw new IllegalArgumentException();
        }
        name = name.toLowerCase();
        _children.put(name, child);
    }

    /**
     * �v�f�̊J�n�ʒm���󂯎��܂��B
     * @param attributes XML��̑����B
     */
    protected void start(Attributes attributes) {
    }
    
    /**
     * �v�f�̏I���ʒm���󂯎��܂��B
     * @param body �{�f�B�e�L�X�g�B
     */
    protected void end(String body) {
    }

    /**
     * �n���h���̏�Ԃ𖳌��ɂ���B
     */
    public void invalidate() {
        _valid = false;
    }

    /**
     * �n���h���̏�Ԃ𒲂ׂ�B
     * @return
     */
    public boolean isValid() {
        return _valid;
    }
    
    // HandlerStack���Ăяo�����B
    public TagHandler startElement(String name, Attributes attributes) {
        if(_valid) {
	        TagHandler child = (TagHandler)_children.get(name.toLowerCase());
	        if(child != null) {
	            child._valid = true;
	            child._buffer.setLength(0);
	            child.start(attributes);
		        return child;
	        }
        }
        return NULL_HANDLER;
    }

    // HandlerStack���Ăяo�����B
    public void endElement() {
        end(_buffer.toString().trim());        
    }

    // HandlerStack���Ăяo�����B
    public void characters(String body) {
        _buffer.append(body);
    }
    
}
