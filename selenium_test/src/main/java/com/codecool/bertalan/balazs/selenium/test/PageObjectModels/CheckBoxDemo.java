package com.codecool.bertalan.balazs.selenium.test.PageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBoxDemo extends TestFunction {
    public CheckBoxDemo(WebDriver driver) {
        this.driver = driver;
    }

    public String singleCheckboxResult() {
        driver.navigate().to("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        driver.findElement(By.cssSelector(".checkbox:nth-child(2) > label")).click();
        return driver.findElement(By.id("txtAge")).getText();
    }

    public String doubleCheckbox() {
        driver.navigate().to("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        driver.findElement(By.cssSelector(".checkbox:nth-child(2) > label")).click();
        driver.findElement(By.id("check1")).click();
        driver.findElement(By.cssSelector(".checkbox:nth-child(3) > label")).click();
        return driver.findElement(By.id("check1")).getAttribute("value");
    }
}
