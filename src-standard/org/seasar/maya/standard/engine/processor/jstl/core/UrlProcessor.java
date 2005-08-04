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
package org.seasar.maya.standard.engine.processor.jstl.core;

import org.seasar.maya.cycle.ServiceCycle;
import org.seasar.maya.impl.util.StringUtil;
import org.seasar.maya.standard.engine.processor.AttributeValue;
import org.seasar.maya.standard.engine.processor.AttributeValueFactory;

/**
 * @author maruo_syunsuke
 */
public class UrlProcessor extends HasParamsProcessor{
    
    private static final long serialVersionUID = 6419793385551077813L;

    private String _value ;
    private String _var   ;
    private String _scope ;
    
    public void setVar(String var) {
        _var = var;
    }
    
    public void setScope(String scope) {
    	_scope = scope;
    }
    
    public ProcessStatus doEndProcess(ServiceCycle cycle) {
        outPutEncodedString(cycle, getEncodedUrlString(cycle));
        return super.doEndProcess(cycle);
    }
    
    private void outPutEncodedString(ServiceCycle cycle, String encodedString) {
        if( StringUtil.isEmpty( _var ) ){
            cycle.getResponse().write(encodedString);
        } else {
            AttributeValue attributeValue = AttributeValueFactory.create(_var, _scope);
            attributeValue.setValue(cycle, encodedString);
        }
    }
    
	protected String getBaseURL() {
		return _value;
	}
}
