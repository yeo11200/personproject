package com.sin1.util;

import java.io.File;
import java.io.IOException;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	
	// Controller로 넘어온 첨부파일을 실제적으로 서버의 하드디스크 복사해주는 메서드
	public static String copyFile(String realPath, MultipartFile multiFile) throws IOException {
		// 파일이 있는지 중복체크하여 처리하는 프로그램
		// 파일을 realPath에 저장(복시)
		File saveFile = FileUtil.removeDuplicat(realPath, multiFile.getOriginalFilename());
		// DB에서 저장파일이름을 바꿔준다.
//		dto.setFileName(saveFile.getName());
		
		// 예외 처리가 필요한 메서드를 호출 -> throws 시켜서 스프링 예외처리를 할 수 있도록 해준다.
		FileCopyUtils.copy(multiFile.getBytes(), saveFile);
		return saveFile.getName();
	}
	
	
	// 중복을 하지않게 한다. 
	// 중복이 되는 파일명을 확인해서 중복이 되면 중복이 되지않는 파일 객체를 만들어서 사용하게 해주는 메서드가 된다.
	public static File removeDuplicat(String realPath, String fileName) {
		File saveFile = new File(realPath, fileName);
		if(!saveFile.exists()) {
			// 중복이 되지않는 경우
			return saveFile;
		}
		else {
			// 중복이 되는 경우의 처리
			String firstName = fileName.substring(0, fileName.lastIndexOf("."));
			// .을 포함하는 것으로 만든다.
			String lastName = fileName.substring(fileName.lastIndexOf("."));
			// 중간에 붙이는 카운트 숫자 ex)dog01.jpg -> 01
			int cnt = 1;
			while(true) {
				// file 객체를 만들어야할 파일의 이름
				String saveFileName = firstName + cnt++ + lastName;
				System.out.println("FileUtil.removeDuplication().saveFileName : " + saveFileName);
				saveFile = new File(realPath, saveFileName);
				// 빠져나가는 조건 - 파일이 존재하지 않으면 리턴한다.
				if(!saveFile.exists()) {
					return saveFile;
				}
			}
		}
	}// end of removeDuplicat
	
	// 파일명을 받아서 서버에서 제거해주는 메서드 removeFile
	public static void removeFile(String realPath, String fileName) {
		// 파일객체를 만든다.
		File file = new File(realPath, fileName);
		// 파일을 지운다
		file.delete();
	}// end of removeFile
	
}//end ofFileUtil class
