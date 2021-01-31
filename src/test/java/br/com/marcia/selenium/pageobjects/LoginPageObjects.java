package br.com.marcia.selenium.pageobjects;

import br.com.marcia.selenium.util.PathUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageObjects {

    private WebDriver driver;

    private WebDriverWait wait;

    private static final By USERNAME_FIELD = By.id("username");

    private static final By PASSWORD_FIELD = By.id("password");

    private static final By LOGIN_BUTTON = By.id("login");

    private static final By ERROR_MESSAGE = By.cssSelector(".error");

    private static final By SUCCESS_MESSAGE = By.cssSelector(".success");

    public LoginPageObjects(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));;
    }

    public void acessaTelaLogin(){
        driver.get("http://bootcamp-selenium.matera.com/html/ajax_loading.html");

        // Para rodar local (ajustar php)
        //driver.get(PathUtils.URL + "ajax_loading.html");
    }

    public void preencherUsuario(String usuario) {
        driver.findElement(USERNAME_FIELD).sendKeys(usuario);
    }

    public void preencherSenha(String senha) {
        driver.findElement(PASSWORD_FIELD).sendKeys(senha);
    }

    public void clicarLogin() {
        driver.findElement(LOGIN_BUTTON).click();
    }

    public String capturarMensagemErro() {
        wait.until(ExpectedConditions.presenceOfElementLocated(ERROR_MESSAGE));
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    public String capturarMensagemSucesso() {
        wait.until(ExpectedConditions.presenceOfElementLocated(SUCCESS_MESSAGE));
        return driver.findElement(SUCCESS_MESSAGE).getText();
    }

}
