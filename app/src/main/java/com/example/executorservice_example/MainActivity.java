package com.example.executorservice_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private String HTML_URL = "https://api.github.com/user/repos";
    private String token = "6e88c875791a29d5f2b31187b51a81f7c6273337"; //有時效性，要在github 上建一個新的
    HttpHelper httpHelper;
    Animation animation =  new Animation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        httpHelper = HttpHelper.getInstance();
        httpHelper.setPath(HTML_URL);
        httpHelper.setMethod("GET");
        httpHelper.setToken(token);
        httpHelper.request(); // request() 和 runAnimate() 會同時跑
        animation.runAnimate(); //若要確保先走 request 完後再走runAnimate，就將runAnimate 放在request 的run裡面，是比較差的作法

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("suvini", "onDestroy");
        httpHelper.Destroy();
        animation.Destroy();
    }
}
