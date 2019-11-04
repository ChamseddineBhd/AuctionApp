package com.auction.models;

import com.auction.entities.Bid;
import org.springframework.data.repository.CrudRepository;

public interface BidDao extends CrudRepository<Bid, Long> {
}
