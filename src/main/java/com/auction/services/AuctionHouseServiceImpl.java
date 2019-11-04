package com.auction.services;

import com.auction.models.AuctionDao;
import com.auction.models.AuctionHouseDao;

import com.auction.entities.AuctionHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class AuctionHouseServiceImpl implements AuctionHouseService {
	
	@Autowired
	private AuctionDao auctionDao;
	
	@Autowired
	private AuctionHouseDao auctionHouseDao;

	@Override
	public AuctionHouse createAuctionHouse(String name) {
		AuctionHouse auctionHouse = AuctionHouse.builder().name(name).build();
		auctionHouseDao.save(auctionHouse);
		return auctionHouse;
	}

	@Override
	public List<AuctionHouse> lisAuctionHouses() {
		return (List<AuctionHouse>) auctionHouseDao.findAll();
	}

	@Override
	public void deleteAuctionHouse(Long auctionHouseId) {
		auctionHouseDao.deleteById(auctionHouseId);
	}

	@Override
	public void deleteAll() {
		auctionHouseDao.deleteAll();
	}
}
