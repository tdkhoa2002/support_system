/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tdkhoa.pojo.Banner;
import com.tdkhoa.repository.BannerRepository;
import com.tdkhoa.services.BannerService;
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
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerRepository bRepo;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public Banner addOrUpdate(Map<String, String> params, MultipartFile thumbnail) {
        Banner banner = new Banner();
        if (!thumbnail.isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(thumbnail.getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                banner.setThumbnail(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.bRepo.addOrUpdate(banner);
        return banner;
    }

    @Override
    public boolean deleteBanner(int id) {
        return this.bRepo.deleteBanner(id);
    }

    @Override
    public Banner getBannerById(int id) {
        return this.bRepo.getBannerById(id);
    }

    @Override
    public List<Banner> getAllBanners() {
        return this.bRepo.getAllBanners();
    }

    @Override
    public List<Banner> getNewBanners() {
        return this.bRepo.getNewBanners();
    }
    
}
