package com.codecool.bertalan.balazs.selenium.test.PageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SelectDropdownDemo extends TestFunction {

    public SelectDropdownDemo(WebDriver driver) {
        this.driver = driver;
    }

    public String selectList() {
        driver.navigate().to("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
        driver.findElement(By.id("select-demo")).click();
        driver.findElement(By.cssSelector("#select-demo > option:nth-child(5)")).click();
        return driver.findElement(By.cssSelector(".selected-value")).getText();
    }

    public String selectListArrow() {
        driver.navigate().to("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
        driver.findElement(By.id("select-demo")).click();
        for (int i = 0; i < 4; i++) {
            driver.findElement(By.id("select-demo")).sendKeys(Keys.ARROW_DOWN);
        }
        driver.findElement(By.id("select-demo")).sendKeys(Keys.ENTER);
        return driver.findElement(By.cssSelector(".selected-value")).getText();
    }
}
