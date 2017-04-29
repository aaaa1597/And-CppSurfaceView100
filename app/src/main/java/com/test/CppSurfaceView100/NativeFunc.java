package com.test.CppSurfaceView100;

import android.view.Surface;

public class NativeFunc {
    static { System.loadLibrary("testlib"); }

    public native static void create(int id);
    public native static void surfaceCreated(int id, Surface surface);
    public native static void surfaceChanged(int id, int width, int height);
    public native static void surfaceDestroyed(int id);
}
