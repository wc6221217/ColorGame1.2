package com.example.colorgame;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{
	Button button1;
	SeekBar red_seekBar,green_seekBar,blue_seekBar;
	TextView red_text,green_text,blue_text,back_panel,back_panel0;
	View root;
	int r,g,b,r0,g0,b0;
	int dr=300,dg=300,db=300;
	PopupWindow pWindow;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		r0=(int)(Math.random()*256);
		g0=(int)(Math.random()*256);
		b0=(int)(Math.random()*256);
		
		root = this.getLayoutInflater().inflate(R.layout.root, null);
        pWindow = new PopupWindow(root,350,200);
		
		button1=(Button) findViewById(R.id.button1);
		button1.setOnClickListener(this);
		
		back_panel0=(TextView)findViewById(R.id.back_panel0);
		back_panel0.setBackgroundColor(Color.rgb(r0, g0, b0));
		
		back_panel=(TextView)findViewById(R.id.back_panel);
		back_panel.setBackgroundColor(Color.rgb(r, g, b));
		
		red_text=(TextView)findViewById(R.id.red);
		red_seekBar=(SeekBar)findViewById(R.id.red_seekBar);
		red_seekBar.setOnSeekBarChangeListener(new RedSeekBar());
		
		green_text=(TextView)findViewById(R.id.green);
		green_seekBar=(SeekBar)findViewById(R.id.green_seekBar);
		green_seekBar.setOnSeekBarChangeListener(new GreenSeekBar());
		
		blue_text=(TextView)findViewById(R.id.blue);
		blue_seekBar=(SeekBar)findViewById(R.id.blue_seekBar);
		blue_seekBar.setOnSeekBarChangeListener(new BlueSeekBar());
		
		root.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				pWindow.dismiss();
				
			}
		});
		
		root.findViewById(R.id.restart).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this,MainActivity.class);
				finish();
				startActivity(intent);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		setTitle("按钮被按下");
		this.finish();
		
	}

	class RedSeekBar implements OnSeekBarChangeListener{
		public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
			red_text.setText("当前值："+progress);
			r=progress;
			back_panel.setBackgroundColor(Color.rgb(r, g, b));
			dr=Math.abs(r-r0);
			dg=Math.abs(g-g0);
			db=Math.abs(b-b0);
			if(dr<=30 && dg<=30 && db<=30){
				back_panel.setText("Success!!!");
				pWindow.showAtLocation(button1, Gravity.CENTER, 30, 25);
			}
		}

		public void onStartTrackingTouch(SeekBar seekBar) {
		
		}

		public void onStopTrackingTouch(SeekBar seekBar) {
			
		}
	}
	
	class GreenSeekBar implements OnSeekBarChangeListener{
		public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
			green_text.setText("当前值："+progress);
			g=progress;
			back_panel.setBackgroundColor(Color.rgb(r, g, b));
			dr=Math.abs(r-r0);
			dg=Math.abs(g-g0);
			db=Math.abs(b-b0);
			if(dr<=30 && dg<=30 && db<=30){
				back_panel.setText("Success!!!");
				pWindow.showAtLocation(button1, Gravity.CENTER, 30, 25);
			}
		}

		public void onStartTrackingTouch(SeekBar seekBar) {
		
		}

		public void onStopTrackingTouch(SeekBar seekBar) {
			
		}
	}
	
	class BlueSeekBar implements OnSeekBarChangeListener{
		public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
			blue_text.setText("当前值："+progress);
			b=progress;
			back_panel.setBackgroundColor(Color.rgb(r, g, b));
			dr=Math.abs(r-r0);
			dg=Math.abs(g-g0);
			db=Math.abs(b-b0);
			if(dr<=30 && dg<=30 && db<=30){
				back_panel.setText("Success!!!");
				pWindow.showAtLocation(button1, Gravity.CENTER, 30, 25);
			}
		}

		public void onStartTrackingTouch(SeekBar seekBar) {
		
		}

		public void onStopTrackingTouch(SeekBar seekBar) {
			
		}
	}
}
