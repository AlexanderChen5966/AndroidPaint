package com.example.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.Log;
import android.view.MotionEvent;

public class EraserPath extends EraserDraw {
	private Path mPath;
	private float mX, mY;
	
	public EraserPath(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		mPath = new Path();

	}
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		canvas.drawPath(mPath, paint);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		float x = event.getX();
		float y = event.getY();
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			onTouchDown(x, y);
			invalidate();
			break;
		case MotionEvent.ACTION_MOVE:
			onTouchMove(x, y);
			invalidate();
			break;
		case MotionEvent.ACTION_UP:
			onTouchUp(x, y);
			invalidate();
			break;
		default:
		}
		return true;
	}

	private void onTouchDown(float x, float y) {
		Log.e("eraser----", "touchdown");
		mPath.reset();
		mPath.moveTo(x, y);
		mX = x;
		mY = y;
	}

	private void onTouchMove(float x, float y) {
		Log.e("eraser---", "touchmove");
		float dx = Math.abs(x - mX);
		float dy = Math.abs(y - mY);
		if (dx > 0 || dy > 0) {
			mPath.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2);
			mX = x;
			mY = y;
		} else if (dx == 0 || dy == 0) {
			mPath.quadTo(mX, mY, (x + 1 + mX) / 2, (y + 1 + mY) / 2);
			mX = x + 1;
			mY = y + 1;
		}
	}

	private void onTouchUp(float x, float y) {
		Log.e("eraser----.", "upmove");
		// mPath.lineTo(mX, mY);
		canvas.drawPath(mPath, paint);
		mPath.reset();
	}
}
