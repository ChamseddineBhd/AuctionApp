package com.auction.test;

import com.auction.MySpringBootApplication;
import com.auction.entity.Auction;
import com.auction.entity.AuctionHouse;
import com.auction.service.AuctionHouseService;
import com.auction.service.AuctionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes= {MySpringBootApplication.class})
public class AuctionServiceTest {

	@Autowired
	private AuctionService auctionService;

	@Autowired
	private AuctionHouseService auctionHouseService;

	@PostConstruct
	void init() {
		auctionHouseService.deleteAll();
		auctionService.deleteAll();
	}

	@Test
	public void setAuctionServiceTest() {
		AuctionHouse auctionHouse1 = auctionHouseService.createAuctionHouse("firstAuctionHouse");
		AuctionHouse auctionHouse2 = auctionHouseService.createAuctionHouse("SecondAuctionHouse");

		assertTrue(auctionService.listAuctions(auctionHouse1.getAuctionHouseId()).isEmpty());
		assertTrue(auctionService.listAuctions(auctionHouse2.getAuctionHouseId()).isEmpty());

		Auction auction = auctionService.createAuction(Auction.builder()
				.name("firstAuction")
				.price(700)
				.description("description")
				.start(LocalDateTime.now())
				.end(LocalDateTime.now().plusDays(2))
				.currentPrice(800)
				.build(), auctionHouse1.getAuctionHouseId());

		assertEquals(1, auctionService.listAuctions(auctionHouse1.getAuctionHouseId()).size());

		auctionService.deleteAuction(auction.getAuctionId());

		assertTrue(auctionService.listAuctions(auctionHouse1.getAuctionHouseId()).isEmpty());
	}
}
