package com.auction.services;

import com.auction.entities.User;

public interface UserService {

    public User createUser(User user);

    void deleteAll();
}
