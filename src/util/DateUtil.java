package util;

import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author Justyn
 * @version 1.0
 * @date 2021/12/9 19:03
 */
public class DateUtil {
    static final long MILLISECONDS_OF_ONE_DAY = 24 * 60 * 60 * 1000;

    public static java.sql.Date util2sql(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }

    /**
     * 获取当天日期，时分秒都置为零
     */
    public static Date today() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    /**
     * 获取本月第一天
     */
    public static Date monthBegin() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.DATE, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    /**
     * 获取本月最后一天
     */
    public static Date monthEnd() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.DATE, 1);
        c.add(Calendar.MONTH, 1);
        c.add(Calendar.DATE, -1);
        return c.getTime();
    }

    /**
     * 本月一共天数
     */
    public static int thisMonthTotalDay() {
        long startMilli = monthBegin().getTime();
        long endMilli = monthEnd().getTime();
        return (int) ((endMilli - startMilli) / MILLISECONDS_OF_ONE_DAY + 1);
    }

    /**
     * 本月还剩天数（包括今天）
     */
    public static int thisMonthLeftDay() {
        long startMilli = today().getTime();
        long endMilli = monthEnd().getTime();
        return (int) ((endMilli - startMilli) / MILLISECONDS_OF_ONE_DAY + 1);
    }

    /**
     * 本月已过天数（包括今天）
     */
    public static int thisMonthPastDay() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.DATE);
    }


    public static void main(String[] args) {
        System.out.println(thisMonthLeftDay());
    }
}
