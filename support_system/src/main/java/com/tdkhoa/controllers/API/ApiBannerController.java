/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.controllers.API;

import com.tdkhoa.pojo.Banner;
import com.tdkhoa.services.BannerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Khoa Tran
 */
@RestController
@RequestMapping("/api")
public class ApiBannerController {
    @Autowired
    private BannerService bServ;
    
    @GetMapping("/banners/")
    @CrossOrigin
    public ResponseEntity<List<Banner>> list() {
        return new ResponseEntity<>(this.bServ.getAllBanners(), HttpStatus.OK);
    }
    
    @GetMapping("/banners_homepage/")
    @CrossOrigin
    public ResponseEntity<List<Banner>> listBannersAtHomepage() {    //Banner hien thi o trang chu
        return new ResponseEntity<>(this.bServ.getNewBanners(), HttpStatus.OK);
    }

    @PostMapping("/create_banner/")
    @CrossOrigin
    public ResponseEntity<Boolean> add(@RequestBody Banner b) {
        return new ResponseEntity<>(this.bServ.addOrUpdate(b), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete_banner/{b_id}/")
    @CrossOrigin
    public ResponseEntity<String> add(@PathVariable(value = "b_id") int b_id) {
        boolean deleted = this.bServ.deleteBanner(b_id);
        if (deleted) {
            return ResponseEntity.ok("Đã xóa banner thành công");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy banner để xóa");
        }
    }
}
