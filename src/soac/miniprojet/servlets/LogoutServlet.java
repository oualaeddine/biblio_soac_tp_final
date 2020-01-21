package soac.miniprojet.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
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

            session.removeAttribute("user");
            response.sendRedirect("Auth");

        } else response.sendRedirect("/Login");


    }
}
