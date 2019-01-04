package bai.yun.test;

import bai.yun.app.Constant;
import bai.yun.app.TestConfig;
import bai.yun.util.LogUtil;
import bai.yun.util.WaitUtil;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test1 extends BaseTest {

    protected static AndroidDriver<AndroidElement> driver;

    @BeforeClass
    public static void beforeClassTest1() throws MalformedURLException {
        LogUtil.i(" -> baibai--Test1: beforeClassTest1");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, TestConfig.DEVICE_NAME);
        capabilities.setCapability(Constant.CAPABILITY_APP_PACKAGE, TestConfig.APP_PACKAGE);
        capabilities.setCapability(Constant.CAPABILITY_APP_ACTIVITY, TestConfig.APP_ACTIVITY);
        driver = new AndroidDriver<AndroidElement>(new URL(TestConfig.SERVER_URL), capabilities);
        WaitUtil.init(driver);
    }

    @Test
    public void test1(){
        LogUtil.i(" -> baibai--Test1: test1");
//        WaitUtil.waitForActivity(".activity.ChooseActivity");
        WaitUtil.waitForElementById("btn_choose_location").click();
        WaitUtil.waitForElementById("btn_location_have_net").click();
    }

    @Test
    public void test2(){
        LogUtil.i(" -> baibai--Test1: test2");
    }

    @Test
    public void test3(){
        LogUtil.i(" -> baibai--Test1: test3");
    }

    @AfterClass
    public static void afterClassTest1(){
        LogUtil.i(" -> baibai--Test1: afterClassTest1");
    }

}
