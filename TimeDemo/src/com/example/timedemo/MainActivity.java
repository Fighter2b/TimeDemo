package com.example.timedemo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/** 
 * @author ���� Fighter2b 
 * @version ����ʱ�䣺2016-12-2 ����4:45:13 
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
		// ���ϵͳʱ���ʽ��24Сʱ�ƣ�ʹ��SimpleDateFormat��ʽ�����24Сʱ��ʱ��
		// ���ϵͳʱ���ʽ��12Сʱ�ƣ�ʹ��DateFormat���12Сʱ��ʱ��
		if (android.text.format.DateFormat.is24HourFormat(this)) {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			textView.setText("���ڵ�ʱ���ǣ�" + sdf.format(date) + ", ʹ�õĸ�ʽ�ǣ�" + "24Сʱ��");
		} else {
			textView.setText("���ڵ�ʱ���ǣ�" + df.format(date) + ", ʹ�õĸ�ʽ�ǣ�" + "12Сʱ��");
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		refreshTime();
	}

}
