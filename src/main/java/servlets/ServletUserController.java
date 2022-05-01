package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.DAOUserRepository;
import model.ModelLogin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletUserController", value = "/ServletUserController")
public class ServletUserController extends HttpServlet {

    private final DAOUserRepository daoUserRepository = new DAOUserRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            String action = request.getParameter("action");

            if (action != null && action.equalsIgnoreCase("delete")) {
                String idUser = request.getParameter("id");
                daoUserRepository.deleteUserById(idUser);

                RequestDispatcher redirect = request.getRequestDispatcher("main/user.jsp");
                request.setAttribute("msg", "User successfully deleted");
                redirect.forward(request, response);
            } else if (action != null && action.equalsIgnoreCase("search")) {
                String searchName = request.getParameter("searchName");
                List<ModelLogin> usersFound = daoUserRepository.getUserByName(searchName);

                ObjectMapper mapper = new ObjectMapper();
                String json = mapper.writeValueAsString(usersFound);
                response.getWriter().write(json);
            } else if (action != null && action.equalsIgnoreCase("edit")) {
                String id = request.getParameter("id");

                ModelLogin modelLogin = daoUserRepository.getUserById(id);
                request.setAttribute("msg", "User being edited");
                request.setAttribute("model", modelLogin);
                request.getRequestDispatcher("main/user.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();

            RequestDispatcher redirect = request.getRequestDispatcher("erro.jsp");
            request.setAttribute("msg", e.getMessage());
            redirect.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            String msg = "";

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

            if (daoUserRepository.loginExists(modelLogin.getLogin()) && modelLogin.getId() == null) {
                msg = "There is already a user with the same login, enter another login";
                modelLogin = daoUserRepository.getUserByLogin(modelLogin.getLogin());
            } else {
                if (modelLogin.isNew()) {
                    msg = "User created successfully";
                } else {
                    msg = "User successfully updated";
                }
                modelLogin = daoUserRepository.saveUser(modelLogin);
            }

            RequestDispatcher redirect = request.getRequestDispatcher("main/user.jsp");
            request.setAttribute("msg", msg);
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
