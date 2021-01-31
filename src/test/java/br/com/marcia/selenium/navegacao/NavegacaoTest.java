package br.com.marcia.selenium.navegacao;

import br.com.marcia.selenium.util.PathUtils;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavegacaoTest {

    @Test
    public void testeNavegacao(){

        System.setProperty("webdriver.chrome.driver", PathUtils.CHROME_DRIVER);

        WebDriver driver = new ChromeDriver();

        driver.get(PathUtils.URL + "navegacao.html");

        driver.navigate().to(PathUtils.URL + "datahora.html");
        driver.navigate().refresh();
        driver.navigate().back();
        driver.navigate().forward();

    }

}
