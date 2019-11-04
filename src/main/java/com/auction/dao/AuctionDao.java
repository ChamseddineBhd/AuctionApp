package com.auction.dao;

import com.auction.entity.Auction;
import org.springframework.data.repository.CrudRepository;

public interface AuctionDao extends CrudRepository<Auction, Long> {
}
