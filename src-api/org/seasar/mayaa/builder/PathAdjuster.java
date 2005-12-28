/*
 * Copyright 2004-2005 the Seasar Foundation and the Others.
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
package org.seasar.mayaa.builder;

import org.seasar.mayaa.ParameterAware;
import org.seasar.mayaa.engine.specification.QName;

/**
 * HTML�^�O�����̑��΃p�X���΃p�X�ɒu������B
 * @author Koji Suga (Gluegent, Inc.)
 */
public interface PathAdjuster extends ParameterAware {

    /**
     * �u���Ώۂ̑��������^�O�����肷��B
     * @param nodeName �Ώۃ^�O��QName
     * @return �u���Ώۂ̑��������^�O�Ȃ�true
     */
    boolean isTargetNode(QName nodeName);

    /**
     * �u���Ώۂ̑��������肷��B
     * @param nodeName �Ώۃ^�O��QName
     * @param attributeName �Ώۑ�����QName
     * @return �u���Ώۂ̑����Ȃ�true
     */
    boolean isTargetAttribute(QName nodeName, QName attributeName);

    /**
     * ���΃p�X���΃p�X�ɒu������B
     * @param base ���΃p�X�̋N�_(���\�[�X���܂Ŋ܂�)
     * @param path �u���Ώۂ̑��΃p�X
     * @return ���΃p�X�Ȃ��΃p�X�ɒu������
     */
    String adjustRelativePath(String base, String path);

}
