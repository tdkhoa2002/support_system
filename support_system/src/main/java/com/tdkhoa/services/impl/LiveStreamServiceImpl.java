/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tdkhoa.pojo.Faculty;
import com.tdkhoa.pojo.Livestream;
import com.tdkhoa.repository.LiveStreamRepository;
import com.tdkhoa.services.LiveStreamService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Khoa Tran
 */
@Service
public class LiveStreamServiceImpl implements LiveStreamService {
    @Autowired
    private LiveStreamRepository liveRepo;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Livestream> getListLivestreams() {
        return this.liveRepo.getListLivestreams();
    }

    @Override
    public Livestream addOrUpdate(Map<String, String> params, MultipartFile thumbnail, Faculty fal) {
        Livestream liveS = new Livestream();
        
        liveS.setTitle(params.get("title"));
        liveS.setTime(0.0);
        liveS.setFacultyId(fal);
        
        if (!thumbnail.isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(thumbnail.getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                liveS.setThumbnail(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.liveRepo.addOrUpdate(liveS);
        return null;
    }

    @Override
    public boolean deleteLivestream(int id) {
        return this.liveRepo.deleteLivestream(id);
    }

    @Override
    public Livestream getLivestreamById(int id) {
        return this.liveRepo.getLivestreamById(id);
    }
    
}
