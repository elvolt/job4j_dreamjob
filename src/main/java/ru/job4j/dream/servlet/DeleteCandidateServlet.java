package ru.job4j.dream.servlet;

import ru.job4j.dream.store.PsqlStore;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class DeleteCandidateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        req.setAttribute("id", id);
        req.setAttribute("name", name);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/deleteCandidate.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws  IOException {
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        PsqlStore.instOf().deleteCandidate(Integer.parseInt(id));
        File folder = new File("c:\\images\\");
        File file =  new File(folder + File.separator + "id" + id + ".jpg");
        file.delete();
        resp.sendRedirect(req.getContextPath() + "/candidates.do");
    }
}
