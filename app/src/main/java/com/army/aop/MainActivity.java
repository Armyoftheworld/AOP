package com.army.aop;


import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.army.aop.annotation.BehaviorTrace;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
    }

    @BehaviorTrace("点击事件")
    public void onClick(View view) {
        SystemClock.sleep(1000);
    }
}
