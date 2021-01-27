package br.com.marcia.selenium.manipulacao;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class ManipulacaoTest {

    @Test
    public void testeManipulacao() {

        System.setProperty("webdriver.chrome.driver", "/home/marcia-castagna/chromedriver/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("http://bootcamp-selenium.matera.com/html/elementos_html.html");

        driver.findElement(By.id("name1")).sendKeys("João");
        driver.findElement(By.id("name2")).sendKeys("dos Santos");
        driver.findElement(By.cssSelector("input[value='Homem']")).click();

        driver.findElement(By.id("value1")).click();
        driver.findElement(By.id("value2")).click();
        driver.findElement(By.id("value3")).click();

        WebElement txtArea = driver.findElement(By.id("txtarea"));
        txtArea.clear();
        txtArea.sendKeys("Churrasco");

        Select selectEducacao = new Select(driver.findElement(By.name("education")));
        selectEducacao.selectByValue("graduado");

        Select selectMelhorParteDia = new Select(driver.findElement(By.id("dia")));
        selectMelhorParteDia.selectByVisibleText("Manhã");
        selectMelhorParteDia.selectByVisibleText("Noite");

        driver.findElement(By.name("send")).click();

        assertEquals("Olá, João dos Santos", driver.findElement(By.id("nome")).getText());
        assertEquals("Você é Homem", driver.findElement(By.id("sexo")).getText());
        assertEquals("E você gosta de: Carne Frango Pizza", driver.findElement(By.id("comida")).getText());
        assertEquals("Você também gosta de: Churrasco", driver.findElement(By.id("outra_comida")).getText());
        assertEquals("Sua parte favorita do dia é: Manha Noite", driver.findElement(By.id("parte_favorita")).getText());
        assertEquals("Seu grau de instrução é: Graduado", driver.findElement(By.id("instrucao")).getText());

        driver.quit();
    }

}
