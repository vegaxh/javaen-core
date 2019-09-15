package com.javaen.core.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * <p>
 * Project Name: javaen-core
 * <br>
 * Description: date format class
 * <br>
 * File Name: DateUtils
 * <br>
 * Copyright: Copyright (C) 2019 All Rights Reserved.
 * <br>
 *
 * @author: vegaxh
 * <p>
 * Date                 Author      Version     Description
 * ------------------------------------------------------------------
 * 2019/8/25 10:50     |vegaxh      |v1.0.0       |Create
 */
public class DateUtils {

    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String TIME_PATTERN = "HH:mm:ss";
    public static final String TIME_WITHOUT_SECOND_PATTERN = "HH:mm";
    public static final String DATE_TIME_WITHOUT_SECONDS_PATTERN = "yyyy-MM-dd HH:mm";


    /**
     * @return 获取当前日期
     */
    public static LocalDate getCurrentLocalDate() {
        return LocalDate.now();
    }

    /**
     * @return 返回当前时间
     */
    public static LocalDateTime getCurrentLocalDateTime() {
        return LocalDateTime.now();
    }

    /**
     * @return 返回年
     */
    public static int getYear() {
        return getCurrentLocalDateTime().getYear();
    }

    /**
     * @return 返回月
     */
    public static int getMonth() {
        return getCurrentLocalDateTime().getMonth().getValue();
    }

    /**
     * @return 返回天
     */
    public static int getDayOfMonth() {
        return getCurrentLocalDateTime().getDayOfMonth();
    }

    /**
     * @return 返回当前月共有几天
     */
    public static int getLengthOfMonth() {
        return getCurrentLocalDate().lengthOfMonth();
    }

    public static LocalDate date2LocalDate(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }

        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static Date localDate2Date(LocalDate localDate) {
        if (localDate == null) {
            throw new IllegalArgumentException("The localDate must not be null");
        }

        ZonedDateTime zdt = localDate.atStartOfDay(ZoneId.systemDefault());
        return Date.from(zdt.toInstant());
    }


    public static LocalDateTime date2LocalDateTime(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * @param localDateTime
     * @return localDatetime 转 date
     */
    public static Date localDateTime2Date(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            throw new IllegalArgumentException("The localDateTime must not be null");
        }

        ZonedDateTime zdt = localDateTime.atZone(ZoneId.systemDefault());
        return Date.from(zdt.toInstant());
    }

    /**
     * @param date
     * @param pattern
     * @return 日期格式化字符串
     */
    public static String format(Date date, String pattern) {
        LocalDateTime localDateTime = date2LocalDateTime(date);
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * @param dateStr
     * @param pattern
     * @return 格式化日期
     */
    public static Date parse(String dateStr, String pattern) {
        if (dateStr == null || "".equals(dateStr)) {
            throw new IllegalArgumentException("The dateStr must not be null");
        }
        LocalDateTime localDateTime = LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
        return localDateTime2Date(localDateTime);
    }

    /**
     * @param calendar1
     * @param calendar2
     * @return 返回是否是同一天
     */
    public static boolean isSameDay(Calendar calendar1, Calendar calendar2) {
        if (calendar1 == null || calendar2 == null) {
            throw new IllegalArgumentException("The calendar must not be null");
        }

        return isSameDay(calendar1.getTime(), calendar2.getTime());
    }

    /**
     * @param date1
     * @param date2
     * @return 返回是否是同一天
     */
    public static boolean isSameDay(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }

        return date2LocalDate(date1).equals(date2LocalDate(date2)) ? Boolean.TRUE : Boolean.FALSE;
    }

    public static Date addYears(Date date, int years) {
        return add(date, ChronoUnit.YEARS, years);
    }

    public static Date addMonths(Date date, int months) {
        return add(date, ChronoUnit.MONTHS, months);
    }

    public static Date addWeeks(Date date, int weeks) {
        return add(date, ChronoUnit.WEEKS, weeks);
    }

    public static Date addDays(Date date, int days) {
        return add(date, ChronoUnit.DAYS, days);
    }

    public static Date addHours(Date date, int hours) {
        return add(date, ChronoUnit.HOURS, hours);
    }

    public static Date addMinutes(Date date, int minutes) {
        return add(date, ChronoUnit.MINUTES, minutes);
    }

    public static Date addSeconds(Date date, int seconds) {
        return add(date, ChronoUnit.SECONDS, seconds);
    }

    public static Date addMillis(Date date, int millis) {
        return add(date, ChronoUnit.MILLIS, millis);
    }

    public static Date addNanos(Date date, int nanos) {
        return add(date, ChronoUnit.NANOS, nanos);
    }

    private static Date add(Date date, ChronoUnit unit, int amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }

        LocalDateTime localDateTime = date2LocalDateTime(date);
        return localDateTime2Date(localDateTime.plus(amount, unit));
    }


    /**
     * @param date1
     * @param date2
     * @return 相差几秒
     */
    public static long durationSeconds(Date date1, Date date2) {
        return duration(date1, date2, ChronoUnit.SECONDS);
    }

    /**
     * @param date1
     * @param date2
     * @return 相差几分钟
     */
    public static long durationMinutes(Date date1, Date date2) {
        return duration(date1, date2, ChronoUnit.MINUTES);
    }

    /**
     * @param date1
     * @param date2
     * @return 相差几个小时
     */
    public static long durationHours(Date date1, Date date2) {
        return duration(date1, date2, ChronoUnit.HOURS);
    }

    /**
     * @param date1
     * @param date2
     * @return 相差几天
     */
    public static long durationDays(Date date1, Date date2) {
        return duration(date1, date2, ChronoUnit.DAYS);
    }

    /**
     * @param date1
     * @param date2
     * @return 相差几个月
     */
    public static long durationMonths(Date date1, Date date2) {
        return duration(date1, date2, ChronoUnit.MONTHS);
    }

    /**
     * @param date1
     * @param date2
     * @return 相差几年
     */
    public static long durationYears(Date date1, Date date2) {
        return duration(date1, date2, ChronoUnit.YEARS);
    }

    private static long duration(Date date1, Date date2, ChronoUnit chronoUnit) {
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }

        LocalDate localDate1 = date2LocalDate(date1);
        LocalDate localDate2 = date2LocalDate(date2);
        return localDate2.until(localDate1, chronoUnit);
    }

    /**
     * @return 返回当天的起始时间
     */
    public static Date getStartTime() {
        LocalDateTime localDateTime = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0);
        return localDateTime2Date(localDateTime);
    }

    /**
     * @return 返回当天的结束时间
     */
    public static Date getEndTime() {
        LocalDateTime localDateTime = LocalDateTime.now().withHour(23).withMinute(59).withSecond(59).withNano(999);
        return localDateTime2Date(localDateTime);
    }


    public static void main(String[] args) {
        System.out.println(LocalDateTime.now().getMonth().getValue());
    }
}
