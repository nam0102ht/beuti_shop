/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ygame.yg05.repository;

import com.ygame.yg05.entity_cometics.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository{
    User findUserById(int id);
    User findUserByUsernamePassword(String username, String Password);
    void updateUser(User user);
    void updateInfo(User user);
    User findUserByEmail(String email);
    void updateAvatar(String avatar_img, int id_user);
}
