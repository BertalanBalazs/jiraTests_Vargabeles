package com.codecool.bertalan.balazs.selenium.test.PageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BootstrapDatePickerDemo extends TestFunction {
    public BootstrapDatePickerDemo(WebDriver driver) {
        this.driver = driver;
    }

    public int testDatePickerBootstrap(int year, int month, int day) {
        driver.navigate().to("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
        driver.findElement(By.cssSelector(".glyphicon-th")).click();
        driver.findElement(By.cssSelector(".datepicker-days .datepicker-switch")).click();
        while (true) {
            int getYear = (Integer.parseInt(driver.findElement(By.cssSelector(".datepicker-months .datepicker-switch")).getText()));
            if (year == getYear) {
                driver.findElement(By.cssSelector(".month:nth-child(" + month + ")")).click();
                for (int i = 1; i < 7; i++) {
                    for (int i1 = 1; i1 < 8; i1++) {
                        int getDay = Integer.parseInt(driver.findElement(By.cssSelector("tr:nth-child(" + i + ") > .day:nth-child(" + i1 + ")")).getText());
                        if (day == getDay) {
                            return i1;
                        }
                    }
                }
                break;
            }
            driver.findElement(By.cssSelector(".datepicker-months .prev")).click();
        }
        return Integer.parseInt(null);
    }
}
