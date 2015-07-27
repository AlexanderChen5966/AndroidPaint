

/* �m�ߤT
 * 
 * �ĤT�ӽm�߬O�e���M����
 * 
 * �o�ӽm�ߤ�������@�I�A���O���e���M��������]�w�A�H�θ��|�M�欰���P�_
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
/*�e���M��������\��t�~�����O����
 * 
 * */


public class MainActivity extends Activity {
	private Button penBtn;
	private Button eraserBtn;

	private DrawPath dp;
	private EraserPath ep;
	
	Paint p = new Paint(); 
	/*�]�mview���G���j�p
	 *this set of layout parameters defaults the width and the height
	 *LayoutParams.MATCH_PARENT�Mxml���A�w�q����j�p��match_parent�ݩʤ@��
	 *���B�Nheight�G�]�m��700�A�p�G�]�m��match_parent�Bwrap_content�hview�e�������ù��ɦ���s����
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
