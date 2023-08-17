/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.controllers.API;

import com.tdkhoa.pojo.Livestream;
import com.tdkhoa.services.LiveStreamService;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Khoa Tran
 */
@RestController
@RequestMapping("/api")
public class ApiLivestreamController {
    @Autowired 
    private LiveStreamService liveServ;
    
    @GetMapping("/livestreams/")
    @CrossOrigin
    public ResponseEntity<List<Livestream>> list() {
        return new ResponseEntity<>(this.liveServ.getListLivestreams(), HttpStatus.OK);
    }
    
    @PostMapping("/create_livestream/")
    @CrossOrigin
    public ResponseEntity<Boolean> add(@RequestBody Livestream lstream) {
        return new ResponseEntity<>(this.liveServ.addOrUpdate(lstream), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/delete_comment/{livestream_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "livestream_id") int livestream_id) {
        this.liveServ.deleteLivestream(livestream_id);
    }
}
