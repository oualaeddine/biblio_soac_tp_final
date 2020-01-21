package soac.miniprojet.servlets;


import soac.miniprojet.api.StudentsBiblioInscAPI;
import soac.miniprojet.model.beans.Employees;
import soac.miniprojet.model.beans.InscriptionPeriod;
import soac.miniprojet.utils.ScholarYearHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * Servlet implementation class DashboardServlet
 */
@WebServlet({"/dashboard","/Dashboard"})
public class DashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentsBiblioInscAPI periodApi;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardServlet() {
        super();
        periodApi = new StudentsBiblioInscAPI();
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

            this.getServletContext().getRequestDispatcher("/WEB-INF/app_views/Dashboard.jsp").forward(request, response);
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
            String debut = request.getParameter("start");
            String fin = request.getParameter("end");
            switch (request.getParameter("action")) {

                case "add_period": {
                    if (!ScholarYearHelper.isInscPeriodOpen()) {
                        InscriptionPeriod period = new InscriptionPeriod();
                        period.setStartInscDate(new Date(debut));
                        period.setEndInscDate(new Date(fin));
                        periodApi.add(period);
                    }
                    break;
                }
                case "edit_period": {
                    if (ScholarYearHelper.isInscPeriodOpen()) {
                        InscriptionPeriod period = new InscriptionPeriod();
                        period.setStartInscDate(new Date(debut));
                        period.setEndInscDate(new Date(fin));
                        periodApi.update(period);
                    }
                    break;
                }
                case "end_period": {
                    if (ScholarYearHelper.isInscPeriodOpen()) {
                        String _id = request.getParameter("id");
                        int id = Integer.parseInt(_id);
                        InscriptionPeriod period = (InscriptionPeriod) periodApi.getById(id);
                        period.setEndInscDate(new Date(fin));
                        periodApi.update(period);
                    }
                    break;
                }
            }
            doGet(request, response);

        } else response.sendRedirect(request.getContextPath() + "/login");

    }

}
