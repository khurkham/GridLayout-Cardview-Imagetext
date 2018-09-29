package khurkham.com.android.learntailanguage.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import khurkham.com.android.learntailanguage.R;
import khurkham.com.android.learntailanguage.infrastructure.AppSection;

import static android.widget.Toast.*;

/**
 * Created by angel on 2/2/2018.
 */

public class FragmentImore extends MyAppFragment {
    EditText edText;


    public FragmentImore(){
        this.appSection = AppSection.MORE;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_more, container, false);

        edText = (EditText) view.findViewById(R.id.edText);


        return view;




    }

    public void Send(View view) {
        if (edText.getText().equals(null) || edText.getText().toString().isEmpty()){
            makeText(this, "Please write your want to say!!", LENGTH_SHORT).show();
        }else{
            sentemail();
        }
    }

    private Toast makeText(FragmentImore fragmentImore, String s, int lengthShort) {
        return null;
    }


    public void sentemail() {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", "khurkhamlangkhur@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "MIUI Custom Font Installer");
        emailIntent.putExtra(Intent.EXTRA_TEXT, edText.getText().toString());
        startActivity(Intent.createChooser(emailIntent, "Send email via..."));
    }




}
