package com.illicitintelligence.android.animationbasics.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.illicitintelligence.android.animationbasics.R;

public class Loader extends View {

    public Loader(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        imageArray = getResources().obtainTypedArray(R.array.my_loader_images);
        Log.d("TAG_X", "Loader: "+imageArray.length());
    }

    Bitmap gazoo;
    int index = 0 ;
    private TypedArray imageArray;
    Paint paint = new Paint();


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        index++;
        if(index >= imageArray.length()-1){
            index = 0;
        }
        int id = imageArray.getResourceId(imageArray.getIndex(index),R.drawable.sonic);
        if(id==R.drawable.sonic){
            Log.d("TAG_X", "onFail: "+index+", "+imageArray.getIndex(index));
        }else{
            Log.d("TAG_X", "onGood: "+index+", "+imageArray.getIndex(index));
        }
        gazoo = BitmapFactory.decodeResource(getResources(),
                id);

        canvas.drawBitmap(gazoo,0,0,paint);
        invalidate();
    }
}
