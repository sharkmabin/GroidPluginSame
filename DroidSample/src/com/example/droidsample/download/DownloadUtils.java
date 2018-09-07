package com.example.droidsample.download;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.example.droidsample.FileUtils;

public class DownloadUtils {

    public static void downLoad(final String path, final String FileName,final DownLoadListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                	File file = null ;
                    URL url = new URL(path);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setReadTimeout(5000);
                    con.setConnectTimeout(5000);
                    con.setRequestProperty("Charset", "UTF-8");
                    con.setRequestMethod("GET");
                    if (con.getResponseCode() == 200) {
                        InputStream is = con.getInputStream();//获取输入流
                        FileOutputStream fileOutputStream = null;//文件输出流
                        if (is != null) {
                            FileUtils fileUtils = new FileUtils();
                            file = fileUtils.createFile(FileName) ;
                            fileOutputStream = new FileOutputStream(file);//指定文件保存路径，代码看下一步
                            byte[] buf = new byte[1024];
                            int ch;
                            while ((ch = is.read(buf)) != -1) {
                                fileOutputStream.write(buf, 0, ch);//将获取到的流写入文件中
                            }
                        }else {
                        	listener.onFail("fileOutputStream is null");
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                            listener.onSuccess(file.getAbsolutePath());
                        }
                        
                    }else {
                    	listener.onFail("con.getResponseCode = " + con.getResponseCode());
                    }
                } catch (Exception e) {
                	listener.onFail("Exception e = " + e.getMessage());
                }
            }
        }).start();
    }
}
