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
package org.seasar.maya.impl.engine.processor;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

import org.seasar.maya.engine.processor.ProcessorProperty;
import org.seasar.maya.engine.processor.TemplateProcessorSupport;

/**
 * �{�f�B�e�L�X�g�̏o�͂��s���v���Z�b�T�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public class CharactersProcessor extends TemplateProcessorSupport {
    
	private ProcessorProperty _text;
    
    public void setText(ProcessorProperty text) {
        _text = text;
    }
    
    public ProcessorProperty getText() {
    	return _text;
    }
    
    protected Object getExpressed(PageContext context) {
        return _text.getValue(context);
    }
    
    public int doStartProcess(PageContext context) {
    	if(context == null) {
    		throw new IllegalArgumentException();
    	}
        Object value = getExpressed(context);
        if(value != null) {
            Writer out = context.getOut();
	        try {
                out.write(value.toString());
	        } catch(IOException e) {
	        	throw new RuntimeException(e);
	        }
        }
        return Tag.EVAL_BODY_INCLUDE;
    }

}
