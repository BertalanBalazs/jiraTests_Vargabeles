package com.codecool.bertalan.balazs.selenium.test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class TestFunction {
    Keyword keyword;

    public TestFunction(WebDriver driver) {
        keyword = new Keyword(driver);
    }


    public String getUrl() {
        keyword.openWebsite("https://www.seleniumeasy.com/test/");
        keyword.clickOnElementBy("//*[@id=\"navbar-brand-centered\"]/ul[1]/li[1]/a");
        keyword.clickOnElementBy("//ul[@class='dropdown-menu']/li[1]/a[1 and @href='./basic-first-form-demo.html']");
        return keyword.getCurrentUrl();
    }

    public String singleFieldButtonResult() {
        keyword.openWebsite("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        keyword.sendKeysToElementBy("//input[@id='user-message']", "Test me!");
        keyword.clickOnElementBy("//button[text()='Show Message']");
        return keyword.getTextFromElementByxPath("//span[@id='display']");
    }

    public String twoFieldOutputResult() {
        keyword.openWebsite("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        keyword.sendKeysToElementBy("//input[@id='sum1']", "33333333333333333333");
        keyword.sendKeysToElementBy("//input[@id='sum2']", "55555555555555555555");
        keyword.clickOnElementBy("//button[text()='Get Total']");
        return keyword.getTextFromElementByxPath("//span[@id='displayvalue']");
    }

    public String singleCheckboxResult() {
        keyword.openWebsite("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        keyword.clickOnElementBy("//input[@id='isAgeSelected']");
        return keyword.getTextFromElementByxPath("//div[@id='txtAge']");
    }

    public String doubleCheckbox() {
        keyword.openWebsite("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        keyword.clickOnElementBy("//input[@id='check1']");
        keyword.clickOnElementBy("//input[@id='isAgeSelected']");
        keyword.clickOnElementBy("//div[1]/label[1]/input[@class='cb1-element' and @type='checkbox']");
        return keyword.getValueFromElementBy("//input[@id='check1']");
    }


    public String selectList() {
        keyword.openWebsite("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
        keyword.clickOnElementBy("//select[@id='select-demo']");
        keyword.clickOnElementBy("//select[@id='select-demo']");
        keyword.clickOnElementBy("//*[@id=\"select-demo\"]/option[5]");
        return keyword.getTextFromElementByxPath("//p[@class='selected-value']");
    }

    public String selectListArrow() {
        keyword.openWebsite("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
        keyword.clickOnElementBy("//select[@id='select-demo']");
        for (int i = 0; i < 4; i++) {
            keyword.sendKeysToElementBy("//select[@id='select-demo']", Keys.ARROW_DOWN);
        }
        keyword.sendKeysToElementBy("//select[@id='select-demo']", Keys.ENTER);
        return keyword.getTextFromElementByxPath("//p[@class='selected-value']");
    }

    public String getRadioButtonResult(String s, String s2) {
        keyword.openWebsite("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
        keyword.clickOnElementBy(s);
        keyword.clickOnElementBy(s2);
        keyword.clickOnElementBy("//button[text()='Get values']");
        return keyword.getTextFromElementByxPath("//p[@class='groupradiobutton']");
    }

    public int testDatePickerBootstrap(int year, int month, int day) {
        keyword.openWebsite("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
        keyword.clickOnElementBy("//input[@placeholder='dd/mm/yyyy']");
        keyword.sendKeysToElementBy("//input[@placeholder='dd/mm/yyyy']", day + "/" + month + "/" + year);
        keyword.clickOnElementBy("//i[@class='glyphicon glyphicon-th']");
        for (int i = 1; i < 7; i++) {
            for (int i1 = 1; i1 < 8; i1++) {
                int getDay = Integer.parseInt(keyword.getTextFromElementByCss("tr:nth-child(" + i + ") > .day:nth-child(" + i1 + ")"));
                if (day == getDay) {
                    return i1;
                }
            }
        }
        return Integer.parseInt(null);
    }

    public int getNumOfSumAge() {
        int result = 0;
        keyword.openWebsite("https://www.seleniumeasy.com/test/table-sort-search-demo.html");
        keyword.clickOnElementBy("//select");
        keyword.clickOnElementBy("//*[@id=\"example_length\"]/label/select/option[2]");
        keyword.clickOnElementBy("//th[4]");
        keyword.clickOnElementBy("//th[4]");
        for (int i = 1; i < 26; i++) {
            result += Integer.parseInt(keyword.getTextFromElementByxPath("//tr[" + i + "]/td[@class='sorting_1' and 4]"));
        }
        return result;
    }
}
