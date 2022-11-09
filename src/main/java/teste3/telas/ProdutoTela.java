package teste3.telas;

import base.TelaBase;
import org.openqa.selenium.WebDriver;

public class ProdutoTela extends TelaBase {



    public ProdutoTela(WebDriver driver) {
        super(driver);
    }

    public ProdutoTela verificarInformacoesProduto() {
        return this;
    }

    public ProdutoTela clicarCorProduto(String cor) {
        return this;
    }

    public ProdutoTela verificarCorProdutoPopupCarrinho(String cor) {
        return this;
    }

    public ProdutoTela clicarAdicionarQuantidade() {
        return this;
    }

    public ProdutoTela clicarBotaoCheckout() {
        return this;
    }
}
