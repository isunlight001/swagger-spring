package com.scan.controll;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 下载功能
 * @author sunlight001
 * 2018年12月12日
 */
@Controller
@RequestMapping("/file") 
public class DownloadController {
	/**
	 * 使用组件下载，可以兼容的格式比较多
	 * 设置filename和path进行传参
	 * 2018年12月13日@return
	 * 2018年12月13日@throws IOException
	 */
	@RequestMapping(value = "/downfile")
    public ResponseEntity<byte[]> downloadFile() throws IOException { 
        HttpHeaders headers = new HttpHeaders();    
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);    
        headers.setContentDispositionFormData("attachment", "git命令.png");    
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(new File(
        		"/Users/apple/Downloads/git命令.png")),   
                                              headers, HttpStatus.CREATED);    
    }  
   
    @RequestMapping(value = "/downfile1",produces = "application/octet-stream;charset=UTF-8")
    public void download(HttpServletRequest request, 
    	      HttpServletResponse response, String storeName, String contentType1
    	       ) throws Exception {  
    	    request.setCharacterEncoding("UTF-8");  
    	    BufferedInputStream bis = null;  
    	    BufferedOutputStream bos = null;  
    	    //获取项目根目录
//    	    String ctxPath = request.getSession().getServletContext()  
//    	        .getRealPath("");  
    	    //获取下载文件露肩
//    	    String downLoadPath = ctxPath+"/uploadFile/"+ storeName;  
    	    String downLoadPath = "/Users/apple/Downloads/git命令.png\"";  
    	  
    	    //获取文件的长度
    	    long fileLength = new File(downLoadPath).length();  
    	    //设置文件输出类型
    	    response.setContentType("application/octet-stream");  
    	    response.setHeader("Content-disposition", "attachment; filename=11.png"  
    	        ); 
    	    //设置输出长度
    	    response.setHeader("Content-Length", String.valueOf(fileLength));  
    	    //获取输入流
    	    bis = new BufferedInputStream(new FileInputStream(downLoadPath));  
    	    //输出流
    	    bos = new BufferedOutputStream(response.getOutputStream());  
    	    byte[] buff = new byte[2048];  
    	    int bytesRead;  
    	    while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {  
    	      bos.write(buff, 0, bytesRead);  
    	    }  
    	    //关闭流
    	    bis.close();  
    	    bos.close();  
    	  }  
    	   
}
