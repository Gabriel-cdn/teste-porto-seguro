package teste3.telas;

import base.TelaBase;
import org.openqa.selenium.WebDriver;

public class InicioTela extends TelaBase {



    public InicioTela(WebDriver driver) {
        super(driver);
    }

    public InicioTela acessarUrl() {
        return this;
    }

    public InicioTela clicarMenu(String opcao) {
        return this;
    }

    public InicioTela clicarBotao(String botaoTexto) {
        return this;
    }

    public InicioTela clicarIconeLupa() {
        return this;
    }

    public InicioTela escreverCampoBusca(String pesquisa) {
        return this;
    }

    public InicioTela clicarProdutoPesquisado(String produto) {
        return this;
    }

    public InicioTela clicarIconeCarrinho() {
        return this;
    }
}
