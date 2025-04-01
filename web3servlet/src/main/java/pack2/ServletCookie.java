package pack2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;


@WebServlet("/ServletCookie")
public class ServletCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<link rel='stylesheet' type='text/css' href='css/css.css'>");
		out.println("<body><html>");
		out.println("<h3>*로그인*</h3>");
		out.println("<form method='post'>");	// action 이 없으면 현재 서블릿을 다시호출
		out.println("i d : <input type='text' name='id'><br>");
		out.println("pwd : <input type='text' name='pwd'><br>");
		out.println("<input type='submit' value='로그인'>");
		out.println("</form>");
		out.println("</body></html>");
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<link rel='stylesheet' type='text/css' href='css/css.css'>");
		
		out.println("<body><html>");
		// 특정 클라이언트의 쿠키를 읽어 로그인 화면 출력 여부 결정
		
		// 쿠키가 이미 있다면 (로그인 한 상태라면) 로그인 화면대신 다른 무언가의 작업을 표시한다
		// 웹서버는 클라이언트의 요청이 있는 경우 클라이언트에 저장된 모든 쿠키를 읽어 자신이 만든 쿠키를 찾음
		String id = null;
		String pwd = null;
		try {
			Cookie[] cookies = request.getCookies();
			for(int i=0; i< cookies.length; i++) {
				String name = cookies[i].getName();
				System.out.println("name : " + name);
				if(name.equals("id")) {
					id = URLDecoder.decode(cookies[i].getValue(),"utf-8");
					
				}
				if(name.equals("pwd")) {
					pwd = URLDecoder.decode(cookies[i].getValue(),"utf-8");
					
			}
		}
		} catch (Exception e) {
		}
		  if(id != null && pwd != null) {
		         out.println(id + "님 쿠키를 통해 로그인한 상태임을 확인했어요. 저희가 제공한 모든 정보를 즐기세요");
		         out.println("</body></html>");
		         out.close();
		         return;
		         
		      }
		// 쿠키가 없는 뎡우에만 로그인 화면 출력
		// System.out.println(id + " " + pwd);
		
		if(id.equals("aa") && pwd.equals("11")) {
			out.println("로그인 성공 : 쿠키 생성");
			try {
				// 로그인에 성공(인증)한 경우 클라이언트 컴에 웹 서버가 쿠키를 저장
				id = URLEncoder.encode(id,"utf-8"); // 암호화:쿠키와 같이 한글을 표현하지 못하는 경우 한글을 ASCII값으로 인코딩
				Cookie idCookie = new Cookie("id", id);		// new Cookie("키", 값) 형식으로 작성
				idCookie.setMaxAge(60 * 60 * 24 * 365);	// 초 분 하루 년 : 쿠키 유효기간
				
				pwd = URLEncoder.encode(id,"utf-8");
				Cookie pwdCookie = new Cookie("pwd", pwd);	
				pwdCookie.setMaxAge(60 * 60 * 24 * 365);	
				
				// 클라이언트 컴에 쿠리를 저장
				response.addCookie(idCookie);	
				response.addCookie(pwdCookie);
				
			} catch (Exception e) {
				
			}
		}else {
			out.println("로그인실패");
		}
		out.println("</body></html>");
		out.close();
	}

}
