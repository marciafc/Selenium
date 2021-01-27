package br.com.marcia.selenium.interrogacao;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathAvancadoTest {

    @Test
    public void testeXpathAvancado() {

        System.setProperty("webdriver.chrome.driver", "/home/marcia-castagna/chromedriver/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("http://bootcamp-selenium.matera.com/html/css_xpath.html");

        WebElement email = driver.findElement(By.xpath("//input[starts-with(@id,'name')]"));
        WebElement repetirSenha = driver.findElement(By.xpath("//input[contains(@id, '-password-')]"));

        driver.quit();
    }

}
