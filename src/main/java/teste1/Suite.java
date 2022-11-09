package teste1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.OperadorDriver;

import static teste1.DadosIniciaisTela.TEMPO_USO_MAIOR;
import static teste1.DadosIniciaisTela.TEMPO_USO_MENOR;

public class Suite {

    DadosIniciaisFunc dadosIniciaisFunc = new DadosIniciaisFunc();

    @Test
    void testeCep() throws Exception {
        dadosIniciaisFunc.abrirPaginaDeTeste();
        dadosIniciaisFunc.validarPreenchimentoCampoCepFalha("11", "Informe no m�nimo 8 caracteres");
        dadosIniciaisFunc.validarPreenchimentoCampoCepFalha("00000000", "CEP inv�lido");
        dadosIniciaisFunc.validarPreenchimentoCampoCepSucesso("01153000");
    }

    @Test
    void testeCpf() throws Exception {
        dadosIniciaisFunc.abrirPaginaDeTeste();
        dadosIniciaisFunc.validarPreenchimentoCampoCpfFalha("0123", "CPF inv�lido");
        dadosIniciaisFunc.validarPreenchimentoCampoCpfFalha("00000000000", "CPF inv�lido");
        dadosIniciaisFunc.validarPreenchimentoCampoCpfSucesso("88588228033");
    }

    @Test
    void testeNome() throws Exception {
        dadosIniciaisFunc.abrirPaginaDeTeste();
        dadosIniciaisFunc.validarPreenchimentoCampoNomeFalha("Porto", "Por favor, informe o nome e sobrenome");
        dadosIniciaisFunc.validarPreenchimentoCampoNomeFalha("", "Preenchimento obrigat�rio");
        dadosIniciaisFunc.validarPreenchimentoCampoNomeSucesso("Porto Seguro");
    }

    @Test
    void testeCelular() throws Exception {
        dadosIniciaisFunc.abrirPaginaDeTeste();
        dadosIniciaisFunc.validarPreenchimentoCampoCelularFalha("436233", "N�mero de celular inv�lido");
        dadosIniciaisFunc.validarPreenchimentoCampoCelularFalha("92839299999", "Telefone inv�lido");
        dadosIniciaisFunc.validarPreenchimentoCampoCelularSucesso("11968868077");
    }

    @Test
    void testeEmail() throws Exception {
        dadosIniciaisFunc.abrirPaginaDeTeste();
        dadosIniciaisFunc.validarPreenchimentoCampoEmailFalha("suporte", "Email inv�lido");
        dadosIniciaisFunc.validarPreenchimentoCampoEmailFalha("suporte@portoseguro", "Email inv�lido.");
        dadosIniciaisFunc.validarPreenchimentoCampoEmailSucesso("suporte@portoseguro.com");
    }

    @Test
    void testeModelo() throws Exception {
        dadosIniciaisFunc.abrirPaginaDeTeste();
        dadosIniciaisFunc.validarPreenchimentoCampoModeloFalha("", "Preenchimento obrigat�rio");
        dadosIniciaisFunc.validarPreenchimentoCampoModeloSucesso("Redmi");
    }

    @Test
    void testeTempoUso() throws Exception {
        dadosIniciaisFunc.abrirPaginaDeTeste();
        dadosIniciaisFunc.validarPreenchimentoCampoTempoUsoFalha("Preenchimento obrigat�rio");
        dadosIniciaisFunc.validarPreenchimentoCampoTempoUsoSucesso(TEMPO_USO_MENOR);
        dadosIniciaisFunc.validarPreenchimentoCampoTempoUsoSucesso(TEMPO_USO_MAIOR);
    }

    @BeforeClass
    void before() {
        OperadorDriver.startDriver();
    }

    @AfterClass
    void after() {
        OperadorDriver.quitDriver();
    }
}