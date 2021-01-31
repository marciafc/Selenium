package br.com.marcia.selenium.interrogacao;

import br.com.marcia.selenium.util.PathUtils;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathTest {

    private WebDriver driver;

    @Test
    public void testeXpathBasico() {

        System.setProperty("webdriver.chrome.driver", PathUtils.CHROME_DRIVER);

        driver = new ChromeDriver();

        driver.get(PathUtils.URL + "find_elements.html");

        WebElement divPai = driver.findElement(By.xpath("//div[@class='divpai border']"));
        WebElement divFilho = driver.findElement(By.xpath("//div[@class='divfilho border']"));
        WebElement divNeto2 = driver.findElement(By.xpath("//div[@class='divneto border'][2]"));
        WebElement dataInicioRelatorio = driver.findElement(By.xpath("//input[@id='dataInicio']"));

    }

    @After
    public void after() {
        driver.quit();
    }

}
