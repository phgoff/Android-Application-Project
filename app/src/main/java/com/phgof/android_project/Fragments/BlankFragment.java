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
public class BlankFragment extends Fragment {

    private static BlankFragment fragment;
    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        String value = getArguments().getString("KEY");
        Toast.makeText( getActivity() , value, Toast.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    public static Fragment newInstance(String value) {
        if ( fragment == null )
            fragment = new BlankFragment();
        Bundle bundle = new Bundle();
        bundle.putString("KEY", value);
        fragment.setArguments(bundle);
        return fragment;

    }

}
