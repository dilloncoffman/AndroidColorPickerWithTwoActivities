package edu.temple.colorpickerwithtwoactivities;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class PaletteActivity extends AppCompatActivity implements PaletteFragment.ColorSelectedInterface {
    Spinner spinner;
    ConstraintLayout paletteLayout;
    String[] colors;
    int checkIfSpinnerReady = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        colors = res.getStringArray(R.array.colors);

        spinner = findViewById(R.id.colorSpinner);
        paletteLayout = findViewById(R.id.paletteLayout);
        final ColorAdapter colorAdapter = new ColorAdapter(PaletteActivity.this, colors);

        spinner.setAdapter(colorAdapter);
        String paletteActionBarTitle = res.getString(R.string.palette_action_bar_title);
        getSupportActionBar().setTitle(paletteActionBarTitle);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (++checkIfSpinnerReady > 1) {
                    Intent canvasIntent = new Intent(PaletteActivity.this, CanvasActivity.class);
                    String colorToUse;
                    switch (colors[position]) {
                        case "Azul":
                            colorToUse = "Blue";
                            break;
                        case "Cian":
                            colorToUse = "Cyan";
                            break;
                        case "Gris":
                            colorToUse = "Gray";
                            break;
                        case "Verde":
                            colorToUse = "Green";
                            break;
                        case "Rojo":
                            colorToUse = "Red";
                            break;
                        case "Negro":
                            colorToUse = "Black";
                            break;
                        case "Amarillo":
                            colorToUse = "Yellow";
                            break;
                        default:
                            colorToUse = colors[position];
                            break;
                    }
                    canvasIntent.putExtra("BACKGROUND_COLOR", colorToUse);
                    startActivity(canvasIntent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void colorSelected(String colorName) {
        
    }
}
