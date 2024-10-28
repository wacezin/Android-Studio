package com.teines.projeto09;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editValor;
    private TextView textPorcentagem, textGorjeta, textTotal;
    private SeekBar seekBarGorjeta;
    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editValor = findViewById(R.id.edit_valor);
        textGorjeta = findViewById(R.id.text_gorjeta);
        textPorcentagem = findViewById(R.id.text_porcentagem);
        textTotal = findViewById(R.id.text_total);
        seekBarGorjeta = findViewById(R.id.seekBar_gorjeta);

        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                porcentagem = progress;
                textPorcentagem.setText(Math.round(porcentagem) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                calcular();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
    public void calcular(){
        String valorRecuperado = editValor.getText().toString();

        if (valorRecuperado == null || valorRecuperado.equals("")){
            Toast.makeText(
                    getApplicationContext(), "Digite um valor primeiro!",
                    Toast.LENGTH_SHORT
            ).show();
        }else {
            double valorDigitado = Double.parseDouble(valorRecuperado);

            double gorjeta = valorDigitado * (porcentagem / 100);
            double total = gorjeta + valorDigitado;

            textGorjeta.setText("R$" + Math.round(gorjeta));
            textTotal.setText("R$" + String.format("%.2f", total));
        }
    }
}