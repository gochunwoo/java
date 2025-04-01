package pack;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Servlet implementation class ProductList
 */
@WebServlet("/ProductList")
public class ProductList extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> products = new ArrayList<Product>();
		
		products.add(new Product("볼펜", 1500, "부드럽게 써짐", new Date()));
		products.add(new Product("연필", 1000, "그냥 써짐", new Date()));
		products.add(new Product("노트", 8000, "글쓸수있는 책이면서 그림도그릴수 있고 글도 쓴다", new Date()));
		
		request.setAttribute("products", products);
		request.getRequestDispatcher("productshow.jsp").forward(request, response);
	}
	
}
