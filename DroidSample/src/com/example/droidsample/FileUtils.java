package com.example.droidsample;

import java.io.File;

import android.os.Environment;

/**
 * @author weishu
 * @date 16/3/29
 */
public class FileUtils {

	public static void createAiriSDKDir() {
		String path = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "MA_AiriSDK";
		LogUtil.e(path);
		File destDir = new File(path);
		if (!destDir.exists()) {
			destDir.mkdirs();
		}else {
			LogUtil.e("~~~创建完成了");
		}
	}

	// /**
	// * 把Assets里面得文件复制到 /data/data/files 目录下
	// *
	// * @param context
	// * @param sourceName
	// */
	// public static void extractAssets(Context context, String sourceName) {
	// AssetManager am = context.getAssets();
	// InputStream is = null;
	// FileOutputStream fos = null;
	// try {
	// is = am.open(sourceName);
	// File extractFile = context.getFileStreamPath(sourceName);
	// fos = new FileOutputStream(extractFile);
	// byte[] buffer = new byte[1024];
	// int count = 0;
	// while ((count = is.read(buffer)) > 0) {
	// fos.write(buffer, 0, count);
	// }
	// fos.flush();
	// } catch (IOException e) {
	// e.printStackTrace();
	// } finally {
	// closeSilently(is);
	// closeSilently(fos);
	// }
	// }
	//
	// // --------------------------------------------------------------------------
	// private static void closeSilently(Closeable closeable) {
	// if (closeable == null) {
	// return;
	// }
	// try {
	// closeable.close();
	// } catch (Throwable e) {
	// // ignore
	// }
	// }
}
