package com.example.jiangong.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by zx on 2018/8/8
 */
public class StringUtil {
    public static boolean stringNotNull(String val) {
        boolean flag = false;
        if (val != null && !val.trim().equals("") && !val.trim().equals("null")) {
            flag = true;
        }
        return flag;
    }


//    public static String base64DecodeToString(String data) {
//        return new String(EncodeUtils.base64Decode(data));
//    }

    /**
     * 日期data 转字符串
     *
     * @param date
     * @param format 转化为字符串的格式 "yyyy-MM-dd" 等
     * @return
     */
    public static String getStringByFormat(Date date, String format) {
        SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat(format);
        String strDate = null;
        try {
            strDate = mSimpleDateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strDate;
    }

    /**
     * 字符串转data
     *
     * @param strTime
     * @param formatType
     * @return
     */
    public static Date stringToDate(String strTime, String formatType) {
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
        Date date = null;
        try {
            date = formatter.parse(strTime);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 使用 Map按key进行排序
     *
     * @param map
     * @return 排序后的map键值对 字符串拼接
     */
    public static String getKeyValues(Map<String, Object> map) {
        String str = "";
        if (map == null || map.isEmpty()) {
            return "";
        }

        Map<String, Object> sortMap = new TreeMap<String, Object>(
                new Comparator<String>() {
                    @Override
                    public int compare(String s, String t1) {
                        return s.compareTo(t1);
                    }
                });
        sortMap.putAll(map);
        for (String o : sortMap.keySet()) {
            System.out.println("key=" + o + " value=" + sortMap.get(o));
            str += o + "="+sortMap.get(o);
        }
        return str;
    }

    /**
     * 对插入的字符串进行去重判断 并返回List子集字符串
     *
     * @param list
     * @param content
     * @return "xx,LL" 形式
     */
    public static String getListToString(List<String> list, String content) {
        String str = "";
        if (StringUtil.stringNotNull(content) && !list.contains(content)) {
            list.add(content);
        }
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                str += list.get(i);
            } else {
                str += list.get(i) + ",";
            }

        }
        return str;
    }

    /**
     * list 转数组
     *
     * @param list
     * @return
     */
    public static String[] ListToArray(List<String> list) {
        return (String[]) list.toArray(new String[list.size()]);
    }


}
