/*
 * Copyright 2004-2006 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.seasar.mayaa.engine.specification.serialize;

/**
 * @author Taro Kato (Gluegent, Inc.)
 */
public interface NodeReferenceResolverFinder {

    /**
     * �c���[��ʂɈʒu����V���A���C�Y���̈ˑ��֌W��
     * �������邽�߂́A�m�[�h�Q�ƃ��]���o����������B
     * 
     * @return �m�[�h�Q�ƃ��]���o�B���݂��Ȃ��ꍇ�̓k���B
     */
    NodeReferenceResolver findNodeResolver();
    
}

