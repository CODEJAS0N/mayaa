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
package org.seasar.mayaa;

import java.io.Serializable;

/**
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public interface PositionAware extends Serializable {

    /**
     * �\�[�X��SystemID��ݒ肷��B
     * @param systemID �\�[�XSystemID�B
     */
    void setSystemID(String systemID);

    /**
     * �\�[�X��SystemID���擾����B
     * @return �\�[�XSystemID�B
     */
    String getSystemID();

    /**
     * �\�[�X��̍s�ʒu��ݒ肷��B
     * @param lineNumber �ʒu���B
     */
    void setLineNumber(int lineNumber);

    /**
     * �\�[�X��̍s�ʒu���擾����B
     * @return �ʒu���B
     */
    int getLineNumber();

    /**
     * �\�[�X���e���v���[�g����ݒ肷��B
     * @param onTemplate �\�[�X���e���v���[�g���B
     */
    void setOnTemplate(boolean onTemplate);

    /**
     * �\�[�X���e���v���[�g�����擾����B
     * @return �\�[�X���e���v���[�g���B
     */
    boolean isOnTemplate();

}
