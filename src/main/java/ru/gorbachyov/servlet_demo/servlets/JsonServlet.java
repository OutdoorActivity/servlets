package ru.gorbachyov.servlet_demo.servlets;

import com.google.gson.Gson;
import org.eclipse.jetty.util.ajax.JSON;
import ru.gorbachyov.servlet_demo.Human;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class JsonServlet extends HttpServlet {
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        Human human = new Human("Steven", "Seagal");
        String humanJson = this.gson.toJson(human);

        try (PrintWriter printWriter = resp.getWriter()) {
            printWriter.print(humanJson);

        }
    }
}
