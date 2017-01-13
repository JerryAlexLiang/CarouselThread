package com.liangyang.carouseldemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.liangyang.carouseldemo.view.SlideShowView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SlideShowView slideShowView= (SlideShowView) findViewById(R.id.slideshowView);
        //设置字符串
        String[] texts = new String[]{
                "中共第八大会议",
                "正月庆元宵",
                "大冬天的能不这样吗！大家都觉得你们如何呢大家都觉得你们如何呢大家都觉得你们如何呢",
                "大家都觉得你们如何呢大家都觉得你们如何呢大家都觉得你们如何呢大家都觉得你们如何呢"
        };
        slideShowView.setData(texts);
    }
}
