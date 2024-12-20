package shop.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import shop.model.Product;
import shop.service.ProductService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Servlet implementation class SearchController
 */
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		Product prod = new Product();
		int pid = Integer.parseInt(request.getParameter("pid"));
		ProductService pservice = new ProductService();
		List<Product> lstprod = pservice.retrieveProduct(pid);
		if(lstprod != null) {
			prod = lstprod.get(0);
			pw.println("<html><head><style>");
	        pw.println("body { font-family: Arial, sans-serif; background-color: #f9fafb; padding: 20px; }");
	        pw.println("h2 { color: #2980b9; }");
	        pw.println("table { width: 100%; border-collapse: collapse; margin-top: 20px; }");
	        pw.println("th, td { padding: 10px; border: 1px solid #ddd; text-align: left; }");
	        pw.println("th { background-color: #4CAF50; color: white; }");
	        pw.println("tr:nth-child(even) { background-color: #f2f2f2; }");
	        pw.println("</style></head><body>");
	        
	        pw.println("<h2>Product Details</h2>");
	        pw.println("<table>");
	        pw.println("<tr><th>Product ID</th><th>Product Name</th><th>Price</th><th>Quantity</th></tr>");
	        pw.println("<tr>");
	        pw.println("<td>" + prod.getPid() + "</td>");
	        pw.println("<td>" + prod.getPname() + "</td>");
	        pw.println("<td>" + prod.getPprice() + "</td>");
	        pw.println("<td>" + prod.getPqty() + "</td>");
	        pw.println("</tr>");
	        pw.println("</table>");
	        
	        pw.println("</body></html>");
	    } else {
	        pw.println("<h3>"+"Product not found."+"</h3>");
	    }
	}
}