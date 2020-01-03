# AuctionApp
Rest API App

## Documentation
After lunching the App you can find the API documentation on : localhost:8080/swagger-ui.html

## Assignment
### Step 1 - Auction house
- Create an auction house with a given name.
- List all auction houses created.
- Delete a specific house.
### Step 2 - Auction
- create an auction with some parameters: name, description, starting time, end time, start
price, current price
- List all auctions for a given auction house
- Delete a specific auction
- (Optional): List all auctions based on their status (i.e. not_started, running, terminated,
deleted, ...)
### Step 3 - Bidding in an auction
- Let a specific user bid (if only the bidding price is higher than the auction current price and
the auction is started)
- List all bidding (with the user name) that has happen until now
- For a terminated auction, show the winner (i.e. the bidder that puts the higher price)
### Infos
- Framework : Spring Boot 2
- DataBase : h2
- Build system : maven
- Tests : Junit
- Documentation : Swagger docs
