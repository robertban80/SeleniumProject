package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginFailTest {
    @Test
    public void loginFail(){ // este un test negativ
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
//        // testare cu username gresit
//        WebElement username = driver.findElement(By.id("username"));  // creare un web element pt username
//        username.sendKeys("tomsmith2");
//
////        WebElement password = driver.findElement(By.id("password"));  // creare un web element pt parola
//        WebElement password = driver.findElement(By.name("password"));  // creare un web element pt parola
//        password.sendKeys("SuperSecretPassword!");

        // TESTARE CU PAROLA GRESITA
        WebElement username = driver.findElement(By.id("username"));  // creare un web element pt username
        username.sendKeys("tomsmith");

//        WebElement password = driver.findElement(By.id("password"));  // creare un web element pt parola
        WebElement password = driver.findElement(By.name("password"));  // creare un web element pt parola
        password.sendKeys("SuperSecretPassword!gresit");

        //3. apasam pe butonul de Login

        WebElement loginButton = driver.findElement(By.className("radius"));
        loginButton.click();

        // varianta 3 - VERIFICAM UN TEXT DIN PAGINA DE LANDING
        WebElement alert = driver.findElement(By.id("flash-messages"));
        Assert.assertTrue(alert.isDisplayed());
        //String alertText = "Your username is invalid!";
        String alertText = "Your password is invalid!";
        //Assert.assertEquals(alert.getText(), alertText); // cauta un text identic
        Assert.assertTrue(alert.getText().contains(alertText));  // cauta o bucata din text


    }
}
