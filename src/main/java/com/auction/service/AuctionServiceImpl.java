package com.auction.service;

import com.auction.dao.AuctionDao;

import com.auction.dao.AuctionHouseDao;
import com.auction.entity.Auction;
import com.auction.entity.AuctionHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuctionServiceImpl implements AuctionService {
	
	@Autowired
	private AuctionDao auctionDao;

	@Autowired
	private AuctionHouseDao auctionHouseDao;

	@Override
	public Auction createAuction(Auction auction, Long auctionHouseId) {
		AuctionHouse auctionHouse = auctionHouseDao.findById(auctionHouseId).get();
		auction.setAuctionHouse(auctionHouse);
		auctionDao.save(auction);
		return auction;
	}

	@Override
	public List<Auction> listAuctions(Long auctionHouseId) {
		List<Auction> auctions =  auctionHouseDao.findById(auctionHouseId).get().getAuctions();
		// to force loading auctions
		auctions.size();
		return auctions;
	}

	@Override
	public void deleteAuction(Long auctionId) {
		auctionDao.deleteById(auctionId);
	}

	@Override
	public List<Auction> listAuctionsBySTatus(String status) {
		return null;
	}

	@Override
	public void deleteAll() {
		auctionDao.deleteAll();
	}
}