package com.sandev.juno.ui.lista;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sandev.juno.R;
import com.sandev.juno.data.model.Termo;
import com.sandev.juno.ui.adapter.TermoAdapter;
import com.sandev.juno.ui.adapter.listener.RecyclerItemClickListener;
import com.sandev.juno.ui.detalhe.DetalheTermoActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static com.sandev.juno.utils.Utils.hideKeyboard;

public class ListaTermosActivity extends AppCompatActivity implements ListaTermosContract.view {

    public static final String CHAVE_INTENT = "termo";
    private static final String TAG_RESULTADO = "Resultados: ";
    private TextView termoBusca;
    private TextView qtdResultado;
    private ProgressBar progressBar;
    private TextView buscar;
    private RecyclerView recycler;
    private ListaTermosContract.presenter mPresenter;
    private List<Termo> mList;
    private Termo termSelect;
    private TermoAdapter adapter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_termos_layout);
        iniciaView();
        configuraCliqueRecycler();
        configuraBotaoBuscar();
    }

    private void configuraBotaoBuscar() {
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String termo = termoBusca.getText().toString().trim().toLowerCase();
                Log.i("teste", "buscar:  activity");
                if (!TextUtils.isEmpty(termo)) {
                    hideKeyboard(ListaTermosActivity.this);
                    progressBar.setVisibility(View.VISIBLE);
                    mPresenter.buscar(termo, ListaTermosActivity.this);
                } else {
                    Toast.makeText(ListaTermosActivity.this, "Necessário informar algum termo!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void iniciaView() {
        recycler = findViewById(R.id.recycler_view);
        termoBusca = findViewById(R.id.activity_texto_buscar);
        qtdResultado = findViewById(R.id.activity_lista_resultados);
        buscar = findViewById(R.id.activity_buscar);
        progressBar = findViewById(R.id.progress_bar);
    }

    private void configuraCliqueRecycler() {
        recycler.addOnItemTouchListener(new RecyclerItemClickListener(
                this,
                recycler,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        termSelect = mList.get(position);
                        Intent i = new Intent(ListaTermosActivity.this, DetalheTermoActivity.class);
                        i.putExtra(CHAVE_INTENT, termSelect);
                        startActivity(i);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                }
        ));
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mPresenter == null) mPresenter = new ListaTermosPresenter();
        mPresenter.setView(this);
    }

    @Override
    public void retornaLista(List<Termo> list) {
        mList = list;
        if (list.size() < 1) {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(this, "Nenhum resultado encontrado", Toast.LENGTH_SHORT).show();
        } else {
            qtdResultado.setText(TAG_RESULTADO + list.size());
            progressBar.setVisibility(View.GONE);
            LinearLayoutManager layoutManager
                    = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            recycler.setLayoutManager(layoutManager);
            adapter = new TermoAdapter(this, new ArrayList<>(list));
            recycler.setAdapter(adapter);
        }
    }

}
