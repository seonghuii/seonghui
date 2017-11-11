package com.example.hee.seonghui;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by hee on 2017-11-10.
 */

public class View2 extends AppCompatActivity {

    static View2Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view2);

        ActionBar actionBar = getSupportActionBar();

            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);


        //listview에 들어갈 객체 선언
        //title과 description 두 가지 string 객체를 데이터로 갖는 itemdata라는 객체들을 배열의 현태로 저장하는 클래스
        ArrayList<View2Item> data = new ArrayList<View2Item>();
        data.add(new View2Item("안드로이드\n프로그래밍", "수2.3", "B107"));
        data.add(new View2Item("소프트웨어\n설계 패턴 A", "월5.6,수5", "B105"));
        data.add(new View2Item("소프트웨어\n설계 패턴 A", "월야2.3,수야1", "B105"));

        //list어댑터 생성 - 실제 리스트로 들어갈 내용 담도록
        adapter = new View2Adapter(this, R.layout.view2_item, data);

        //list 뷰 만듦 list id
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);

        //listview 기타설정
        listView.setDivider(new ColorDrawable(Color.RED));
        listView.setDividerHeight(5);

        //listview이벤트 처리 -클릭했을때
        //parent는 adapterview의 속성을 모두 사용할 수 있다.
        //position은 클릭한 row의 position을 반환해준다.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View vClickezd, int position, long id) {
                //   String name = (String) ((TextView)vClicked.findViewById(R.id.textItem1)).getText();
                String classname = ((View2Item) adapter.getItem(position)).nClassname;
                Toast.makeText(View2.this, classname + " selected",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_view3:
                startActivity(new Intent(this, View3.class));
                return true;
            case R.id.action_view4:
                startActivity(new Intent(this, View4.class));
                return true;
            case R.id.action_view5:
                startActivity(new Intent(this, View5.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }




}
