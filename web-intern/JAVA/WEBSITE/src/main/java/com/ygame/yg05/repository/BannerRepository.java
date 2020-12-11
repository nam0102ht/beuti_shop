/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ygame.yg05.repository;

import com.ygame.yg05.entity_cometics.Banner;
import java.util.List;


public interface BannerRepository {
    void insertBanner(Banner banner);
    Banner getBannerById(int id);
    List<Banner> getListBanner();
}
