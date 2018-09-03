package com.duteliang.spring.mvc.controller;

import com.duteliang.spring.mvc.vo.Json;
import lombok.extern.log4j.Log4j;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: 文件操作控制器， 上传文件 和 下载文件 <br/>
 * spring.http.multipart.maxFileSize=100Mb
 * spring.http.multipart.maxRequestSize=100Mb
 *
 *
 * @Auther: zl
 * @Date: 2018-9-3 14:27
 */
@Controller
@RequestMapping(value = "fileOperationController")
@Log4j
public class FileOperationController extends BaseController {

	/**
	 * 用缓存把已经保存的文件保存一下（模拟数据库）
	 */
	private static Map<String,File> map = new ConcurrentHashMap<>();

	private final static String FILE_PATH = "C:/fileTest/";

	private final static String PAGE = "html/fileOperation";

	@GetMapping(value = "page")
	public String page(){
		return PAGE;
	}

	/**
	 * 文件上传 （单个文件）
	 * @param file
	 */
	@PostMapping(value = "upload")
	@ResponseBody
	public Json upload(MultipartFile file,HttpServletRequest request){
		Json json = new Json();
		try {
			String fileName = file.getOriginalFilename();
			log.info("文件名："+fileName);
			String suffixName = fileName.substring(fileName.lastIndexOf("."));
			log.info("文件后缀名："+suffixName);
			File dest = new File(FILE_PATH + fileName);
			if(!dest.getParentFile().exists()){
				dest.getParentFile().mkdirs();
			}
			file.transferTo(dest);
			map.put(fileName, dest);
			json.setSuccess(true);
			json.setMsg("文件上传成功！");
		} catch (Exception e){
			log.info("文件上传失败！",e);
			json.setSuccess(false);
			json.setMsg(e.getMessage());
		}
		return json;
	}

	/**
	 * 文件上传 (支持多个文件)
	 * @return
	 */
	@PostMapping(value = "uploadMultiple")
	@ResponseBody
	public Json uploadMultiple(HttpServletRequest request){
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Json json = new Json();
		try {
			multipartRequest.setCharacterEncoding("UTF-8");
			Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
			MultipartFile fileMF = null;
			Set<Map.Entry<String, MultipartFile>> entrySet = fileMap.entrySet();
			int i = 0;
			for (Map.Entry<String, MultipartFile> entry : entrySet) {
				fileMF = entry.getValue();
				if(saveFile(fileMF,FILE_PATH)){
					i++;
				}
			}
			if(i == fileMap.size()){
				json.setSuccess(true);
				json.setMsg("文件上传成功！");
			} else {
				json.setSuccess(false);
				json.setMsg("文件上传失败，数量："+ (fileMap.size()-i));
			}
		} catch (UnsupportedEncodingException e) {
			log.error("文件上传失败！",e);
			json.setSuccess(false);
			json.setMsg("文件上传失败！");
		}
		return json;
	}

	private boolean saveFile(MultipartFile fileMF,String path){
		if(fileMF == null) return false;
		if(fileMF.isEmpty()) return false;
		File pathFile = new File(path);
		if(!pathFile.exists()){
			pathFile.mkdirs();
		}
		String fileName = fileMF.getOriginalFilename();
		File file = new File(pathFile,fileName);
		byte[] bytes = null;
		BufferedOutputStream stream = null;
		try {
			bytes = fileMF.getBytes();
			stream = new BufferedOutputStream(new FileOutputStream(file));
			stream.write(bytes);
			map.put(fileMF.getOriginalFilename(), file);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			IOUtils.closeQuietly(stream);
		}
	}


	@GetMapping("/download")
	public void download(HttpServletRequest request, HttpServletResponse response, String fileName) throws IOException {
		File file = map.get(fileName);
		// 清空response
		response.reset();
		// 设置response的Header
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(fileName.getBytes("gb2312"), "ISO8859-1"));
		// 基本的IO输出
		FileInputStream in = null;
		ServletOutputStream out = null;
		try {
			in = new FileInputStream(file);
			out = response.getOutputStream();
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len=in.read(buffer)) != -1){
				out.write(buffer, 0, len);
			}
		} catch (Exception e){
			log.error("文件下载失败！",e);
		} finally {
			IOUtils.closeQuietly(in);
			IOUtils.closeQuietly(out);
		}
	}

	/**
	 * 导出数据
	 */
	@RequestMapping(value = "exportMetaData",method = RequestMethod.GET)
	public void exportMetaData(HttpServletResponse response){
		OutputStream os = null;
		BufferedOutputStream bos = null;
		try {
			String metaDataJson = "哈哈哈哈哈哈哈哈123456789qwerteuihhjka";
			// 清空response
			response.reset();
			// 设置response的Header
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition",
					"attachment;filename=" +
							new String("metaData.txt".getBytes("gb2312"), "ISO8859-1"));
			os = response.getOutputStream();
			bos = new BufferedOutputStream(os);
			byte[] bytes = metaDataJson.getBytes("UTF-8");
			bos.write(bytes, 0, bytes.length);
		} catch (Exception e) {
			log.error("导出报表失败！",e);
		} finally {
			IOUtils.closeQuietly(bos);
			IOUtils.closeQuietly(os);
		}
	}

	@PostMapping(value = "queryFile")
	@ResponseBody
	public List<String> queryFile(){
		List<String> files = new ArrayList<>();
		for (Map.Entry<String, File> fileEntry : map.entrySet()) {
			files.add(fileEntry.getKey());
		}
		return files;
	}


}
