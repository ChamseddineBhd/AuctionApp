package com.auction.services;

import com.auction.entities.Auction;

import java.util.List;

public interface AuctionService {

    public Auction createAuction(Auction auction, Long auctionHouseId);

    public List<Auction> listAuctions(Long auctionHouseId);

    public void deleteAuction(Long auctionId);

    public List<Auction> listAuctionsBySTatus(Long auctionHouseId, String status);

    public void deleteAll();

    Auction findById(Long auctionId);
}
