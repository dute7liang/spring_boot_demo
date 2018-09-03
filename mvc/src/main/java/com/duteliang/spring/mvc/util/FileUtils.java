package com.duteliang.spring.mvc.util;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @Description: 文件操作工具类
 * @Auther: zl
 * @Date: 2018-9-3 16:06
 */
public class FileUtils {

	/**
	 * 下载文件
	 * @param file
	 * @param filePath 文件路径
	 * @param fileName 文件名称
	 * @throws Exception
	 */
	public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
		File targetFile = new File(filePath);
		if(!targetFile.exists()){
			targetFile.mkdirs();
		}
		FileOutputStream out = null;
		try{
			new FileOutputStream(filePath+fileName);
			out.write(file);
			out.flush();
		} catch (Exception e){
			throw e;
		} finally {
			out.close();
		}
	}
}
