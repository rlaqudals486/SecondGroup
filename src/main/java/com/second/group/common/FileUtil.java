package com.second.group.common;

import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.second.group.dto.SecondFileDto;

@Component
public class FileUtil {
	
	public List<SecondFileDto> parseFileInfo(int boardIdx, MultipartHttpServletRequest uploadFiles) throws Exception {

		if (ObjectUtils.isEmpty(uploadFiles)) {
			return null;
		}
		

		List<SecondFileDto> fileList = new ArrayList<>();
		

		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd"); // 날짜 형식 지정
		ZonedDateTime current = ZonedDateTime.now(); 
		

		String path = "images/" + current.format(format);
		

		File file = new File(path);

		if (file.exists() == false) {
			file.mkdirs(); 
		}
		
		
		Iterator<String> iterator = uploadFiles.getFileNames();
		
		String newFileName, oriFileExtension, contentType;
		
		while (iterator.hasNext()) {
			List<MultipartFile> list = uploadFiles.getFiles(iterator.next());
			
			for (MultipartFile multiFile : list) {
				if (multiFile.isEmpty() == false) {
					contentType = multiFile.getContentType();
					
					
					if (ObjectUtils.isEmpty(contentType)) {
						break;
					}
					else {
						if (contentType.contains("image/jpeg")) {
							oriFileExtension = ".jpg";
						}
						else if (contentType.contains("image/png")) {
							oriFileExtension = ".png";
						}
						else if (contentType.contains("image/gif")) {
							oriFileExtension = ".gif";
						}
						else {
							break;
						}
					}					

					newFileName = Long.toString(System.nanoTime()) + oriFileExtension;
					SecondFileDto secondFile = new SecondFileDto();
					secondFile.setBoardIdx(boardIdx);
					secondFile.setFileSize(multiFile.getSize());
					secondFile.setFileName(multiFile.getOriginalFilename());
					secondFile.setStoredFilePath(path + "/" + newFileName);
					fileList.add(secondFile);
					
					
					file = new File(path + "/" + newFileName);
					multiFile.transferTo(file);
				}
			}
		}
		
		return fileList;
	}
}