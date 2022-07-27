const randomFlightButton = document.getElementById('random-flight-button');

randomFlightButton.onclick = function randomFlight() {
    fetch('http://localhost:8080/custom-flight/generate')
        .then(res => res.json())
        .then(data => {
            console.log(data)
            addDataToDepartureDiv(data.airport1);
            addDataToDestinationDiv(data.airport2);
            addDataToFlightInfoDiv(data, data.plane);
    });
}

function addDataToDepartureDiv(airport1){
    const airportData = `
    <h2><i class="fa fa-map-marker"></i>Departure</h2>
    <hr/>
    <p>Airport Name: <span>${airport1.airportName}</span></p>
    <p>ICAO Code: <span>${airport1.icaoCode}</span></p>
    <p>Country: <span>${airport1.country}</span></p>
    <p>Continent: <span>${airport1.continent}</span></p>
    <p>Coordinates: <span>${airport1.latitude} , ${airport1.longitude}</span></p>
    `;

    document.getElementById('departure-div').innerHTML = airportData; 
}

function addDataToFlightInfoDiv(flightInfo, plane){
    const airportData = `
    <h2><i class="fa fa-map-o"></i>Flight Info and Plane</h2>
    <hr/>
    <p>Hours of Flight: <span>${flightInfo.flightHours} hours</span></p>
    <p>Flight Distance: <span>${flightInfo.flightDistance} miles</span></p>
    <p>Plane: <span>${plane.name}</span></p>
    <p>Cruising Speed: <span>${plane.speedInKnots} knots</span></p>
    <p>Type of Plane: <span>${plane.type}</span></p>  
    `;

    document.getElementById('flight-info-div').innerHTML = airportData; 
}

function addDataToDestinationDiv(airport2){
    const airportData = `
    <h2><i class="fa fa-map-marker"></i>Destination</h2>
    <hr/>
    <p>Airport Name: <span>${airport2.airportName}</span></p>
    <p>ICAO Code: <span>${airport2.icaoCode}</span></p>
    <p>Country: <span>${airport2.country}</span></p>
    <p>Continent: <span>${airport2.continent}</span></p>
    <p>Coordinates: <span>${airport2.latitude} , ${airport2.longitude}</span></p>
    `;

    document.getElementById('destination-div').innerHTML = airportData; 
}