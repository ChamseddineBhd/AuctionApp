package com.auction.service;

import com.auction.entity.Auction;

import java.util.List;

public interface AuctionService {

    public Auction createAuction(Auction auction, Long auctionHouseId);

    public List<Auction> listAuctions(Long auctionHouseId);

    public void deleteAuction(Long auctionId);

    public List<Auction> listAuctionsBySTatus(String status);

    public void deleteAll();
}
