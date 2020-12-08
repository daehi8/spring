package spring.model;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/file/")
public class FileBean {
	
	@Autowired
	private FileService fileDAO = null;
	
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
		//String savePath = "C:\\Users\\82107\\Desktop\\WORK\\SAVE\\";
		String savePath = request.getRealPath("save");
		System.out.println(savePath);
		
		// 파일 저장위치 객체 생성
		File saveFile = new File(savePath+"\\"+saveName); 	
		
		// 파일업로드 예외처리
		try {
			mf.transferTo(saveFile);
		}catch(Exception e){
			e.printStackTrace();
		}		
		
		return "redirect:/file/list.do";
	}
	
	
	@RequestMapping("list.do")
	public String list(Model model)throws Exception{
		//model.addAttribute("list", fileServiceImpl.selectAll());
		model.addAttribute("list", fileDAO.selectAll());
		return "1207/list";		
	}
	
	@RequestMapping("download.do")
	public void download(HttpServletResponse response, HttpServletRequest request, int num)throws Exception{
		FileDTO dto = fileServiceImpl.selectNum(num);
		
		// 다운로드할 파일 위치
		String savePath = request.getRealPath("save");
		File file = new File(savePath + "\\" + dto.getSavename());
		
		// 다운로드 전 버퍼 생성
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
		
		// 파일 형식을 모든 확장자로 저장 
		response.setContentType("application/octet-stream");
		
		// 리스폰스 헤더에 원본 파일이름을 다운로드이름으로 저장
		String fileName = java.net.URLEncoder.encode(dto.getOrgname(),"UTF-8");
		response.setHeader("Content-Disposition", "attachment; filename=\""+ fileName + "\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		// 다운로드
		FileCopyUtils.copy(in, response.getOutputStream());
		
		// 종료
	    in.close();
	    response.getOutputStream().flush();
	    response.getOutputStream().close();
	}
	
	@RequestMapping("down.do")
	public ModelAndView down(HttpServletRequest request, int num) throws Exception {
		FileDTO dto = fileServiceImpl.selectNum(num);
		String path = request.getRealPath("save")+"//"+dto.getSavename();
		File file = new File(path);
		// 다운로드 BEAN, 파라미터, 값 -> 파라미터와 값을 BEAN에 전송
		ModelAndView mv =new ModelAndView("download", "downloadFile", file);
		
		return mv;
	}
	
	@RequestMapping("delete.do")
	public String delete(HttpServletResponse response, HttpServletRequest request, int num)throws Exception{
		FileDTO dto = fileServiceImpl.selectNum(num);
		
		// 삭제할 파일 위치
		String savePath = request.getRealPath("save");
		File file = new File(savePath + "\\" + dto.getSavename());
		
		// 파일 삭제 및 데이터베이스 삭제
		if(file.exists() == true){
			file.delete();
			fileServiceImpl.fileDelete(num);
		}
		return "redirect:/file/list.do";	
	}	
}
