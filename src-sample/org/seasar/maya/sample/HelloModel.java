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
package org.seasar.maya.sample;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Masataka Kurihara (Gluegent, Inc.)
 */
public class HelloModel {
    
    public String getGreeting() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        String greeting = "zzz...";
        if(6 <= hour && hour < 12) {
            greeting = "���͂悤�������܂�";
        } else if(12 <= hour && hour < 18) {
            greeting = "����ɂ���";
        } else if(18 <= hour && hour < 24) {
            greeting = "����΂��";
        }
        return greeting;
    }
    
}
