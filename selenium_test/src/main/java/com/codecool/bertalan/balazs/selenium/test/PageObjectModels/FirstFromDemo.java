package com.codecool.bertalan.balazs.selenium.test.PageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FirstFromDemo extends TestFunction {
    public FirstFromDemo(WebDriver driver) {
        this.driver = driver;
    }

    public String singleFieldButtonResult() {
        driver.navigate().to("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        driver.findElement(By.cssSelector("#user-message")).sendKeys("Test me!");
        driver.findElement(By.cssSelector("#get-input > button")).click();
        return driver.findElement(By.id("display")).getText();
    }

    public String twoFieldOutputResult() {
        driver.navigate().to("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        driver.findElement(By.id("sum1")).sendKeys("33333333333333333333");
        driver.findElement(By.id("sum2")).sendKeys("55555555555555555555");
        driver.findElement(By.cssSelector(".btn:nth-child(3)")).click();
        return driver.findElement(By.id("displayvalue")).getText();
    }
}
