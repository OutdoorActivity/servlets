package ru.gorbachyov.servlet_demo.servlets;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import ru.gorbachyov.servlet_demo.Human;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class CRUDFilesServlet extends HttpServlet {
    private final Gson gson = new Gson();
    private final static String filePath = "human.json";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        Human human = new Human("Steven", "Seagal");
        try (Writer writer = new FileWriter(filePath)) {
            new Gson().toJson(human, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            JsonReader reader = new JsonReader(new FileReader(filePath));
            Human human = gson.fromJson(reader, Human.class);
            PrintWriter printWriter = resp.getWriter();
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            reader.close();
            printWriter.print(human.toString());
            printWriter.flush();
        } catch (FileNotFoundException e) {
            PrintWriter printWriter = resp.getWriter();
            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");
            printWriter.print("file not found");
            printWriter.flush();
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        Human human = new Human("Peter", "the Great");
        try (Writer writer = new FileWriter(filePath)) {
            new Gson().toJson(human, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        File file = new File("C:\\Users\\gorba\\IdeaProjects\\servletHomework\\human.json");
        file.delete();

    }


}
