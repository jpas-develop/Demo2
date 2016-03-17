package jp.co.jpas.demo2;

import android.app.ActivityManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate called");

        // サービスが実行中かチェック
        ActivityManager am = (ActivityManager)this.getSystemService(ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> listServiceInfo = am.getRunningServices(Integer.MAX_VALUE);

        Log.d(TAG, "Running Services ="+listServiceInfo.size());

        for(ActivityManager.RunningServiceInfo rsi : listServiceInfo){
            Log.d(TAG, rsi.service.getClassName());
        }

        // Serviceの起動
        Intent intent = new Intent(MainActivity.this, MyService.class);
        startService(intent);

        // Serviceの起動
        Intent intent2 = new Intent(MainActivity.this, HelloService.class);
        startService(intent2);

        for(ActivityManager.RunningServiceInfo rsi : listServiceInfo){
            Log.d(TAG, rsi.service.getClassName());
        }

    }


}




