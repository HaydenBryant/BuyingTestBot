package com.company;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Main {

    public static WebDriver driver = null;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //open the web app
        driver.navigate().to("https://www.bestbuy.com/");
        driver.manage().window().maximize();
        String title = driver.getTitle();

        if(title.equalsIgnoreCase("bestbuy.com"))
            System.out.println("title matches");
        else
            System.out.println(title);

        // wait for popup and close
        Thread.sleep(2000);

        //instantiate actions and jsexecute
        Actions action = new Actions(driver);
        JavascriptExecutor js = null;

        //delete popup overlay
        if (driver instanceof JavascriptExecutor) {
            js = (JavascriptExecutor) driver;
        }
        js.executeScript("return document.getElementsByClassName('c-modal-window email-submission-modal modal-full-width active')[0].remove();");

        //locate searchbar. Type Playstation 5. move to and click
        WebElement search = driver.findElement(By.id("gh-search-input"));
        search.sendKeys("Playstation 5");
        search.sendKeys(Keys.RETURN);

        WebElement ps5 = driver.findElement(By.linkText("Sony - PlayStation 5 Console"));
        js.executeScript("arguments[0].scrollIntoView();", ps5);

        action.moveToElement(ps5).perform();
        action.click();
        action.perform();
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,500)");


//        //locate web element hamburger
//        WebElement menu;
//        menu = driver.findElement(By.id("nav-hamburger-menu"));
//        System.out.println(menu);
//
//        //move to hamburger
//
//        action.moveToElement(menu).perform();
//        Thread.sleep(2000);
//
//        //click hamburger menu
//        action.click();
//        action.perform();
//        Thread.sleep(2000);
//
//        //locate category
//        WebElement category = driver.findElement(By.linkText("Home, Garden & Tools"));
//
//        //scroll to element
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView();", category);
//
//        //move to element
//        action.moveToElement(category).perform();
//        Thread.sleep(2000);
//
//        //click category
//        action.click();
//        action.perform();
//        Thread.sleep(2000);
//
//        //locate subcategory
//        WebElement subcategory = driver.findElement(By.linkText("Home Improvement"));
//
//        //scroll to element
//        js.executeScript("arguments[0].scrollIntoView();", subcategory);
//
//        //move to element
//        action.moveToElement(subcategory).perform();
//        Thread.sleep(2000);
//
//        //click subcategory
//        action.click();
//        action.perform();
//        Thread.sleep(2000);
//
//        //locate and click search bar
//        WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
//        searchBar.sendKeys("N95 mask");
//
//        driver.findElement(By.className("nav-input")).click();
//        Thread.sleep(2000);
//
//        //locate and select mask
//        WebElement mask = driver.findElement(By.partialLinkText("3M"));
//        js.executeScript("arguments[0].scrollIntoView();", mask);
//        action.moveToElement(mask).perform();
//        //action dot chain for control click open new tab
//        action.keyDown(Keys.LEFT_CONTROL)
//                .click(mask)
//                .keyUp(Keys.LEFT_CONTROL)
//                .build()
//                .perform();
//
//        Thread.sleep(2000);
//
//        //shift the tab
//        java.util.Set<String> handles = driver.getWindowHandles();
//        String winHandle1 = driver.getWindowHandle();
//        handles.remove(winHandle1);
//
//        String winHandle = handles.iterator().next();
//        String winHandle2 = " ";
//        if(winHandle != winHandle1)
//        {
//            //store next handle
//            winHandle2 = winHandle;
//            driver.switchTo().window(winHandle2);
//            System.out.println(winHandle2);
//        }
//        Thread.sleep(2000);
//
//        //learn more
//        driver.findElement(By.cssSelector("a#a-autoid-0-announce.a-button-text")).click();

        //close browser
//        driver.close();
//        driver.quit();

    }

}
