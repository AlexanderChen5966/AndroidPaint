package com.example.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.Log;
import android.view.View;
/*
 * 橡皮擦
 * */
public class EraserDraw extends View {
	protected Paint paint;//畫筆
	protected Canvas canvas;//畫布
	protected Bitmap bitmap;//位圖
	protected int downState;
	protected int moveState;
	protected Point downPoint,movePoint,upPoint;

	public EraserDraw(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		//建立畫筆
				paint = new Paint(Paint.DITHER_FLAG);
				//設定位圖的寬高
				bitmap = Bitmap.createBitmap(600,700,Bitmap.Config.ARGB_8888);
				canvas = new Canvas(bitmap);
				
				//設定橡皮擦
				//設置非填充
				paint.setStyle(Style.STROKE);
				//筆寬5個像素
				paint.setStrokeWidth(20);
				//設定筆色
				paint.setColor(Color.WHITE);
//				paint.setAlpha(1);//透明度為0
				//鋸齒不顯示
				paint.setAntiAlias(true);
//				paint.setDither(true);
//				paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
//				paint.setStrokeJoin(Paint.Join.ROUND); //平滑
//				paint.setStrokeCap(Paint.Cap.ROUND);  //圓頭
				
				downPoint = new Point();
				movePoint = new Point();
				upPoint = new Point();
				
				Log.i("EraserDraw", "bitmap::::::::::::::::::"+bitmap);
	
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		canvas.drawBitmap(bitmap, 0, 0,null);
	}
	
}
