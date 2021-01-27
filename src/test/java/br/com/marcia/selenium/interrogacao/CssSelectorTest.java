package br.com.marcia.selenium.interrogacao;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelectorTest {

    @Test
    public void testeCssBasico() {

        System.setProperty("webdriver.chrome.driver", "/home/marcia-castagna/chromedriver/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("http://bootcamp-selenium.matera.com/html/find_elements.html");

        WebElement divPai = driver.findElement(By.cssSelector(".divpai.border"));
        WebElement divFilho = driver.findElement(By.cssSelector(".divfilho.border"));
        WebElement divNeto1 = driver.findElement(By.cssSelector(".divneto.border"));
        WebElement dataInicioRelatorio = driver.findElement(By.cssSelector("#dataInicio"));

        driver.quit();
    }

}
