package edu.temple.colorpickerwithtwoactivities;

import android.graphics.Color;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.colorSpinner);
        paletteLayout = findViewById(R.id.paletteLayout);
        ColorAdapter colorAdapter = new ColorAdapter(PaletteActivity.this, colors);

        spinner.setAdapter(colorAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                view.setBackgroundColor(Color.WHITE); // when an item is selected, set Spinner background color to white
                paletteLayout.setBackgroundColor(Color.parseColor(colors[position])); // when an item is selected, set layout background color to value of color selected
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
