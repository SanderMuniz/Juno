package com.sandev.juno.ui.adapter;

import android.content.Context;

import com.sandev.juno.data.model.Termo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ListaTermoAdapterTest {
    @Mock
    Context context;
    @Spy
    ListaTermoAdapter adapter = new ListaTermoAdapter(context);

    @Test
    public void deve_AtualizarListaDeTermos_QuandoReceberTermos() {

        doNothing().when(adapter).atualizaLista();

        adapter.atualiza(new ArrayList<>(Arrays.asList(
                new Termo(1, "StringID", "MVP_TESTE_JUNO",
                        "Teste caso de uso", "Teste de exemplo", 2.5),
                new Termo(2, "idString", "MVP_TESTE",
                        "Teste caso de uso", "Teste de exemplo", 2.5)
        )));

        int quantidadeTermosDevolvidos = adapter.getItemCount();

        verify(adapter).atualizaLista();
        assertThat(quantidadeTermosDevolvidos, is(2));
    }
}