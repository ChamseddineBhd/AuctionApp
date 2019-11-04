package com.auction.services;

import com.auction.entities.User;

import com.auction.models.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User createUser(User user) {
		userDao.save(user);
		return user;
	}

	@Override
	public void deleteAll() {
		userDao.deleteAll();
	}
}
