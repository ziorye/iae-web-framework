package com.ioewvsau.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadController {
    @GetMapping("/")
    String index() {
        return "index";
    }

    @PostMapping("/fileUploadController")
    //@ResponseBody
    String upload(@RequestParam("description") String description,
                  @RequestParam("avatar") MultipartFile avatar, HttpSession session) throws IOException {

        String path = session.getServletContext().getRealPath("");
        String filename = avatar.getOriginalFilename();
        String pathAndFileName = path + filename;

        if (!avatar.isEmpty()) {
            avatar.transferTo(new File(pathAndFileName));
        }

        //return "description=" + description + ", pathAndFileName=" + pathAndFileName;

        System.out.println("description=" + description + ", pathAndFileName=" + pathAndFileName);
        return "redirect:" + filename;
    }
}
