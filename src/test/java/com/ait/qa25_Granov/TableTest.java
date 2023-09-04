package com.ait.qa25_Granov;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TableTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/css/css_table.asp");
        //maximize browser window
        driver.manage().window().maximize();
        //set implicit timeout
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void tableByCssTest() {
//        numbers of roads
        List<WebElement> tr = driver.findElements(By.cssSelector("tr"));
        System.out.println("Rows in table --> " + tr.size());
        for (int i = 0; i < tr.size(); i++) {
            System.out.println(tr.get(i).getText());
        }
        System.out.println("___________________________ ");
//        numbers of columns
        List<WebElement> columns = driver.findElements(By.cssSelector("tr th"));
        System.out.println("Rows in table --> " + columns.size());
//
        List<WebElement> row3 = driver.findElements(By.cssSelector("tr:nth-child(3) td"));
        for (WebElement element : row3) {
            System.out.println(element.getText());
        }
        System.out.println("__________________________");

//        print last columns
        List<WebElement> lastColumn = driver.findElements(By.cssSelector("tr td:last-child"));
        for (WebElement element : lastColumn) {
            System.out.println(element.getText());
        }
        System.out.println("___________________________");

        System.out.println(driver.findElement(By.cssSelector("tr:nth-child(2) td:nth-child(2)")).getText());
    }


    @Test
    public void tableXPath() {
        //        numbers of roads
        List<WebElement> tr = driver.findElements(By.xpath("//tr"));
        System.out.println("Rows in table --> " + tr.size());
        for (int i = 0; i < tr.size(); i++) {
            System.out.println(tr.get(i).getText());
        }
        System.out.println("___________________________ ");
//        numbers of columns
        List<WebElement> columns = driver.findElements(By.xpath("//tr/th"));
        System.out.println("Rows in table --> " + columns.size());
//
        List<WebElement> row3 = driver.findElements(By.xpath("//tr[3]//td"));
        for (WebElement element : row3) {
            System.out.println(element.getText());
        }
        System.out.println("__________________________");

//        print last columns
        List<WebElement> lastColumn = driver.findElements(By.xpath("//tr/td[last()]"));
        for (WebElement element : lastColumn) {
            System.out.println(element.getText());
        }
        System.out.println("___________________________");

        System.out.println(driver.findElement(By.xpath("//td[text()='Maria Anders']")).getText());
        System.out.println(driver.findElement(By.xpath("//td[contains(.,'Maria Anders')]")).getText());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

/*
 XPath  - //beginning element/relationship::tagName
 sibling - preceding-sibling   //td[text()='Sweden']/preceding-sibling::td[1]

 sibling - following-sibling   //td[text()='Ernst Handel']/following-sibling::td[1]


 parent  & child   //td[text()='Sweden']/parent::tr

 descendant        //table[@id='customers']/descendant::td[1]

 ancestor          //td[text()='Sweden']/ancestor::table

 */


