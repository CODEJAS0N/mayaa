/*
 * Copyright (c) 2004-2005 the Seasar Foundation and the Others.
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
package org.seasar.maya.impl.util;

import java.io.File;

import org.cyberneko.html.HTMLEntities;

/**
 * �����񑀍�Ɋւ�郆�[�e�B���e�B
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public final class StringUtil {

    private StringUtil() {
    }

    /**
     * �󔒕����񂩂ǂ����̃e�X�g�B
     * @param test �e�X�g������B
     * @return	null�������̓[��������true�B
     */
    public static boolean isEmpty(String test) {
        return test == null || test.length() == 0;
    }

    /**
     * ������l�����邩�ǂ����̃e�X�g�B
     * @param test �e�X�g������B
     * @return null�������̓[��������false�B
     */
    public static boolean hasValue(String test) {
        return !isEmpty(test);
    }
    
    /**
     * �p�X������̐��`�B�擪�Ɂu/�v�����A�����́u/�v�Ȃ��Ƃ���B
     * @param path ���`�O�p�X������B
     * @return ���`��p�X������B
     */
    public static String preparePath(String path) {
        if(path == null) {
            return "";
        }
        path = path.trim();
        path = path.replace(File.separatorChar, '/');
        if(path.endsWith("/")) {
            path = path.substring(0, path.length() - 1);
        }
        if(path.length() > 0 && !path.startsWith("/")) {
            path = "/" + path;
        }
        return path;
    }

    public static String resolveEntity(String blockString) {
        StringBuffer buffer = new StringBuffer();
        int start = blockString.indexOf("&");
        if(start == -1) {
            return blockString;
        }
        buffer.append(blockString.substring(0, start));
        String entity;
        while(true) {
            int end = blockString.indexOf(";", start);
            if(end == -1) {
                buffer.append(blockString.substring(start));
                break;
            }
            entity = blockString.substring(start + 1, end);
            int value = HTMLEntities.get(entity);
            if(value != -1) {
                buffer.append((char)value);
            } else {
                buffer.append(blockString.substring(start, end + 1));
            }
            start = blockString.indexOf("&", end);
            if(start == -1) {
                buffer.append(blockString.substring(end + 1));
                break;
            }
            if(start != end + 1) {
                buffer.append(blockString.substring(end + 1, start));
            }
            if(start == blockString.length()) {
                break;
            }
        }
        return buffer.toString();
    }
    
    public static String escapeEntity(String blockString) {
        blockString = blockString.replaceAll("&", "&amp;");
        blockString = blockString.replaceAll("<", "&lt;");
        blockString = blockString.replaceAll(">", "&gt;");
        blockString = blockString.replaceAll("\"", "&quot;");
        blockString = blockString.replaceAll("'", "&apos;");
        return blockString;
    }
    
}
