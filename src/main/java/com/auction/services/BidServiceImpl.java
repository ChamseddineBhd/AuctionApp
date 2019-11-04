package com.auction.services;

import com.auction.models.AuctionDao;
import com.auction.models.AuctionHouseDao;
import com.auction.models.BidDao;
import com.auction.models.UserDao;
import com.auction.entities.Auction;
import com.auction.entities.Bid;
import com.auction.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BidServiceImpl implements BidService {
	
	@Autowired
	private AuctionDao auctionDao;

	@Autowired
	private AuctionHouseDao auctionHouseDao;

	@Autowired
	private BidDao bidDao;

	@Autowired
	private UserDao userDao;

	@Override
	public void bid(Long auctionId,Long userId, double biddingPrice) {
		Auction auction = auctionDao.findById(auctionId).get();
		User user = userDao.findById(userId).get();

		if (biddingPrice > auction.getCurrentPrice()) {
			auction.setCurrentPrice(biddingPrice);
			bidDao.save(Bid.builder()
					.auction(auction)
					.user(user)
					.bidPrice(biddingPrice)
					.build());
			auctionDao.save(auction);
		}

	}

	@Override
	public List<Bid> listBids(Long auctionId) {
		Auction auction = auctionDao.findById(auctionId).get();
		// to enforce load
		auction.getBids().size();

		return auction.getBids();
	}

	@Override
	public User getWinner(Long auctionId) {
		Auction auction = auctionDao.findById(auctionId).get();
		Bid bid = auction.getBids().stream().max((bid1, bid2) -> (int) (100 * (bid1.getBidPrice() - bid2.getBidPrice()))).get();
		return bid.getUser();
	}

    @Override
    public void deleteAll() {
        auctionDao.deleteAll();
    }
}
