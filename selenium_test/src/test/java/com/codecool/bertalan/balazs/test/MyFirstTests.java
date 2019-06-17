package com.codecool.bertalan.balazs.test;

import com.codecool.bertalan.balazs.selenium.test.Day;
import com.codecool.bertalan.balazs.selenium.test.TestFunction;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


class MyFirstTests {
    static WebDriver driver;

    TestFunction testFunction = new TestFunction();


    @BeforeAll
    static void init() {
        System.setProperty("webdriver.chrome.driver", "/home/bertalan/Desktop/codecool/downloads/chrome/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterAll
    static void finish() {
        driver.close();
    }

    @Test
    void testNavigation() {
        String resultUrl = testFunction.getUrl();
        Assert.assertEquals(resultUrl, "https://www.seleniumeasy.com/test/basic-first-form-demo.html");
    }


    @Test
    void testSingleFieldButton() {
        String result = testFunction.singleFieldButtonResult();
        Assert.assertEquals(result, "Test me!");
    }


    @Test
    void testTwoFieldOutput() {
        String result = testFunction.twoFieldOutputResult();
        String expected = "88888888888888888888";
        Assert.assertEquals(result, expected);
    }


    @Test
    void testSingleCheckbox() {
        String result = testFunction.singleCheckboxResult();
        Assert.assertEquals(result, "Success - Check box is checked");
    }


    @Test
    void testDoubleCheckbox() {
        String result = testFunction.doubleCheckbox();
        Assert.assertEquals(result, "Check All");
    }


    @Test
    void testSelectListWithClick() {
        String result = testFunction.selectList();
        Assert.assertEquals(result, "Day selected :- Wednesday");
    }


    @Test
    void testSelectListWithArrow() {
        String result = testFunction.selectListArrow();
        Assert.assertEquals(result, "Day selected :- Wednesday");
    }


    @Test
    void testRadioButtons() {
        driver.navigate().to("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");

        //First test

        String resultOne = testFunction.getRadioButtonResult(".panel-body > div:nth-child(2) > .radio-inline:nth-child(2)", "div:nth-child(3) > .radio-inline:nth-child(2)");
        Assert.assertEquals(resultOne, "Sex : Male\n" +
                "Age group: 0 - 5");

        //Second test
        String resultTwo = testFunction.getRadioButtonResult(".panel-body > div:nth-child(2) > .radio-inline:nth-child(3)", "div:nth-child(3) > .radio-inline:nth-child(3)");
        Assert.assertEquals(resultTwo, "Sex : Female\n" +
                "Age group: 5 - 15");

        //Third test
        String resultThree = testFunction.getRadioButtonResult(".panel-body > div:nth-child(2) > .radio-inline:nth-child(3)", "div:nth-child(3) > .radio-inline:nth-child(4)");
        Assert.assertEquals(resultThree, "Sex : Female\n" +
                "Age group: 15 - 50");
    }


    @Test
    void testDatePickerBootstrap() {
        int date = testFunction.testDatePickerBootstrap(2007, 12, 8);
        Assert.assertEquals(Day.SAT, Day.values()[date - 1]);
    }

    @Test
    void testSortAndSearchDemo() {
        int numOfSumAge = testFunction.getNumOfSumAge();
        Assert.assertEquals(numOfSumAge, 1164);
    }
}
