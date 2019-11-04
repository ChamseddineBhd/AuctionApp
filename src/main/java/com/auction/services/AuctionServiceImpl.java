package com.auction.services;

import com.auction.models.AuctionDao;

import com.auction.models.AuctionHouseDao;
import com.auction.entities.Auction;
import com.auction.entities.AuctionHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AuctionServiceImpl implements AuctionService {
	
	@Autowired
	private AuctionDao auctionDao;

	@Autowired
	private AuctionHouseDao auctionHouseDao;

	@Override
	public Auction createAuction(Auction auction, Long auctionHouseId) {
		AuctionHouse auctionHouse = auctionHouseDao.findById(auctionHouseId).orElseThrow( () ->
				new IllegalArgumentException("auction not found !"));
		auction.setAuctionHouse(auctionHouse);
		auctionDao.save(auction);
		return auction;
	}

	@Override
	public List<Auction> listAuctions(Long auctionHouseId) {
		List<Auction> auctions =  auctionHouseDao.findById(auctionHouseId).orElseThrow( () ->
				new IllegalArgumentException("auctionHouse not found !")).getAuctions();
		// to force loading auctions
		auctions.size();
		return auctions;
	}

	@Override
	public void deleteAuction(Long auctionId) {
		auctionDao.deleteById(auctionId);
	}

	@Override
	public List<Auction> listAuctionsBySTatus(Long auctionHouseId, String status) {
		switch (status) {
			case "not started ":
				return listAuctions(auctionHouseId).stream().filter(auction -> auction.getStatus().equals("not started")).collect(Collectors.toList());
			case "terminated":
				return listAuctions(auctionHouseId).stream().filter(auction -> auction.getStatus().equals("terminated")).collect(Collectors.toList());
			case "running" :
				return listAuctions(auctionHouseId).stream().filter(auction -> auction.getStatus().equals("running")).collect(Collectors.toList());
			default:
				throw new IllegalArgumentException("possible status are : running, terminated and not started");
		}
	}

	@Override
	public void deleteAll() {
		auctionDao.deleteAll();
	}

    @Override
    public Auction findById(Long auctionId) {
        return auctionDao.findById(auctionId).orElseThrow( () ->
				new IllegalArgumentException("auction not found !"));
    }
}
