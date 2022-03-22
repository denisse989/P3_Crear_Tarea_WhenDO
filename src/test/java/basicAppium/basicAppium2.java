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

public class basicAppium2 {
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
        appiumDriver.findElement(By.xpath("//android.widget.Button[@text='2']")).click();
        appiumDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'bt_add')]")).click();
        appiumDriver.findElement(By.xpath("//android.widget.Button[@text='5']")).click();
        appiumDriver.findElement(By.xpath("//android.widget.Button[@content-desc='Igual']")).click();
        String actualResult=appiumDriver.findElement(By.xpath("//android.widget.EditText[contains(@resource-id,'txtCalc')]")).getText();
        String expectedResult="7";
        Assertions.assertEquals(expectedResult,actualResult,"ERROR la suma es incorrecta");
    }
}
