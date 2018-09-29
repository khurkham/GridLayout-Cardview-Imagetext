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

public class Fragmenttitle7 extends MyAppFragment {

    private Button titleButton1;
    private Button titleButton2;
    private Button titleButton3;
    private Button titleButton4;


    public Fragmenttitle7(){
        this.appSection = AppSection.TITLE7;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_title7, container, false);

        getMainActivity().getSupportActionBar().setTitle("Learn Tai Language");

        titleButton1 = (Button)view.findViewById(R.id.lvTitle71);
        titleButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getMainActivity().navigateToSection(AppSection.TITLE71, true)   ;
            }
        });

        titleButton2 = (Button)view.findViewById(R.id.lvTitle72);
        titleButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getMainActivity().navigateToSection(AppSection.TITLE72, true)   ;
            }
        });

        titleButton3 = (Button)view.findViewById(R.id.lvTitle73);
        titleButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getMainActivity().navigateToSection(AppSection.TITLE73, true)   ;
            }
        });

        titleButton4 = (Button)view.findViewById(R.id.lvTitle74);
        titleButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getMainActivity().navigateToSection(AppSection.TITLE74, true)   ;
            }
        });

        return view;
    }
}
