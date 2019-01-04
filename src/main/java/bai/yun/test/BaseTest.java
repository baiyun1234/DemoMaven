package bai.yun.test;

import bai.yun.app.Constant;
import bai.yun.app.TestConfig;
import bai.yun.util.LogUtil;
import bai.yun.util.WaitUtil;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @BeforeClass – 表示在类中的任意public static void方法执行之前执行
 * @AfterClass – 表示在类中的任意public static void方法执行之后执行
 * @Before – 表示在任意使用@Test注解标注的public void方法执行之前执行
 * @After – 表示在任意使用@Test注解标注的public void方法执行之后执行
 * @Test – 使用该注解标注的public void方法会表示为一个测试方法
 *
 * @Beforeclass： 在类中只会被执行一次
 * @Before： 在跑测试test001，test002时候都会各执行一次@Before部分的代码。
 * @After： 释放资源对于每一个测试方法都要执行一次
 * @Afterclass: 所有测试用例执行完才执行一次
 */


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BaseTest {

    protected static AndroidDriver<AndroidElement> driver;

    @BeforeClass
    public static void beforeClass1() throws MalformedURLException {
        LogUtil.i(" -> baibai--BaseTest: beforeClass1");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, TestConfig.DEVICE_NAME);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, TestConfig.AUTOMATION_NAME);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, TestConfig.DEVICE_PLATFORM);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, TestConfig.DEVICE_PLATFORM_VERSION);

        capabilities.setCapability(Constant.CAPABILITY_APP_PACKAGE, TestConfig.APP_PACKAGE);
        capabilities.setCapability(Constant.CAPABILITY_APP_ACTIVITY, TestConfig.APP_ACTIVITY);
        // 初始化等待机制
        driver = new AndroidDriver<AndroidElement>(new URL(TestConfig.SERVER_URL), capabilities);
        WaitUtil.init(driver);
    }

    @Before
    public void before1() {
        LogUtil.i(" -> baibai--BaseTest: before1");
    }

    @Before
    public void before2() {
        LogUtil.i(" -> baibai--BaseTest: before2");
    }

    @After
    public void after1() {
        LogUtil.i(" -> baibai--BaseTest: after1");
    }

    @After
    public void after2() {
        LogUtil.i(" -> baibai--BaseTest: after2");
    }

    @AfterClass
    public static void afterClass1() {
        LogUtil.i(" -> baibai--BaseTest: afterClass1");
    }

}
