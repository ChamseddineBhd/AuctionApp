package com.auction.service;

import com.auction.dao.AuctionDao;
import com.auction.dao.AuctionHouseDao;

import com.auction.entity.AuctionHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
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
