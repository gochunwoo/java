package pack;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/HelloServlet") // 논리적요청으로 물리적 파일을 찾아감
public class HelloServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	
	public void init(ServletConfig config) throws ServletException {	// 서블릿 초기화 코드
		// 서블릿이 첫 번쨰 요청을 받기전에 호출됩니다. 서블릿 객체가 생성되고 초기화될 때 실행되는 메서드 입니다
		// 주로 서블릿 초기화 작업을 여기서 수행합니다. 데이터베이스 연결설정,리소스 등을 처리할 수 있습니다
	}

	public void destroy() {// 서블릿 종료 시 리소스 정리 작업
		// 서블릿이 종료될때 호출됩니다. 서블릿이 더 이상 사용되지 않거나 서버가 종료될 때 리소스를 정리할 때 사용됩니다. 
		// 데이터베이스 연결를 닫거나 열린파일을 닫는 작업을 할 때 사용합니다
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("요청 성공");
		response.setContentType("text/html;charset=utf-8");	// Mime type 과 문자코드 설정
		// MIME TYPE 은 인터넷에서 전송되는 다양한 종류의 데이터를 식별하기 위한 형식
		
		PrintWriter out = response.getWriter();
		out.println("<body><html>");
		out.println("<h2>안녕하세요. 서블릿 세상입니다</h2>");   
		out.println("</body></html>");
		out.close();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// HTTP get 요청을 처리하는 메소드 입니다. 클라이언트가 URL 을 통해 정보를 요청할때 호출됩니다
		// 일반적으로 데이터를 조회하거나 정보를 표시할 떄 사용됩니다.
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// HTTP post 요청을 처리하는 메서드 입니다. 클라이언트가 데이터를 서버로 보내는 요청을 할 떄 사용됩니다.
		// 폼을 제출할 때 데이터를 서버로 보내는 경우 입니다
		doGet(request, response);
	}

}
