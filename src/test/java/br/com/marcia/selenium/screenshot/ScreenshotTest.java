package br.com.marcia.selenium.screenshot;

import br.com.marcia.selenium.util.PathUtils;
import junit.framework.TestCase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ScreenshotTest {

    @Test
    public void testeScreenshot() throws IOException {

        System.setProperty("webdriver.chrome.driver", PathUtils.CHROME_DRIVER);

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {

            //driver.get("http://bootcamp-selenium.matera.com/html/ajax_show.html");
            driver.get(PathUtils.URL + "ajax_show.html");

            driver.findElement(By.name("nome_aluno")).sendKeys("Aluno 1");
            driver.findElement(By.name("email_aluno")).sendKeys("aluno1@teste.com.br");

            Select combo = new Select(driver.findElement(By.id("idadea")));
            combo.selectByValue("13");

            driver.findElement(By.name("nome_pais")).sendKeys("Pai do Aluno 1, Mãe do Aluno 1");
            driver.findElement(By.name("email_pais")).sendKeys("paisaluno1@teste.com.br");

        } catch (Exception e) {

            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("src/test/resources/evidencias.png"));

            TestCase.fail(e.getMessage());

        } finally {
            driver.quit();
        }
    }

}
