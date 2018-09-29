package info.android.khurkham.gridlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {

    private Button button1;
    private Button button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button)findViewById(R.id.botton1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCardview();
            }


        });

        button2 = (Button)findViewById(R.id.botton2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImagetext();
            }


        });


    }
    private void openCardview() {
        Intent intent = new Intent(this, Cardview.class);
        startActivity(intent);
    }

    private void openImagetext() {
        Intent intent = new Intent(this, Imagetext.class);
        startActivity(intent);
    }




}
