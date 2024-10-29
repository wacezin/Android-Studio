package com.teines.projeto10;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ImageView btTelaImc, btTelaGas, btTelaCalc, btTelaOutros;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btTelaImc = findViewById(R.id.app_imc);
        btTelaGas = findViewById(R.id.app_gasolina);
        btTelaCalc = findViewById(R.id.app_calculadora);
        btTelaOutros = findViewById(R.id.apps_outros);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void abrirAppImc(View view){
        Intent telaImc = new Intent(MainActivity.this, ImcActivity.class);
        startActivity(telaImc);
    }
}