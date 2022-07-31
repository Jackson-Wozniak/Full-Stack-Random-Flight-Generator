const randomFlightButton = document.getElementById('random-flight-button');
const departureDiv = document.getElementById('departure-div');
const destinationDiv = document.getElementById('destination-div');
const flightInfoDiv = document.getElementById('flight-info-div');

randomFlightButton.onclick = function randomFlight() {

    const maxFlightHours = document.querySelector("input[name='hours']:checked").value;
    const planeType = document.querySelector("input[name='type']:checked").value;
    const parameters = JSON.stringify({"maxFlightHours" : maxFlightHours, "planeType": planeType});

    fetch('http://localhost:8080/random/custom-flight', {
        method : "POST",
        headers: {
            'Content-Type': 'application/json',
        },
        body : parameters
    })
        .then(res => res.json())
        .then(data => {
            departureDiv.innerHTML = formattedAirportData(data.airport1);
            destinationDiv.innerHTML = formattedAirportData(data.airport2);
            flightInfoDiv.innerHTML = formattedFlightData(data);
    });
}

function formattedFlightData(flightInfo){
    return `
        <h2><i class="fa-solid fa-earth-americas"></i>Flight Info and Plane</h2>
        <hr/>
        <p>Estimated Flight Time: <span>${flightInfo.flightHours}</span></p>
        <p>Flight Distance: <span>${flightInfo.flightDistance} miles</span></p>
        <p>Plane: <span>${flightInfo.plane.name}</span></p>
        <p>Cruising Speed: <span>${flightInfo.plane.speedInKnots} knots</span></p>
        <p>Type of Plane: <span>${flightInfo.plane.type}</span></p>  `;
}

function formattedAirportData(airport){
    let regionNames = new Intl.DisplayNames(['en'], {type: 'region'});
    return `
        <h2><i class="fa-solid fa-plane-arrival"></i>Destination</h2>
        <hr/>
        <p>Airport Name: <span>${airport.airportName}</span></p>
        <p>ICAO Code: <span>${airport.icaoCode}</span></p>
        <p>Country: <span>${regionNames.of(airport.country)}</span></p>
        <p>Continent: <span>${airport.continent}</span></p>
        <p>Coordinates: <span>${airport.latitude} , ${airport.longitude}</span></p> `;
}