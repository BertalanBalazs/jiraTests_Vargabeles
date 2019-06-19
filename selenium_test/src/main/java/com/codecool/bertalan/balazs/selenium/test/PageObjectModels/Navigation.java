package com.codecool.bertalan.balazs.selenium.test.PageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Navigation extends TestFunction {
    public Navigation(WebDriver driver) {
        this.driver = driver;
    }

    public String testNavigation() {
        driver.get("https://www.seleniumeasy.com/test/");
        driver.findElement(By.cssSelector("#treemenu > li > ul > li:nth-child(1) > a")).click();
        driver.findElement(By.cssSelector("#treemenu > li > ul > li:nth-child(1) > ul > li:nth-child(1) > a")).click();
        return driver.getCurrentUrl();
    }
}
