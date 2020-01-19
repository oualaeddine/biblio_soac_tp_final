package soac.miniprojet.servlets;

import soac.miniprojet.api.EmployeesApi;
import soac.miniprojet.model.beans.Employees;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AuthServlet
 */
public class AuthServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {


            if (request.getAttribute("error") == null)
                request.setAttribute("error", false);

            if (!(boolean) request.getAttribute("error"))
                request.setAttribute("error", false);

            this.getServletContext().getRequestDispatcher("/WEB-INF/app_views/Login.jsp").forward(request, response);
        } else response.sendRedirect("/Dashboard");

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        EmployeesApi employeeApi = new EmployeesApi();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + " " + password);
        boolean isAuth = employeeApi.login(username, password);

        if (isAuth) {
            HttpSession session = request.getSession();
            Employees employee = employeeApi.getByUsername(username);
            session.setAttribute("user", employee);
            response.sendRedirect("/Dashboard");
        } else {
            request.setAttribute("error", true);
            doGet(request, response);
        }
    }

}
