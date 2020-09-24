package com.toad.java.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/***
 * 字符串工具类
 */
public class TGStringUtils {

    /***
     * 判断字符串是否为空或空字符串
     * @param str 字符串
     * @return 空或空字符串
     */
    public static boolean isNullOrEmpty(String str){
        boolean result = true;
        if (null != str && str.length() > 0 && str.trim().length() > 0 ) {
            result = false;
        }
        else {
        }
        return result;
    }

    /***
     * 默认字符串字
     */
    final static public String defauleStrValue = "";
    /***
     * 默认整数值
     */
    final static public int defauleIntValue = 0;
    /***
     * 默认布尔值
     */
    final static public boolean defauleBooleanValue = false;
    /***
     * 默认时间格式
     */
    final static public String defauleDataFormat = "yyyy-MM-DD HH:SS";

    /***
     * 获取时间
     * @param str 入力字符串
     * @param pattern 格式
     * @param defValue 默认值
     * @return 转换后时间
     */
    public static Date dateValue(String str, String pattern, Date defValue){
        if (isNullOrEmpty(str)) {
            return defValue;
        }
        java.util.Date result = null;

        try {
            SimpleDateFormat dateFormat =new SimpleDateFormat(pattern);
            result = dateFormat.parse(str);
        }
        catch (ParseException exc){
            result = defValue;
        }
        catch (Exception exc){
            result = defValue;
        }
        return result;
    }

    /***
     * 获取时间
     * @param str 入力字符串
     * @param pattern 格式
     * @return 转换后时间 默认值为 Date()
     */
    public static Date dateValue(String str,String pattern){
        return dateValue(str, pattern, new Date());
    }

    /***
     * 获取时间
     * @param str 入力字符串
     * @return 转换后时间 默认值为 Date()
     */
    public static Date dateValue(String str){
        return dateValue(str, defauleDataFormat, new Date());
    }

    /***
     * 转字符串
     * @param obj 参数
     * @param defValue 默认字符串
     * @return 转换后
     */
    public static String stringValue(Object obj, String defValue){
        if (null == obj) {
            return defValue;
        }
        else if (obj instanceof String) {
            return (String)obj;
        }
        else if (obj instanceof Object) {
            String result = null;
            try {
                result = obj.toString();
            }
            catch (Exception exc) {
                result = defValue;
            }
            return result;
        }
        return defValue;
    }
    /***
     * 转字符串
     * @param obj 参数
     * @auth
     * @return 转换后
     */
    public static String stringValue(Object obj){
        return stringValue(obj, defauleStrValue);
    }

    public static int intValue(String str, int defValue){
        int result = defValue;

        if (isNullOrEmpty(str)) {

        }
        else {
            try {
                result = Integer.parseInt(str);
            }
            catch (NumberFormatException e) {
                result = defValue;
            }
            catch (Exception exc){
                result = defValue;
            }
        }
        return result;
    }
    public static int intValue(String str){
        return intValue(str, defauleIntValue);
    }

    public static boolean booleanValue(String str, boolean defValue){
        boolean result = defValue;
        if (isNullOrEmpty(str)) {

        }
        else {
            try {
                result = Boolean.parseBoolean(str);
            }
            catch (NumberFormatException e) {
                result = defValue;
            }
            catch (Exception exc){
                result = defValue;
            }
        }
        return result;
    }
    public static boolean booleanValue(String str){
        return booleanValue(str, defauleBooleanValue);
    }


    public static String base64Decode(String str) {
        String result = str;
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] temp = decoder.decodeBuffer(str);
            result = new String(temp);
        } catch (Exception e) {
        }
        return result;
    }
    public static String base64Encode(String str) {
        String result = "";
        BASE64Encoder encoder = new BASE64Encoder();
        result = encoder.encodeBuffer(str.getBytes()).replaceAll("(\\r\\n|\\n|\\n\\r)", "");
        return result;
    }

}
