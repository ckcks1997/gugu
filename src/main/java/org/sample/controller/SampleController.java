package org.sample.controller;

import lombok.extern.log4j.Log4j2;
import org.sample.domain.SampleDTO;
import org.sample.domain.TodoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Log4j2
@Controller
@RequestMapping("/sample/*")
public class SampleController {

    @RequestMapping("/")
    public ModelAndView index(){
        log.info("index controller start!!");

        ModelAndView mav = new ModelAndView();
        mav.addObject("title", "Spring Test");
        mav.addObject("content", "Hello World!!");
        mav.setViewName("index");

        return mav;
    }

    @GetMapping("/ex01")
    public String ex01(SampleDTO dto){
        log.info(""+dto);
        return "ex01";
    }

    @GetMapping("/ex02")
    @ResponseBody
    public TodoDTO ex02(TodoDTO dto){
        log.info(""+dto);
        return dto;
    }

    @GetMapping("/ex03")
    public String ex03(TodoDTO dto,
                       @RequestParam(value="page", required = false) Integer page,
                       Model model ){
        model.addAttribute("sampleDTO", dto);
        model.addAttribute("page", page);

        return "/ex04";
    }
    @GetMapping("/ex04")
    public String ex04(TodoDTO dto,
                       @RequestParam(value="page", required = true) Integer page,
                       Model model,
                       RedirectAttributes rttr){
        model.addAttribute("sampleDTO", dto);
        rttr.addFlashAttribute("page", page);

        return "redirect:/sample/ex03";
    }

    @GetMapping("/exUpload")
    public void exUpload(){
        log.info("exupload");
    }

    @PostMapping("/exUploadPost")
    public void exUploadPost(ArrayList<MultipartFile> files){
        files.forEach(file -> {
            log.info("name:"+file.getOriginalFilename());
            log.info("size:"+file.getSize());
        });
    }
}


