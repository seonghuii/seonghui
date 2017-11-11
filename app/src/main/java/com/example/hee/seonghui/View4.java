package com.example.hee.seonghui;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by hee on 2017-11-11.
 */

public class View4 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view4);
        Button button = (Button)findViewById(R.id.FIRSTFRAG);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchFragment(0);
            }
        });
        button = (Button)findViewById(R.id.SECONDFRAG);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchFragment(1);
            }
        });
    }

    final FirstFragment firstFragment = new FirstFragment();
    final SecondFragment secondFragment = new SecondFragment();

    protected void switchFragment(int id) {
        final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (id == 0)
            fragmentTransaction.replace(R.id.fragment, firstFragment);
        else
            fragmentTransaction.replace(R.id.fragment, secondFragment);
        fragmentTransaction.commit();
    }
}

