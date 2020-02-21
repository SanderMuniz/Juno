package com.sandev.juno.ui.lista;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sandev.juno.R;
import com.sandev.juno.data.model.Termo;
import com.sandev.juno.ui.adapter.ListaTermoAdapter;
import com.sandev.juno.ui.detalhe.DetalheTermoActivity;

import java.util.List;

import static com.sandev.juno.utils.Utils.hideKeyboard;

public class ListaTermosActivity extends AppCompatActivity implements ListaTermosContract.view {

    public static final String CHAVE_INTENT = "termo";
    private TextView termoBusca;
    private TextView qtdResultado;
    private ProgressBar progressBar;
    private TextView buscar;
    private ListaTermosContract.presenter mPresenter;
    private ListaTermoAdapter adapter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_termos_layout);
        iniciaView();
        configuraBotaoBuscar();
        configuraListaTermos();
    }

    private void configuraListaTermos() {
        configuraAdapter();
        configuraRecyclerView();
    }

    @Override
    public void informaUI(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
    }

    private void configuraBotaoBuscar() {
        buscar.setOnClickListener(view -> {
            validaCampoDigitarTermo();
        });
    }

    private void validaCampoDigitarTermo() {
        String termo = termoBusca.getText().toString().trim().toLowerCase();
        if (diferenteDeVazio(termo)) {
            hideKeyboard(this);
            alteraExibicaoProgressBar(View.VISIBLE);
            realizaBuscaDoTermo(termo);
        } else {
            informaUI("Necessário informar algum termo!");
        }
    }

    private boolean diferenteDeVazio(String termo) {
        return !TextUtils.isEmpty(termo);
    }

    private void realizaBuscaDoTermo(String termo) {
        mPresenter.buscar(termo, ListaTermosActivity.this);
    }

    private void alteraExibicaoProgressBar(int visible) {
        progressBar.setVisibility(visible);
    }

    private void iniciaView() {
        termoBusca = findViewById(R.id.activity_texto_buscar);
        qtdResultado = findViewById(R.id.activity_lista_resultados);
        buscar = findViewById(R.id.activity_buscar);
        progressBar = findViewById(R.id.progress_bar);
    }


    private void enviaTermoPelaIntent(Termo termo) {
        Intent i = new Intent(ListaTermosActivity.this, DetalheTermoActivity.class);
        i.putExtra(CHAVE_INTENT, termo);
        startActivity(i);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mPresenter == null) mPresenter = new ListaTermosPresenter();
        mPresenter.setView(this);
    }

    @Override
    public void retornaLista(List<Termo> list) {
        validaItensRetornados(list);
    }

    private void validaItensRetornados(List<Termo> termos) {
        if (termos.size() < 1) {
            alteraExibicaoProgressBar(View.GONE);
            informaUI("Nenhum resultado encontrado");
        } else {
            contaItensDaListaInformaUsuario(termos);
            alteraExibicaoProgressBar(View.GONE);
            adapter.atualiza(termos);
        }
    }

    private void configuraRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void configuraAdapter() {
        adapter = new ListaTermoAdapter(this);
        adapter.setOnItemClickListener(termo -> enviaTermoPelaIntent(termo));
    }

    private void contaItensDaListaInformaUsuario(List<Termo> list) {
        qtdResultado.setText(getString(R.string.txt_item_resultado) + list.size());
    }

}
