package com.auction.models;

import com.auction.entities.AuctionHouse;
import org.springframework.data.repository.CrudRepository;

public interface AuctionHouseDao extends CrudRepository<AuctionHouse, Long> {
}
