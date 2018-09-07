package com.example.droidsample.download;

public interface DownLoadListener {
	void onSuccess(String path) ;
	void onFail(String errorMessage) ;
}	
