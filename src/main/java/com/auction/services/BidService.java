package com.auction.services;

import com.auction.entities.Bid;
import com.auction.entities.User;

import java.util.List;

public interface BidService {

    public void bid(Long auctionId, Long userId, double biddingPrice);

    public List<Bid> listBids(Long auctionId) ;

    public User getWinner(Long auctionId);

    void deleteAll();
}
