package com.sandev.juno.ui.detalhe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.sandev.juno.R;
import com.sandev.juno.data.model.Termo;

import static com.sandev.juno.ui.lista.ListaTermosActivity.CHAVE_INTENT;

//todo imports
public class DetalheTermoActivity extends AppCompatActivity implements DetalheTermoContract.view {

    private DetalheTermoContract.presenter mPresenter;

    private Termo termo;
    private TextView name;
    private TextView full_name;
    private TextView description;
    private TextView score;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_termo_layout);
        if (mPresenter == null) mPresenter = new DetalheTermoPresenter();
        mPresenter.setView(this);
        //implements code
        iniciaViews();
        preencheCampos();
    }

    private void preencheCampos() {
        Intent dados = getIntent();
        if (dados.hasExtra(CHAVE_INTENT)) {
            termo = (Termo) dados.getSerializableExtra(CHAVE_INTENT);

            name.setText(termo.getName());
            score.setText(String.valueOf(termo.getScore()));
            full_name.setText(termo.getFull_name());
            description.setText(termo.getDescription());

/*            TermDAO dao = JunoDatabase.getInstance(this).getTermDAO();
            Log.i("teste", "salvando... ");

            if(isConnected(this)){
                dao.salvar(term);
            }*/
        }
    }

    private void iniciaViews() {
        name = findViewById(R.id.detail_name);
        full_name = findViewById(R.id.detail_full_name);
        description = findViewById(R.id.detail_description);
        score = findViewById(R.id.detail_score);
    }


}
