package com.auction.test;

import com.auction.MySpringBootApplication;
import com.auction.entities.AuctionHouse;
import com.auction.services.AuctionHouseService;

import com.auction.services.AuctionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {MySpringBootApplication.class})
public class AuctionHouseServiceTest {

	@Autowired
	private AuctionHouseService auctionHouseService;

    @Autowired
    private AuctionService auctionService;

    @PostConstruct
	void init() {
    	// clean the h2 db
		auctionHouseService.deleteAll();
	}

	@Test
	public void auctionHouseServiceTest() {
    	assertTrue(auctionHouseService.lisAuctionHouses().isEmpty());

		AuctionHouse auctionHouse = auctionHouseService.createAuctionHouse("firstAuctionHouse");

		assertEquals(1, auctionHouseService.lisAuctionHouses().size());
		assertNotNull(auctionHouse);

		auctionHouseService.deleteAuctionHouse(auctionHouse.getAuctionHouseId());

		assertTrue(auctionHouseService.lisAuctionHouses().isEmpty());
	}
}
