package com.auction.dao;

import com.auction.entity.Bid;
import org.springframework.data.repository.CrudRepository;

public interface BidDao extends CrudRepository<Bid, Long> {
}
