package com.auction.service;

import com.auction.entity.AuctionHouse;

import java.util.List;

public interface AuctionHouseService {

    public AuctionHouse createAuctionHouse(String name);

    public List<AuctionHouse> lisAuctionHouses();

    public void deleteAuctionHouse(Long auctionHouseId);

    public void deleteAll();

}

