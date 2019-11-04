package com.auction.controllers;

import com.auction.services.AuctionHouseService;
import com.auction.services.MyServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/" + AuctionHouseRest.API_VERSION + "auction-server" )
public class AuctionHouseRest {

	public static final String API_VERSION = "v1";

	@Autowired
	private AuctionHouseService auctionHouseService;

	@PostMapping("/auctionHouse/{auctionHouseName}")
	public void createAuctionHouse(@PathVariable("auctionHouseName") String auctionHouseName) {
		try {
			auctionHouseService.createAuctionHouse(auctionHouseName);
		} catch (Exception e) {
			throw new MyServiceException(e);
		}
	}

	@GetMapping("/auctionHouses")
	public void getAuctionHouses() {
		try {
			auctionHouseService.lisAuctionHouses();
		} catch (Exception e) {
			throw new MyServiceException(e);
		}
	}

	@DeleteMapping("/auctionHouse/{auctionHouseId}")
	public void deleteAuctionHouse(@PathVariable("auctionHouseName") Long auctionHouseId) {
		try {
			auctionHouseService.deleteAuctionHouse(auctionHouseId);
		} catch (Exception e) {
			throw new MyServiceException(e);
		}
	}

}
