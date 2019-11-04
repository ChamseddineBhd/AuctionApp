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

import java.time.LocalDateTime;
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

	private static final String AUCTION_NOT_FOUND = "auction not found !";

	@Override
	public void bid(Long auctionId,Long userId, double biddingPrice) {
		Auction auction = auctionDao.findById(auctionId).orElseThrow( () ->
				new IllegalArgumentException(AUCTION_NOT_FOUND));

		User user = userDao.findById(userId).orElseThrow( () ->
				new IllegalArgumentException("user not found !"));

		if (biddingPrice > auction.getCurrentPrice() && auction.getStart().compareTo(LocalDateTime.now()) <  0 ) {
			auction.setCurrentPrice(biddingPrice);
			bidDao.save(Bid.builder()
					.auction(auction)
					.user(user)
					.bidPrice(biddingPrice)
					.build());
			auctionDao.save(auction);
		} else {
			throw new IllegalArgumentException("check that the auction is started and the bidding price is greater than the current price");
		}

	}

	@Override
	public List<Bid> listBids(Long auctionId) {
		Auction auction = auctionDao.findById(auctionId).orElseThrow( () ->
				new IllegalArgumentException(AUCTION_NOT_FOUND));
		// to enforce load
		auction.getBids().size();

		return auction.getBids();
	}

	@Override
	public User getWinner(Long auctionId) {
		Auction auction = auctionDao.findById(auctionId).orElseThrow( () ->
				new IllegalArgumentException(AUCTION_NOT_FOUND));

		Bid bid = auction.getBids().stream().max((bid1, bid2) -> (int) (100 * (bid1.getBidPrice() - bid2.getBidPrice()))).orElseThrow( () ->
				new IllegalArgumentException("no bids was found for that auction!"));
		return bid.getUser();
	}

    @Override
    public void deleteAll() {
        auctionDao.deleteAll();
    }
}
