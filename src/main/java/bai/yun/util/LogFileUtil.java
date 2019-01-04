package bai.yun.util;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by hongge on 2017/5/29.
 */

public class LogFileUtil {

    public static String logFileName = "";
    public static boolean isWriteToFile = true;

    public static void write(String content) {
        if (isWriteToFile) {
            write(logFileName, content);
        }
    }

    private static void write(String fileName, String content) {

        if (StringUtils.isEmpty(fileName)) {
            return;
        }

        content = System.currentTimeMillis() + ", " + DateUtil.getCurrentDate() + ", " + content + "\r\n";

        File file = new File(fileName);
        if (!file.getParentFile().exists()) {
            // 父目录不存在，创建父目录
            file.getParentFile().mkdirs();
        }
        if (!file.exists()) {
            // 文件不存在，创建文件
            try {
                boolean newFile = file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileWriter fis = null;
        BufferedWriter bw = null;
        try {
            fis = new FileWriter(file, true);
            bw = new BufferedWriter(fis);
            bw.write(content);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static String read(String fileName) {

        return "";
    }
}