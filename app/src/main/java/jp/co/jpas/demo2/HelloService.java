package jp.co.jpas.demo2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class HelloService extends Service {

    public static String TAG = "HelloService";

    /** indicates how to behave if the service is killed */
    int mStartMode;

    /** interface for clients that bind */
    IBinder mBinder;

    /** indicates whether onRebind should be used */
    boolean mAllowRebind;

    /** Called when the service is being created. */
    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate called");
    }

    /** The service is starting, due to a call to startService() */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand called");

        return mStartMode;
    }

    /** A client is binding to the service with bindService() */
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind called");

        return mBinder;
    }

    /** Called when all clients have unbound with unbindService() */
    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind called");
        return mAllowRebind;
    }

    /** Called when a client is binding to the service with bindService()*/
    @Override
    public void onRebind(Intent intent) {
        Log.d(TAG, "onRebind called");

    }

    /** Called when The service is no longer used and is being destroyed */
    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy called");

    }
}