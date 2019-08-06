package com.example.gs.testaidl.mock;

import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

//import com.example.gs.mockwindowmanager.IMockWindowManager;
//import com.example.gs.mockwindowmanager.IMockWindowSession;

public class MockWindowManagerGlobal {
    private static final String TAG = "WindowManager";
    private static MockWindowManagerGlobal sDefaultWindowManager;
//    private static IMockWindowManager sWindowManagerService;
//    private static IMockWindowSession sWindowSession;

    private MockWindowManagerGlobal() {
    }

    public static MockWindowManagerGlobal getInstance() {
        synchronized (MockWindowManagerGlobal.class) {
            if (sDefaultWindowManager == null) {
                sDefaultWindowManager = new MockWindowManagerGlobal();
            }
            return sDefaultWindowManager;
        }
    }

//    public static IMockWindowSession getWindowSession() {
//        synchronized (MockWindowManagerGlobal.class) {
//            if (sWindowSession == null) {
//                try {
//                    Class InputMethodManagerClass = InputMethodManager.class;
////                    InputMethodManager imm = InputMethodManager.getInstance();
//                    Method getInstance = InputMethodManagerClass.getDeclaredMethod("getInstance");
//                    Method getClient = InputMethodManagerClass.getDeclaredMethod("getClient");
//                    Method getInputContext = InputMethodManagerClass.getDeclaredMethod("getInputContext");
//                    InputMethodManager imm = (InputMethodManager)getInstance.invoke(null);
//                    IMockWindowManager windowManager = getWindowManagerService();
////                    sWindowSession = windowManager.openSession(
////                            new IWindowSessionCallback.Stub() {
////                                @Override
////                                public void onAnimatorScaleChanged(float scale) {
//////                                    ValueAnimator.setDurationScale(scale);
////                                }
////                            },
////                            getClient.invoke(imm), getInputContext.invoke(imm));
//                } catch (Exception e) {
////                    throw e.rethrowFromSystemServer();
//                    Log.e("xie", "getWindowSession e:" + e.getMessage());
//                }
//            }
//            return sWindowSession;
//        }
//    }
//
//    public static IMockWindowManager getWindowManagerService() {
//        // 反射获取ServiceManager
//        Class ServiceManager = null;
//        try {
//            ServiceManager = Class.forName("android.os.ServiceManager");
//            Method getService = ServiceManager.getDeclaredMethod("getService", String.class);
//            synchronized (MockWindowManagerGlobal.class) {
//                if (sWindowManagerService == null) {
//                    sWindowManagerService = IMockWindowManager.Stub.asInterface(
//                            (IBinder) getService.invoke(null, "window"));
////                try {
////                    sWindowManagerService = getWindowManagerService();
//////                    ValueAnimator.setDurationScale(sWindowManagerService.getCurrentAnimatorScale());
////                } catch (RemoteException e) {
////                    Log.e(TAG, "Failed to get WindowManagerService, cannot set animator scale", e);
////                }
//                }
//            }
//            return sWindowManagerService;
//        } catch (Exception e) {
//            Log.e("xie", "e:" + e.getMessage());
//            e.printStackTrace();
//        }
//        return null;
//    }
//    }

    public void addView(View view, ViewGroup.LayoutParams params, Display display, Window window) {
//        new ViewRootImpl(view.getContext(), display);
    }

    public void removeView(View view, boolean b) {

    }
}
