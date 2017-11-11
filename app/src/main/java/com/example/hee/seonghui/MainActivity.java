package com.example.hee.seonghui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String PREFERENCES_GROUP = "LoginInfo";
    public static final String PREFERENCES_ATTR1 = "Username";
    public static final String PREFERENCES_ATTR2 = "Password";
    public static final String USER_NAME="midterm";
    public static final String PASSWORD="a";
    SharedPreferences setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



           //loginInfo라는 프레퍼런스 등록
        setting = getSharedPreferences(PREFERENCES_GROUP, MODE_PRIVATE);
        //입력 상자에 값 세팅
        final EditText textInput1 = (EditText) findViewById(R.id.textInput1);
        final EditText textInput2 = (EditText) findViewById(R.id.textInput2);

        textInput1.setText(retrieveName());
        textInput2.setText(retrievePassword());
         //메인 화면 login 버튼
        Button btn = (Button) findViewById(R.id.login);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String name = textInput1.getText().toString();
                String password = textInput2.getText().toString();

                saveName(name);
                savePassword(password);

                if (name.equals(USER_NAME) && password.equals(PASSWORD)) {
                    Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), View2.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT ).show();
            }
        });


    }


    private String retrieveName() {
        String nameText = "";
        if (setting.contains(PREFERENCES_ATTR1)) {
            nameText = setting.getString(PREFERENCES_ATTR1, "");
        }
        return nameText;
    }

    private String retrievePassword() {
        String pwText = "";
        if (setting.contains(PREFERENCES_ATTR2)) {
            pwText = setting.getString(PREFERENCES_ATTR2, "");
        }
        return pwText;
    }

    private void saveName(String text) {
        SharedPreferences.Editor editor = setting.edit();
        editor.putString(PREFERENCES_ATTR1, text);
        editor.commit();
    }
    private void savePassword(String text) {
        SharedPreferences.Editor editor = setting.edit();
        editor.putString(PREFERENCES_ATTR2, text);
        editor.commit();
    }

}
