package edu.temple.colorpickerwithtwoactivities;

import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CanvasActivity extends AppCompatActivity {
    ConstraintLayout canvasLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        canvasLayout = findViewById(R.id.canvasLayout);
        getSupportActionBar().setTitle("Canvas Activity");

        Intent bgColorInt = getIntent();
        // Get the BACKGROUND_COLOR passed from PaletteActivity
        String bgColor = (String) bgColorInt.getSerializableExtra("BACKGROUND_COLOR");
        // Set background color for CanvasActivity layout
        canvasLayout.setBackgroundColor(Color.parseColor(bgColor));
    }
}
