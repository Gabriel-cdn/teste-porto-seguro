package teste3.telas;

import base.Logger;
import base.TelaBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarrinhoTela extends TelaBase {

    String xpathBotaoCheckout = "//button[contains(text(),'CHECKOUT') and contains(@class,'tami')]";
    String xpathBotaoRemover = "//a[contains(@class,'remove')]";
    String xpathTextoCarrinhoVazio = "//label[contains(text(),'Your shopping cart is empty')]/parent::*[@class='emptyCart']";

    public CarrinhoTela(WebDriver driver) {
        super(driver);
    }

    public CarrinhoTela clicarBotaoRemover() throws Exception {
        Logger.logarPasso("Clicando botão remover");
        clicarElemento(retornarElemento(new By.ByXPath(xpathBotaoRemover)));
        return this;
    }

    public CarrinhoTela verificarCarrinhoVazio() throws Exception {
        Logger.logarPasso("Verificando texto carrinho vazio");
        retornarElemento(new By.ByXPath(xpathTextoCarrinhoVazio));
        return this;
    }

    public CarrinhoTela clicarBotaoCheckout() throws Exception {
        Logger.logarPasso("Clicando botão checkout");
        clicarElemento(retornarElemento(new By.ByXPath(xpathBotaoCheckout)));
        return this;
    }
}
