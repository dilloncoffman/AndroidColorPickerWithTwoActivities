package edu.temple.colorpickerwithtwoactivities;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PaletteActivity extends AppCompatActivity implements PaletteFragment.ColorSelectedInterface {

    CanvasFragment canvasFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources res = getResources();
        String paletteActionBarTitle = res.getString(R.string.palette_action_bar_title);
        getSupportActionBar().setTitle(paletteActionBarTitle);

        canvasFragment = new CanvasFragment();
        PaletteFragment paletteFragment = PaletteFragment.newInstance(getResources().getStringArray(R.array.colors));
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container_1, paletteFragment)
                .add(R.id.container_2, canvasFragment)
                .commit();
    }

    @Override
    public void colorSelected(String colorName) {
        canvasFragment.displayColor(colorName);
    }
}
