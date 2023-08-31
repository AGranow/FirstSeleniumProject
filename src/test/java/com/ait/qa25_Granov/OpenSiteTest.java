package com.ait.qa25_Granov;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenSiteTest {

    WebDriver driver;

    //before  -  setUp
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
//        driver.get("https://www.google.com/");  // without history - без истории
        driver.navigate().to("https://www.google.com/"); // with history - с историей
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }


    // tests
    @Test
    public void openGoogleTest() {
        System.out.println("Site opened!!!");
    }


    //after   -   tearDown
    @AfterMethod
    public void tearDown(){
//        driver.quit(); // all tabs & browser - закрывает браузер
        driver.close(); // only one tab, if only one tab close browser
    }
}