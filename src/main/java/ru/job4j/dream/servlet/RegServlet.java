package ru.job4j.dream.servlet;

import ru.job4j.dream.model.User;
import ru.job4j.dream.store.PsqlStore;
import ru.job4j.dream.store.Store;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("reg.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Store store = PsqlStore.instOf();
        if (store.findUserByEmail(email) != null) {
            req.setAttribute("error", "Пользователь с таким email уже существует");
            req.getRequestDispatcher("reg.jsp").forward(req, resp);
        } else {
            store.save(new User(0, name, email, password));
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
