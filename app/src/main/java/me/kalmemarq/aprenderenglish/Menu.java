package me.kalmemarq.aprenderenglish;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class Menu extends AppCompatActivity {
    private static final Aprender.AprenderCategory FRUTAS;
    private static final Aprender.AprenderCategory ESTACOES;
    private static final Aprender.AprenderCategory ANIMAIS;
    private static final Aprender.AprenderCategory CORES;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    private void startAprender(Aprender.AprenderCategory category) {
        Aprender.setCurrentCategory(category);
        this.startActivity(new Intent(this, Aprender.class));
        this.finish();
    }

    public void goToFrutas(View view) {
        this.startAprender(FRUTAS);
    }

    public void goToCores(View view) {
        this.startAprender(CORES);
    }

    public void goToEstacoes(View view) {
        this.startAprender(ESTACOES);
    }

    public void goToAnimais(View view) {
        this.startAprender(ANIMAIS);
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu_aprender, menu);
        menu.removeItem(R.id.voltarmenu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.sairmenu) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    static {
        FRUTAS = new Aprender.AprenderCategory(
                R.string.frutas,
                new int[] { R.drawable.lemons, R.drawable.orange, R.drawable.apple },
                new int[] { R.raw.lemon, R.raw.orange, R.raw.apple },
                new String[] { "Limão", "Laranja", "Maça" }
        );
        CORES = new Aprender.AprenderCategory(
                R.string.txtcor,
                new int[] { R.drawable.red, R.drawable.blue, R.drawable.green },
                new int[] { R.raw.red, R.raw.blue, R.raw.green },
                new String[] { "Vermelho", "Azul", "Verde" }
        );
        ESTACOES = new Aprender.AprenderCategory(
                R.string.txtestacoes,
                new int[] { R.drawable.spring, R.drawable.summer, R.drawable.fall, R.drawable.winter },
                new int[] { R.raw.spring, R.raw.summer, R.raw.fall, R.raw.winter },
                new String[] { "Primavera", "Verão", "Outono", "Inverno" }
        );
        ANIMAIS = new Aprender.AprenderCategory(
                R.string.txtanimals,
                new int[] { R.drawable.lion, R.drawable.zebra, R.drawable.parrot },
                new int[] { R.raw.lion, R.raw.zebra, R.raw.parrot },
                new String[] { "Leão", "Zebra", "Papagaio" }
        );
    }
}