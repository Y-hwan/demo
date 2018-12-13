//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.demo.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

public class DateHelper {
    private static final String msDateFormat = "yyyy-MM-dd HH:mm:ss.SSS";
    private static final String dateFormat = "yyyy-MM-dd HH:mm:ss";
    private static final String shortDateFormat = "yyyy-MM-dd";
    private static final String msDateUTCFormat = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    private static final String dateUTCFormat = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    private static final String msDateFormat2 = "yyyy/MM/dd HH:mm:ss.SSS";
    private static final String dateFormat2 = "yyyy/MM/dd HH:mm:ss";
    private static final String shortDateFormat2 = "yyyy/MM/dd";

    public DateHelper() {
    }

    public static String generateCalendarDirectory() {
        Calendar calendar = new GregorianCalendar();
        int year = calendar.get(1);
        int month = calendar.get(2) + 1;
        int day = calendar.get(5);
        StringBuilder sb = new StringBuilder();
        sb.append(year).append('/').append(month).append('/').append(day).append('/');
        return sb.toString();
    }

    public static String dateToString(Date d, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        String s = simpleDateFormat.format(d);
        return s;
    }

    public static Date stringToDate(String s, String format) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            Date d = simpleDateFormat.parse(s);
            return d;
        } catch (Exception var4) {
            throw new RuntimeException(var4.getMessage(), var4);
        }
    }

    public static boolean dateAfterDateDays(Date afterDate, Date beforeDate, int days) {
        Date truncatedAfterDate = DateUtils.truncate(afterDate, 5);
        Date truncatedBeforeDate = DateUtils.truncate(beforeDate, 5);
        Date tempTruncatedAfterDate = DateUtils.addDays(truncatedAfterDate, 0 - days);
        return tempTruncatedAfterDate.after(truncatedBeforeDate);
    }

    public static boolean dateBeforeDateDays(Date afterDate, Date beforeDate, int days) {
        Date truncatedAfterDate = DateUtils.truncate(afterDate, 5);
        Date truncatedBeforeDate = DateUtils.truncate(beforeDate, 5);
        Date tempTruncatedAfterDate = DateUtils.addDays(truncatedAfterDate, 0 - days);
        return tempTruncatedAfterDate.before(truncatedBeforeDate);
    }

    public static Date smartConvert(String source) {
        if (StringUtils.isBlank(source)) {
            return null;
        } else {
            source = source.trim();

            try {
                SimpleDateFormat formatter = null;
                Date dtDate;
                if (source.contains("-")) {
                    if (source.contains(".")) {
                        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                    } else if (source.contains(":")) {
                        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    } else {
                        formatter = new SimpleDateFormat("yyyy-MM-dd");
                    }

                    dtDate = formatter.parse(source);
                    return dtDate;
                }

                if (source.contains("/")) {
                    if (source.contains(".")) {
                        formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
                    } else if (source.contains(":")) {
                        formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    } else {
                        formatter = new SimpleDateFormat("yyyy/MM/dd");
                    }

                    dtDate = formatter.parse(source);
                    return dtDate;
                }
            } catch (Exception var3) {
                throw new RuntimeException(String.format("parser %s to Date fail", source));
            }

            throw new RuntimeException(String.format("parser %s to Date fail", source));
        }
    }

    public static String getCurrentTime() {
        Date NowDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(NowDate);
    }

    public static String getCurrentTime(String format) {
        Date NowDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(NowDate);
    }

    public static String getOneHourAgoTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, calendar.get(11) - 1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(calendar.getTime());
    }

    public static boolean beforeCurrentDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.before(Calendar.getInstance());
    }

    public static String addTimeToCurrentDate(int minute, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar nowTime = Calendar.getInstance();
        System.out.println(sdf.format(nowTime.getTime()));
        nowTime.add(12, minute);
        return sdf.format(nowTime.getTime());
    }

    public static int getIntervalMinutes(Date beginDate, Date endDate) {
        long between = (endDate.getTime() - beginDate.getTime()) / 1000L;
        long min = between / 60L;
        return (int)min;
    }

    public static int getIntervalSeconds(String beginTime, String endTime) {
        Date beginDate = stringToDate(beginTime, "yyyy-MM-dd HH:mm:ss");
        Date endDate = stringToDate(endTime, "yyyy-MM-dd HH:mm:ss");
        long between = (endDate.getTime() - beginDate.getTime()) / 1000L;
        return (int)Math.abs(between);
    }

    public static String utcTime2BeijingTime(String utcMsTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String str = "";

        try {
            Date date = sdf.parse(utcMsTime);
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(10, 8);
            Date newDate = c.getTime();
            str = sdf2.format(newDate);
        } catch (Exception var7) {
            ;
        }

        return str;
    }

    public static Date addTimeToCurrentDate(int seconds) {
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(13, seconds);
        return nowTime.getTime();
    }

    public static void main(String[] args) {
        int inteval = 2592000;
        Date d1 = addTimeToCurrentDate(inteval);
        Date d2 = addTimeToCurrentDate(-1 * inteval);
        System.out.println(d1);
        System.out.println(d2);
        String utcMsTime = "2018-09-18T07:44:36.000Z";
        String beijingMsTime = utcTime2BeijingTime(utcMsTime);
        System.out.println(utcMsTime);
        System.out.println(beijingMsTime);
        System.out.println(addTimeToCurrentDate(45, "yyyyMMddHHmmss"));
        System.out.println(getCurrentTime("yyyyMMddHHmmss"));
    }
}
