package servlets;

import dao.DAOLoginRepository;
import model.ModelLogin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/main/ServletLogin","/partial/ServletLogin", "/ServletLogin"})
public class ServletLogin extends HttpServlet {

    private DAOLoginRepository daoLoginRepository = new DAOLoginRepository();

    public ServletLogin(){
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action != null && action.equalsIgnoreCase("logout")){
            request.getSession().invalidate();
            RequestDispatcher redirect = request.getRequestDispatcher("index.jsp");
            redirect.forward(request,response);
        }else {
            doPost(request,response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String url = request.getParameter("url");

        try {

            if (login != null && !login.isEmpty() && password != null && !password.isEmpty()) {

                ModelLogin modelLogin = new ModelLogin();
                modelLogin.setLogin(login);
                modelLogin.setPassword(password);
                if (daoLoginRepository.validateAuth(modelLogin)) {

                    request.getSession().setAttribute("user", modelLogin.getLogin());

                    if (url == null || url.equals("null")) {
                        url = "/main/main.jsp";
                    }

                    RequestDispatcher redirect = request.getRequestDispatcher(url);
                    redirect.forward(request, response);

                } else {
                    RequestDispatcher redirect = request.getRequestDispatcher("/index.jsp");
                    request.setAttribute("msg", "Enter your login and password correctly!");
                    redirect.forward(request, response);
                }

            } else {
                RequestDispatcher redirect = request.getRequestDispatcher("index.jsp");
                request.setAttribute("msg","Enter your login and password correctly!");
                redirect.forward(request, response);
            }
        }catch (Exception e){
            e.printStackTrace();

            RequestDispatcher redirect = request.getRequestDispatcher("erro.jsp");
            request.setAttribute("msg", e.getMessage());
            redirect.forward(request, response);
        }

    }
}
