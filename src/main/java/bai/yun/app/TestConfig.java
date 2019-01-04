package bai.yun.app;

import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobilePlatform;

/**
 * Created by Kevin on 2017/8/2.
 */
public class TestConfig {

    // 旺收银外部调用Demo
    public static final String SNAPPAY_APP_PACKAGE = "bai.bai.bai.demo";
    public static final String SNAPPAY_APP_LAUNCHER_ACTIVITY = ".activity.ChooseActivity";



    /* ================================= 需要配置的参数 ================================ */

//    // 测试应用Apk路径.
//    public static final String APK = "apk/CashierSnapPay1.0.0_201811211100.apk.apk";
    // 测试应用包名
    public static final String APP_PACKAGE = SNAPPAY_APP_PACKAGE;
    // 测试应用启动页面
    public static final String APP_ACTIVITY = SNAPPAY_APP_LAUNCHER_ACTIVITY;

    // 测试设备标识- adb devices
    public static final String DEVICE_NAME = "0123abcd";
    // 测试设备系统：Android/ios
    public static final String DEVICE_PLATFORM = MobilePlatform.ANDROID;
    // 测试设备系统版本：设置界面->关于手机 或 adb shell cat /system/build.prop | findstr ro.build.version
    public static final String DEVICE_PLATFORM_VERSION = "5.1.1";

    // 测试使用框架
    public static final String AUTOMATION_NAME = AutomationName.APPIUM;
    // Server Url
    public static final String SERVER_URL = "http://0.0.0.0:4723/wd/hub";


}