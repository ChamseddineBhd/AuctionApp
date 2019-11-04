package com.auction.controllers;


import com.auction.entities.User;

import com.auction.services.MyServiceException;
import com.auction.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/" + UserRest.API_VERSION + "auction-server" )
public class UserRest {

	public static final String API_VERSION = "v1";

	@Autowired
	private UserService userService;


	@PostMapping("/user")
	public void createAuction(@RequestBody User user) {
		try {
			userService.createUser(user);
		} catch (Exception e) {
			throw new MyServiceException(e);
		}
	}
}
