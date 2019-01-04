package bai.yun.util;

import com.google.common.base.Function;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

/**
 * 等待机制工具类
 * 测试
 * Created by Kevin on 2017/7/29.
 */
public class WaitUtil {

    /**
     * 等待超时时间
     * - 单位 s(秒)，如果超过该时间仍然没有等到期待的结果，就会抛出异常
     * org.openqa.selenium.TimeoutException: Expected condition failed
     */
    public static final int WAIT_TIMEOUT = 30;
    /**
     * 轮训间隔时间
     * - 每隔该时间，就会取当前值和期待值进行比较
     */
    public static final int POLLING_INTERVAL_TIME = 2;

    /**
     * 等待机制，可以查看
     * { FluentWait#until(java.util.function.Function)}
     * 在FluentWait的until的方法中可以看到一个死循环，一直在调用传入的Function的apply方法，
     * 一直到apply()方法返回值不是Boolean类型并且不会null，或者为Boolean类型但是为true。
     */
    public static Wait<AndroidDriver<AndroidElement>> wait;

    public static void init(AndroidDriver driver) {
        wait = new FluentWait<AndroidDriver<AndroidElement>>(driver)
                .withTimeout(WAIT_TIMEOUT, TimeUnit.SECONDS)  // 等待超时时间30s
                .pollingEvery(POLLING_INTERVAL_TIME, TimeUnit.SECONDS)  // 每隔2s进行验证
                .ignoring(NotFoundException.class); // 忽略异常
    }

    /**
     * 睡眠等待(s)
     */
    public static void sleep(long time) {
        try {
            Thread.sleep(time * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 睡眠等待(ms)
     */
    public static void sleepMS(long time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 单个测试开始
     */
    public static void waitForTestStart() {
        sleep(5);
    }

    /**
     * 单个测试结束
     */
    public static void waitForTestStop() {
        sleep(5);
    }

    /**
     * 等待界面
     */
    public static void waitForActivity(final String activityName) {
        if (StringUtils.isEmpty(activityName)) return;
        LogUtil.i("waitForActivity:" + activityName);
        wait.until(new Function<AndroidDriver, Object>() {
            public Object apply(AndroidDriver driver) {
                // 直到返回true
                return activityName.equals(driver.currentActivity());
            }
        });
    }

    /**
     * 等待控件
     * - 根据Id查找
     */
    public static AndroidElement waitForElementById(final String id) {
        if (StringUtils.isEmpty(id)) return null;
        LogUtil.i("waitForElementById:" + id);
        return wait.until(new Function<AndroidDriver<AndroidElement>, AndroidElement>() {
            public AndroidElement apply(AndroidDriver<AndroidElement> driver) {
                // 直到返回的不为null
                return driver.findElementById(id);
            }
        });
    }

    /**
     * 等待控件
     * - 根据Name查找
     */
    public static AndroidElement waitForElementByName(final String name) {
        if (StringUtils.isEmpty(name)) return null;
        LogUtil.i("waitForElementByName:" + name);
        return wait.until(new Function<AndroidDriver<AndroidElement>, AndroidElement>() {
            public AndroidElement apply(AndroidDriver<AndroidElement> driver) {
                // 直到返回的不为null
                return driver.findElementByName(name);
            }
        });
    }

    /**
     * 等待结果
     */
    public static void waitForResult(final String id) {
        if (StringUtils.isEmpty(id)) return;
        LogUtil.i("waitForResult:" + id);
        wait.until(new Function<AndroidDriver, Object>() {
            public Object apply(AndroidDriver driver) {
                // 直到返回true
                return !StringUtils.isEmpty(driver.findElementById(id).getText());
            }
        });
    }
}