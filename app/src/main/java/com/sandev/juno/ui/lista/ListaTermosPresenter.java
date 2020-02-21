package com.sandev.juno.ui.lista;

import android.content.Context;

import com.sandev.juno.data.database.JunoDatabase;
import com.sandev.juno.data.database.dao.TermoDAO;
import com.sandev.juno.data.model.Retorno;
import com.sandev.juno.data.model.Termo;

import java.util.List;

import retrofit.Response;

import static com.sandev.juno.utils.Utils.isConnected;

//todo imports
public class ListaTermosPresenter implements ListaTermosContract.presenter {

    private final ListaTermosCall mCall;
    private ListaTermosContract.view mView;

    public ListaTermosPresenter() {
        mCall = new ListaTermosCall(this);
    }

    @Override
    public void setView(ListaTermosContract.view view) {
        this.mView = view;
    }

    @Override
    public Context getContext() {
        return null;
    }

    @Override
    public void buscar(String termo, Context context) {
        if(isConnected(context)){
            mCall.buscar(termo);
        }else {
            enviaMensagemUI("Sem conexão com internet ! \n Verificando dados off-line");
            buscarNoBanco(termo, context);
        }
    }

    private void enviaMensagemUI(String s) {
        mView.informaUI(s);
    }

    private void buscarNoBanco(String termo, Context context) {
        TermoDAO dao = JunoDatabase.getInstance(context).getTermDAO();
        List<Termo> list = dao.listar(termo);
        validaQuantidadeDeItensNaLista(context, list);
    }

    private void validaQuantidadeDeItensNaLista(Context context, List<Termo> list) {
        if (list.size() < 1){
            enviaMensagemUI("Não foram encontrados registros para o termo buscado. \n Listando os termos gravados no banco.");
            listarTodosTermos(context);
        }else {
            retornaListaParaUI(list);
        }
    }

    private void listarTodosTermos(Context context) {
        TermoDAO dao = JunoDatabase.getInstance(context).getTermDAO();
        List<Termo> list = dao.listarTodos();
        retornaListaParaUI(list);
    }

    private void retornaListaParaUI(List<Termo> list) {
        mView.retornaLista(list);
    }

    @Override
    public void retornaDados(Response response) {
        Retorno retorno = (Retorno) response.body();
        List<Termo> list = retorno.getItems();
        retornaListaParaUI(list);
    }
}
