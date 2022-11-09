package teste3.telas;

import base.Logger;
import base.TelaBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import teste3.database.Produto;

import java.util.Arrays;
import java.util.List;

public class ProdutoTela extends TelaBase {

    public static List<String> CORES_DIPONIVEIS = Arrays.asList("BLUE", "BLACK", "GRAY", "PURPLE", "RED", "YELLOW");

    String xpathName = "//*[@id='Description']//h1";
    String xpathCustomization = "//label[text()='CUSTOMIZATION']/following-sibling::*";
    String xpathDisplay = "//label[text()='DISPLAY']/following-sibling::*";
    String xpathDisplayResolution = "//label[text()='DISPLAY RESOLUTION']/following-sibling::*";
    String xpathDisplaySize = "//label[text()='DISPLAY SIZE']/following-sibling::*";
    String xpathMemory = "//label[text()='MEMORY']/following-sibling::*";
    String xpathOperatingSystem = "//label[text()='OPERATING SYSTEM']/following-sibling::*";
    String xpathProcessor = "//label[text()='PROCESSOR']/following-sibling::*";
    String xpathTouchscreen = "//label[text()='TOUCHSCREEN']/following-sibling::*";
    String xpathWeight = "//label[text()='WEIGHT']/following-sibling::*";
    String xpathColor = "//*[@id='bunny' and @title='%s']";

    String xpathColorCarrinho = "//tool-tip-cart//span[@class='ng-binding' and text()='%s']";
    String xpathAdicionarQuantidade = "//*[@class='plus']";
    String xpathBotaoCheckoutPopup = "//tool-tip-cart[contains(@style,'display: block; height')]//*[@id='checkOutPopUp']";
    String xpathValorProduto = "//*[@id='Description']//h2";

    public ProdutoTela(WebDriver driver) {
        super(driver);
    }

    public ProdutoTela verificarInformacoesProduto(Produto produto) throws Exception {
        Logger.logarPasso("Verificando informações produto");
        String name = retornarElemento(new By.ByXPath(xpathName)).getText();
        String customization = retornarElemento(new By.ByXPath(xpathCustomization)).getText();
        String display = retornarElemento(new By.ByXPath(xpathDisplay)).getText();
        String displayResolution = retornarElemento(new By.ByXPath(xpathDisplayResolution)).getText();
        String displaySize = retornarElemento(new By.ByXPath(xpathDisplaySize)).getText();
        String memory = retornarElemento(new By.ByXPath(xpathMemory)).getText();
        String operatingSystem = retornarElemento(new By.ByXPath(xpathOperatingSystem)).getText();
        String processor = retornarElemento(new By.ByXPath(xpathProcessor)).getText();
        String touchscreen = retornarElemento(new By.ByXPath(xpathTouchscreen)).getText();
        String weight = retornarElemento(new By.ByXPath(xpathWeight)).getText();

        Assert.assertEquals(produto.getName(), name);
        Assert.assertEquals(produto.getCustomization(), customization);
        Assert.assertEquals(produto.getDisplay(), display);
        Assert.assertEquals(produto.getDisplayResolution(), displayResolution);
        Assert.assertEquals(produto.getDisplaySize(), displaySize);
        Assert.assertEquals(produto.getMemory(), memory);
        Assert.assertEquals(produto.getOperatingSystem(), operatingSystem);
        Assert.assertEquals(produto.getProcessor(), processor);
        Assert.assertEquals(produto.getTouchscreen(), touchscreen);
        Assert.assertEquals(produto.getWeight(), weight);
        return this;
    }

    public ProdutoTela clicarCorProduto(String cor) throws Exception {
        Logger.logarPasso(String.format("Clicando cor '%s'", cor));
        clicarElemento(retornarElemento(new By.ByXPath(String.format(xpathColor, cor))));
        return this;
    }

    public ProdutoTela verificarCorProdutoPopupCarrinho(String cor) throws Exception {
        Logger.logarPasso(String.format("Verificando no carrinho a cor '%s'", cor));
        retornarElemento(new By.ByXPath(String.format(xpathColorCarrinho, cor)));
        return this;
    }

    public ProdutoTela clicarAdicionarQuantidade() throws Exception {
        Logger.logarPasso("Clicando no botão adicionar quantidade");
        clicarElemento(retornarElemento(new By.ByXPath(xpathAdicionarQuantidade)));
        return this;
    }

    public double recuperarValorProduto() throws Exception {
        Logger.logarPasso("Recuperando valor produto");
        String valor = retornarElemento(new By.ByXPath(xpathValorProduto)).getText();
        valor = valor.replace(" ", "")
                .replace("\n", "")
                .replace("$", "");
        return Double.parseDouble(valor);
    }
}
