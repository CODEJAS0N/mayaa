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
package org.seasar.mayaa.impl;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.seasar.mayaa.impl.cycle.CycleUtil;

/**
 * Struts�Ȃ�Mayaa�ȊO�Ƒg�ݍ��킹���ŕK���K�v�ƂȂ�B
 * Mayaa��forward�����\���̂��郊�N�G�X�g�͑S��
 * ���̃t�B���^����Ȃ��ƂȂ�Ȃ��B
 * ����āA*.do �Ȃǂɂ��ݒ肷��K�v������B
 * @author Taro Kato (Gluegent, Inc.)
 */
public class MayaaApplicationFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        // no operation
    }

    public void destroy() {
        // no operation
    }

    public void doFilter(ServletRequest request, ServletResponse response, 
            FilterChain chain) throws IOException, ServletException {
        CycleUtil.initialize(request, response);
        chain.doFilter(request, response);
    }

}
