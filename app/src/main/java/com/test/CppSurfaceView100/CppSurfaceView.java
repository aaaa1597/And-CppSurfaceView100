package com.test.CppSurfaceView100;

import android.content.Context;
import android.graphics.PixelFormat;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.util.Random;

/**
 * Created by jun on 2017/04/29.
 */
public class CppSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    int mId = -1;
    private static Random mRnd = new Random(System.currentTimeMillis());

    public CppSurfaceView(Context context, int id) {
        super(context);
        mId = id;
        setId(55000+mId);

        /* 背景色をランダムに設定 */
        int bkclr = mRnd.nextInt();
        bkclr &= 0xffffff00;
        bkclr |= 0x30;
        setBackgroundColor(bkclr);

        /* 透過設定 */
        getHolder().setFormat(PixelFormat.TRANSLUCENT);
        setZOrderOnTop(true);

        /* コールバック設定 */
        getHolder().addCallback(this);

        /* C++ */
        NativeFunc.create(id);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        NativeFunc.surfaceCreated(mId, holder.getSurface());
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        NativeFunc.surfaceChanged(mId, width, height);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        NativeFunc.surfaceDestroyed(mId);
    }
}
