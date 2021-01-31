package br.com.marcia.selenium.alerta;

import br.com.marcia.selenium.util.PathUtils;
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

public class AlertaHtmlTest {

    private WebDriver driver;

    private WebDriverWait wait;

    @Before
    public void before() {

        System.setProperty("webdriver.chrome.driver", PathUtils.CHROME_DRIVER);

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //driver.get("http://bootcamp-selenium.matera.com/html/alert_confirmation_js.html");
        driver.get(PathUtils.URL + "alert_confirmation_js.html");
    }

    @After
    public void after() {
        driver.quit();
    }

    @Test
    public void testeAlertaHtml() {

        driver.findElement(By.id("alerta")).click();

        By element = By.cssSelector(".bootbox-body");
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));

        assertEquals("Este é um alerta", driver.findElement(element).getText());
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();
    }

    @Test
    public void testeConfirmacao() {

        By element = By.cssSelector(".bootbox-body");
        By msg = By.id("msg");

        //Cancela mensagem
        //Clica no botão confirmação
        driver.findElement(By.id("confirmacao")).click();

        //aguarda aparecer a tela e valida a mensagem
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        assertEquals("Tem certeza?", driver.findElement(element).getText());

        //Clica no botão cancelar
        driver.findElement(By.cssSelector(".btn.btn-default")).click();

        //Aguarda aparecer a mensagem e valida o texto de cancelou
        wait.until(ExpectedConditions.visibilityOfElementLocated(msg));
        assertEquals("Cancelou", driver.findElement(msg).getText());

        //Aceita mensagem
        //Clica no botão confirmação
        wait.until(ExpectedConditions.invisibilityOfElementLocated(msg));
        driver.findElement(By.id("confirmacao")).click();

        //Aguarda aparecer a tela e valida a mensagem
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        assertEquals("Tem certeza?", driver.findElement(element).getText());

        //Clica no botão ok
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();

        //Aguarda aparecer a mensagem e valida o texto de aceitou
        wait.until(ExpectedConditions.visibilityOfElementLocated(msg));
        assertEquals("Aceitou", driver.findElement(msg).getText());
    }

    @Test
    public void testePrompt() {

        By element = By.cssSelector(".bootbox-body");
        By msg = By.id("msg");

        driver.findElement(By.id("prompt")).click();

        //aguarda aparecer a tela e valida a mensagem
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        driver.findElement(By.cssSelector(".bootbox-input.bootbox-input-text.form-control")).sendKeys("Teste");

        driver.findElement(By.cssSelector(".btn.btn-primary")).click();

        //Aguarda aparecer a mensagem e valida o texto de cancelou
        wait.until(ExpectedConditions.visibilityOfElementLocated(msg));
        assertEquals("Olá: Teste", driver.findElement(msg).getText());

    }

}
