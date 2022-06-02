package br.edu.fateczl.appsoi20221t;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultadoActivity extends AppCompatActivity {

    private TextView tvResultado;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        tvResultado = findViewById(R.id.tvResultado);
        btnVoltar = findViewById(R.id.btnVoltar);

        Toast.makeText(this,
                R.string.parabens,
                Toast.LENGTH_LONG).show();

        int rand = recebeValor();
        tvResultado.setText(getString(R.string.resultado)+" "+rand);

        btnVoltar.setOnClickListener(click -> voltar());
    }

    private void voltar() {
        Intent i = new Intent(this, MainActivity.class);
        this.startActivity(i);
        this.finish();
    }

    private int recebeValor() {
        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        int rand = bundle.getInt("rand");
        return rand;
    }



}