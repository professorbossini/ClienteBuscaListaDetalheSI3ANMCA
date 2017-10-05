package br.com.bossini.clientebuscalistadetalhesi3anmca;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class ListaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        Intent intentOrigem  = getIntent();
        String texto = intentOrigem.getStringExtra("txt");
        Toast torrada = Toast.makeText(this, texto, Toast.LENGTH_SHORT);
        torrada.show();
    }
}
