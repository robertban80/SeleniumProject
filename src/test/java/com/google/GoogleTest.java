package com.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest {
    @Test
    public void testGoogle(){
        //creare driver
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //deschidem pagina care trebuie testata
        String url = "https://www.google.com/";
        driver.get(url);
        System.out.println("Opening www.google.com page...");

        //maximizare fereastra
        driver.manage().window().maximize();
        System.out.println("Maximizeaza fereastra...");

        // verific pe ce pagina sunt
        System.out.println("Adresa web curenta e: " + driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),url); // returneaza url-ul curent din chrome
        //Assert.assertEquals("https://google.com/",url);

        //inchide fereastra cu browser-ul
        driver.quit();
        System.out.println("Inchid fereastra cu google.com");




    }
}
