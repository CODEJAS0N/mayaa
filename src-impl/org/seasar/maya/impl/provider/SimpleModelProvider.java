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
package org.seasar.maya.impl.provider;

import javax.servlet.jsp.PageContext;

import org.seasar.maya.impl.util.ObjectUtil;
import org.seasar.maya.provider.ModelProvider;

/**
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public class SimpleModelProvider implements ModelProvider {
    
    public SimpleModelProvider() {
    }
    
	public Object getModel(PageContext context, 
    		String modelName, Class modelClass, int modelScope) {
        Object model = context.getAttribute(modelName, modelScope); 
        if(model != null) {
            return model;
        }
        model = ObjectUtil.newInstance(modelClass);
        context.setAttribute(modelName, model, modelScope);
        return model;
	}
	
}

