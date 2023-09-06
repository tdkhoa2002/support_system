/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tdkhoa.services;

import com.tdkhoa.pojo.Faculty;
import com.tdkhoa.pojo.Livestream;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Khoa Tran
 */
public interface LiveStreamService {
    List<Livestream> getListLivestreams();
    Livestream getLivestreamById(int id);
    Livestream addOrUpdate(Map<String, String> params, MultipartFile thumbnail, Faculty fal);
    boolean deleteLivestream(int id);
}
