package br.edu.fateczl.appsoi20221t;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etNumero;
    private Button btnJogar;
    private TextView tvMensagem;
    private int rand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumero = findViewById(R.id.etNumero);
        etNumero.setGravity(Gravity.CENTER);
        btnJogar = findViewById(R.id.btnJogar);
        tvMensagem = findViewById(R.id.tvMensagem);

        rand = (int)((Math.random() * 100) + 1);

        btnJogar.setOnClickListener(click -> tentar());

    }

    private void tentar() {
        int numdigitado = Integer.parseInt(etNumero.getText().toString());
        if (numdigitado < rand) {
            tvMensagem.setText(R.string.num_maior);
        }
        if (numdigitado > rand) {
            tvMensagem.setText(R.string.num_menor);
        }
        if (numdigitado == rand) {
            trocarActivity();
        }

    }

    private void trocarActivity() {
        Bundle bundle = new Bundle();
        bundle.putInt("rand", rand);

        Intent i = new Intent(this, ResultadoActivity.class);
        i.putExtras(bundle);
        this.startActivity(i);
        this.finish();
    }
}