package com.ioewvsau;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

@WebServlet("/fileUploadServlet")
@MultipartConfig(
        //location = "/tmp",
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5
)
public class FileUploadServlet extends HttpServlet {
    private static String uploadPath;

    @Override
    public void init(ServletConfig config) throws ServletException {
        uploadPath = config.getServletContext().getRealPath("upload/");
        System.out.println("uploadPath = " + uploadPath);
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            System.out.println(uploadDir.mkdir());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");

        Part avatar = request.getPart("avatar");
        String submittedFileName = avatar.getSubmittedFileName();
        String pathAndFileName = uploadPath + submittedFileName;
        avatar.write(pathAndFileName);

        response.getWriter().write("description=" + description + ", pathAndFileName=" + pathAndFileName);
    }
}
