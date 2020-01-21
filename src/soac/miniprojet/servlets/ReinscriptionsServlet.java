package soac.miniprojet.servlets;


import soac.miniprojet.api.StudentsApi;
import soac.miniprojet.model.beans.Students;
import soac.miniprojet.model.beans.StudentsBiblioInsc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Servlet implementation class ReinscriptionsServlet
 */
@WebServlet("/reinscription")
public class ReinscriptionsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReinscriptionsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            LinkedList<Students> students = new StudentsApi().getAll();
            request.setAttribute("students", students);
            this.getServletContext().getRequestDispatcher("/WEB-INF/app_views/reinscription.jsp").forward(request, response);

        } else response.sendRedirect("/Login");



    }


    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _id = request.getParameter("id");
        int id = Integer.parseInt(_id);
        StudentsBiblioInsc fg = new StudentsBiblioInsc();
        fg.setId(id);

        new StudentsApi().Reinscrire(fg);
    }
}