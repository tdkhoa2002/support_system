/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.controllers;

import com.tdkhoa.pojo.Livestream;
import com.tdkhoa.pojo.Question;
import com.tdkhoa.services.FacultyService;
import com.tdkhoa.services.LiveStreamService;
import com.tdkhoa.services.QuestionService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Khoa Tran
 */
@Controller
public class LiveStreamController {

    @Autowired
    private LiveStreamService liveServ;
    @Autowired
    private FacultyService facultyServ;
    @Autowired
    private QuestionService qServ;

    @GetMapping("/admin/livestreams")
    public String index(Model model) {
        model.addAttribute("livestreams", this.liveServ.getListLivestreams());
        return "livestream/index_livestream";
    }

    @GetMapping("/admin/create_livestream")
    public String create(Model model) {
        model.addAttribute("livestream", new Livestream());
        model.addAttribute("faculties", this.facultyServ.getFaculties());

        return "livestream/create_livestream";
    }
    
    @GetMapping("/admin/view_livestream/{id}")
    public String view(Model model, @PathVariable(value = "id") int id) {
        Livestream livestream = this.liveServ.getLivestreamById(id);
        List<Question> questions = this.qServ.getListQuestionsByLivestreamId(livestream);
        model.addAttribute("livestream", livestream);
        model.addAttribute("questions", questions);
        return "livestream/view_livestream";
    }
    
    @GetMapping("/admin/edit_livestream/{id}")
    public String edit(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("faculties", facultyServ.getFaculties());
        model.addAttribute("livestream", this.liveServ.getLivestreamById(id));
        return "livestream/create_livestream";
    }

//    @PostMapping("/admin/create_livestream")
//    public String add(@ModelAttribute("livestream") Livestream livestream, BindingResult result) throws ParseException {
//        String dateStr = "10/09/2023T15:00";
//        Date date = new SimpleDateFormat("dd/MM/yyyyThh:mm").parse(dateStr);
//        livestream.setDate(date);
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//        SimpleDateFormat parseFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//        Date date = new Date();
//
//        livestream.setDate(parseFormat.parse(dateFormat.format(date)));
//        System.out.println("Title: " + livestream.getTitle());
//        System.out.println("Date: " + livestream.getDate());
//        System.out.println("Khoa: " + livestream.getFacultyId());
//        this.liveServ.addOrUpdate(livestream);
//        return "redirect: /support_system/admin/livestreams";
//    }
}
