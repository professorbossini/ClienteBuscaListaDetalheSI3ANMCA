package br.com.bossini.clientebuscalistadetalhesi3anmca;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListaActivity extends AppCompatActivity {

    private ListView nomesListView;
    private List<String> lista = new ArrayList<>();


    private void inicializaBase (){
        lista.add("Carlos Drummond de Andrade");
        lista.add("Manuel Bandeira");
        lista.add("Olavo Bilac");
        lista.add("Vinícius de Moraes");
        lista.add("Cecília Meireles");
        lista.add("Castro Alves");
        lista.add("Gonçalves Dias");
        lista.add("Ferreira Gullar");
        lista.add("Machado de Assis");
        lista.add("Mário de Andrade");
        lista.add("Cora Coralina");
        lista.add("Manoel de Barros");
        lista.add("João Cabral de Melo Neto");
        lista.add("Casimiro de Abreu");
        lista.add("Paulo Leminski");
        lista.add("Álvares de Azevedo");
        lista.add("Guilherme de Almeida");
        lista.add("Alphonsus de Guimarães");
        lista.add("Mário Quintana");
        lista.add("Gregório de Matos");
        lista.add("Augusto dos Anjos");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        nomesListView = (ListView) findViewById(R.id.nomesListView);
        Intent intentOrigem  = getIntent();
        String texto = intentOrigem.getStringExtra("txt");
        inicializaBase();
        List <String> resultado = realizaBusca(texto);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, resultado);
        nomesListView.setAdapter(adapter);
        if (resultado.size() <= 0)
            Toast.makeText(this, getString(R.string.sem_resultados, texto), Toast.LENGTH_SHORT).show();
        nomesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(ListaActivity.this, "Posição: " + i, Toast.LENGTH_SHORT).show();
                String tocou = nomesListView.getItemAtPosition(i).toString();
                Intent intent = new Intent (ListaActivity.this, DetalhesActivity.class);
                intent.putExtra("txt", tocou);
                startActivity(intent);
            }
        });
    }

    private List <String> realizaBusca (String texto){
        if (texto == null || texto.length() <= 0)
            return lista;
        List <String> resultado = new ArrayList<>();
        for (String s : lista){
            if (s.contains(texto)){
                resultado.add(s);
            }
        }
        return resultado;
    }
}
