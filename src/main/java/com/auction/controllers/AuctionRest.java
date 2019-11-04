package com.auction.controllers;

import com.auction.entities.Auction;
import com.auction.services.AuctionHouseService;
import com.auction.services.AuctionService;
import com.auction.services.MyServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/" + AuctionRest.API_VERSION + "/auction-server" )
public class AuctionRest {

	public static final String API_VERSION = "v1";

	@Autowired
	private AuctionHouseService auctionHouseService;

	@Autowired
	private AuctionService auctionService;
	
	@GetMapping("/auctions/{auctionHouseId}")
    public List<Auction> listAuctions(@PathVariable("auctionHouseId") Long auctionHouseId){
		return auctionService.listAuctions(auctionHouseId);
	}


	@PostMapping("/auction/{auctionHouseId}")
	public void createAuction(@RequestBody Auction auction, @PathVariable("auctionHouseId") Long auctionHouseId) {
		try {
			auctionService.createAuction(auction, auctionHouseId);
		} catch (Exception e) {
			throw new MyServiceException(e);
		}
	}

	@DeleteMapping("/auction/{auctionId}")
	public void deleteAuction(@PathVariable("auctionId") Long auctionId) {
		try {
			auctionService.deleteAuction(auctionId);
		} catch (Exception e) {
			throw new MyServiceException(e);
		}
	}

}
