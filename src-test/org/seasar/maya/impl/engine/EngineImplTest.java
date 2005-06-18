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
package org.seasar.maya.impl.engine;

import junit.framework.TestCase;

import org.seasar.maya.impl.provider.EngineSettingImpl;
import org.seasar.maya.impl.provider.factory.SimpleServiceProviderFactory;
import org.seasar.maya.provider.factory.ServiceProviderFactory;

/**
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public class EngineImplTest extends TestCase {
    
	static {
		ServiceProviderFactory.setDefaultFactory(new SimpleServiceProviderFactory());
	}

    private EngineImpl _engine;
    
    public EngineImplTest(String name) {
        super(name);
    }
    
    protected void setUp() {
        _engine = new EngineImpl();
    }
    
    public void testGetRequestedPageInfo() {
        String[] info;
        // �悭����p�^�[��
        EngineSettingImpl setting = new EngineSettingImpl();
        info = _engine.getRequestedPageInfo(setting, "/index.html");
        assertEquals("/index", info[0]);
        assertEquals("", info[1]);
        assertEquals("html", info[2]);
        
        // �ڔ����������I�Ɏw�肳��Ă���p�^�[��
        info = _engine.getRequestedPageInfo(setting, "/index$ja.html");
        assertEquals("/index", info[0]);
        assertEquals("ja", info[1]);
        assertEquals("html", info[2]);

        // �t�H���_�K�w������p�^�[��
        info = _engine.getRequestedPageInfo(setting, "/folder/index.html");
        assertEquals("/folder/index", info[0]);
        assertEquals("", info[1]);
        assertEquals("html", info[2]);
        
        // �g���q���Ȃ��p�^�[��
        info = _engine.getRequestedPageInfo(setting, "/index");
        assertEquals("/index", info[0]);
        assertEquals("", info[1]);
        assertEquals("", info[2]);
        
        // �t�@�C�����̐擪���h�b�g�̃p�^�[��
        info = _engine.getRequestedPageInfo(setting, "/.index");
        assertEquals("/.index", info[0]);
        assertEquals("", info[1]);
        assertEquals("", info[2]);

        // �t�@�C�����̐擪���A���_�[�X�R�A�̃p�^�[��
        info = _engine.getRequestedPageInfo(setting, "/_index.html");
        assertEquals("/_index", info[0]);
        assertEquals("", info[1]);
        assertEquals("html", info[2]);
    }

}
