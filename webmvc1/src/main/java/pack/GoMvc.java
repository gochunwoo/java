package pack;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/GoMvc")
public class GoMvc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 컨트롤러 역활
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String name;
		try {
			name = request.getParameter("name");
		} catch (Exception e) {
			name = null;
		}
		
		String result = "";
		String viewName = "";
		// 클라이언트의 요청을 판단 -> 적당한 모델 영역의 클래스를 수행 -> 결과 반환 -> 뷰 영역의 출력 파일을 선택
		if(name == null || name.equals("")) {
			result = "환영합니다"; // 모델 영역의 클래스를 수행 후 반환된 결과를 치환한다고 가정
			viewName = "환영합니다";
			viewName = "view1.jsp";
		}else if(name.equals("korea")) {
			result = "한국인이군요";
			viewName = "view2.jsp";
		}else if(name.equals("tome")) {
			result = name + "님 반가워요";
			viewName = "view3.jsp";
		}else {
			response.sendRedirect("gomvc.html1");
		}
		request.setAttribute("result", result);
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewName);
		dispatcher.forward(request, response);
	}

}
