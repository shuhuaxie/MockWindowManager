package com.example.gs.testaidl;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.example.gs.testaidl.mock.MockWindowManager;
import com.example.gs.testaidl.mock.MockWindowManagerGlobal;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainActivity extends Activity {
    private LayoutInflater mInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        forSystem();
        forMock();
//        Log.e("xie", "Mo:" + (MockWindowManagerGlobal.getWindowManagerService() == null));
    }

    private void forMock() {
        final WindowManager mWindowManager = new MockWindowManager(MainActivity.this,
                MainActivity.this.getWindow());
//        try {
////            Method getActivityToken = Activity.class.getDeclaredMethod("getActivityToken");
////            MainActivity.this.getWindow().setWindowManager(mWindowManager, (IBinder) getActivityToken.invoke(
////                    MainActivity.this),
////                    "com.example.gs.testaidl/com.example.gs.testaidl.MainActivity");
//            Field field = Window.class.getField("mWindowManager");
//            field.setAccessible(true);
//            field.set(MainActivity.this.getWindow(),mWindowManager);
//        } catch (Exception e) {
//            e.printStackTrace();
//            Log.e("xie", "e:" + e.getMessage());
//        }

//        final WindowManager mWindowManager = MainActivity.this.getWindow().getWindowManager();
        mInflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View contentView = mInflater.inflate(R.layout.mock_content, null);
        contentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWindowManager.removeViewImmediate(contentView);
            }
        });
        findViewById(R.id.show_mock_dialog).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // my windowManager
                WindowManager.LayoutParams params = new WindowManager.LayoutParams();
//                params.token = MainActivity.this
                try {
                    Method getActivityToken = Activity.class.getDeclaredMethod("getActivityToken");
                    getActivityToken.setAccessible(true);
                    params.token = (IBinder) getActivityToken.invoke(MainActivity.this);
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("xie", "e:" + e.getMessage());
                }

                mWindowManager.addView(contentView, params);
            }
        });
    }

    private void forSystem() {
        final WindowManager mWindowManager = (WindowManager) MainActivity.this.getSystemService(Context.WINDOW_SERVICE);
        mInflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View contentView = mInflater.inflate(R.layout.system_content, null);
        contentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWindowManager.removeViewImmediate(contentView);
            }
        });

        findViewById(R.id.show_system_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWindowManager.addView(contentView, new WindowManager.LayoutParams());
            }
        });
    }
}
