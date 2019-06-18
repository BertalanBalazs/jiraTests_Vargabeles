package com.codecool.bertalan.balazs.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Keyword {
    static WebDriver driver;

    public Keyword() {
        System.setProperty("webdriver.chrome.driver", "/home/bertalan/Desktop/codecool/downloads/chrome/chromedriver");
        driver = new ChromeDriver();
    }

    public void openWebsite(String url){
        driver.navigate().to(url);
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public void clickOnElementBy(String xPath){
        driver.findElement(By.xpath(xPath)).click();
    }

    public void sendKeysToElementBy(String xPath, String sendKey) {
        driver.findElement(By.xpath(xPath)).sendKeys(sendKey);
    }

    public void sendKeysToElementBy(String xPath, Keys sendKey) {
        driver.findElement(By.xpath(xPath)).sendKeys(sendKey);
    }

    public String getTextFromElementByxPath(String xPath) {
        return driver.findElement(By.xpath(xPath)).getText();
    }

    public String getTextFromElementByCss(String cssSelector) {
        return driver.findElement(By.cssSelector(cssSelector)).getText();
    }

    public String getValueFromElementBy(String xPath) {
        return driver.findElement(By.xpath(xPath)).getAttribute("value");
    }
}
