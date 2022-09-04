package com.example.springpagination.controller;
import com.example.springpagination.serviceImp.PostServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class PostController {
    private final PostServiceImp postService;
    @Autowired
    public PostController(PostServiceImp postService) {
        this.postService = postService;
    }

    @GetMapping
    public String posts(@RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
                        @RequestParam(value = "size", required = false, defaultValue = "5") int size, Model model) {
        model.addAttribute("posts", postService.getPage(pageNumber, size));
        return "post";
    }
}
