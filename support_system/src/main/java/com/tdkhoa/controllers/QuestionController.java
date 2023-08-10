/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.controllers;

import com.tdkhoa.pojo.Livestream;
import com.tdkhoa.pojo.Question;
import com.tdkhoa.services.LiveStreamService;
import com.tdkhoa.services.QuestionService;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Khoa Tran
 */
@Controller
public class QuestionController {
    @Autowired
    private QuestionService qServ;
    @Autowired
    private LiveStreamService liveServ;
    
    @PostMapping("/send_question")
    public String save(Model model, @ModelAttribute Question question, @RequestParam int liveId, BindingResult rs) {
        String msg = "";
        Livestream lstream = liveServ.getLivestreamById(liveId);
        
        LocalDateTime now = LocalDateTime.now();
        question.setDateSubmitted(now.toString());
        question.setLivestreamId(lstream);
        
        if(this.qServ.saveOrUpdate(question)) {
            msg = "Đặt câu hỏi thành công. Cảm ơn bạn đã đặt câu hỏi !";
        }
        else {
            msg = "Đặt câu hỏi thất bại. Lỗi hệ thống !";
        }
        model.addAttribute("msg", msg);
        return "redirect: /support_system/homepage";
    }
}
