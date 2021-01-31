package br.com.marcia.selenium.sincronizacao;

import br.com.marcia.selenium.util.PathUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class EsperaImplicitaTest {

    @Test
    public void testeEsperaImplicita() {

        System.setProperty("webdriver.chrome.driver", PathUtils.CHROME_DRIVER);

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(PathUtils.URL + "ajax_show.html");

        driver.findElement(By.name("nome_aluno")).sendKeys("Aluno 1");
        driver.findElement(By.name("email_aluno")).sendKeys("aluno1@teste.com.br");

        Select combo = new Select(driver.findElement(By.id("idade")));
        combo.selectByValue("13");

        driver.findElement(By.name("nome_pais")).sendKeys("Pai do Aluno 1, Mãe do Aluno 1");
        driver.findElement(By.name("email_pais")).sendKeys("paisaluno1@teste.com.br");

        driver.quit();
    }

}
