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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources res = getResources();
        String paletteActionBarTitle = res.getString(R.string.palette_action_bar_title);
        getSupportActionBar().setTitle(paletteActionBarTitle);

        PaletteFragment paletteFragment = PaletteFragment.newInstance(getResources().getStringArray(R.array.colors));
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container_1, paletteFragment)
                .commit();



    }

    @Override
    public void colorSelected(String colorName) {

    }
}
