package com.codecool.bertalan.balazs.selenium.test.PageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TableSortSearchDemo extends TestFunction {
    public TableSortSearchDemo(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public int getNumOfSumAge(String url) {
        int result = 0;
        driver.navigate().to(url);
        driver.findElement(By.cssSelector(".sorting:nth-child(4)")).click();
        driver.findElement(By.cssSelector(".sorting_asc")).click();
        driver.findElement(By.cssSelector("#example_length > label > select")).click();
        driver.findElement(By.cssSelector("#example_length > label > select > option:nth-child(2)")).click();
        for (int i = 1; i < 26; i++) {
            if (i % 2 != 0) {
                result += Integer.parseInt(driver.findElement(By.cssSelector(".odd:nth-child(" + i + ") > .sorting_1")).getText());
            } else {
                result += Integer.parseInt(driver.findElement(By.cssSelector(".even:nth-child(" + i + ") > .sorting_1")).getText());
            }
        }
        return result;
    }
}
