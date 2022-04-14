package servlets;

import dao.DAOUserRepository;
import model.ModelLogin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletUserController", value = "/ServletUserController")
public class ServletUserController extends HttpServlet {

    private final DAOUserRepository daoUserRepository = new DAOUserRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String login = request.getParameter("login");
            String password = request.getParameter("password");

            ModelLogin modelLogin = new ModelLogin();
            modelLogin.setId(id != null && !id.isEmpty() ? Long.parseLong(id) : null);
            modelLogin.setName(name);
            modelLogin.setEmail(email);
            modelLogin.setLogin(login);
            modelLogin.setPassword(password);

            daoUserRepository.saveUser(modelLogin);

            RequestDispatcher redirect = request.getRequestDispatcher("main/user.jsp");
            request.setAttribute("model", modelLogin);
            redirect.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();

            RequestDispatcher redirect = request.getRequestDispatcher("erro.jsp");
            request.setAttribute("msg", e.getMessage());
            redirect.forward(request, response);
        }
    }

}
