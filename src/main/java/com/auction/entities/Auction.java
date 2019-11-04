package com.auction.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Auction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long auctionId;

	private String name;

	private String description;

	private LocalDateTime start;

	private LocalDateTime end;

	private double price;

	private double currentPrice;

	@ManyToOne
	@JoinColumn(name="auctionHouse")
	@JsonIgnore
	private AuctionHouse auctionHouse;

	@OneToMany(mappedBy="auction",  cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Bid> bids;

	public String getStatus() {
		if (LocalDateTime.now().compareTo(start) < 0) {
			return "not running";
		} else if (LocalDateTime.now().compareTo(end) > 0) {
			return "terminated";

		} else {
			return "running";
		}
	}
}
