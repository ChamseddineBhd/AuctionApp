package com.auction.rest;

import com.auction.entity.Bid;
import com.auction.entity.User;
import com.auction.service.BidService;
import com.auction.service.MyServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/" + BidRest.API_VERSION + "auction-server" )
public class BidRest {

	public static final String API_VERSION = "v1";

	@Autowired
	private BidService bidService;

	
	@GetMapping("/bids/{auctionId}")
    public List<Bid> listBids(@PathVariable("auctionId") Long auctionId){
		return bidService.listBids(auctionId);
	}


	@GetMapping("/auction-winner/{auctionId}")
	public User showWinner(@PathVariable("auctionId") Long auctionId) {
		try {
			return bidService.showWinner(auctionId);
		} catch (Exception e) {
			throw new MyServiceException(e);
		}
	}

	@DeleteMapping("/bid")
	public void bid(@RequestParam(required = true) Long auctionId,
					@RequestParam(required = true) Long userId,
					@RequestParam(required = true) double biddingPrice) {
		try {
			bidService.bid(auctionId, userId, biddingPrice);
		} catch (Exception e) {
			throw new MyServiceException(e);
		}
	}

}
