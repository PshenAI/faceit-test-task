# faceit-test-task

Task is to create a backend application for a restaurant ordering system, following special entity constraints and use an H2 db.

It should be extendable and covered by unit tests.

Project has swagger support for easier endpoint testing. You can access swagger UI via: http://localhost:8080/swagger-ui/index.html after project has booted.

In order to create correct payload for POST endpoint, you need to list all available dishes through GET endpoint first,
so you can fill in right values for POST request body. Here's the example of correct request object for `/api/v1/restaurant/order` endpoint:

    {
        "lunchDTO": {
        "lunchName": "Carbonara",
        "lunchCuisine": "ITALIAN"
        },
        "drinkDTO": {
        "drinkName": "Morshynska",
        "drinkCuisine": "ALL",
        "drinkHasIce": false,
        "drinkHasLemon": true
        }
    }

