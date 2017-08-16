package com.example.internship.accenture.beaconapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.internship.accenture.beaconapp.R;
import com.skyfishjy.library.RippleBackground;

/**
 * Created by oprea.flaviu on 8/14/2017.
 */

public class FragmentSearch extends Fragment {

    RippleBackground rippleBackground;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search, container, false);
        rippleBackground = view.findViewById(R.id.content);
        rippleBackground.startRippleAnimation();
        return view;
    }
}
