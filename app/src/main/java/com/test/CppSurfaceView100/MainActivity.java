package com.test.CppSurfaceView100;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Point p = new Point();
        getWindowManager().getDefaultDisplay().getSize(p);
        Log.d("aaaaa", "aaaaa w=" + p.x + " h=" + p.y);

        int LpMax = 10;
        for(int lpy = 0; lpy < LpMax; lpy++) {
            for(int lpx = 0; lpx < LpMax; lpx++) {
                /* 100枚追加処理 */
                int id = (LpMax*lpy) + lpx;
                RelativeLayout.LayoutParams prm = new RelativeLayout.LayoutParams(p.x/LpMax, p.y/LpMax);
                if(lpx!=0) prm.addRule(RelativeLayout.RIGHT_OF, 55000+id-1);
                if(lpy!=0) prm.addRule(RelativeLayout.BELOW   , 55000+id-LpMax);

                ((RelativeLayout)findViewById(R.id.activity_main)).addView(new CppSurfaceView(this, id), prm);
            }
        }
    }
}
