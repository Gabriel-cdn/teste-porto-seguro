package teste3.telas;

import base.TelaBase;
import org.openqa.selenium.WebDriver;

public class CarrinhoTela extends TelaBase {



    public CarrinhoTela(WebDriver driver) {
        super(driver);
    }

    public CarrinhoTela clicarBotaoRemover() {
        return this;
    }

    public CarrinhoTela verificarCarrinhoVazio() {
        return this;
    }
}
