package teste1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import base.Logger;
import base.TelaBase;

import static teste1.DadosIniciaisFunc.campoTempoUso;

public class DadosIniciaisTela extends TelaBase {

    public static String TEMPO_USO_MENOR = "Até 1 ano e 6 meses";
    public static String TEMPO_USO_MAIOR = "De 1 ano e 6 meses a 2 anos";

    String xpathCampoGenerico = "//mat-label[contains(text(),'%s')]/../../../input";
    String xpathSpinnerGenerico = "//mat-label[contains(text(),'%s')]/../../../input/../..//mat-spinner";
    String xpathMensagemErroGenerico = "//mat-label[contains(text(),'%s')]/../../../input/../../..//mat-error";
    String xpathMensagemErroTempoUso = "//label[contains(text(),'" + campoTempoUso + "')]/../..//mat-error";
    String xpathAceitarCookies = "//*[text()='Aceitar todos os cookies' and @data-gtm-type='click']";
    String xpathTempoUsoMenorTexto = "//button//*[contains(text(),'" + TEMPO_USO_MENOR + "')]";
    String xpathTempoUsoMaiorTexto = "//button//*[contains(text(),'" + TEMPO_USO_MAIOR + "')]";
    String xpathTempoUsoMenorButton = "//button//*[contains(text(),'" + TEMPO_USO_MENOR + "')]/ancestor::mat-button-toggle";
    String xpathTempoUsoMaiorButton = "//button//*[contains(text(),'" + TEMPO_USO_MAIOR + "')]/ancestor::mat-button-toggle";
    String xpathBotaoProximoPasso = "//*[@data-gtm-name='proximo-passo']";

    public DadosIniciaisTela(WebDriver driver) {
        super(driver);
    }

    public DadosIniciaisTela preencherCampo(String nomeCampo, String texto) throws Exception {
        Logger.logarPasso(String.format("Prenchendo campo %s com '%s'", nomeCampo, texto));
        By campoBy = new By.ByXPath(String.format(xpathCampoGenerico, nomeCampo));
        WebElement campo = retornarElemento(campoBy);
        tocarElemento(campo);
        apagarCampo(campo);
        digitarTexto(campo, texto);
        return this;
    }

    public DadosIniciaisTela aguardarCarregamentoCampo(String nomeCampo) throws Exception {
        Logger.logarPasso(String.format("Aguardando campo '%s'", nomeCampo));
        By spinnerBy = new By.ByXPath(String.format(xpathSpinnerGenerico, nomeCampo));
        try {
            WebElement spinner = driver.findElement(spinnerBy);
            Assert.assertTrue(esperarElementoDesaparecer(spinner));
        } catch (Exception ignore) {
        }
        return this;
    }

    public DadosIniciaisTela verificarSemMensagemErro(String nomeCampo) {
        Logger.logarPasso(String.format("Verificando sucesso preenchimento campo %s", nomeCampo));
        By erroBy = new By.ByXPath(String.format(xpathMensagemErroGenerico, nomeCampo));
        try {
            WebElement erro = retornarElemento(erroBy, 3);
            Assert.assertNull(erro);
        } catch (Exception ignore) {
        }
        return this;
    }

    public DadosIniciaisTela verificarValorCampo(String nomeCampo, String valor) throws Exception {
        Logger.logarPasso(String.format("Verificando valor do campo %s seja '%s'", nomeCampo, valor));
        By campoBy = new By.ByXPath(String.format(xpathCampoGenerico, nomeCampo));
        WebElement campo = retornarElemento(campoBy);
        Assert.assertEquals(valor, campo.getAttribute("value"));
        return this;
    }

    public DadosIniciaisTela verificarComMensagemErro(String nomeCampo, String mensagem) throws Exception {
        Logger.logarPasso(String.format("Verificando campo %s com mensagem de erro '%s'", nomeCampo, mensagem));
        By erroBy = new By.ByXPath(String.format(xpathMensagemErroGenerico, nomeCampo));
        WebElement erro = retornarElemento(erroBy, 3);
        Assert.assertEquals(mensagem, erro.getText());
        return this;
    }

    public DadosIniciaisTela tirarFocoElemento() {
        Logger.logarPasso("Tirando foco do elemento");
        try {
            driver.findElement(new By.ByXPath("//body")).click();
        } catch (Exception ignore) {
        }
        return this;
    }

    public DadosIniciaisTela aceitarCookies() throws Exception {
        Logger.logarPasso("Aceitando cookies");
        try {
            tocarElemento(retornarElemento(new By.ByXPath(xpathAceitarCookies), 5));
        } catch (Exception ignore) {
        }
        return this;
    }

    public DadosIniciaisTela tocarTempoUso(String tempoUso) throws Exception {
        Logger.logarPasso(String.format("Tocando no Tempo de Uso %s", tempoUso));
        String xpath = tempoUso.equals(TEMPO_USO_MENOR) ?
                xpathTempoUsoMenorTexto : xpathTempoUsoMaiorTexto;
        tocarElemento(retornarElemento(new By.ByXPath(xpath)));
        return this;
    }

    public DadosIniciaisTela verificarTempoUsoSelecionado(String tempoUso) throws Exception {
        Logger.logarPasso(String.format("Verificando se tempo de uso '%s' selecionado", tempoUso));
        String xpath = tempoUso.equals(TEMPO_USO_MENOR) ?
                xpathTempoUsoMenorButton : xpathTempoUsoMaiorButton;
        WebElement button = retornarElemento(new By.ByXPath(xpath));
        String classes = button.getAttribute("class");
        Assert.assertTrue(classes.contains("mat-button-toggle-checked"));
        return this;
    }

    public DadosIniciaisTela verificarMensagemErroTempoUso(String mensagem) throws Exception {
        Logger.logarPasso(String.format("Verificando campo 'Tempo de Uso' com mensagem de erro '%s'", mensagem));
        By erroBy = new By.ByXPath(xpathMensagemErroTempoUso);
        WebElement erro = retornarElemento(erroBy, 3);
        Assert.assertEquals(mensagem, erro.getText());
        return this;
    }

    public DadosIniciaisTela tocarBotaoProximoPasso() throws Exception {
        Logger.logarPasso("Tocando botão 'Próximo Passo'");
        By campoBy = new By.ByXPath(xpathBotaoProximoPasso);
        tocarElemento(retornarElemento(campoBy));
        return this;
    }
}
