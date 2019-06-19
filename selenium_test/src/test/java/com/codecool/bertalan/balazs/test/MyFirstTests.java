package com.codecool.bertalan.balazs.test;

import com.codecool.bertalan.balazs.selenium.test.DayEnum.Day;
import com.codecool.bertalan.balazs.selenium.test.PageObjectModels.*;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


class MyFirstTests {

    private WebDriver driver;

    @BeforeEach
    void setUp(){
        System.setProperty("webdriver.chrome.driver", "/home/bertalan/Desktop/codecool/downloads/chrome/chromedriver");
        driver = new ChromeDriver();
    }


    @AfterEach
    void finish() {
        driver.close();
    }

    @Test
    void testNavigation() {
        Navigation navigation = new Navigation(driver);
        String resultUrl = navigation.testNavigation();
        Assert.assertEquals(resultUrl, "https://www.seleniumeasy.com/test/basic-first-form-demo.html");
    }


    @Test
    void testSingleFieldButton() {
        FirstFromDemo firstFromDemo = new FirstFromDemo(driver);
        String result = firstFromDemo.singleFieldButtonResult();
        Assert.assertEquals(result, "Test me!");
    }


    @Test
    void testTwoFieldOutput() {
        FirstFromDemo firstFromDemo = new FirstFromDemo(driver);
        String result = firstFromDemo.twoFieldOutputResult();
        String expected = "88888888888888888888";
        Assert.assertEquals(result, expected);
    }


    @Test
    void testSingleCheckbox() {
        CheckBoxDemo checkBoxDemo = new CheckBoxDemo(driver);
        String result = checkBoxDemo.singleCheckboxResult();
        Assert.assertEquals(result, "Success - Check box is checked");
    }


    @Test
    void testDoubleCheckbox() {
        CheckBoxDemo checkBoxDemo = new CheckBoxDemo(driver);
        String result = checkBoxDemo.doubleCheckbox();
        Assert.assertEquals(result, "Check All");
    }


    @Test
    void testSelectListWithClick() {
        SelectDropdownDemo selectDropdownDemo = new SelectDropdownDemo(driver);
        String result = selectDropdownDemo.selectList();
        Assert.assertEquals(result, "Day selected :- Wednesday");
    }


    @Test
    void testSelectListWithArrow() {
        SelectDropdownDemo selectDropdownDemo = new SelectDropdownDemo(driver);
        String result = selectDropdownDemo.selectListArrow();
        Assert.assertEquals(result, "Day selected :- Wednesday");
    }


    @Test
    void testRadioButtons() {
        RadioButtonDemo radioButtonDemo = new RadioButtonDemo(driver);

        //First test

        String resultOne = radioButtonDemo.getRadioButtonResult(".panel-body > div:nth-child(2) > .radio-inline:nth-child(2)", "div:nth-child(3) > .radio-inline:nth-child(2)");
        Assert.assertEquals(resultOne, "Sex : Male\n" +
                "Age group: 0 - 5");

        //Second test
        String resultTwo = radioButtonDemo.getRadioButtonResult(".panel-body > div:nth-child(2) > .radio-inline:nth-child(3)", "div:nth-child(3) > .radio-inline:nth-child(3)");
        Assert.assertEquals(resultTwo, "Sex : Female\n" +
                "Age group: 5 - 15");

        //Third test
        String resultThree = radioButtonDemo.getRadioButtonResult(".panel-body > div:nth-child(2) > .radio-inline:nth-child(3)", "div:nth-child(3) > .radio-inline:nth-child(4)");
        Assert.assertEquals(resultThree, "Sex : Female\n" +
                "Age group: 15 - 50");
    }


    @Test
    void testDatePickerBootstrap() {
        BootstrapDatePickerDemo bootstrapDatePickerDemo = new BootstrapDatePickerDemo(driver);
        int date = bootstrapDatePickerDemo.testDatePickerBootstrap(2007, 12, 8);
        Assert.assertEquals(Day.SAT, Day.values()[date - 1]);
    }

    @Test
    void testSortAndSearchDemo() {
        TableSortSearchDemo tableSortSearchDemo = new TableSortSearchDemo(driver);
        int numOfSumAge = tableSortSearchDemo.getNumOfSumAge();
        Assert.assertEquals(numOfSumAge, 1164);
    }
}
