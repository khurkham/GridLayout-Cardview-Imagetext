package khurkham.com.android.learntailanguage.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import khurkham.com.android.learntailanguage.R;
import khurkham.com.android.learntailanguage.infrastructure.AppSection;
/**
 * Created by angel on 2/2/2018.
 */

public class FragmentReferable extends MyAppFragment {


    public FragmentReferable() {
        this.appSection = AppSection.REFERABLE;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_referable, container, false);


        getMainActivity().getSupportActionBar().setTitle("Referable");

        return view;
    }
}
