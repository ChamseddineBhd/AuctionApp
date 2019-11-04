package com.auction.dao;

import com.auction.entity.AuctionHouse;
import org.springframework.data.repository.CrudRepository;

public interface AuctionHouseDao extends CrudRepository<AuctionHouse, Long> {
}
