package com.example.quizbandeiras;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class QuizResultado extends AppCompatActivity {

    Button btnSair, btnReiniciar;
    TextView txtResultado, txtMotivacional, txtNomeUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz_resultado);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnSair = findViewById(R.id.btnSair);
        btnReiniciar = findViewById(R.id.btnReiniciar);
        txtResultado = findViewById(R.id.txtResultado);
        txtNomeUsuario = findViewById(R.id.txtNomeUsuario);

        btnSair.setOnClickListener(view -> {
            QuizTela.setPontos(0); // Reseta os pontos
            Intent it = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(it);
            finish();
        });

        btnReiniciar.setOnClickListener(view -> {
            QuizTela.setPontos(0); // Reseta os pontos
            Intent it = new Intent(getApplicationContext(), QuizTela.class);
            startActivity(it);
            finish();
        });

        resultado();
    }

    public void resultado() {
        int pontos = QuizTela.getPontos();
        txtResultado.setText(pontos + "/10");


        exibirNomeUsuario();
    }

    private void exibirNomeUsuario() {
        SharedPreferences prefs = getSharedPreferences("QuizPrefs", MODE_PRIVATE);
        String nomeUsuario = prefs.getString("NomeUsuario", "Desconhecido");

        // Exibir o nome do usuário
        txtNomeUsuario.setText(nomeUsuario);
    }
}
