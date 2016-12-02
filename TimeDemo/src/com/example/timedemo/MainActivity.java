package com.example.timedemo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/** 
 * @author 作者 Fighter2b 
 * @version 创建时间：2016-12-2 下午4:45:13 
 * 
 */
public class MainActivity extends Activity {

	private TextView textView;
	private DateFormat df;
	private Date date;
	@SuppressLint("SimpleDateFormat")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView = (TextView) findViewById(R.id.textView);
		df = android.text.format.DateFormat.getDateFormat(this);
		df = android.text.format.DateFormat.getTimeFormat(getApplicationContext());
	}

	@SuppressLint("SimpleDateFormat")
	public void refreshTime() {
		date = new Date(System.currentTimeMillis());
		// 如果系统时间格式是24小时制，使用SimpleDateFormat格式化输出24小时制时间
		// 如果系统时间格式是12小时制，使用DateFormat输出12小时制时间
		if (android.text.format.DateFormat.is24HourFormat(this)) {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			textView.setText("现在的时间是：" + sdf.format(date) + ", 使用的格式是：" + "24小时制");
		} else {
			textView.setText("现在的时间是：" + df.format(date) + ", 使用的格式是：" + "12小时制");
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		refreshTime();
	}

}
