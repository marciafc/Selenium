package br.com.marcia.selenium.interrogacao;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathTest {

    @Test
    public void testeXpathBasico() {

        System.setProperty("webdriver.chrome.driver", "/home/marcia-castagna/chromedriver/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("http://bootcamp-selenium.matera.com/html/find_elements.html");

        WebElement divPai = driver.findElement(By.xpath("//div[@class='divpai border']"));
        WebElement divFilho = driver.findElement(By.xpath("//div[@class='divfilho border']"));
        WebElement divNeto2 = driver.findElement(By.xpath("//div[@class='divneto border'][2]"));
        WebElement dataInicioRelatorio = driver.findElement(By.xpath("//input[@id='dataInicio']"));

        driver.quit();
    }

}
