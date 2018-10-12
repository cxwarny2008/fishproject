package com.tyb.fish.core;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间帮助类
 *
 * @author garry
 */
public class DateHelper {

    /**
     * 时间转换为字符串
     *
     * @param date
     * @param formart
     * @return
     */
    public static String DateToString(Date date, String formart) {
        if (null == date) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat(formart);
        return formatter.format(date);
    }
}
