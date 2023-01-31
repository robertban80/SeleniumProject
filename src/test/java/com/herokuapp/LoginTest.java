package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.ref.SoftReference;
import java.sql.Driver;

public class LoginTest {
    @Test
    public void login(){

        //cream driver-ul
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //1. deschidem pagina

        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);
        System.out.println("Am deschis pagina: " + url);
//        driver.manage().window().maximize(); //maximizeaza pagina
//        System.out.println("Am maximizat pagina curenta...");

        //2. introducere user si parola

        WebElement username = driver.findElement(By.id("username"));  // creare un web element pt username
        username.sendKeys("tomsmith");

//        WebElement password = driver.findElement(By.id("password"));  // creare un web element pt parola
        WebElement password = driver.findElement(By.name("password"));  // creare un web element pt parola
        password.sendKeys("SuperSecretPassword!");

        //3. apasam pe butonul de Login

        WebElement loginButton = driver.findElement(By.className("radius"));
        loginButton.click();

        //4. verificare rezultat

        // varianta 1 - dupa url-ul landing page-ului
        String landingUrl = "https://the-internet.herokuapp.com/secure";
        Assert.assertEquals(landingUrl,"https://the-internet.herokuapp.com/secure");

        // varianta 2 - prezenta buton Logout
        WebElement logoutButton = driver.findElement(By.linkText("Logout"));
        Assert.assertTrue(logoutButton.isDisplayed());

        // varianta 3 - VERIFICAM UN TEXT DIN PAGINA DE LANDING
        WebElement alert = driver.findElement(By.id("flash"));
        Assert.assertTrue(alert.isDisplayed());
        String alertText = "You logged into a secure area!";
        //Assert.assertEquals(alert.getText(), alertText); // cauta un text identic
        Assert.assertTrue(alert.getText().contains(alertText));  // cauta o bucata din test

        //inchide fereastra cu browser-ul
        //driver.quit(); // inchide intreaga fereastra
        driver.close(); // inchide doar tab-ul
        System.out.println("Inchid fereastra...");
    }


}
