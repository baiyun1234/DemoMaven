package bai.yun.util;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by Kevin on 2017/7/29.
 */
public class DateUtil {

    /**
     * 返回当前时间
     * - 格式为"yyyyMMddHHmmss"
     */
    public static String getCurrentDate() {
        return new SimpleDateFormat("yyyyMMddHHmmssSSS",Locale.getDefault()).format(System.currentTimeMillis());
    }

    /**
     * 返回当前时间
     * - 格式为"yyyy-MM-dd HH:mm:ss:SSS"
     */
    public static String getCurrentDate(long time) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS",Locale.getDefault()).format(time);
    }
}
