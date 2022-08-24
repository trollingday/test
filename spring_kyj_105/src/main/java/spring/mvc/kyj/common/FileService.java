package spring.mvc.kyj.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class FileService {
	
	public MultipartFile uploadFile(MultipartHttpServletRequest req) {
		
		MultipartFile file = req.getFile("imgFile");
		  
		//저장경로
		String saveDir=req.getSession().getServletContext().getRealPath("/resources/upload2/");
		  
		//저장경로(jsp의 IMG_UPLOAD_DIR)
		String realDir="D:\\Dev105\\workspace\\spring_kyj_105\\src\\main\\webapp\\resources\\upload2\\";
		  
		try {
			file.transferTo(new File(saveDir+file.getOriginalFilename()));
			FileInputStream fis = new FileInputStream(saveDir + file.getOriginalFilename());
			FileOutputStream fos = new FileOutputStream(realDir + file.getOriginalFilename());
		
			int data = 0;
			  
			while((data=fis.read())!=-1) {
				fos.write(data);
			}
			  
			fis.close();
			fos.close();
			  
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return file;		
			
	}

	public MultipartFile uploadFile2(MultipartHttpServletRequest req) {
		
		MultipartFile file = req.getFile("pdImg01");

		if(!file.isEmpty()) {
			  
			//저장경로
			String saveDir=req.getSession().getServletContext().getRealPath("/resources/upload/");
			  
			//저장경로(jsp의 IMG_UPLOAD_DIR)
			String realDir="D:\\Dev105\\workspace\\spring_kyj_105\\src\\main\\webapp\\resources\\upload\\";
			System.out.println("realDir : "+realDir);
		  
		    try {
			    file.transferTo(new File(saveDir+file.getOriginalFilename()));
			    FileInputStream fis = new FileInputStream(saveDir + file.getOriginalFilename());
			    FileOutputStream fos = new FileOutputStream(realDir + file.getOriginalFilename());
		
			    int data = 0;
			  
			    while((data=fis.read())!=-1) {
			    	fos.write(data);
			    }
			  
			    fis.close();
			    fos.close();
			  
		    } catch(IOException e) {
			    e.printStackTrace();
		    }			
		} else {
			return file;
		}
				
		return file;
	}

}
