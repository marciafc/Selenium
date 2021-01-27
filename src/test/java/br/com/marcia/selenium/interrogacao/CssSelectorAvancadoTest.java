package br.com.marcia.selenium.interrogacao;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelectorAvancadoTest {

    @Test
    public void testeCssAvancado() {

        System.setProperty("webdriver.chrome.driver", "/home/marcia-castagna/chromedriver/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("http://bootcamp-selenium.matera.com/html/css_xpath.html");

        WebElement email = driver.findElement(By.cssSelector("input[id^='name-']"));
        WebElement senha = driver.findElement(By.cssSelector("input[id$='-password']"));
        WebElement repetirSenha = driver.findElement(By.cssSelector("input[id*='-password-']"));
        WebElement cadastrar = driver.findElement(By.cssSelector("input[id*='send']"));

        driver.quit();
    }

}
