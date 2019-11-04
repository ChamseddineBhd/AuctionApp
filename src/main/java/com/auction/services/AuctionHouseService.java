package com.auction.services;

import com.auction.entities.AuctionHouse;

import java.util.List;

public interface AuctionHouseService {

    public AuctionHouse createAuctionHouse(String name);

    public List<AuctionHouse> lisAuctionHouses();

    public void deleteAuctionHouse(Long auctionHouseId);

    public void deleteAll();

}

