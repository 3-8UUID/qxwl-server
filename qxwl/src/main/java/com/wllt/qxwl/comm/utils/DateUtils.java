/**
 * Copyright &copy; 2012-2016 <a href="https://git.oschina.net/sechot/emergency-handle-center">emergency</a> All rights reserved.
 */
package com.wllt.qxwl.comm.utils;


import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {


    private static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};


    /**
     * 年月日时分秒(无下划线) yyyyMMddHHmmss
     */
    public static final String dtLong = "yyyyMMddHHmmss";
    public static final DateFormat dtLongFormat = new SimpleDateFormat("yyyyMMddHHmmss");

    /**
     * 完整时间 yyyy-MM-dd HH:mm:ss
     */
    public static final String simple = "yyyy-MM-dd HH:mm:ss";
    public static final DateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * 年月日(无下划线) yyyyMMdd
     */
    public static final String dtShort = "yyyy-MM-dd";
    public static final DateFormat dtShortFormat = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 获取当前时间
     * @return  yyyy-MM-dd HH:mm:ss
     */
    public static String getDateTime(){
        return simpleFormat.format(new Date());
    }

    /**
     * fommat: UtilDate.dtLong = "yyyyMMddHHmmss"; UtilDate.simple =
     * "yyyy-MM-dd HH:mm:ss"; UtilDate.dtShort
     * = "yyyyMMdd";
     *
     * @return
     */
    public static String getDate(String format) {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    /**
     * fommat: UtilDate.dtLong = "yyyyMMddHHmmss"; UtilDate.simple =
     * "yyyy-MM-dd HH:mm:ss"; UtilDate.dtShort
     * = "yyyyMMdd";
     *
     * @return
     */
    public static String getDate(Date date, String format) {
        DateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    /**
     * 字符串转换成日期
     *
     * @param str
     * @return date
     */
    public static Date strToDate(String str) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Long convertDateToTimestamp(String time, String format) {

        try {
            DateFormat df = new SimpleDateFormat(format);
            Date date = StringUtils.isEmpty(time) ? new Date() : df.parse(time);
            return date.getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static long getBeginningOfDay(long time) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(time);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);

        return c.getTimeInMillis();
    }

    public static long getBeginningOfMonth(long time) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(time);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);

        return c.getTimeInMillis();
    }

    public static long getEndOfMonth(long time) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(time);
        c.add(Calendar.MONTH, 1);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);

        return c.getTimeInMillis();
    }

    public static long getEndOfDay(long time) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(time);
        c.add(Calendar.DAY_OF_YEAR, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        c.add(Calendar.MILLISECOND, -1);

        return c.getTimeInMillis();
    }

    public static boolean inAMonth(Date start, Date end) {
        Calendar startCal = Calendar.getInstance();
        Calendar endCal = Calendar.getInstance();

        startCal.setTime(start);
        endCal.setTime(end);

        if (startCal.get(Calendar.MONTH) + 1 < endCal.get(Calendar.MONTH))
            return false;

        startCal.add(Calendar.DATE, startCal.getActualMaximum(Calendar.DAY_OF_MONTH));

        if (startCal.before(endCal))
            return false;

        return true;

    }

    /**
     * @param start
     * @param end
     * @return
     */
    public static boolean checkTimeRange(Date start, Date end, int field, int range) {

        Calendar startCal = Calendar.getInstance();
        Calendar endCal = Calendar.getInstance();

        startCal.setTime(start);
        endCal.setTime(end);

        startCal.add(field, range);

        if (startCal.before(endCal))
            return false;

        return true;

    }

    public static boolean inADay(Date start, Date end) {
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(start);
        startCal.add(Calendar.DATE, 1);

        Calendar endCal = Calendar.getInstance();
        endCal.setTime(end);

        if (startCal.before(endCal))
            return false;
        return true;

    }

    /**
     * 根据时间戳获取yyMMdd的整数值
     *
     * @param timeMillis
     * @return
     */
    public static long getYMDByTimeMillis(Long timeMillis) {
        if (null == timeMillis || timeMillis < 1000000000000L) {
            return 0;
        }
        Calendar calendar = Calendar.getInstance();//日历对象
        calendar.setTime(new Date(timeMillis));//设置当前日期
        StringBuilder sb = new StringBuilder();
        String yearStr = calendar.get(Calendar.YEAR) + "";//获取年份
        int month = calendar.get(Calendar.MONTH) + 1;//获取月份
        String monthStr = month < 10 ? "0" + month : month + "";
        int day = calendar.get(Calendar.DATE);//获取日
        String dayStr = day < 10 ? "0" + day : day + "";
        sb.append(yearStr).append(monthStr).append(dayStr);
        return Long.valueOf(sb.toString());
    }

    /**
     * yyMMdd 整形转换成毫秒
     *
     * @param ymd
     * @return
     */
    public static long getTimeMillisByYMD(String ymd) {
        long result = 0L;
        if (StringUtils.isEmpty(ymd)) {
            return result;
        }
        try {
            Date date = dtShortFormat.parse(ymd);
            result = date.getTime();
        } catch (ParseException e) {

        }
        return result;
    }

    public static Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * @param min
     * @return
     */
    public static Timestamp getTimestampOverM(int min) {
        Timestamp tt = new Timestamp(System.currentTimeMillis());
        Calendar cc = Calendar.getInstance();
        cc.setTime(tt);
        cc.add(Calendar.MINUTE, min);
        tt.setTime(cc.getTimeInMillis());
        return tt;
    }

    public static Timestamp getTimestampDetM(int min) {
        Timestamp tt = new Timestamp(System.currentTimeMillis());
        Calendar cc = Calendar.getInstance();
        cc.setTime(tt);
        cc.add(Calendar.MINUTE, -min);
        tt.setTime(cc.getTimeInMillis());
        return tt;
    }

    public static Timestamp getTimestampH(Timestamp timestamp, int hour) {
        Calendar cc = Calendar.getInstance();
        cc.setTime(timestamp);
        cc.add(Calendar.HOUR, hour);
        timestamp.setTime(cc.getTimeInMillis());
        return timestamp;
    }

    /**
     * 获取当前时间后几小时
     *
     * @param hour
     * @return
     */
    public static Timestamp getTimestampOverH(int hour) {
        Timestamp tt = new Timestamp(System.currentTimeMillis());
        getTimestampH(tt, hour);
        return tt;
    }

    /**
     * 当前时间前几小时
     *
     * @param hour
     * @return
     */
    public static Timestamp getTimestampDecH(int hour) {
        Timestamp tt = new Timestamp(System.currentTimeMillis());
        getTimestampH(tt, -hour);
        return tt;
    }

    /**
     * Timestamp时间差计算
     */
    public static String getTimeDifference(Timestamp formatTime1, Timestamp formatTime2) {
        //SimpleDateFormat timeformat = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
        long t1 = formatTime1.getTime();
        long t2 = formatTime2.getTime();
        int hours = (int) ((t1 - t2) / (1000 * 60 * 60));
        int minutes = (int) (((t1 - t2) / 1000 - hours * (60 * 60)) / 60);
        int second = (int) ((t1 - t2) / 1000 - hours * (60 * 60) - minutes * 60);
        return "" + hours + "小时" + minutes + "分" + second + "秒";
    }


    public static String getNowDateTimeWithDateToString() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");//设置日期格式
        String date = df.format(new Date());
        return date;
    }
    /**
     * 获取过去的天数
     *
     * @param date
     * @return
     */
    public static long pastDays(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (24 * 60 * 60 * 1000);
    }

    /**
     * 获取过去的小时
     *
     * @param date
     * @return
     */
    public static long pastHour(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (60 * 60 * 1000);
    }

    /**
     * 获取过去的分钟
     *
     * @param date
     * @return
     */
    public static long pastMinutes(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (60 * 1000);
    }

    /**
     * 获取过去的秒
     *
     * @param date
     * @return
     */
    public static long pastSeconds(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (1000);
    }

    public static long getSecondDif(Date d1, Date d2) {
        return (d1.getTime() - d2.getTime()) / 1000;
    }

    /**
     * 转换为时间（天,时:分:秒.毫秒）
     *
     * @param timeMillis
     * @return
     */
    public static String formatDateTime(long timeMillis) {
        long day = timeMillis / (24 * 60 * 60 * 1000);
        long hour = (timeMillis / (60 * 60 * 1000) - day * 24);
        long min = ((timeMillis / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (timeMillis / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        long sss = (timeMillis - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000 - min * 60 * 1000 - s * 1000);
        return (day > 0 ? day + "," : "") + hour + ":" + min + ":" + s + "." + sss;
    }

    /**
     * 获取两个日期之间的天数
     *
     * @param before
     * @param after
     * @return
     */
    public static double getDistanceOfTwoDate(Date before, Date after) {
        long beforeTime = before.getTime();
        long afterTime = after.getTime();
        return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
    }

}
