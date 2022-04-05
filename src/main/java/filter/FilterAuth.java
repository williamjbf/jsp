package filter;

import connection.SingleConnectionDB;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter(urlPatterns = {"/main/*"})
public class FilterAuth implements Filter {

    private static Connection connection;

    public FilterAuth(){
    }

    public void init(FilterConfig config) throws ServletException {
        connection = SingleConnectionDB.getConnection();
    }

    public void destroy() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        try {

            HttpServletRequest req = (HttpServletRequest) request;
            HttpSession session = req.getSession();

            String loggedUser = (String) session.getAttribute("user");

            String urlParaAutenticar = req.getServletPath();/*Url que está sendo acessada*/

            /*Validar se está logado senão redireciona para a tela de login*/
            if (loggedUser == null &&
                    !urlParaAutenticar.equalsIgnoreCase("/main/ServletLogin")) {/*Não está logado*/

                RequestDispatcher redireciona = request.getRequestDispatcher("/index.jsp?url=" + urlParaAutenticar);
                request.setAttribute("msg", "Por favor realize o login!");
                redireciona.forward(request, response);
                return; /*Para a execução e redireciona para o login*/

            } else {
                chain.doFilter(request, response);
            }

            connection.commit();

        }catch (Exception e){
            e.printStackTrace();
            RequestDispatcher redirect = request.getRequestDispatcher("erro.jsp");
            request.setAttribute("msg", e.getMessage());
            redirect.forward(request, response);
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
