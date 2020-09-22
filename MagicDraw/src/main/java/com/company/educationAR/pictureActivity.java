package com.company.educationAR;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class pictureActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picture);

        Resources resources = getApplicationContext().getResources();
        // 1.查找原图
        ImageView iv = (ImageView) findViewById(R.id.imageView2);
        Intent intent = getIntent();
        int aa = intent.getIntExtra("data", 1);
        Drawable drawable = resources.getDrawable(aa);
        iv.setImageDrawable(drawable);
    }

}