package com.teines.projeto04;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private static final int NUMERO_MAXIMO = 60; // VARIÁVEIS CONSTANTES
    private static final int QUANTIDADE_SORTEADA = 6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void sortearNumeros(View view){
        // CRIAR UM ARRAY PARA ARMAZENAR OS NÚMEROS
        ArrayList<Integer> numeros = new ArrayList<>();

        // INTEGER = VARIAVEIS WRAPPER
        // ADICIONANDO NÚMEROS DE 1 ATÉ 60
        for(int i = 1; i <= NUMERO_MAXIMO; i++){ // i++; i = 1 + i
            numeros.add(i);
        }

        // EMBARALHANDO OS NÚMEROS
        Collections.shuffle(numeros);

        // ORGANIZANDO
        StringBuilder resultado = new StringBuilder("Números Sorteados: \n");

        // PEGAR OS NÚMEROS DO ARRAY
        for(int i = 0; i < QUANTIDADE_SORTEADA; i++){
            resultado.append(numeros.get(i)).append(" ");
        }

        // EXIBIR RESULTADO
        TextView resultadosTextView = findViewById(R.id.resultadoSorteio);
        resultadosTextView.setText(resultado.toString());
    }

}