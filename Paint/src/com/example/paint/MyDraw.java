package com.example.paint;

import android.R.color;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.util.Log;
import android.view.View;
/* 主view
 * 其他畫圖工具view類別都繼承致主view
 * 
 * 主view類別中有已經有定義paint、bitmap、canvas
 * 以及子類別需要用到的3個downPoint,movePoint,upPoint方法
 * 
 * */
public class MyDraw extends View {
protected Paint paint;//畫筆
protected Canvas canvas;//畫布
protected Bitmap bitmap;//位圖
protected int downState;
protected int moveState;
protected Point downPoint,movePoint,upPoint;

	public MyDraw(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		//建立畫筆
		paint = new Paint(Paint.DITHER_FLAG);
		//設定位圖的寬高
		bitmap = Bitmap.createBitmap(600,700,Bitmap.Config.ARGB_8888);
		canvas = new Canvas(bitmap);
		
		//設定畫筆
		//設置非填充
		paint.setStyle(Style.STROKE);
		//筆寬5個像素
		paint.setStrokeWidth(5);
		//設定筆色
		paint.setColor(Color.YELLOW);
		//鋸齒不顯示
		paint.setAntiAlias(true);

		downPoint = new Point();
		movePoint = new Point();
		upPoint = new Point();
		
		Log.i("MyDraw", "bitmap::::::::::::::::::"+bitmap);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		canvas.drawBitmap(bitmap, 0, 0,null);
	}

}
