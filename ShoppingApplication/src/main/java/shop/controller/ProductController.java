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

/**
 * Servlet implementation class ProductController
 */
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter pw = response.getWriter();
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		String pname = request.getParameter("pname");
		float pprice = Float.parseFloat(request.getParameter("pprice"));
		int pqty = Integer.parseInt(request.getParameter("pqty"));
		
		Product prodobj = new Product(pid, pname, pprice, pqty);
		
		ProductService pservice = new ProductService();
		int i = pservice.createProduct(prodobj);
		if(i > 0) {
			response.sendRedirect("success.html");
		}
		else pw.println("Could not save record");
		
	}

}
