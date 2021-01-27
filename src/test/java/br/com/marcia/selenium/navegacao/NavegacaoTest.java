package br.com.marcia.selenium.navegacao;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavegacaoTest {

    @Test
    public void testeNavegacao(){

        System.setProperty("webdriver.chrome.driver", "/home/marcia-castagna/chromedriver/chromedriver");

        WebDriver driver = new ChromeDriver();

        final String URL = "http://bootcamp-selenium.matera.com/html/";

        driver.get(URL + "navegacao.html");

        driver.navigate().to(URL + "datahora.html");
        driver.navigate().refresh();
        driver.navigate().back();
        driver.navigate().forward();

    }

}
