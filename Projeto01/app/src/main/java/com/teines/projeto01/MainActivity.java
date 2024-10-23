package com.teines.projeto01;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

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
    public void alterarTexto(View view){
        TextView texto = findViewById(R.id.txt_result);
        texto.setText("Bem Vindo ao curso de Desenvolvimento Android!");
    };

    public void abrirLinkedIn(View view){
        Uri link = Uri.parse("https://www.x.com");
        Intent intent = new Intent(Intent.ACTION_VIEW, link);

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }

}