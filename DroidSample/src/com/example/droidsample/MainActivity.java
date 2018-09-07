package com.example.droidsample;

import java.io.File;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView resultTv;
	private Button loadApkBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		resultTv = findViewById(R.id.resultTv);
		loadApkBtn = findViewById(R.id.loadApkBtn);
		resultTv.setText("load:" + Environment.getExternalStorageDirectory());

		String path = "file:///android_asset/DeviceCommon.apk";
		File file = new File(path) ;
		if (file.exists()) {
			resultTv.setText(file.getAbsolutePath());
		}else {
			resultTv.setText("没有文件");
		}
		
		loadApkBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FileUtils.createAiriSDKDir();
			}
		});
	}
}
