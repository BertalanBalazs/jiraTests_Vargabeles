package com.codecool.bertalan.balazs.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestFunction {
    static WebDriver driver;

    void init() {
        System.setProperty("webdriver.chrome.driver", "/home/bertalan/Desktop/codecool/downloads/chrome/chromedriver");
        driver = new ChromeDriver();
    }

    public String getUrl() {
        driver.get("https://www.seleniumeasy.com/test/");
        driver.findElement(By.cssSelector("#treemenu > li > ul > li:nth-child(1) > a")).click();
        driver.findElement(By.cssSelector("#treemenu > li > ul > li:nth-child(1) > ul > li:nth-child(1) > a")).click();
        return driver.getCurrentUrl();
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

    public String singleCheckboxResult() {
        driver.navigate().to("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        driver.findElement(By.cssSelector(".checkbox:nth-child(2) > label")).click();
        return driver.findElement(By.id("txtAge")).getText();
    }

    public String doubleCheckbox() {
        driver.navigate().to("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        driver.findElement(By.cssSelector(".checkbox:nth-child(2) > label")).click();
        driver.findElement(By.xpath("check1")).click();
        driver.findElement(By.cssSelector(".checkbox:nth-child(3) > label")).click();
        return driver.findElement(By.id("check1")).getAttribute("value");
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

    public String getRadioButtonResult(String s, String s2) {
        driver.findElement(By.cssSelector(s)).click();
        driver.findElement(By.cssSelector(s2)).click();
        driver.findElement(By.cssSelector(".btn:nth-child(5)")).click();
        return driver.findElement(By.cssSelector(".groupradiobutton")).getText();
    }

    public int testDatePickerBootstrap(int year, int month, int day) {
        init();
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

    public int getNumOfSumAge() {
        int result = 0;
        driver.navigate().to("https://www.seleniumeasy.com/test/table-sort-search-demo.html");
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
