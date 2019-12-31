package com.linda.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class GameView extends View {
    private float posX, posY = 400;
    Happy happy;


    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        if (happy == null){
//            happy = new Happy(this);
//        }
        Log.d("Game", "onDraw: " + getWidth() + "," + getHeight());
        Paint paint = new Paint();
        Paint paint0 = new Paint();
        paint0.setColor(0);
        canvas.drawLine(400,0, 0,600, paint);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.happy);
        canvas.drawBitmap(bitmap, posX, posY, paint);
//        for (int i=0; i<getHeight()-bitmap.getHeight(); i+=50) {
//            canvas.drawBitmap(bitmap, 400, 300+i, paint);
//        }
    }

    public void moveRight(){
        if (posX < getWidth()-150){
            posX = posX +50;
            invalidate();
        }
    }

    public void moveLeft(){
        if (posX > 50){
            posX -= 50;
            invalidate();
        }
    }

    public void moveUp(){
        if (posY > 50){
            posY = posY - 50;
            invalidate();
        }
    }

    public void moveDown(){
        if (posY < getHeight()-150){
            posY = posY +50;
            invalidate();
        }
    }

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        if (posX >= 0 && posX < getWidth()-100) {
            this.posX = posX;
        }
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        if (posY > 0 && posY < getWidth()-100) {
            this.posY = posY;
        }
    }
}
