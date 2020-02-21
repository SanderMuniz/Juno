package com.sandev.juno.data.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class TermoTest {

    private final Termo TERMO = new Termo(1, "StringID", "MVP_TESTE_JUNO",
            "Teste caso de uso", "Teste de exemplo", 2.5);

    @Test
    public void deve_DevolverIdDoBanco_QuandoRecebeIdDoBanco() {
        int idDoBancoRetornado = TERMO.get_id();
        assertEquals(1, idDoBancoRetornado);
    }

    @Test
    public void deve_DevolverIdWs_QuandoReceberIdWS(){
        String idRetornado = TERMO.getId();
        assertEquals("StringID", idRetornado);
    }

    @Test
    public void deve_DevolverNome_QuandoReceberNome() {
        String nameRetornado = TERMO.getName();
        assertEquals("MVP_TESTE_JUNO", nameRetornado);
    }

    @Test
    public void deve_DevolverNomeCompleto_QuandoReceberNomeCompleto() {
        String fullNameRetornado = TERMO.getFull_name();
        assertEquals("Teste caso de uso", fullNameRetornado);
    }

    @Test
    public void deve_DevolverDescricao_QuandoReceberDescricao() {
        String descricaoRetornada = TERMO.getDescription();
        assertEquals("Teste de exemplo", descricaoRetornada);
    }

    @Test
    public void deve_DevolverPontuacao_QuantoReceberPontuacao(){
        double scoreRetornado = TERMO.getScore();
        assertEquals(2.5, scoreRetornado, 0.0001);
    }

    @Test
    public void deve_DevolverPontuacaoAdapatada_QuantoReceberPontuacaoAdaptada() {
        String scoreAdaptadoRetornado = TERMO.getScoreAdaptado();
        assertEquals("Score: 2.5", scoreAdaptadoRetornado);
    }
}