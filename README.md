# AuctionApp
Small Rest API App

## Documentation
after lunching the App you can find the API documentation (here) [localhost:8080/swagger-ui.html]

## Assignment
### Step 1 - Auction house
Create an auction house with a given name.
List all auction houses created.
Delete a specific house.
### Step 2 - Auction
For a given Auction house
- create an auction with some parameters: name, description, starting time, end time, start
price, current price
- List all auctions for a given auction house
- Delete a specific auction
- (Optional): List all auctions based on their status (i.e. not_started, running, terminated,
deleted, ...)
### Step 3 - Bidding in an auction
For a given auction:
- Let a specific user bid (if only the bidding price is higher than the auction current price and
the auction is started)
- List all bidding (with the user name) that has happen until now
- For a terminated auction, show the winner (i.e. the bidder that puts the higher price)
### Infos
- framework : Spring Boot 2
- dataBase : h2
- build system : maven
- Tests : Junit
- Documentation : Swagger docs