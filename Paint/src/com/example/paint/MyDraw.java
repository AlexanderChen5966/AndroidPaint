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
/* �Dview
 * ��L�e�Ϥu��view���O���~�ӭP�Dview
 * 
 * �Dview���O�����w�g���w�qpaint�Bbitmap�Bcanvas
 * �H�Τl���O�ݭn�Ψ쪺3��downPoint,movePoint,upPoint��k
 * 
 * */
public class MyDraw extends View {
protected Paint paint;//�e��
protected Canvas canvas;//�e��
protected Bitmap bitmap;//���
protected int downState;
protected int moveState;
protected Point downPoint,movePoint,upPoint;

	public MyDraw(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		//�إߵe��
		paint = new Paint(Paint.DITHER_FLAG);
		//�]�w��Ϫ��e��
		bitmap = Bitmap.createBitmap(600,700,Bitmap.Config.ARGB_8888);
		canvas = new Canvas(bitmap);
		
		//�]�w�e��
		//�]�m�D��R
		paint.setStyle(Style.STROKE);
		//���e5�ӹ���
		paint.setStrokeWidth(5);
		//�]�w����
		paint.setColor(Color.YELLOW);
		//���������
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
