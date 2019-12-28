package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.chrisbanes.photoview.PhotoView;
//이런식으로 import 문을 입력해줘야 진행될 때가 있다.

public class image_inlarge extends AppCompatActivity {
    double random;
    Button img_share;
    Integer[] pics = {
            R.drawable.santa1,
            R.drawable.santa2,
            R.drawable.santa3,
            R.drawable.santa4,
            R.drawable.santa5,
            R.drawable.santa6};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_inlarge);

        random = Math.random();
        int int_random = (int)(random*5);

        Intent mIntent = getIntent();
        int position = mIntent.getIntExtra("intVariableName", 0);

        if(position != int_random){
            PhotoView photoView= findViewById(R.id.image_large);
            photoView.setImageResource(pics[position]);
//
//            ImageView img = (ImageView) findViewById(R.id.image_large);
//            img.setImageResource(pics[position]);
        }
        else{
            PhotoView photoView= findViewById(R.id.image_large);
            photoView.setImageResource(R.drawable.gift);
//            ImageView img_gift = (ImageView) findViewById(R.id.image_large);
//            img_gift.setImageResource(R.drawable.gift);
            TextView text_congra = (TextView)findViewById(R.id.text_congra);
            text_congra.setVisibility(View.VISIBLE);
        }

        img_share = (Button)findViewById(R.id.share_button);






    }

}
