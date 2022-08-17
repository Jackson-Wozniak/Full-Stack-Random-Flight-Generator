# Flight-Generator-For-MSFS

A web application used to create random flight plans for flight simulators. 

Flight plan data includes two random airports from across the world, a random plane to be flown, and the estimated flight time and distance.
Flight parameters can be chosen to get flights that fall within a specific duration, or are flown by a plane of a specific type.

This app also includes web pages that recommend famous locations across the world to visit, and popular real world flights to re-enact.

---
# Technologies

### Backend

* Spring Boot
* Spring Data JPA
* MySql Database

### Frontend

* Plain JavaScript
* Bootstrap CSS

---

Airport data is taken from https://ourairports.com/data/,
and is filtered to include all airports with IATA codes, to help filter out private or closed airports.

All plane data is taken from Microsoft Flight Simulator.

---
# Demo

![ezgif com-gif-maker (2)](https://user-images.githubusercontent.com/105665813/185027431-59eec1be-8e3c-4739-ae4e-3361b9189649.gif)
