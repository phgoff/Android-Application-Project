package com.phgof.android_project.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.phgof.android_project.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment2 extends Fragment {

    private static BlankFragment2 fragment;
    public BlankFragment2() {
        // Required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        String value = getArguments().getString("KEY");
        Toast.makeText( getActivity() , value, Toast.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
    }

    public static Fragment newInstance(String value) {
        if ( fragment == null )
            fragment = new BlankFragment2();
        Bundle bundle = new Bundle();
        bundle.putString("KEY", value);
        fragment.setArguments(bundle);
        return fragment;

    }

}
