package com.illicitintelligence.android.animationbasics.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.illicitintelligence.android.animationbasics.R;

public class DroidSpace extends View {


    public DroidSpace(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        androidGuy = BitmapFactory.decodeResource(getResources(), R.drawable.sonic);
        int scale = 4;
        androidGuy = Bitmap.createScaledBitmap(androidGuy,
                androidGuy.getWidth()/scale,
                androidGuy.getHeight()/scale,
                false);

        paint = new Paint();
        posX = 0;
        posY = 0;
        matrix = new Matrix();
    }

    public DroidSpace(Context context) {
        super(context);
        androidGuy = BitmapFactory.decodeResource(getResources(), R.drawable.sonic);
        int scale = 4;
        androidGuy = Bitmap.createScaledBitmap(androidGuy,
                androidGuy.getWidth()/scale,
                androidGuy.getHeight()/scale,
                false);

        paint = new Paint();
        posX = 0;
        posY = 0;
        matrix = new Matrix();
    }

    public DroidSpace(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        androidGuy = BitmapFactory.decodeResource(getResources(), R.drawable.sonic);
        int scale = 4;
        androidGuy = Bitmap.createScaledBitmap(androidGuy,
                androidGuy.getWidth()/scale,
                androidGuy.getHeight()/scale,
                false);

        paint = new Paint();
        posX = 0;
        posY = 0;
        matrix = new Matrix();


    }

    private Bitmap androidGuy;
    private Paint paint;
    Matrix matrix;
    private int posX;
    private int posY;
    private float rotate = 0;
    private float rotateAngle = 4f;

    private float speedX = 10f;
    private float speedY = 10f;






    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(posX+androidGuy.getWidth()>=getWidth()){
            speedX = (int)Math.abs(speedX)*-1;
        }
        if(posY+androidGuy.getHeight()>=getHeight()){
            speedY=(int)Math.abs(speedY)*-1;
        }
        if(posX<0){
            speedX = (int)Math.abs(speedX);
        }
        if(posY<0){
            speedY = (int)Math.abs(speedY);
        }
        posX += speedX;
        posY += speedY;

        canvas.drawBitmap(rotateBitmap(),
                posX,
                posY,
                paint);
        rotate += rotateAngle;
        Log.d("TAG_X", "onDraw: "+rotate);
        invalidate();
    }

    public Bitmap rotateBitmap(float anglee) {
        matrix.postRotate(anglee);
        return Bitmap.createBitmap(androidGuy, 0, 0, androidGuy.getWidth(), androidGuy.getHeight(), matrix, true);
    }

    private Bitmap rotateBitmap(){
        return rotateBitmap(rotateAngle);
    }


    public void stop(){
        speedX = 0;
        speedY = 0;
    }

    public void speedUp(){
        if(speedX==0){
            speedX+=2;
        }else {
            speedX = speedX + speedX * 2 / Math.abs(speedX);
        }
        if(speedY==0) {
            speedY+=2;
        }else{
            speedY = speedY + speedY * 2 / Math.abs(speedY);
        }
    }

    public void slowDown(){
        if(Math.abs(speedX)<=1){
            speedX = 0;
        }else {
            speedX = speedX - speedX / Math.abs(speedX);
        }
        if(Math.abs(speedY)<=1) {
            speedY=0;
        }else{
            speedY = speedY - speedY / Math.abs(speedY);
        }
    }

    public void stopSpin(){
        rotateAngle = 0;
        rotate = 0;
    }

    public void spin(){
        rotateAngle+=1f;
    }

}
