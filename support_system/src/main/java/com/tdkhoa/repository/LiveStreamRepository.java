/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tdkhoa.repository;

import com.tdkhoa.pojo.Livestream;
import java.util.List;

/**
 *
 * @author Khoa Tran
 */
public interface LiveStreamRepository {
    List<Livestream> getListLivestreams();
    Livestream getLivestreamById(int id);
    boolean addOrUpdate(Livestream livestream);
    boolean deleteLivestream(int id);
}
