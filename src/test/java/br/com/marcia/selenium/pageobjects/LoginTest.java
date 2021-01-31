package br.com.marcia.selenium.pageobjects;

import br.com.marcia.selenium.util.PathUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class LoginTest {

    private WebDriver driver;

    private LoginPageObjects loginPageObjects;

    @Before
    public void before() {

        System.setProperty("webdriver.chrome.driver", PathUtils.CHROME_DRIVER);

        driver = new ChromeDriver();

        loginPageObjects = new LoginPageObjects(driver);
        loginPageObjects.acessaTelaLogin();
    }

    @After
    public void after() {
        driver.quit();
    }

    @Test
    public void testeLoginInvalido() {

        loginPageObjects.preencherUsuario("demo");
        loginPageObjects.preencherSenha("123456");
        loginPageObjects.clicarLogin();

        assertEquals("Usuario ou senhas invalidos.", loginPageObjects.capturarMensagemErro());
    }

    @Test
    public void testeLoginValido() {

        loginPageObjects.preencherUsuario("demo");
        loginPageObjects.preencherSenha("demo");
        loginPageObjects.clicarLogin();

        assertEquals("Voce efetuou o login com sucesso!", loginPageObjects.capturarMensagemSucesso());
    }

}
