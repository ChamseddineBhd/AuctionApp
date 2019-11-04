package com.auction.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bid {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bidId;

	private double bidPrice;

	@ManyToOne
	@JoinColumn(name="auction")
	@JsonIgnore
	private Auction auction;

	@ManyToOne
	@JoinColumn(name="user")
	@JsonIgnore
	private User user;
}
