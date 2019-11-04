package com.auction.service;

import com.auction.entity.Auction;
import com.auction.entity.Bid;
import com.auction.entity.User;

import java.util.List;

public interface BidService {

    public void bid(Long auctionId, Long userId, double biddingPrice);

    public List<Bid> listBids(Long auctionId) ;

    public User showWinner(Long auctionId);
}
