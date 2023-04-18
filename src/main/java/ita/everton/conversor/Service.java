package ita.everton.conversor;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author emuvi
 */
@WebServlet(urlPatterns = {"/service"})
public class Service extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Direcao direcao = Direcao.from(req.getParameter("direcao"));
        if (direcao == null) {
            throw new RuntimeException("Você deve especificar a direção.");
        }
        Double origem = Double.valueOf(req.getParameter("origem"));
        Double resultado = direcao == Direcao.CelsiusParaFahrenheit
                ? (((origem * 9.0) / 5.0) + 32.0)
                : (((origem - 32.0) * 5.0) / 9.0);
        resp.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Temperatura Convertida</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Temperatura Convertida</h1>");
            out.println("<h2>" + resultado + "</h2>");
            out.println("<h3><a href='/conversor'>Return</a></h3>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
