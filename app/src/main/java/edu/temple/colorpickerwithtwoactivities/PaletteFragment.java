package edu.temple.colorpickerwithtwoactivities;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PaletteFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PaletteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PaletteFragment extends Fragment {
    String[] colors;
    private static final String COLOR_KEY = "colors";
    private ColorSelectedInterface fragmentParent;

    public PaletteFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param colors String.
     * @return A new instance of fragment PaletteFragment.
     */
    public static PaletteFragment newInstance(String[] colors) {
        PaletteFragment paletteFragment = new PaletteFragment();
        Bundle args = new Bundle();
        args.putStringArray(COLOR_KEY, colors);
        paletteFragment.setArguments(args);
        return paletteFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            colors = bundle.getStringArray(COLOR_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Spinner spinner = (Spinner) inflater.inflate(R.layout.fragment_palette, container, false);
        spinner.setAdapter(new ColorAdapter((Context) fragmentParent, colors));

        return spinner;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ColorSelectedInterface) {
            fragmentParent = (ColorSelectedInterface) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentParent = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface ColorSelectedInterface {
        void colorSelected(String colorName);
    }
}
