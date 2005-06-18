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
package org.seasar.maya.standard.engine.processor.jsp;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

import org.seasar.maya.engine.processor.TemplateProcessor;

/**
 * @author suga
 */
public class TagContext {

    /**
     * �X�e�[�g�t������ێ�����R���e�L�X�g�I�u�W�F�N�g�̎擾���s���B
     * @param context �J�����g�̃e���v���[�g�R���e�L�X�g�B
     * @return �R���e�L�X�g�I�u�W�F�N�g�B
     *          �e���v���[�g�R���e�L�X�g���ɕێ����Ă��Ȃ��Ƃ��ɂ͐�������B
     */
    public static TagContext getTagContext(PageContext context) {
        final String KEY_TAG_CONTEXT = TagContext.class.getName();
        TagContext tagContext = (TagContext)context.getAttribute(KEY_TAG_CONTEXT);
        if(tagContext == null) {
            tagContext = new TagContext();
            context.setAttribute(KEY_TAG_CONTEXT, tagContext);
        }
        return tagContext;
    }

    private Map _tagPoolEntries = new HashMap();
    
    private Map _loadedTagMap = new HashMap();
    private Map _nestedVariableMap = new HashMap();
    private Map _nestedVariableNameMap = new HashMap();

    private TagPoolEntry getEntry(Class tagClass, String attributesKey) {
        synchronized (_tagPoolEntries) {
	        String key = tagClass.getName() + attributesKey;
	        TagPoolEntry entry = (TagPoolEntry)_tagPoolEntries.get(key);
	        if(entry == null) {
                entry = new TagPoolEntry(tagClass);
                _tagPoolEntries.put(key, entry);
            }
	        return entry;
        }
    }
    
    /**
     * �N���X�����w�肵�ăJ�X�^���^�O���擾����B
     * @param tagClassName �J�X�^���^�O�̃N���X���B
     * @param attributesKey �����̑g�ݍ��킹���ʃL�[
     * @return �J�X�^���^�O�̃C���X�^���X�B
     */
    public Tag loadTag(Class tagClass, String attributesKey) {
        TagPoolEntry entry = getEntry(tagClass, attributesKey);
        return entry.request();
    }
    
    /**
     * ���[�h����JSP�J�X�^���^�O��ۑ�����BTemplateProcessor�����N�G�X�g�ɑ΂���
     * �X�e�[�g���X�Ȃ���̂��߂ɁA�X�e�[�g�t����JSP�J�X�^���^�O���R���e�L�X�g��
     * �n���h������K�v������B
     * @param templateProcessor �������s��TemplateProcessor�B
     * @param customTag	�C���W�F�N�g���ꂽJSP�J�X�^���^�O�B
     */
    public void putLoadedTag(TemplateProcessor templateProcessor, Tag customTag) {
        _loadedTagMap.put(templateProcessor, customTag);
    }
    
    /**
     * ���[�h�ς݂�JSP�J�X�^���^�O���擾����B
     * @param templateProcessor �������s��TemplateProcessor�B
     * @return �C���W�F�N�g���ꂽJSP�J�X�^���^�O�B
     */
    public Tag getLoadedTag(TemplateProcessor templateProcessor) {
        return (Tag)_loadedTagMap.get(templateProcessor);
    }

    /**
     * JSP�J�X�^���^�O�l�X�g���Ɉꎞ�Ҕ�����NESTED�ϐ�Map��ۑ�����B
     * @param customTag �C���W�F�N�g���ꂽJSP�J�X�^���^�O�B
     * @param variables �J�X�^���^�O��NESTED�ϐ��̒l�B
     */
    public void putNestedVariables(Tag customTag, Map variables) {
        _nestedVariableMap.put(customTag, variables);
    }

    /**
     * �ꎞ�Ҕ�����JSP�J�X�^���^�O��NESTED�ϐ�Map���擾����B
     * @param customTag �C���W�F�N�g���ꂽJSP�J�X�^���^�O�B
     * @return �J�X�^���^�O��NESTED�ϐ��̒l�B
     */
    public Map getNestedVariables(Tag customTag) {
        return (Map)_nestedVariableMap.get(customTag);
    }

    /**
     * JSP�J�X�^���^�O��NESTED�ϐ�����ۑ�����B
     * @param customTag �C���W�F�N�g���ꂽJSP�J�X�^���^�O�B
     * @param variableNames �J�X�^���^�O�p��NESTED�ϐ���
     */
    public void putNestedVariableNames(Tag customTag, Collection variableNames) {
        _nestedVariableNameMap.put(customTag, variableNames);
    }

    /**
     * JSP�J�X�^���^�O��NESTED�ϐ������擾����B
     * @param customTag �C���W�F�N�g���ꂽJSP�J�X�^���^�O�B
     * @return JSP�J�X�^���^�O�̕ϐ����B
     */
    public Collection getNestedVariableNames(Tag customTag) {
        return (Collection)_nestedVariableNameMap.get(customTag);
    }

    /**
     * �J�X�^���^�O���v�[���ɖ߂�.
     * @param tag �v�[���ɖ߂��J�X�^���^�O
     * @param attributesKey �����̑g�ݍ��킹���ʃL�[
     */
    public void releaseTag(Tag tag, String attributesKey) {
        TagPoolEntry entry = getEntry(tag.getClass(), attributesKey);
        entry.release(tag);
    }
    
}
