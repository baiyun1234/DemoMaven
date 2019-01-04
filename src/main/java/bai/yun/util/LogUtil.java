package bai.yun.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * 日志工具类
 * Created by Kevin on 2017/7/29.
 */
public class LogUtil {

    private static Logger logger = LogManager.getLogger(LogUtil.class);
    private static boolean isDebug = true;

    public static void i(Object msg) {
        if (isDebug) {
            logger.info(msg);
            LogFileUtil.write("[i] " + msg.toString());
            System.out.print(msg.toString());
        }
    }

    public static void e(Object msg) {
        if (isDebug) {
            logger.error(msg);
            LogFileUtil.write("[e] " + msg.toString());
        }
    }
}
