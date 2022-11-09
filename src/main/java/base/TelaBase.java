package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TelaBase {

    protected WebDriver driver;

    protected TelaBase(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement retornarElemento(By localizador) throws Exception {
        return retornarElemento(localizador, 30);
    }

    protected WebElement retornarElemento(By localizador, int timeout) throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.presenceOfElementLocated(localizador));
        } catch (Exception e) {
            throw new Exception(String.format("Não foi possível encontrar elemento %s", localizador), e);
        }
    }

    protected boolean esperarElementoDesaparecer(WebElement localizador) throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            return wait.until(ExpectedConditions.invisibilityOf(localizador));
        } catch (Exception ignore) {
            return true;
        }
    }

    protected void digitarTexto(WebElement elemento, String texto) throws Exception {
        try {
            elemento.sendKeys(texto);
        } catch (Exception e) {
            throw new Exception(String.format("Não foi possível digitar texto %s", texto), e);
        }
    }

    protected void apagarCampo(WebElement elemento) throws Exception {
        try {
            elemento.sendKeys(Keys.CONTROL + "a");
            elemento.sendKeys(Keys.DELETE);
        } catch (Exception e) {
            throw new Exception("Não foi possível apagar campo", e);
        }
    }

    protected void tocarElemento(WebElement elemento) throws Exception {
        try {
            elemento.click();
        } catch (Exception e) {
            throw new Exception("Não foi possível clicar no elemento", e);
        }
    }
}
