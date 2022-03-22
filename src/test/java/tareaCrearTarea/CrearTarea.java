package tareaCrearTarea;

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

public class CrearTarea {
    private AppiumDriver appiumDriver;

    @BeforeEach
    public void openApplication() throws MalformedURLException {
        DesiredCapabilities capabilities= new DesiredCapabilities();
        capabilities.setCapability("deviceName","Samsung de Domo");
        capabilities.setCapability("platformVersion","10");
        capabilities.setCapability("appPackage","com.vrproductiveapps.whendo");
        capabilities.setCapability("appActivity","com.vrproductiveapps.whendo.ui.HomeActivity");
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
    public void verifyWhenDo() throws InterruptedException {
        Thread.sleep(3000);
        appiumDriver.findElement(By.id("com.vrproductiveapps.whendo:id/fab")).click();
        appiumDriver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).click();
        appiumDriver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys("Tarea1");
        //appiumDriver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_equal")).click();
        appiumDriver.findElement(By.id("com.vrproductiveapps.whendo:id/saveItem")).click();
        String actualResult=appiumDriver.findElement(By.id("com.vrproductiveapps.whendo:id/home_list_item_text")).getText();

        String actualResult1=appiumDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.view.ViewGroup/android.widget.ListView/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")).getText();
        String expectedResult="Tarea1";
        Assertions.assertEquals(expectedResult,actualResult,"ERROR los nombres son diferentes");
    }
}
