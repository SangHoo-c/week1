package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TabHost;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost1 = (TabHost) findViewById(R.id.tabHost1);
        tabHost1.setup();


        //첫번째 탭 설정
        TabHost.TabSpec ts1 = tabHost1.newTabSpec("tab spec 1");
        ts1.setContent(R.id.content1);
        ts1.setIndicator("TAB 1");
        tabHost1.addTab(ts1);

        //두번쨰 탭 설정
        TabHost.TabSpec ts2 = tabHost1.newTabSpec("tab spec 2");
        ts2.setContent(R.id.content2);
        ts2.setIndicator("TAB 2");
        tabHost1.addTab(ts2);

        //세번째 탭 설정
        TabHost.TabSpec ts3 = tabHost1.newTabSpec("tab spec 3");
        ts3.setContent(R.id.content3);
        ts3.setIndicator("TAB 3");
        tabHost1.addTab(ts3);


        //화면 전체 크기
        Display display = ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
        int displayWidth = display.getWidth();
        int displayHeight = display.getHeight();

        GridView gridView_image = (GridView)findViewById(R.id.gridView_image);
        image_adapter adapter = new image_adapter(this, displayWidth);
        gridView_image.setAdapter(adapter);
        gridView_image.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(), position+"click!",Toast.LENGTH_SHORT).show();
                if(position <6){

                    Intent myIntent = new Intent(MainActivity.this, image_inlarge.class);
                    myIntent.putExtra("intVariableName", position);
                    startActivity(myIntent);
                }
                else{
                    position %=6;
                    Intent myIntent = new Intent(MainActivity.this, image_inlarge.class);
                    myIntent.putExtra("intVariableName", position);
                    startActivity(myIntent);
                }

               //Toast.makeText(getApplicationContext(), res,Toast.LENGTH_SHORT).show();


                //startActivity(intent);

            }
        });

    }




}
