package pack.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import pack.qa.QaBean;
import pack.qa.QaManager;

@WebServlet("/qa/QaUploadServlet")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 5,
    maxFileSize = 1024 * 1024 * 50,
    maxRequestSize = 1024 * 1024 * 60
)
public class QaUploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        // 업로드 경로 (실제 웹서버 경로에 저장)
        String uploadPath = getServletContext().getRealPath("/upload");
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs(); // 디렉토리 생성
        }

        // 폼 입력값 받기
        String writer = req.getParameter("writer");
        String postpassword = req.getParameter("postpassword");
        String title = req.getParameter("title");
        String postcontent = req.getParameter("postcontent");
        int secretYN = req.getParameter("secretYN") == null ? 0 : 1;

        // 이미지 처리
        Part filePart = req.getPart("image");
        String orgFileName = null;
        String saveFileName = null;

        if (filePart != null && filePart.getSize() > 0) {
            orgFileName = filePart.getSubmittedFileName();
            saveFileName = UUID.randomUUID().toString() + orgFileName;
            String filePath = uploadPath + File.separator + saveFileName;

            try (InputStream is = filePart.getInputStream()) {
                Files.copy(is, Paths.get(filePath));
            }

            // 게시글 내용에 이미지 태그 삽입
            postcontent += "<br><img src='" + req.getContextPath() + "/upload/" + saveFileName + "' width='400'/>";
        }

        // DB 저장용 Bean 생성
        QaBean bean = new QaBean();
        bean.setWriter(writer);
        bean.setPostpassword(postpassword);
        bean.setTitle(title);
        bean.setPostcontent(postcontent);
        bean.setSecretYN(secretYN);

        // 날짜는 현재 시각이 아닌 JSP에서 지정하거나 DB에서 설정할 수 있음
        bean.setPostcreatedate(new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()));

        // DB 저장
        QaManager manager = new QaManager();
        manager.saveData(bean);

        resp.sendRedirect("qa_list.jsp");
    }
}