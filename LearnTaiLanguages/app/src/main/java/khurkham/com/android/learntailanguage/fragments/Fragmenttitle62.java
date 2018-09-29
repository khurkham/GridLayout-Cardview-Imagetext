package khurkham.com.android.learntailanguage.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import khurkham.com.android.learntailanguage.R;
import khurkham.com.android.learntailanguage.infrastructure.AppSection;

/**
 * Created by angel on 2/2/2018.
 */

public class Fragmenttitle62 extends MyAppFragment {

    private Button titleButton1;
    private Button titleButton2;
    private Button titleButton3;

    public Fragmenttitle62(){
        this.appSection = AppSection.TITLE62;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_title62, container, false);

        getMainActivity().getSupportActionBar().setTitle("Learn Tai Language");

        titleButton1 = (Button)view.findViewById(R.id.lvTitle621);
        titleButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getMainActivity().navigateToSection(AppSection.TITLE621, true)   ;
            }
        });

        titleButton2 = (Button)view.findViewById(R.id.lvTitle622);
        titleButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getMainActivity().navigateToSection(AppSection.TITLE622, true)   ;
            }
        });

        titleButton3 = (Button)view.findViewById(R.id.lvTitle623);
        titleButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getMainActivity().navigateToSection(AppSection.TITLE623, true)   ;
            }
        });

        return view;
    }
}
