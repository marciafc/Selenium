package br.com.marcia.selenium.sincronizacao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class EsperaExplicitaTest {

    private WebDriver driver;

    private WebDriverWait wait;

    @Before
    public void before() {

        System.setProperty("webdriver.chrome.driver", "/home/marcia-castagna/chromedriver/chromedriver");

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("http://bootcamp-selenium.matera.com/html/ajax_loading.html");
    }

    @After
    public void after() {
        driver.quit();
    }

    @Test
    public void testeLoginInvalido() {

        driver.findElement(By.id("username")).sendKeys("demo");
        driver.findElement(By.id("password")).sendKeys("12345");
        driver.findElement(By.id("login")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".error")));

        assertEquals("Usuario ou senhas invalidos.", driver.findElement(By.cssSelector(".error")).getText());
    }

    @Test
    public void testeLoginValido() {

        driver.findElement(By.id("username")).sendKeys("demo");
        driver.findElement(By.id("password")).sendKeys("demo");
        driver.findElement(By.id("login")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".success")));

        assertEquals("Voce efetuou o login com sucesso!", driver.findElement(By.cssSelector(".success")).getText());
    }
}


