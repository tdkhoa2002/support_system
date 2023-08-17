/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tdkhoa.services;

import com.tdkhoa.pojo.Banner;
import java.util.List;

/**
 *
 * @author Khoa Tran
 */
public interface BannerService {
    boolean addOrUpdate(Banner b);
    boolean deleteBanner(int id);
    Banner getBannerById(int id);
    List<Banner> getAllBanners();
    List<Banner> getNewBanners();
}
