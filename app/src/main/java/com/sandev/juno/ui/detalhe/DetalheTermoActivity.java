package com.sandev.juno.ui.detalhe;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.sandev.juno.R;
import com.sandev.juno.data.database.JunoDatabase;
import com.sandev.juno.data.database.dao.TermoDAO;
import com.sandev.juno.data.model.Termo;

import java.util.Objects;

import static com.sandev.juno.ui.lista.ListaTermosActivity.CHAVE_INTENT;
import static com.sandev.juno.utils.Utils.isConnected;

public class DetalheTermoActivity extends AppCompatActivity{

    private TextView name;
    private TextView full_name;
    private TextView description;
    private TextView score;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_termo_layout);
        iniciaViews();
        preencheCampos();
    }

    private void preencheCampos() {
        Intent dados = getIntent();
        if (dados.hasExtra(CHAVE_INTENT)) {
            Termo termo = (Termo) dados.getSerializableExtra(CHAVE_INTENT);
            if (!TextUtils.isEmpty(Objects.requireNonNull(termo).getName())){
                name.setText(termo.getName());
                score.setText(String.valueOf(termo.getScore()));
                full_name.setText(termo.getFull_name());
                description.setText(termo.getDescription());

                TermoDAO dao = JunoDatabase.getInstance(this).getTermDAO();
                if(isConnected(this)){
                    dao.salvar(termo);
                }
            }
        }
    }

    private void iniciaViews() {
        name = findViewById(R.id.detail_name);
        full_name = findViewById(R.id.detail_full_name);
        description = findViewById(R.id.detail_description);
        score = findViewById(R.id.detail_score);
    }


}
