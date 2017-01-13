package com.liangyang.carouselthread;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView notificationContent;
    private boolean running = true;
    private int count = 1;
    /**
     * 用Handler接收消息，改变TextView内容
     */
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            notificationContent.setText("" + count++ + " " + "秒");

        }
    };

    /**
     * 定时休眠，达到轮播效果
     */
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            while (running) {
                handler.sendEmptyMessage(0);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化视图
        notificationContent = (TextView) findViewById(R.id.tv_notification_content);
    }

    /**
     * Button的点击监听事件
     *
     * @param view
     */
    public void onStart(View view) {
        //启动线程
        new Thread(runnable).start();
    }

//    /**
//     * 停止
//     */
//    @Override
//    protected void onStop() {
//        running = false;
//        super.onStop();
//    }
}
