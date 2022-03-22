package basicAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class basicAppium {
    private AppiumDriver appiumDriver;

    @BeforeEach
    public void openApplication() throws MalformedURLException {
        DesiredCapabilities capabilities= new DesiredCapabilities();
        capabilities.setCapability("deviceName","Samsung de Domo");
        capabilities.setCapability("platformVersion","10");
        capabilities.setCapability("appPackage","com.sec.android.app.popupcalculator");
        capabilities.setCapability("appActivity","com.sec.android.app.popupcalculator.Calculator");
        capabilities.setCapability("platformName","Android");

        appiumDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        // implicit
        appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterEach
    public void closeApplication(){
        appiumDriver.quit();
    }

    @Test
    public void verifyCalculator() throws InterruptedException {
        Thread.sleep(5000);
        appiumDriver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_02")).click();
        appiumDriver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_add")).click();
        appiumDriver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_05")).click();
        appiumDriver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_equal")).click();
        String actualResult=appiumDriver.findElement(By.id("com.sec.android.app.popupcalculator:id/txtCalc")).getText();
        String expectedResult="7";
        Assertions.assertEquals(expectedResult,actualResult,"ERROR la suma es incorrecta");
    }
}
