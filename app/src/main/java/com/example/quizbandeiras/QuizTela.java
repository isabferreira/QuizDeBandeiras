package com.example.quizbandeiras;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class QuizTela extends AppCompatActivity {

    private int contador = 1;
    static int pontos;
    private String nomeUsuario;

    RadioGroup radioGroup;
    RadioButton rdOpcao1, rdOpcao2, rdOpcao3, rdOpcao4;
    TextView txtPergunta, txtNumPergunta;
    ImageView imgvPlaca;
    Button btnConfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz_tela);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Ligação dos componentes da interface
        txtNumPergunta = findViewById(R.id.txtNumPergunta);
        txtPergunta = findViewById(R.id.txtPergunta);
        imgvPlaca = findViewById(R.id.imgvPlaca);
        rdOpcao1 = findViewById(R.id.rdOpcao1);
        rdOpcao2 = findViewById(R.id.rdOpcao2);
        rdOpcao3 = findViewById(R.id.rdOpcao3);
        rdOpcao4 = findViewById(R.id.rdOpcao4);
        radioGroup = findViewById(R.id.radioGroup);
        btnConfirmar = findViewById(R.id.btnConfirmar);

        SharedPreferences prefs = getSharedPreferences("QuizPrefs", MODE_PRIVATE);
        nomeUsuario = prefs.getString("NomeUsuario", "Desconhecido");

        //////////////////////////////////////////////
        btnConfirmar.setEnabled(false);

        // Adicionar OnCheckedChangeListener ao RadioGroup
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            // Habilitar o botão de confirmar quando uma opção for selecionada
            btnConfirmar.setEnabled(checkedId != -1);
        });
        //////////////////////////////////////////////

        atualizarTela();
    }

    public void Sair(View view) {
        finish();
    }

    public static int getPontos() {
        return pontos;
    }

    public static void setPontos(int pontos) {
        QuizTela.pontos = pontos;
    }

    private void atualizarTela() {
        switch (contador) {
            case 1:
                txtNumPergunta.setText("QUESTÃO 1");
                txtPergunta.setText("Que país é esse?");
                imgvPlaca.setImageResource(R.drawable.brasil);
                rdOpcao1.setText("Estados Unidos");
                rdOpcao2.setText("Brasil");
                rdOpcao3.setText("Portugal");
                rdOpcao4.setText("Alemanha");
                break;
            case 2:
                txtNumPergunta.setText("QUESTÃO 2");
                txtPergunta.setText("Que país é esse?");
                imgvPlaca.setImageResource(R.drawable.alemanha);
                rdOpcao1.setText("Alemanha");
                rdOpcao2.setText("Inglaterra");
                rdOpcao3.setText("Holanda");
                rdOpcao4.setText("Argentina");
                break;
            case 3:
                txtNumPergunta.setText("QUESTÃO 3");
                txtPergunta.setText("Que país é esse?");
                imgvPlaca.setImageResource(R.drawable.portugal);
                rdOpcao1.setText("Colômbia");
                rdOpcao2.setText("Portugal");
                rdOpcao3.setText("Argélia");
                rdOpcao4.setText("Egito");
                break;
            case 4:
                txtNumPergunta.setText("QUESTÃO 4");
                txtPergunta.setText("Que país é esse?");
                imgvPlaca.setImageResource(R.drawable.franca);
                rdOpcao1.setText("Rússia");
                rdOpcao2.setText("Finlândia");
                rdOpcao3.setText("França");
                rdOpcao4.setText("Austrália");
                break;
            case 5:
                txtNumPergunta.setText("QUESTÃO 5");
                txtPergunta.setText("Que país é esse?");
                imgvPlaca.setImageResource(R.drawable.colombia);
                rdOpcao1.setText("Espanha");
                rdOpcao2.setText("Peru");
                rdOpcao3.setText("Chile");
                rdOpcao4.setText("Colômbia");
                break;
            case 6:
                txtNumPergunta.setText("QUESTÃO 6");
                txtPergunta.setText("Que país é esse?");
                imgvPlaca.setImageResource(R.drawable.japao);
                rdOpcao1.setText("Angola");
                rdOpcao2.setText("Japão");
                rdOpcao3.setText("Libéria");
                rdOpcao4.setText("Camarões");
                break;
            case 7:
                txtNumPergunta.setText("QUESTÃO 7");
                txtPergunta.setText("Que país é esse?");
                imgvPlaca.setImageResource(R.drawable.argentina);
                rdOpcao1.setText("Argentina");
                rdOpcao2.setText("Líbia");
                rdOpcao3.setText("Jamaica");
                rdOpcao4.setText("Bahamas");
                break;
            case 8:
                txtNumPergunta.setText("QUESTÃO 8");
                txtPergunta.setText("Que país é esse?");
                imgvPlaca.setImageResource(R.drawable.india);
                rdOpcao1.setText("Nepal");
                rdOpcao2.setText("Catar");
                rdOpcao3.setText("Filipinas");
                rdOpcao4.setText("Índia");
                break;
            case 9:
                txtNumPergunta.setText("QUESTÃO 9");
                txtPergunta.setText("Que país é esse?");
                imgvPlaca.setImageResource(R.drawable.peru);
                rdOpcao1.setText("Turquia");
                rdOpcao2.setText("Reino Unido");
                rdOpcao3.setText("Costa Rica");
                rdOpcao4.setText("Paraguai");
                break;
            case 10:
                txtNumPergunta.setText("QUESTÃO 10");
                txtPergunta.setText("Que país é esse?");
                imgvPlaca.setImageResource(R.drawable.belgica);
                rdOpcao1.setText("Chipre");
                rdOpcao2.setText("Armênia");
                rdOpcao3.setText("Bélgica");
                rdOpcao4.setText("Dinamarca");
                break;
            case 11:
                Intent it = new Intent(getApplicationContext(), QuizResultado.class);
                startActivity(it);
                finish();
                break;
        }
    }

    public void ConfirmarResposta(View view) {
        int selectedId = radioGroup.getCheckedRadioButtonId();

        if (selectedId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedId);
            int escolha = radioGroup.indexOfChild(selectedRadioButton) + 1;

            if (verificarResposta(escolha)) {
                pontos++;
            }

            contador++;
            radioGroup.clearCheck();  // Limpar a seleção atual
            atualizarTela();
        }
    }

    private boolean verificarResposta(int escolha) {
        switch (contador) {
            case 1:
                return escolha == 2;
            case 2:
                return escolha == 1;
            case 3:
                return escolha == 2;
            case 4:
                return escolha == 3;
            case 5:
                return escolha == 4;
            case 6:
                return escolha == 2;
            case 7:
                return escolha == 1;
            case 8:
                return escolha == 4;
            case 9:
                return escolha == 1;
            case 10:
                return escolha == 3;
            default:
                return false;
        }
    }
}