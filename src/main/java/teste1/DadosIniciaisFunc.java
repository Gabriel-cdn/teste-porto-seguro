package teste1;

import base.Util;

import static base.OperadorDriver.acessarUrl;
import static base.OperadorDriver.getDriver;

public class DadosIniciaisFunc {

    public final String urlCelular = "https://loja.portoseguro.com.br/porto-seguro-celular/dados-iniciais.html";

    public static final String campoCep = "CEP";
    public static final String campoCpf = "CPF";
    public static final String campoNome = "Nome";
    public static final String campoCelular = "Celular";
    public static final String campoEmail = "Email";
    public static final String campoModelo = "Digite a marca e o modelo do seu celular";
    public static final String campoTempoUso = "Tempo de uso do seu aparelho";

    public void abrirPaginaDeTeste() throws Exception {
        acessarUrl(urlCelular);
        new DadosIniciaisTela(getDriver())
                .aceitarCookies();
    }

    public void validarPreenchimentoCampoTextoSucesso(String nomeCampo, String texto) throws Exception {
        new DadosIniciaisTela(getDriver())
                .preencherCampo(nomeCampo, texto)
                .tirarFocoElemento()
                .aguardarCarregamentoCampo(nomeCampo)
                .verificarSemMensagemErro(nomeCampo)
                .verificarValorCampo(nomeCampo, formatarCampo(nomeCampo, texto));
    }

    public void validarPreenchimentoCampoTextoFalha(String nomeCampo, String texto, String mensagemErro) throws Exception {
        new DadosIniciaisTela(getDriver())
                .preencherCampo(nomeCampo, texto)
                .tirarFocoElemento()
                .aguardarCarregamentoCampo(nomeCampo)
                .verificarComMensagemErro(nomeCampo, mensagemErro)
                .verificarValorCampo(nomeCampo, formatarCampo(nomeCampo, texto));
    }

    private String formatarCampo(String nomeCampo, String texto) {
        switch (nomeCampo) {
            case campoCep:
                return Util.formatCep(texto);
            case campoCpf:
                return Util.formatCpf(texto);
            case campoCelular:
                return Util.formatCelular(texto);
            default:
                return texto;
        }
    }

    public void validarPreenchimentoCampoCepSucesso(String cep) throws Exception {
        validarPreenchimentoCampoTextoSucesso(campoCep, cep);
    }

    public void validarPreenchimentoCampoCepFalha(String cep, String mensagemErro) throws Exception {
        validarPreenchimentoCampoTextoFalha(campoCep, cep, mensagemErro);
    }

    public void validarPreenchimentoCampoCpfSucesso(String cpf) throws Exception {
        validarPreenchimentoCampoTextoSucesso(campoCpf, cpf);
    }

    public void validarPreenchimentoCampoCpfFalha(String cpf, String mensagemErro) throws Exception {
        validarPreenchimentoCampoTextoFalha(campoCpf, cpf, mensagemErro);
    }

    public void validarPreenchimentoCampoNomeSucesso(String nome) throws Exception {
        validarPreenchimentoCampoTextoSucesso(campoNome, nome);
    }

    public void validarPreenchimentoCampoNomeFalha(String nome, String mensagemErro) throws Exception {
        validarPreenchimentoCampoTextoFalha(campoNome, nome, mensagemErro);
    }

    public void validarPreenchimentoCampoCelularSucesso(String celular) throws Exception {
        validarPreenchimentoCampoTextoSucesso(campoCelular, celular);
    }

    public void validarPreenchimentoCampoCelularFalha(String celular, String mensagemErro) throws Exception {
        validarPreenchimentoCampoTextoFalha(campoCelular, celular, mensagemErro);
    }

    public void validarPreenchimentoCampoEmailSucesso(String email) throws Exception {
        validarPreenchimentoCampoTextoSucesso(campoEmail, email);
    }

    public void validarPreenchimentoCampoEmailFalha(String email, String mensagemErro) throws Exception {
        validarPreenchimentoCampoTextoFalha(campoEmail, email, mensagemErro);
    }

    public void validarPreenchimentoCampoModeloSucesso(String modelo) throws Exception {
        validarPreenchimentoCampoTextoSucesso(campoModelo, modelo);
    }

    public void validarPreenchimentoCampoModeloFalha(String modelo, String mensagemErro) throws Exception {
        validarPreenchimentoCampoTextoFalha(campoModelo, modelo, mensagemErro);
    }

    public void validarPreenchimentoCampoTempoUsoSucesso(String tempoUso) throws Exception {
        new DadosIniciaisTela(getDriver())
                .clicarTempoUso(tempoUso)
                .verificarTempoUsoSelecionado(tempoUso);
    }

    public void validarPreenchimentoCampoTempoUsoFalha(String mensagemErro) throws Exception {
        new DadosIniciaisTela(getDriver())
                .clicarBotaoProximoPasso()
                .verificarMensagemErroTempoUso(mensagemErro);
    }

}
