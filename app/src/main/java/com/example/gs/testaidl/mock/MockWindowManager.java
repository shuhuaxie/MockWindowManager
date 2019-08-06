package com.example.gs.testaidl.mock;

import android.content.Context;
import android.os.IBinder;
import android.util.Log;
import android.view.*;

import java.lang.reflect.Method;

//@SystemService(Context.WINDOW_SERVICE)
public class MockWindowManager implements WindowManager {
    //    private Object mGlobal;
    private final Context mContext;
    private final Window mParentWindow;
    private IBinder mDefaultToken;

    public MockWindowManager(Context context) {
        this(context, null);
    }

    public MockWindowManager(Context context, Window parentWindow) {
        mContext = context;
        mParentWindow = parentWindow;

        try {

        } catch (Exception e) {

        }
    }

    public MockWindowManager createLocalWindowManager(Window parentWindow) {
        return new MockWindowManager(mContext, parentWindow);
    }

    @Override
    public void addView(View view, ViewGroup.LayoutParams params) {
        try {
            Class global = Class.forName("android.view.WindowManagerGlobal");
            Method m = global.getDeclaredMethod("getInstance");
            Object mGlobal = m.invoke(null);
//            Class global = Class.forName("android.view.WindowManagerGlobal");
            Method addView = global.getDeclaredMethod(
                    "addView", View.class, ViewGroup.LayoutParams.class,
                    Display.class, Window.class);
            Method getDisplay = Context.class.getDeclaredMethod("getDisplay");
            addView.invoke(mGlobal, view, params, getDisplay.invoke(mContext), null);

        } catch (Exception e) {
            e.printStackTrace();
            Log.e("xie", "e:" + e.getMessage());
        }
//        mGlobal.addView(view, params, mContext.getDisplay(), mParentWindow);
    }

    @Override
    public void updateViewLayout(View view, ViewGroup.LayoutParams params) {

    }

    @Override
    public Display getDefaultDisplay() {
        return null;
    }

    @Override
    public void removeViewImmediate(View view) {
        try {
            Class global = Class.forName("android.view.WindowManagerGlobal");
            Method m = global.getDeclaredMethod("getInstance");
            Object mGlobal = m.invoke(null);
            Method removeView = global.getDeclaredMethod(
                    "removeView", View.class, boolean.class);
            removeView.invoke(mGlobal, view, true);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("xie", "e:" + e.getMessage());
        }
//        mGlobal.removeView(view, true);

    }

    public void removeView(View view) {
//        mGlobal.removeView(view, false);
    }
}
