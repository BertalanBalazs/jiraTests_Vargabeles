package com.codecool.bertalan.balazs.selenium.test.PageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButtonDemo extends TestFunction {
    public RadioButtonDemo(WebDriver driver) {
        this.driver = driver;
    }

    public String getRadioButtonResult(String s, String s2) {
        driver.navigate().to("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
        driver.findElement(By.cssSelector(s)).click();
        driver.findElement(By.cssSelector(s2)).click();
        driver.findElement(By.cssSelector(".btn:nth-child(5)")).click();
        return driver.findElement(By.cssSelector(".groupradiobutton")).getText();
    }
}
