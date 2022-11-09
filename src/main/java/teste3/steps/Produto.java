package teste3.steps;

import base.OperadorDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import teste3.telas.CarrinhoTela;
import teste3.telas.CheckoutTela;
import teste3.telas.InicioTela;
import teste3.telas.ProdutoTela;

import static base.OperadorDriver.getDriver;

public class Produto {
    @Given("inicio cenario")
    public void inicioCenario() {
        OperadorDriver.startDriver();
    }

    @And("finaliza cenario")
    public void finalizaCenario() {
        OperadorDriver.quitDriver();
    }

    @And("acessa ao site principal")
    public void acessaAoSitePrincipal() {
        new InicioTela(getDriver())
                .acessarUrl();
    }

    @And("clica no menu {string}")
    public void clicaNoMenu(String opcao) {
        new InicioTela(getDriver())
                .clicarMenu(opcao);
    }

    @When("clica no botao {string}")
    public void clicaNoBotao(String botaoTexto) {
        new InicioTela(getDriver())
                .clicarBotao(botaoTexto);
    }

    @Then("as especificacoes do produto devem estar de acordo com as informacoes retornadas do banco de automacao")
    public void asEspecificacoesDoProdutoDevemEstarDeAcordoComAsInformacoesRetornadasDoBancoDeAutomacao() {
        //TODO recuperar dados
        new ProdutoTela(getDriver())
                .verificarInformacoesProduto();
    }

    @And("altera a cor do produto de acordo com a cor informada no banco de automacao")
    public void alteraACorDoProdutoDeAcordoComACorInformadaNoBancoDeAutomacao() {
        //TODO pegar cor do produto
        new ProdutoTela(getDriver())
                .clicarCorProduto("cor");
        //TODO salvar cor escolhida
    }

    @Then("o produto deve ser adicionado ao carrinho com a cor selecionada")
    public void oProdutoDeveSerAdicionadoAoCarrinhoComACorSelecionada() {
        //TODO recuperar cor escolhida
        new ProdutoTela(getDriver())
                .verificarCorProdutoPopupCarrinho("cor");
    }

    @And("pesquisa o nome do produto do banco de automacao clicando no icone de lupa")
    public void pesquisaONomeDoProdutoDoBancoDeAutomacaoClicandoNoiconeDeLupa() {
        //TODO pegar nome produto banco de automacao
        new InicioTela(getDriver())
                .clicarIconeLupa()
                .escreverCampoBusca("pesquisa");
    }

    @And("selecionar produto pesquisado")
    public void selecionarProdutoPesquisado() {
        //TODO pegar nome produto banco de automacao
        new InicioTela(getDriver())
                .clicarProdutoPesquisado("produto");
    }

    @And("altera a cor do produto para uma diferente da existente no banco de automacao")
    public void alteraACorDoProdutoParaUmaDiferenteDaExistenteNoBancoDeAutomacao() {
        //TODO pegar cor do produto
        //TODO pegar cor diferente
        new ProdutoTela(getDriver())
                .clicarCorProduto("cor");
        //TODO salvar cor escolhida
    }

    @And("altera a quantidade de produtos que deseja comprar")
    public void alteraAQuantidadeDeProdutosQueDesejaComprar() {
        new ProdutoTela(getDriver())
                .clicarAdicionarQuantidade();
    }

    @When("acessa a pagina de checkout")
    public void acessaAPaginaDeCheckout() {
        new ProdutoTela(getDriver())
                .clicarBotaoCheckout();
    }

    @Then("a soma dos precos deve corresponder ao total apresentado na pagina de checkout")
    public void aSomaDosPrecosDeveCorresponderAoTotalApresentadoNaPaginaDeCheckout() {
    }

    @And("realiza um update no banco de automacao alterando a cor existente no banco para a cor selecionada no teste")
    public void realizaUmUpdateNoBancoDeAutomacaoAlterandoACorExistenteNoBancoParaACorSelecionadaNoTeste() {
        new CheckoutTela(getDriver())
                .veririficarSomaTotalProdutos();
    }

    @And("clica no carrinho de compras")
    public void clicaNoCarrinhoDeCompras() {
        new InicioTela(getDriver())
                .clicarIconeCarrinho();
    }

    @When("remove produto do carrinho de compras")
    public void removeProdutoDoCarrinhoDeCompras() {
        new CarrinhoTela(getDriver())
                .clicarBotaoRemover();
    }

    @Then("o carrinho de compras deve estar vazio")
    public void oCarrinhoDeComprasDeveEstarVazio() {
        new CarrinhoTela(getDriver())
                .verificarCarrinhoVazio();
    }


}
