package me.kalmemarq.aprenderenglish;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class Aprender extends AppCompatActivity {
    private ImageView apIV;
    private Spinner spinner;
    private TextView nameTV;
    private static AprenderCategory currentCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprender);

        this.spinner = findViewById(R.id.apSP);
        this.nameTV = findViewById(R.id.nameTV);
        this.apIV = findViewById(R.id.apIV);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, currentCategory.names);
        this.spinner.setAdapter(adapter);
        TextView titleTV = findViewById(R.id.titleTV);
        titleTV.setText(getString(currentCategory.title));

        this.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                apIV.setImageResource(currentCategory.imageIds[position]);
                nameTV.setText(currentCategory.names[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void reproduzir(View view) {
        MediaPlayer.create(this, currentCategory.soundIds[this.spinner.getSelectedItemPosition()]).start();
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu_aprender, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.sairmenu) {
            this.finish();
        } else if (item.getItemId() == R.id.voltarmenu) {
            this.startActivity(new Intent(this, Menu.class));
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public static void setCurrentCategory(AprenderCategory category) {
        currentCategory = category;
    }

    public static class AprenderCategory {
        public final int title;
        public final int[] imageIds;
        public final int[] soundIds;
        public final String[] names;

        public AprenderCategory(int title, int[] imageIds, int[] soundIds, String[] names) {
            this.imageIds = imageIds;
            this.soundIds = soundIds;
            this.names = names;
            this.title = title;
        }
    }
}