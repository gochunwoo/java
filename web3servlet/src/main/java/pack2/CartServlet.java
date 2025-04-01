package pack2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		// 세션을 사용
		// 두개의 값 받기
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		
		// 장바구니 공간(세션) 을만듬 / 세션이 있으면 기존세션그대로사용 없으면 새롭게 만듬
		HttpSession httpSession = request.getSession(true);
		
		// 세션(장바구니)에 담긴 기존 상품 목록이 있는지 확인하고 가져옴
		// 장바구니에 상품이 있으면 그상품들이 glist 에 저장 처음 장바구니를 사용하는경우 null 이 나올수도있음
		ArrayList<Goods> glist = (ArrayList<Goods>)httpSession.getAttribute("list"); // 장바구니 관리 코드
		
		// 만약 처음 장바구니를 사용하는 사용자라면 glist 가 null 이 됩니다.
		// 그러면 새로운 장바구니 ArrayList 를 만들어줌
		// 이코드는 null 체크를 너무 늦게 해서 논리 오류가 있음 다음에 glist 사용하기 전에 null 체크가 먼저와야됨
		// 비유: 장바구니가 아예 없는 상태라면 새로운 장바구니를 가져오는 것과 같아요
		if (glist == null) glist = new ArrayList<Goods>();	// Goods 용 컬렉션 객체 생성
		
		// 선택한 상품을 새로운 상품 객체(Goods)로 만들고 장바구니(glist)에 추가함
		//	비유: 장바구니에 새로 상품을 넣는 것과 같음
		glist.add(new Goods(name, price));	// 컬렉션의 장바구니에 담을 DTO 에 값 저장후 컬렉션에 담기
		
		// 업데이트된 장바구니(glist) 를 세션(사용자 공간)에 다시 저장함,장바구니에 담긴 상품을 유지할수있음
		// 비유: 장바구니에 상품을 담고 "이거 내 장바구니야!" 하고 이름표를 붙이는 느낌
		httpSession.setAttribute("list", glist);	// 컬렉션(장바구니 정보가 있는 DTO)을 세션에 저장
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<link rel='stylesheet' type='text/css' href='css/css.css'>");
		out.println("<body><html>😘" + name + " 상품 구입하셧습니다.😘");
		
		out.println("<br>[<a href='shopping/shop.html'>🏠 계속 쇼핑 🏠</a>]");
		out.println("&nbsp;&nbsp;[ <a href='BuyServlet'>💲결제 하기💲</a>]");
		out.println("<br><table width='80%' border='1'>");
		out.println("<tr><th>상품명</th><th>가격</th></tr>");
		for(int i=0; i < glist.size(); i++) {
		Goods goods = glist.get(i);	// 컬렉션에 저장된 상품자료(DTO) 한 개씩 꺼내서 출력
		out.println("<tr>");
		out.println("<td>" + goods.getName() + "</td>");
		out.println("<td>" + goods.getPrice() + " 원</td>");
		out.println("</tr>");
		}
		
		
		
		out.println("</table>");
		
		out.println("</body></html>");
		out.close();
		
	}

}
