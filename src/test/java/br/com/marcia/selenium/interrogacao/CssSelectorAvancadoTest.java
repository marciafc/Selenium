package br.com.marcia.selenium.interrogacao;

import br.com.marcia.selenium.util.PathUtils;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelectorAvancadoTest {

    private WebDriver driver;

    @Test
    public void testeCssAvancado() {

        System.setProperty("webdriver.chrome.driver", PathUtils.CHROME_DRIVER);

        driver = new ChromeDriver();

        driver.get(PathUtils.URL + "css_xpath.html");

        WebElement email = driver.findElement(By.cssSelector("input[id^='name-']"));
        WebElement senha = driver.findElement(By.cssSelector("input[id$='-password']"));
        WebElement repetirSenha = driver.findElement(By.cssSelector("input[id*='-password-']"));
        WebElement cadastrar = driver.findElement(By.cssSelector("input[id*='send']"));

    }

    @After
    public void after() {
        driver.quit();
    }

}
