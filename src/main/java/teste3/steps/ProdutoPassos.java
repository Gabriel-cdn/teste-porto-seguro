package teste3.steps;

import base.OperadorDriver;
import base.Util;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import teste3.database.MySQLConnection;
import teste3.database.Produto;
import teste3.telas.CarrinhoTela;
import teste3.telas.CheckoutTela;
import teste3.telas.InicioTela;
import teste3.telas.ProdutoTela;

import java.sql.SQLException;

import static base.OperadorDriver.getDriver;
import static teste3.telas.ProdutoTela.CORES_DIPONIVEIS;

public class ProdutoPassos {
    Produto produto;
    String novaCor;
    double valorUnitario;

    @Before
    public void before() throws SQLException {
        produto = MySQLConnection.recuperarProduto();
        OperadorDriver.startDriver();
    }

    @After
    public void after() {
        OperadorDriver.quitDriver();
    }

    @Given("acessa ao site principal")
    public void acessaAoSitePrincipal() {
        new InicioTela(getDriver())
                .acessarUrl()
                .esperarUrlCarregar();
    }

    @And("clica no menu {string}")
    public void clicaNoMenu(String opcao) throws Exception {
        new InicioTela(getDriver())
                .clicarMenu(opcao)
                .esperarScrollAutomatico();
    }

    @When("clica no botao {string}")
    public void clicaNoBotao(String botaoTexto) throws Exception {
        new InicioTela(getDriver())
                .clicarBotao(botaoTexto)
                .esperarCarrinhoPopup();
    }

    @Then("as especificacoes do produto devem estar de acordo com as informacoes retornadas do banco de automacao")
    public void asEspecificacoesDoProdutoDevemEstarDeAcordoComAsInformacoesRetornadasDoBancoDeAutomacao() throws Exception {
        new ProdutoTela(getDriver())
                .verificarInformacoesProduto(produto);
    }

    @And("altera a cor do produto de acordo com a cor informada no banco de automacao")
    public void alteraACorDoProdutoDeAcordoComACorInformadaNoBancoDeAutomacao() throws Exception {
        new ProdutoTela(getDriver())
                .clicarCorProduto(produto.getColor());
    }

    @Then("o produto deve ser adicionado ao carrinho com a cor selecionada")
    public void oProdutoDeveSerAdicionadoAoCarrinhoComACorSelecionada() throws Exception {
        new ProdutoTela(getDriver())
                .verificarCorProdutoPopupCarrinho(produto.getColor());
    }

    @And("pesquisa o nome do produto do banco de automacao clicando no icone de lupa")
    public void pesquisaONomeDoProdutoDoBancoDeAutomacaoClicandoNoiconeDeLupa() throws Exception {
        new InicioTela(getDriver())
                .clicarIconeLupa()
                .esperarCampoSurgir()
                .escreverCampoBusca(produto.getName())
                .esperarPesquisa();
    }

    @And("selecionar produto pesquisado")
    public void selecionarProdutoPesquisado() throws Exception {
        new InicioTela(getDriver())
                .clicarProdutoPesquisado(produto.getName());
    }

    @And("altera a cor do produto para uma diferente da existente no banco de automacao")
    public void alteraACorDoProdutoParaUmaDiferenteDaExistenteNoBancoDeAutomacao() throws Exception {
        novaCor = Util.randomChoiceNotEquals(produto.getColor(), CORES_DIPONIVEIS);
        new ProdutoTela(getDriver())
                .clicarCorProduto(novaCor);
    }

    @And("altera a quantidade de produtos que deseja comprar")
    public void alteraAQuantidadeDeProdutosQueDesejaComprar() throws Exception {
        valorUnitario = new ProdutoTela(getDriver())
                .recuperarValorProduto();
        new ProdutoTela(getDriver())
                .clicarAdicionarQuantidade();
    }

    @When("acessa a pagina de checkout")
    public void acessaAPaginaDeCheckout() throws Exception {
        new InicioTela(getDriver())
                .clicarIconeCarrinho();
        new CarrinhoTela(getDriver())
                .clicarBotaoCheckout();
    }

    @Then("a soma dos precos deve corresponder ao total apresentado na pagina de checkout")
    public void aSomaDosPrecosDeveCorresponderAoTotalApresentadoNaPaginaDeCheckout() throws Exception {
        new CheckoutTela(getDriver())
                .veririficarSomaTotalProdutos(valorUnitario);
    }

    @And("realiza um update no banco de automacao alterando a cor existente no banco para a cor selecionada no teste")
    public void realizaUmUpdateNoBancoDeAutomacaoAlterandoACorExistenteNoBancoParaACorSelecionadaNoTeste() throws SQLException {
        MySQLConnection.atualizarProdutoCor(novaCor);
    }

    @And("clica no carrinho de compras")
    public void clicaNoCarrinhoDeCompras() throws Exception {
        new InicioTela(getDriver())
                .clicarIconeCarrinho();
    }

    @When("remove produto do carrinho de compras")
    public void removeProdutoDoCarrinhoDeCompras() throws Exception {
        new CarrinhoTela(getDriver())
                .clicarBotaoRemover();
    }

    @Then("o carrinho de compras deve estar vazio")
    public void oCarrinhoDeComprasDeveEstarVazio() throws Exception {
        new CarrinhoTela(getDriver())
                .verificarCarrinhoVazio();
    }


}
