package edu.temple.colorpickerwithtwoactivities;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class PaletteActivity extends AppCompatActivity {
    Spinner spinner;
    ConstraintLayout paletteLayout;
    String[] colors = {"Blue", "Cyan", "Gray", "Green", "Magenta", "Red", "Black", "Blue", "Green", "Yellow"};
    int checkIfSpinnerReady = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.colorSpinner);
        paletteLayout = findViewById(R.id.paletteLayout);
        ColorAdapter colorAdapter = new ColorAdapter(PaletteActivity.this, colors);

        spinner.setAdapter(colorAdapter);
        getSupportActionBar().setTitle("Palette Activity");

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (++checkIfSpinnerReady > 1) {
                    Intent canvasIntent = new Intent(PaletteActivity.this, CanvasActivity.class);
                    canvasIntent.putExtra("BACKGROUND_COLOR", colors[position]);
                    startActivity(canvasIntent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
