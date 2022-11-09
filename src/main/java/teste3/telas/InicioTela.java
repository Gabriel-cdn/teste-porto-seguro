package teste3.telas;

import base.Logger;
import base.OperadorDriver;
import base.TelaBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InicioTela extends TelaBase {

    private String url = "https://advantageonlineshopping.com/";

    String xpathMenuOpcaoGenerico = "//*[contains(@class,'menu') and text()='%s']";
    String xpathBotaoGenerico = "//button[text()='%s']";
    String xpathIconeLupa = "//*[@id='search']";
    String xpathIconeCarrinho = "//*[@id='menuCart']";
    String xpathPesquisaInput = "//*[@id='search']//input";
    String xpathProdutoResultado = "//*[@class='searchPopUp']//p[contains(text(),'%s')]";

    public InicioTela(WebDriver driver) {
        super(driver);
    }

    public InicioTela acessarUrl() {
        OperadorDriver.acessarUrl(url);
        return this;
    }

    public InicioTela clicarMenu(String opcao) throws Exception {
        Logger.logarPasso(String.format("Clicando no menu '%s'", opcao));
        clicarElemento(retornarElemento(new By.ByXPath(String.format(xpathMenuOpcaoGenerico, opcao))));
        return this;
    }

    public InicioTela clicarBotao(String botaoTexto) throws Exception {
        Logger.logarPasso(String.format("Clicando no botão '%s'", botaoTexto));
        clicarElemento(retornarElemento(new By.ByXPath(String.format(xpathBotaoGenerico, botaoTexto))));
        return this;
    }

    public InicioTela clicarIconeLupa() throws Exception {
        Logger.logarPasso("Clicando no icone da lupa");
        clicarElemento(retornarElemento(new By.ByXPath(xpathIconeLupa)));
        return this;
    }

    public InicioTela escreverCampoBusca(String pesquisa) throws Exception {
        Logger.logarPasso(String.format("Escrevendo pesquisa '%s'", pesquisa));
        digitarTexto(retornarElemento(new By.ByXPath(xpathPesquisaInput)), pesquisa);
        return this;
    }

    public InicioTela clicarProdutoPesquisado(String produto) throws Exception {
        Logger.logarPasso(String.format("Clicando no produto pesquisado '%s'", produto));
        clicarElemento(retornarElemento(new By.ByXPath(String.format(xpathProdutoResultado, produto))));
        return this;
    }

    public InicioTela clicarIconeCarrinho() throws Exception {
        Logger.logarPasso("Clicando icone Carrinho");
        clicarElemento(retornarElemento(new By.ByXPath(xpathIconeCarrinho)));
        return this;
    }

    public InicioTela esperarScrollAutomatico() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public InicioTela esperarUrlCarregar() {
        try {
            retornarElemento(new By.ByXPath("//article"));
        } catch (Exception ignore) {
        }
        return this;
    }

    public InicioTela esperarCampoSurgir() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public InicioTela esperarPesquisa() {
        try {
            retornarElemento(new By.ByXPath("//*[@id='output' and @class='']"));
        } catch (Exception ignore) {
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public InicioTela esperarCarrinhoPopup() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
}
