package com.auction.test;

import com.auction.MySpringBootApplication;
import com.auction.entities.Auction;
import com.auction.entities.AuctionHouse;
import com.auction.entities.User;
import com.auction.services.AuctionHouseService;
import com.auction.services.AuctionService;
import com.auction.services.BidService;
import com.auction.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {MySpringBootApplication.class})
public class BidServiceTest {

	@Autowired
	private AuctionService auctionService;

	@Autowired
	private AuctionHouseService auctionHouseService;

	@Autowired
	private UserService userService;

	@Autowired
	private BidService bidService;

	@PostConstruct
	void init() {
		// clean the h2 db
		auctionHouseService.deleteAll();
		auctionService.deleteAll();
		bidService.deleteAll();
		userService.deleteAll();
	}

	@Test
	public void bidServiceTest() {
		AuctionHouse auctionHouse1 = auctionHouseService.createAuctionHouse("firstAuctionHouse");

		User chamseddine = User.builder().firstName("Chamseddine").lastName("BENHAMED").adress("Paris").build();
		User olivier = User.builder().firstName("Oliver").lastName("jardin").adress("Lyon").build();

		chamseddine = userService.createUser(chamseddine);
		olivier = userService.createUser(olivier);

		Auction auction = auctionService.createAuction(Auction.builder()
				.name("firstAuction")
				.price(700)
				.description("description")
				.start(LocalDateTime.now())
				.end(LocalDateTime.now().plusDays(2))
				.currentPrice(800)
				.build(), auctionHouse1.getAuctionHouseId());

		bidService.bid(auction.getAuctionId(), chamseddine.getUserId(), 900);
		auction = auctionService.findById(auction.getAuctionId());
		assertEquals(900, auction.getCurrentPrice(), 0);


		bidService.bid(auction.getAuctionId(), olivier.getUserId(), 1100);
		auction = auctionService.findById(auction.getAuctionId());
		assertEquals(1100, auction.getCurrentPrice(), 0);

		User winner = bidService.getWinner(auction.getAuctionId());

		assertEquals(winner.getUserId(), olivier.getUserId());
	}
}
