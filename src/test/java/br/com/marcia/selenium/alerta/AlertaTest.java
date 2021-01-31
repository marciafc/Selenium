package br.com.marcia.selenium.alerta;

import br.com.marcia.selenium.util.PathUtils;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class AlertaTest {

    @Test
    public void testeAlertaLoginInvalido() {

        System.setProperty("webdriver.chrome.driver", PathUtils.CHROME_DRIVER);

        WebDriver driver = new ChromeDriver();

        //driver.get("http://bootcamp-selenium.matera.com/html/alert_confirmation.html");
        driver.get(PathUtils.URL + "alert_confirmation.html");

        driver.findElement(By.id("user")).sendKeys("admin");
        driver.findElement(By.id("submit")).click();

        Alert alerta = driver.switchTo().alert();
        assertEquals("Preencha os dois campos!!!", alerta.getText());
        alerta.accept();

        driver.quit();
    }

}
