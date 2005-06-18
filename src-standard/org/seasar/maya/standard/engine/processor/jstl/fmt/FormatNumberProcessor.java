/*
 * Copyright (c) 2004-2005 the Seasar Project and the Others.
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
 *
 * Created on 2005/05/04
 */
package org.seasar.maya.standard.engine.processor.jstl.fmt;

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

import org.seasar.maya.engine.processor.ProcessorProperty;
import org.seasar.maya.impl.util.StringUtil;
import org.seasar.maya.standard.CONST_STANDARD;
import org.seasar.maya.standard.engine.processor.AbstractBodyProcessor;

/**
 * JSTL �� fmt:formatNumber �ɂ�����l�C�e�B�u�v���Z�b�T.
 * 
 * @author duran
 *  
 */
public class FormatNumberProcessor extends AbstractBodyProcessor implements
       CONST_STANDARD {

    private static final String NUMBER 	= "number";
    private static final String CURRENCY 	= "currency";
    private static final String PERCENT 	= "percent";
    
    
    private ProcessorProperty 	_typeAttr;
    private ProcessorProperty 	_patternAttr;
    private ProcessorProperty 	_currencyCodeAttr;
    private ProcessorProperty 	_currencySymbolAttr;
    private ProcessorProperty	_groupingUsedAttr;
    private ProcessorProperty 	_maxIntegerDigitsAttr;
    private ProcessorProperty	_minIntegerDigitsAttr;
    private ProcessorProperty 	_maxFractionDigitsAttr;
    private ProcessorProperty 	_minFractionDigitsAttr;

    
    private String 	_type;
    private String 	_pattern;
    private String 	_currencyCode;
    private String 	_currencySymbol;
    private boolean	_groupingUsed = true;
    private int 		_maxIntegerDigits = -1;
    private int		_minIntegerDigits = -1;
    private int 		_maxFractionDigits = -1;
    private int 		_minFractionDigits = -1;

    private String 	_var;
    private int 		_scope;

    private static final String FMT_LOCALE = "javax.servlet.jsp.jstl.fmt.locale";

    private static final Class[] GET_INSTANCE_PARAM_TYPES = new Class[] { String.class };
    private static Class currencyClass;

    static {
        try {
            //J2SE�̃o�[�W������1.4�ȍ~�̏ꍇ
            currencyClass = Class.forName("java.util.Currency");
        } catch (Exception cnfe) {
        }
    }

    public void setValue(ProcessorProperty value) {
    	super.setValue(value);
    }
    
    public void setType(ProcessorProperty type) {
    	_typeAttr = type;
    }
    
    public void setPattern(ProcessorProperty pattern) {
    	_patternAttr = pattern;
    }
    
    public void setCurrencyCode(ProcessorProperty currencyCode) {
    	_currencyCodeAttr = currencyCode;
    }

    public void setCurrencySymbol(ProcessorProperty currencySymbol) {
    	_currencySymbolAttr = currencySymbol;
    }
    
    public void setGroupingUsed(ProcessorProperty groupingUsed) {
    	_groupingUsedAttr = groupingUsed;
    }

    public void setMaxIntegerDigits(ProcessorProperty maxIntegerDigits) {
    	_maxIntegerDigitsAttr = maxIntegerDigits;
    }
    
    public void setMinIntegerDigits(ProcessorProperty minIntegerDigits) {
    	_minIntegerDigitsAttr = minIntegerDigits;
    }
    
    public void setMaxFractionDigits(ProcessorProperty maxFractionDigits) {
    	_maxFractionDigitsAttr = maxFractionDigits;
    }
    
    public void setMinFractionDigits(ProcessorProperty minFractionDigits) {
    	_minFractionDigitsAttr = minFractionDigits;
    }
    
    public void setVar(String var) {
    	_var = var;
    }

    public void setScope(String scope) {
      if (scope != null) {
			ScopeType scopeType = ScopeType.getByName(scope);
			_scope = scopeType.getValue();
		}
    }
    
    private int parseInt(ProcessorProperty prop,PageContext context){
        if(prop != null && context != null){
            Object obj = prop.getValue(context);
            if(obj instanceof Integer){
                return ((Integer)obj).intValue();
            }else if(obj instanceof String){
                return Integer.parseInt((String)obj);
            }
        }
        return -1;
    }
    private String parseString(ProcessorProperty prop,PageContext context){
        if(prop != null && context != null){
            Object obj = prop.getValue(context);
            if(obj instanceof String){
                return (String)obj;
            }
        }
        return null;
    }

    
    private void initParameter(PageContext context){
        _type = parseString(_typeAttr,context);
        _pattern = parseString(_patternAttr,context);
        _currencyCode = parseString(_currencyCodeAttr,context);
        _currencySymbol = parseString(_currencySymbolAttr,context);
        
        if(_groupingUsedAttr != null){
            Object obj = _groupingUsedAttr.getValue(context);
        	if(obj instanceof Boolean){
        	    _groupingUsed = ((Boolean)obj).booleanValue();
        	}else if(obj instanceof String){
        	    _groupingUsed = Boolean.valueOf((String)obj).booleanValue();
        	}
        }else{
            //�f�t�H���g true
            _groupingUsed = true;
        }
        
        _maxIntegerDigits = parseInt(_maxIntegerDigitsAttr,context);
        _minIntegerDigits = parseInt(_minIntegerDigitsAttr,context);
        _maxFractionDigits = parseInt(_maxFractionDigitsAttr,context);
        _minFractionDigits = parseInt(_minFractionDigitsAttr,context);
        
    }
    
    
    protected int process(PageContext context, Object obj) {
        String formatted = null;
        Object input = obj;
        
        initParameter(context);

        if (input instanceof String) {
            
            if(input.equals("")){
                return Tag.EVAL_PAGE;
            }
            
            try {
                if (((String) input).indexOf('.') != -1) {
                    input = Double.valueOf((String) input);
                } else {
                    input = Long.valueOf((String) input);
                }
            } catch (NumberFormatException nfe) {
                throw new IllegalTagAttributeException(getTemplate(),
                		"formatNumber", "value", obj, null);
            }
        } else if(input instanceof Number){
                input = obj;
        } else {
            throw new IllegalTagAttributeException(getTemplate(),
                    "formatNumber", "value", obj, null);
        }

        Locale locale = getLocale(context);

        if (locale != null) {
            // Create formatter
            NumberFormat formatter = null;
            
            
            
            if ((_pattern != null) && !_pattern.equals("")) {
                // if 'pattern' is specified, 'type' is ignored
                DecimalFormatSymbols symbols = new DecimalFormatSymbols(locale);
                formatter = new DecimalFormat(_pattern, symbols);
            } else {
                formatter = createFormatter(locale,context);
            }
            
            
            if (((_pattern != null) && !_pattern.equals(""))
                    || CURRENCY.equalsIgnoreCase(_type)) {
                try {
                    setCurrency(formatter);
                } catch (Exception e) {
                    //TODO
                }
            }
            configureFormatter(formatter, context);
            formatted = formatter.format(input);
        } else {
            // no formatting locale available, use toString()
            formatted = input.toString();
        }

        if (_var != null) {
            context.setAttribute(_var, formatted, _scope);
        } else {
            Writer out = context.getOut();
            try {
                out.write(formatted);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return Tag.EVAL_PAGE;
    }
 
    /**
     * NumberFormat���쐬���܂��B<br>
     * type���Z�b�g����Ă��Ȃ����<br>
     * type�� "number" "currency" "persent"<br>
     * type�̎w�肪�Ȃ���� "number"
     * @param locale
     * @param context
     * @return NumberFormat
     */
    private NumberFormat createFormatter(Locale locale, PageContext context) {

        NumberFormat formatter = null;

        if ((_type == null) || NUMBER.equalsIgnoreCase(_type)) {
            formatter = NumberFormat.getNumberInstance(locale);
        } else if (CURRENCY.equalsIgnoreCase(_type)) {
            formatter = NumberFormat.getCurrencyInstance(locale);
        } else if (PERCENT.equalsIgnoreCase(_type)) {
            formatter = NumberFormat.getPercentInstance(locale);
        } else {
            throw new IllegalTagAttributeException(getTemplate(),
                    "formatNumber", "type", _type, null);
        }

        return formatter;

    }

    /**
     * �t�H�[�}�b�g��ݒ肵�܂��B
     * 
     * @param formatter
     * @param context
     */
    private void configureFormatter(NumberFormat formatter, PageContext context) {
        formatter.setGroupingUsed(_groupingUsed);
        if (_maxIntegerDigits > -1) {
            formatter.setMaximumIntegerDigits(_maxIntegerDigits);
        }
        if (_minIntegerDigits > -1) {
            formatter.setMinimumIntegerDigits(_minIntegerDigits);
                    
        }
        if (_maxFractionDigits > -1) {
            formatter.setMaximumFractionDigits(_maxFractionDigits);
        }
        if (_minFractionDigits > -1) {
            formatter.setMinimumFractionDigits(_minFractionDigits);
        }
    }

    /**
     * Locale ���擾����B �y�[�W�R���e�L�X�g���� FMT_LOCALE ��T���A����΂����Ԃ��B ������΃f�t�H���g Locale ��Ԃ��B
     * 
     * @param context
     *            �]�����̃y�[�W�R���e�L�X�g
     * @return Locale
     */
    protected Locale getLocale(PageContext context) {
        // TODO Localization
        Object locale = context.findAttribute(FMT_LOCALE);

        if (locale instanceof Locale) {
            return (Locale) locale;
        } else if (locale instanceof String) {
            return parseLocale((String) locale);
        } else {
            // TODO Locale �̃f�t�H���g�̌��� (null or getDefault)
            // return null;
            return Locale.getDefault();
        }
    }

    /**
     * Locale��������p�[�X���ALocale�I�u�W�F�N�g��Ԃ��B
     * 
     * @param localeString
     *            Locale������
     * @return LocaleObject
     * @throws IllegalArgumentException
     *             �`���s���̏ꍇ
     */
    protected Locale parseLocale(String localeString) {
        int index = -1;
        String language;
        String country;

        if ((index = localeString.indexOf('-')) >= 0
                || (index = localeString.indexOf('_')) >= 0) {
            language = localeString.substring(0, index);
            country = localeString.substring(index + 1);
        } else {
            language = localeString;
            country = null;
        }

        if (StringUtil.isEmpty(language)
                || (country != null && country.length() == 0)) {
            throw new IllegalArgumentException("invalid Locale: "
                    + localeString);
        }

        if (country == null) {
            country = "";
        }

        return new Locale(language, country);
    }

    /**
     * �ʉݒl��ݒ肵�܂��B <br>
     * J2SE1.4�ȍ~�̏ꍇ��java.util.Currency��p���܂��B <br>
     * 1.4�ȑO�̏ꍇ��DecimalFormatter��p���܂��B
     * 
     * @param formatter
     * @throws Exception
     */
    private void setCurrency(NumberFormat formatter) throws Exception {
        String code = null;
        String symbol = null;

        if ((_currencyCode == null) && (_currencySymbol == null)) {
			return;
		}

		if ((_currencyCode != null) && (_currencySymbol != null)) {
			if (currencyClass != null) {
				code = _currencyCode;
			} else {
				symbol = _currencySymbol;
			}
		} else if (_currencyCode == null) {
			symbol = _currencySymbol;
		} else {
			if (currencyClass != null) {
				code = _currencyCode;
			} else {
				symbol = _currencyCode;
			}
		}

        if (code != null) {
            Object[] methodArgs = new Object[1];

            /*
			 * java.util.Currency.getInstance()
			 */
            Method m = currencyClass.getMethod("getInstance",
                    GET_INSTANCE_PARAM_TYPES);
            methodArgs[0] = code;
            Object currency = m.invoke(null, methodArgs);

            /*
             * java.text.NumberFormat.setCurrency()
             */
            Class[] paramTypes = new Class[1];
            paramTypes[0] = currencyClass;
            Class numberFormatClass = Class.forName("java.text.NumberFormat");
            m = numberFormatClass.getMethod("setCurrency", paramTypes);
            methodArgs[0] = currency;
            m.invoke(formatter, methodArgs);
        } else {
            /*
             * Let potential ClassCastException propagate up (will almost never
             * happen)
             */
            DecimalFormat df = (DecimalFormat) formatter;
            DecimalFormatSymbols dfs = df.getDecimalFormatSymbols();
            dfs.setCurrencySymbol(symbol);
            df.setDecimalFormatSymbols(dfs);
        }
    }

    public void doInitChildProcess(PageContext context) {

    }

    public int doAfterChildProcess(PageContext context) {
        return Tag.SKIP_BODY;
    }

    public boolean isIteration(PageContext context) {
        return true;
    }

    public boolean isChildEvaluation(PageContext context) {
        return true;
    }
}
