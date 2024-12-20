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
 * Servlet implementation class DisplayRecordController
 */
public class DisplayRecordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayRecordController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		ProductService pservice = new ProductService();
		List<Product> lstprod = pservice.getAllProduct();
		
		response.setContentType("text/html");

	    pw.print("<html><head><style>");
	    pw.print("table { width: 80%; margin: 20px auto; border-collapse: collapse; }");
	    pw.print("th, td { padding: 12px; text-align: left; border: 1px solid #dddddd; }");
	    pw.print("th { background-color: #4CAF50; color: white; }");
	    pw.print("tr:nth-child(even) { background-color: #f2f2f2; }");
	    pw.print("tr:hover { background-color: #ddd; }");
	    pw.print("</style></head><body>");
	    
	    pw.print("<table>");
	    pw.print("<thead><tr><th>Product ID</th><th>Product Name</th><th>Price</th><th>Quantity</th></tr></thead>");
	    pw.print("<tbody>");
	    
	    for (Product prod : lstprod) {
	        pw.print("<tr>");
	        pw.print("<td>" + prod.getPid() + "</td>");
	        pw.print("<td>" + prod.getPname() + "</td>");
	        pw.print("<td>" + prod.getPprice() + "</td>");
	        pw.print("<td>" + prod.getPqty() + "</td>");
	        pw.print("</tr>");
	    }
	    
	    pw.print("</tbody>");
	    pw.print("</table>");
	    pw.print("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
