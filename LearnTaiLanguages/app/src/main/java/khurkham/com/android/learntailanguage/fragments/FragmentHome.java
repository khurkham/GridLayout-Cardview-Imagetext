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

public class FragmentHome extends MyAppFragment  {

    private Button titleButton1;
    private Button titleButton2;
    private Button titleButton3;
    private Button titleButton4;
    private Button titleButton5;
    private Button titleButton6;
    private Button titleButton7;


    public FragmentHome(){
        this.isRootSection = true;
        this.appSection = AppSection.HOME;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        getMainActivity().getSupportActionBar().setTitle("Home");

        titleButton1 = (Button)view.findViewById(R.id.title_button1);
        titleButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getMainActivity().navigateToSection(AppSection.TITLE1, true)   ;
            }
        });

        titleButton2 = (Button)view.findViewById(R.id.title_button2);
        titleButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getMainActivity().navigateToSection(AppSection.TITLE2, true)   ;
            }
        });

        titleButton3 = (Button)view.findViewById(R.id.title_button3);
        titleButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getMainActivity().navigateToSection(AppSection.TITLE3, true)   ;
            }
        });

        titleButton4 = (Button)view.findViewById(R.id.title_button4);
        titleButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getMainActivity().navigateToSection(AppSection.TITLE4, true)   ;
            }
        });

        titleButton5 = (Button)view.findViewById(R.id.title_button5);
        titleButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getMainActivity().navigateToSection(AppSection.TITLE5, true)   ;
            }
        });

        titleButton6 = (Button)view.findViewById(R.id.title_button6);
        titleButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getMainActivity().navigateToSection(AppSection.TITLE6, true)   ;
            }
        });

        titleButton7 = (Button)view.findViewById(R.id.title_button7);
        titleButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getMainActivity().navigateToSection(AppSection.TITLE7, true)   ;
            }
        });

        return view;
    }


}
