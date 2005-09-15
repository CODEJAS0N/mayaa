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
package org.seasar.maya.engine.specification;

import java.util.Date;
import java.util.Iterator;

import org.seasar.maya.source.SourceDescriptor;

/**
 * �X�y�b�N���ɃA�N�Z�X���邽�߂̃C���^�[�t�F�C�X
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface Specification extends NodeTreeWalker {

    /**
     * �ŏI�r���h�����擾����B
     * @return �r���h���B���r���h�̏ꍇnull��Ԃ��B
     */
    Date getTimestamp();

    /**
     * �ݒ�XML�̃\�[�X�ݒ�B
     * @param source �ݒ�XML�\�[�X�B
     */
    void setSource(SourceDescriptor source);
    
	/**
	 * �ݒ�XML�̃\�[�X���擾����B
	 * @return �ݒ�XML�\�[�X�B
	 */
    SourceDescriptor getSource();
    
	/**
	 * �r���h��O�������ɁA��O�⑫�u���b�N�ɂ����Ē��r���[�ȃr���h���ʂ��E���B
	 */
	void kill();

	/**
	 * �e�X�y�b�N�̎擾�B
	 * @return �e�X�y�b�N��������null�B
	 */
    Specification getParentSpecification();

    /**
     * �q�X�y�b�N�̃C�e���[�g�B
     * @return �q�X�y�b�N(Specification)�̃C�e���[�^�B
     */
    Iterator iterateChildSpecification();

    /**
     * �q�X�y�b�N�̒ǉ��B
     * @param child �q�X�y�b�N�B
     */
    void addChildSpecification(Specification child);
    
}
