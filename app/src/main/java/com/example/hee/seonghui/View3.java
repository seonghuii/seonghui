package com.example.hee.seonghui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by hee on 2017-11-11.
 */

public class View3 extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view3);


        Button btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), R.string.button1_clicked_msg,
                        Toast.LENGTH_SHORT).show();
            }
        });


        Button btn4 = (Button)findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), R.string.button4_clicked_msg,
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void OnClickB2(View v){
        Button btn2 = (Button)findViewById(R.id.button3);
        btn2.setText("Btn Chg");
    }

    public void OnClickB3(View v){
        Button btn3 = (Button)findViewById(R.id.button2);
        btn3.setText("Btn Chg");
    }

    public void OnClickB5(View v) {
        LinearLayout layout = (LinearLayout) findViewById(R.id.layout2);
        layout.setGravity(Gravity.CENTER_HORIZONTAL);
    }

    public void OnClickB6(View v) {
        LinearLayout layout = (LinearLayout) findViewById(R.id.layout2);
        layout.setPadding(20,20,20,20);

    }

    @Override
    public  void onBackPressed(){
       Toast.makeText(View3.this,"돌아왔습니다.",Toast.LENGTH_SHORT).show();
        super.onBackPressed();
    }
}
