package br.com.marcia.selenium.interrogacao;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InterrogacaoTest {

    @Test
    public void testeInterrogacaoById() {

        System.setProperty("webdriver.chrome.driver", "/home/marcia-castagna/chromedriver/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("http://bootcamp-selenium.matera.com/html/elementos.html");

        WebElement email = driver.findElement(By.id("email"));
        WebElement senha = driver.findElement(By.id("password"));
        WebElement lembrarSenha = driver.findElement(By.id("lembrar"));
        WebElement login = driver.findElement(By.id("submit"));
        WebElement limpar = driver.findElement(By.id("limpar"));
        WebElement titulo = driver.findElement(By.tagName("h1"));

        driver.quit();
    }

}
