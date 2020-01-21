package soac.miniprojet.servlets;


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
import java.util.Date;
import java.util.LinkedList;

/**
 * Servlet implementation class StudentsServlet
 */
@WebServlet("/students")
public class StudentsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final StudentsApi api;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentsServlet() {
        super();
        // TODO Auto-generated constructor stub
       this.api= new StudentsApi();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            Employees user = (Employees)session.getAttribute("user");

            request.setAttribute("user",user.getNom()+" "+user.getPrenom());
            request.setAttribute("role",user.getRole());
            System.out.println(user.getRole());

            LinkedList<Students> students = new StudentsApi().getAll();
            request.setAttribute("students", students);
            this.getServletContext().getRequestDispatcher("/WEB-INF/app_views/Students.jsp").forward(request, response);

        } else response.sendRedirect(request.getContextPath() + "/login");




    }


    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            Employees user = (Employees)session.getAttribute("user");

            request.setAttribute("user",user.getNom()+" "+user.getPrenom());
            request.setAttribute("role",user.getRole());

            String _id = request.getParameter("id");
            int id = Integer.parseInt(_id);
            String nom = request.getParameter("nom");
            String  prenom = request.getParameter("prenom");
            String  date_naiss = request.getParameter("date_naiss");
            String  sexe = request.getParameter("sexe");
            String  num_bac = request.getParameter("num_bac");

            Students s = new Students();
            s.setId(id);
            s.setNom(nom);
            s.setPrenom(prenom);
            s.setDateNaiss(new Date(date_naiss));
            s.setSexe(sexe);
            s.setNumBac(num_bac);
            s.setDateInsc(new Date());
            api.update(s);

            doGet(request, response);

        } else response.sendRedirect(request.getContextPath() + "/login");




    }



    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("user") != null) {
            Employees user = (Employees)session.getAttribute("user");

            req.setAttribute("user",user.getNom()+" "+user.getPrenom());
            req.setAttribute("role",user.getRole());

            String id = req.getParameter("id");
            api.deleteById(Integer.parseInt(id));
            doGet(req,resp);

        } else resp.sendRedirect(req.getContextPath() + "/login");



    }
}
