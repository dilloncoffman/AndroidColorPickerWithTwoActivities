package edu.temple.colorpickerwithtwoactivities;


import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class CanvasFragment extends Fragment {

    ConstraintLayout constraintLayout;

    public CanvasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        constraintLayout = (ConstraintLayout) inflater.inflate(R.layout.fragment_canvas, container, false);
        return constraintLayout;
    }

    public void displayColor(String color) {
        String colorToUse;
        switch (color) {
            case "Azul":
                colorToUse = "Blue";
                constraintLayout.setBackgroundColor(Color.parseColor(colorToUse));
                break;
            case "Cian":
                colorToUse = "Cyan";
                constraintLayout.setBackgroundColor(Color.parseColor(colorToUse));
                break;
            case "Gris":
                colorToUse = "Gray";
                constraintLayout.setBackgroundColor(Color.parseColor(colorToUse));
                break;
            case "Verde":
                colorToUse = "Green";
                constraintLayout.setBackgroundColor(Color.parseColor(colorToUse));
                break;
            case "Rojo":
                colorToUse = "Red";
                constraintLayout.setBackgroundColor(Color.parseColor(colorToUse));
                break;
            case "Negro":
                colorToUse = "Black";
                constraintLayout.setBackgroundColor(Color.parseColor(colorToUse));
                break;
            case "Amarillo":
                colorToUse = "Yellow";
                constraintLayout.setBackgroundColor(Color.parseColor(colorToUse));
                break;
            default:
                colorToUse = color;
                constraintLayout.setBackgroundColor(Color.parseColor(colorToUse));
                break;
        }
    }

}
