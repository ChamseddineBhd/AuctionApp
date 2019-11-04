package com.auction.models;

import com.auction.entities.Auction;
import org.springframework.data.repository.CrudRepository;

public interface AuctionDao extends CrudRepository<Auction, Long> {
}
