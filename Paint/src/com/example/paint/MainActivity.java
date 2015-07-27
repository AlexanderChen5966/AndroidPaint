

/* 練習三
 * 
 * 第三個練習是畫筆和擦布
 * 
 * 這個練習比較複雜一點，分別有畫筆和橡皮擦的設定，以及路徑和行為的判斷
 * 
 * 
 * */

package com.example.paint;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Paint;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
/*畫筆和橡皮擦的功能另外用類別分離
 * 
 * */


public class MainActivity extends Activity {
	private Button penBtn;
	private Button eraserBtn;

	private DrawPath dp;
	private EraserPath ep;
	
	Paint p = new Paint(); 
	/*設置view的佈局大小
	 *this set of layout parameters defaults the width and the height
	 *LayoutParams.MATCH_PARENT和xml中，定義控制大小的match_parent屬性一樣
	 *此處將height：設置為700，如果設置為match_parent、wrap_content則view畫布佔滿螢幕檔住按鈕元件
	 * 
	*/
	LayoutParams lParams = new LayoutParams(LayoutParams.WRAP_CONTENT,700);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initHandler();
		
	}

	private void initView() {
		// TODO Auto-generated method stub
		penBtn = (Button)findViewById(R.id.penButton);
		eraserBtn = (Button)findViewById(R.id.eraserButton);
	}

	private void initHandler() {
		// TODO Auto-generated method stub
		penBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dp = new DrawPath(getApplicationContext());
				addContentView(dp, lParams);
			}
		});
		
		eraserBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ep = new EraserPath(getApplicationContext());
				addContentView(ep, lParams);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
