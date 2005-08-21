package org.seasar.maya.standard.engine.processor.jstl.fmt;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

import org.seasar.maya.engine.processor.ProcessorProperty;
import org.seasar.maya.impl.util.CycleUtil;
import org.seasar.maya.impl.util.StringUtil;

class FormatUtil {
    private static final String DATE     = "date";
    private static final String TIME     = "time";
    private static final String DATETIME = "both";

    private static final String DEFAULT  = "default";
    private static final String SHORT    = "short";
    private static final String MEDIUM   = "medium";
    private static final String LONG     = "long";
    private static final String FULL     = "full";

    private static final int INVALID_STYLE = Integer.MIN_VALUE;

    private static final String FMT_LOCALE    = "javax.servlet.jsp.jstl.fmt.locale";
    private static final String FMT_TIME_ZONE = "javax.servlet.jsp.jstl.fmt.timeZone";


    static NumberFormat getFormat(Locale locale,String pattern, String type) {
        if( StringUtil.isEmpty(pattern) == false )
            return new DecimalFormat(pattern);
        if("NUMBER".equals(type))
            return NumberFormat.getNumberInstance(locale);
        if("CURRENCY".equals(type))
            return NumberFormat.getCurrencyInstance(locale);
        if("PERCENT".equals(type))
            return NumberFormat.getPercentInstance(locale);        
        return NumberFormat.getInstance(locale);
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
    static Locale parseLocale(String localeString) {
    	return parseLocale(localeString,"");
    }
    static Locale parseLocale(String localeString, String valiant) {
    	if( localeString == null ) 
    		return getLocale();
    	
        int index = -1;
        String language = null ;
        String country  = null ;

        if (( index = localeString.indexOf('-')) >= 0 ||
            ( index = localeString.indexOf('_')) >= 0 ){
            language = localeString.substring(0, index);
            country  = localeString.substring(index+1);
        } else {
            language = localeString;
        }

        if (StringUtil.isEmpty(language)
                || (country != null && country.length() == 0)) {
            throw new IllegalArgumentException("invalid Locale: " + localeString);
        }

        if (country == null) country = "";
        if (valiant == null) valiant = "";

        return new Locale(language, country, valiant);
    }

    
    /**
     * DateFormat ���쐬����B
     * type ���Z�b�g����Ă���Ȃ� type �̕]�����ʂ����ɍ쐬����B 
     * type �� "date", "time", "both" �̂����ꂩ�B
     * type ���Z�b�g����Ă��炸�Apattern ���Z�b�g����Ă���Ȃ�
     *  pattern �̕]�����ʂ����ɍ쐬����B
     * type �� pattern ���Z�b�g����Ă��Ȃ��Ȃ�Atype="date" ���Z�b�g����Ă����
     * ���Ȃ��B
     * @param locale ���� Locale
     * @return DateFormat
     * @throws IllegalTagAttributeException type���s���ȏꍇ
     */
    static DateFormat createFormat(
    		Locale locale, String type, String pattern, String dateStyle, String timeStyle) {
        if (type == null && pattern != null) {
            return new SimpleDateFormat(pattern, locale);
        }

        if ((type == null) || DATE.equalsIgnoreCase(type)) 
            return DateFormat.getDateInstance(getDateStyle(dateStyle), locale);

        if (TIME.equalsIgnoreCase(type)) 
            return DateFormat.getTimeInstance(getTimeStyle(timeStyle), locale);
        
        if (DATETIME.equalsIgnoreCase(type)) 
            return DateFormat.getDateTimeInstance(getDateStyle(dateStyle), getTimeStyle(timeStyle), locale);
        
        throw new IllegalStateException();
    }
    /**
     * ���t�̃t�H�[�}�b�g�X�^�C�����擾����B
     * (DateFormat#getXxxInstance �ŗ��p����萔�l)
     * ����`�̏ꍇ�� DateFormat.DEFAULT ��Ԃ��B
     * @return ���t�̃t�H�[�}�b�g�X�^�C��
     * @throws IllegalTagAttributeException dateStyle���s���ȏꍇ
     */
    static int getDateStyle(String dateStyleString)
            throws IllegalTagAttributeException {
        if (dateStyleString == null) return DateFormat.DEFAULT;

		if (dateStyleString == null || DEFAULT.equalsIgnoreCase(dateStyleString)) 
		    return DateFormat.DEFAULT;
		if (SHORT.equalsIgnoreCase(dateStyleString)) 
		    return DateFormat.SHORT;
		if (MEDIUM.equalsIgnoreCase(dateStyleString)) 
		    return DateFormat.MEDIUM;
		if (LONG.equalsIgnoreCase(dateStyleString)) 
		    return DateFormat.LONG;
		if (FULL.equalsIgnoreCase(dateStyleString)) 
		    return DateFormat.FULL;
	    return INVALID_STYLE;
    }

    /**
     * �����̃t�H�[�}�b�g�X�^�C�����擾����B
     * (DateFormat#getXxxInstance �ŗ��p����萔�l)
     * ����`�̏ꍇ�� DateFormat.DEFAULT ��Ԃ��B
     * @return �����̃t�H�[�}�b�g�X�^�C��
     * @throws IllegalTagAttributeException timeStyle���s���ȏꍇ
     */
    static int getTimeStyle(String timeStyleString)
            throws IllegalTagAttributeException {
        if (timeStyleString == null) return DateFormat.DEFAULT;
		
        if (timeStyleString == null || DEFAULT.equalsIgnoreCase(timeStyleString)) 
		    return DateFormat.DEFAULT;
		if (SHORT.equalsIgnoreCase(timeStyleString)) 
		    return DateFormat.SHORT;
		if (MEDIUM.equalsIgnoreCase(timeStyleString))
		    return DateFormat.MEDIUM;
		if (LONG.equalsIgnoreCase(timeStyleString))
		    return DateFormat.LONG;
		if (FULL.equalsIgnoreCase(timeStyleString))
		    return DateFormat.FULL;

	    return INVALID_STYLE;
    }

    /**
     * timeZone ���Z�b�g����Ă���Ȃ� TimeZone �I�u�W�F�N�g���擾����B
     * timeZone �̕]�����ʂ� TimeZone �I�u�W�F�N�g�Ȃ炻�̂܂ܕԂ��B
     * String �Ȃ� TimeZone �̕�����\���Ƃ��ĕ]�����ĕԂ��B
     * @return TimeZone
     * @throws IllegalTagAttributeException timeZone���s���ȏꍇ
     */
    static TimeZone parseTimeZone(String timeZone) {
        if (StringUtil.isEmpty(timeZone)){
        	return null ;
        }
        return TimeZone.getTimeZone(timeZone);
    }
    static TimeZone getTimeZone(){
    	Object obj = CycleUtil.findAttribute(FMT_TIME_ZONE);
    	if( obj instanceof TimeZone ){
			return (TimeZone)obj;
    	}
    	return null ;
    }
    static void setTimeZone(TimeZone timeZone){
    	CycleUtil.setAttribute(FMT_TIME_ZONE,timeZone);
    }
    static void removeTimeZone(){
    	CycleUtil.removeAttribute(FMT_TIME_ZONE);
    }

    /**
     * Locale ���擾����B
     * �y�[�W�R���e�L�X�g���� FMT_LOCALE ��T���A����΂����Ԃ��B
     * ������΃f�t�H���g Locale ��Ԃ��B
     * @return Locale
     */
    static Locale getLocale() {
        // TODO Localization
        Object locale = CycleUtil.findAttribute(FMT_LOCALE);

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
    static void setLocale(Locale locale){
    	CycleUtil.setAttribute(FMT_LOCALE,locale);
    }
    static void setLocale(Locale locale,String scope){
    	CycleUtil.setAttribute(FMT_LOCALE,locale,scope);
    }

}
