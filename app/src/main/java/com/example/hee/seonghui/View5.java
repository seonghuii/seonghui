package com.example.hee.seonghui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by hee on 2017-11-11.
 */

public class View5 extends AppCompatActivity {


    private TextView result;
    private EditText input;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view5);

            input = (EditText) findViewById(R.id.edit_title);
            result = (TextView) findViewById(R.id.result);
            Button iSave = (Button) findViewById(R.id.save_button);
            Button iLoad = (Button) findViewById(R.id.load_button);

            iSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    saveToInternalStorage();
                }
            });

            iLoad.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loadFromIntenalStorage();
                }
            });
    }
    private void saveToInternalStorage() {
        String data = input.getText().toString();

        try {
            FileOutputStream fos = openFileOutput
                    ("midtermfile.txt", // 파일명 지정
                            Context.MODE_APPEND);// 저장모드
            PrintWriter out = new PrintWriter(fos);
            out.println(data);
            out.close();

            result.setText("file saved");
            input.setText("");
        } catch (Exception e) {
            result.setText("Exception: internal file writing");
        }
    }

    private void loadFromIntenalStorage() {
        try {
            FileInputStream fis = openFileInput("midtermfile.txt");//파일명
            BufferedReader buffer = new BufferedReader
                    (new InputStreamReader(fis));
            String str = buffer.readLine(); // 파일에서 한줄을 읽어옴

            // 파일에서 읽은 데이터를 저장하기 위해서 만든 변수
            StringBuffer data = new StringBuffer();
            while (str != null) {
                data.append(str + "\n");
                str = buffer.readLine();
            }
            buffer.close();
            result.setText(data);
        } catch (FileNotFoundException e) {
            result.setText("File Not Found");
        } catch (Exception e) {
            result.setText("Exception: internal file reading");
        }
    }

}
