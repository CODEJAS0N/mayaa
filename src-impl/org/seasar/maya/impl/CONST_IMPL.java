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
package org.seasar.maya.impl;

import org.seasar.maya.engine.specification.QName;

/**
 * �����ŕK�v�Ȓ萔�̒�`�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface CONST_IMPL {
    
    String KEY_ENGINE = "engine";
    String KEY_PAGE = "page";
    String KEY_TEMPLATE = "template";
    
    /**
     * �f�t�H���g��Maya URI�̃v���t�B�b�N�X�B
     */
    String PREFIX_MAYA = "m";
    
    /**
	 * �e���v���[�g��ݒ�XML�ɋL�q����G���W���̎d�l�����ꂽ���O���URI�B
	 */
    String URI_MAYA = "http://www.seasar.org/maya";

    /**
     * �e���v���[�g�ŋL�q���ȗ����ꂽ�m�[�h�̖��O��ԂƂȂ�HTML��URI�B
     */
    String URI_HTML = "http://www.w3.org/TR/html4";

    /**
     * XHTML�̖��O���URI
     */
    String URI_XHTML = "http://www.w3.org/1999/xhtml";

    /**
     * �e���v���[�g�ɋL�q����A�m�[�h���ʑ����B 
     */
    String ATTR_ID = "id";
    
    /**
	  * �e���v���[�g�ɋL�q����A�^�O�C���W�F�N�V�����̎w�葮���B
	  */
    String ATTR_INJECT = "inject";

    String PUBLIC_MLD10 = "-//The Seasar Project//DTD Maya Library Definition 1.0//EN";
    String PUBLIC_CONF10 = "-//The Seasar Project//DTD Maya Config 1.0//EN";
    
    String PROTOCOL_JAVA = "java";
    String PROTOCOL_PAGE = "page";
    String PROTOCOL_META_INF = "meta-inf";
    String PROTOCOL_CONTEXT = "context";
    String PROTOCOL_WEB_INF = "web-inf";
    
    String PREFIX_PAGE = PROTOCOL_PAGE + ":";
    String PREFIX_CONTEXT = PROTOCOL_CONTEXT + ":";
    String PREFIX_WEB_INF = PROTOCOL_WEB_INF + ":";
    
    /*
     * Known QName
     */
    QName QH_HTML = new QName(URI_HTML, "html");
    QName QH_META = new QName(URI_HTML, "meta");
    QName QH_ID = new QName(URI_HTML, ATTR_ID);
    QName QH_CONTENT = new QName(URI_HTML, "content");
    QName QH_HTTP_EQUIV = new QName(URI_HTML, "http-equiv");    
    
    QName QX_HTML = new QName(URI_XHTML, "html");
    QName QX_META = new QName(URI_XHTML, "meta");
    QName QX_ID = new QName(URI_XHTML, ATTR_ID);
    QName QX_CONTENT = new QName(URI_XHTML, "content");
    QName QX_HTTP_EQUIV = new QName(URI_XHTML, "http-equiv");    

    QName QM_ENGINE = new QName(KEY_ENGINE);
	QName QM_PAGE = new QName(KEY_PAGE);
	QName QM_TEMPLATE = new QName(KEY_TEMPLATE);
    
	QName QM_MAYA = new QName("maya");
	QName QM_CONTENT_TYPE = new QName("contentType");
    QName QM_INJECT = new QName(ATTR_INJECT);
    QName QM_ID = new QName("id");
    QName QM_XPATH = new QName("xpath");
    QName QM_RENDERED = new QName("rendered");
    QName QM_ELEMENT = new QName("element");
    QName QM_Q_NAME = new QName("qName");
    QName QM_NAMESPACE_URI = new QName("namespaceURI");
    QName QM_LOCAL_NAME = new QName("localName");
    QName QM_VALUE = new QName("value");
    QName QM_TEMPLATE_ELEMENT = new QName("templateElement");
    QName QM_DUPLECATED_ELEMENT = new QName("duplecatedElement");
    QName QM_ATTRIBUTE = new QName("attribute");
    QName QM_CHARACTERS = new QName("characters");
    QName QM_TEXT = new QName("text");    
    QName QM_PROCESSING_INSTRUCTION = new QName("processingInstruction");
    QName QM_TARGET = new QName("target");
    QName QM_DATA = new QName("data");
    QName QM_COMMENT = new QName("comment");
    QName QM_CDATA = new QName("cdata");
    QName QM_DOCTYPE = new QName("doctype");
    QName QM_PUBLIC_ID = new QName("publicID");
    QName QM_SYSTEM_ID = new QName("systemID");

    QName QM_IGNORE = new QName("ignore");
    
	QName QM_BEFORE_RENDER = new QName("beforeRender");
	QName QM_AFTER_RENDER = new QName("afterRender");

    QName QM_NAME = new QName("name");
    QName QM_CLASS = new QName("class");
    QName QM_SCOPE = new QName("scope");

    QName QM_TEMPLATE_SUFFIX = new QName("templateSuffix");

    QName QM_DO_BODY = new QName("doBody");

}
