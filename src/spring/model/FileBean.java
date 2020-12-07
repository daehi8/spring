package spring.model;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("/file/")
public class FileBean {
	
	@Autowired
	private FileService fileServiceImpl = null;
	
	@RequestMapping("form.do")
	public String form() {
		return "1207/form";
	}
	
	
	// 최대 업로드 크기, 인코딩 크기는 컨트롤러에 설정
	// 파일이름 중복방지
	@RequestMapping("upload.do")
	public String upload(MultipartHttpServletRequest request, FileDTO dto) throws Exception {
		
		// 파일 객체 생성
		MultipartFile mf = request.getFile("save");	
		
		// 파일 원본 이름 객체 생성
		String fileName = mf.getOriginalFilename();		
		
		// DB에 저장
		dto.setOrgname(fileName);
		int num = fileServiceImpl.fileInsert(dto);
		
		// 파일 확장자 찾기
		String ext = fileName.substring(fileName.lastIndexOf("."));	
		
		// 저장된 파일 이름 설정
		String saveName = "file_"+num+ext;
		
		// DB에 saveName 추가 / 글번호와 저장된 파일 이름을 DTO에 대입
		dto.setNum(num);
		dto.setSavename(saveName);
		fileServiceImpl.fileUpdate(dto);
		
		// 저장경로
		String savePath = "C:\\Users\\82107\\Desktop\\WORK\\SAVE\\";
		
		// 파일 저장위치 객체 생성
		File saveFile = new File(savePath+saveName); 	
		
		// 파일업로드 예외처리
		try {
			mf.transferTo(saveFile);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "1207/upload";
	}
}
