package soac.miniprojet.servlets;



import soac.miniprojet.api.EmployeesApi;
import soac.miniprojet.api.StudentsApi;
import soac.miniprojet.model.beans.Employees;
import soac.miniprojet.model.beans.Students;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Servlet implementation class UsersServlet
 */
@WebServlet("/users")
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {

			LinkedList<Employees> users = new EmployeesApi().getAll();
			request.setAttribute("users",users);
			this.getServletContext().getRequestDispatcher("/WEB-INF/app_views/Users.jsp").forward(request, response);

		} else response.sendRedirect(request.getContextPath() + "/login");


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPut(req, resp);
		String id = req.getParameter("id");
		new EmployeesApi().getById(Integer.parseInt(id));
		doGet(req,resp);


	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		new EmployeesApi().deleteById(Integer.parseInt(id));

		super.doDelete(req, resp);


	}
}
