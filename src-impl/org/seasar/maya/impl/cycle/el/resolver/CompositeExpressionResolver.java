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
package org.seasar.maya.impl.cycle.el.resolver;

import java.util.ArrayList;
import java.util.List;

import org.seasar.maya.cycle.el.resolver.ExpressionChain;
import org.seasar.maya.cycle.el.resolver.ExpressionResolver;

/**
 * ���]���o���܂Ƃ߂ĂЂƂɌ����邽�߂̂��́B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public class CompositeExpressionResolver implements ExpressionResolver {

    private List _resolvers = new ArrayList();
    
    /**
     * ���]���o��ǉ�����B
     * @param resolver �ǉ����������]���o�B
     */
    public void add(ExpressionResolver resolver) {
        if(resolver == null) {
            throw new IllegalArgumentException();
        }
        synchronized(_resolvers) {
            _resolvers.add(resolver);
        }
    }
    
    public Object getValue(Object base, Object property, ExpressionChain chain) {
    	if(property == null || chain == null) {
    		throw new IllegalArgumentException();
    	}
    	if(_resolvers.size() > 0) {
    	    ExpressionChainImpl first = new ExpressionChainImpl(chain);
    	    return first.getValue(base, property);
    	}
    	return chain.getValue(base, property);
    }
    
    public void setValue(Object base, Object property, Object value, ExpressionChain chain) {
    	if(property == null || chain == null) {
    		throw new IllegalArgumentException();
    	}
    	if(_resolvers.size() > 0) {
    	    ExpressionChainImpl first = new ExpressionChainImpl(chain);
    	    first.getValue(base, property);
    	} else {
    	    chain.getValue(base, property);
    	}
    }

    private class ExpressionChainImpl implements ExpressionChain {
    	
    	private int _index;
    	private ExpressionChain _external;
    	
    	public ExpressionChainImpl(ExpressionChain external) {
    		if(external == null) {
    			throw new IllegalArgumentException();
    		}
    		_external = external;
    	}
    	
    	public Object getValue(Object base, Object property) {
    		if(property == null) {
    			throw new IllegalArgumentException();
    		}
            if(_index < _resolvers.size()) {
                ExpressionResolver resolver = (ExpressionResolver)_resolvers.get(_index);
                _index++;
                ExpressionChain chain;
                if(_index == _resolvers.size()) {
                    chain = _external;
                } else {
                    chain = this;
                }
                return resolver.getValue(base, property, chain);
            }
            throw new IndexOutOfBoundsException();
		}
    	
		public void setValue(Object base, Object property, Object value) {
    		if(property == null) {
    			throw new IllegalArgumentException();
    		}
            if(_index < _resolvers.size()) {
                ExpressionResolver resolver = (ExpressionResolver)_resolvers.get(_index);
                _index++;
                ExpressionChain chain;
                if(_index == _resolvers.size()) {
                    chain = _external;
                } else {
                    chain = this;
                }
                resolver.setValue(base, property, value, chain);
            } else {
                throw new IndexOutOfBoundsException();
            }
		}
    }
    
    public void putParameter(String name, String value) {
        throw new UnsupportedOperationException();
    }
    
}
