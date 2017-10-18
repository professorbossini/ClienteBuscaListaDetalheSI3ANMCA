package br.com.bossini.clientebuscalistadetalhesi3anmca;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DetalhesActivity extends AppCompatActivity {

    private TextView nomeTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);
        nomeTextView = (TextView) findViewById(R.id.nomeTextView);
        Intent intent = getIntent();
        String tocou = intent.getStringExtra("txt");
        nomeTextView.setText(tocou);
        nomeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = ((TextView)view).getText().toString();
                Toast.makeText(DetalhesActivity.this, texto, Toast.LENGTH_SHORT).show();

            }
        });

    }
}
