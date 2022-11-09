package teste3.telas;

import base.Logger;
import base.TelaBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutTela extends TelaBase {

    private String xpathTotal = "//*[contains(@class,'totalValue')]";

    public CheckoutTela(WebDriver driver) {
        super(driver);
    }

    public CheckoutTela veririficarSomaTotalProdutos(double valorUnitario) throws Exception {
        Logger.logarPasso("Verificando soma total de produtos");
        String total = retornarElemento(new By.ByXPath(xpathTotal)).getText();
        Assert.assertEquals("$" + valorUnitario * 2, total);
        return this;
    }
}
