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
    <p>${airport1.airportName}</p>
    <p>${airport1.icaoCode}</p>
    <p>${airport1.country}</p>
    <p>${airport1.continent}</p>
    <p>${airport1.latitude}</p>
    <p>${airport1.longitude}</p>
    <p>${airport1.size}</p>
    `;

    document.getElementById('departure-div').innerHTML = airportData; 
}

function addDataToFlightInfoDiv(flightInfo, plane){
    const airportData = `
    <p>${plane.name}</p>
    <p>${plane.rangeInKnots}</p>
    <p>${plane.speedInKnots}</p>
    <p>${plane.standardEdition}</p>
    <p>${plane.type}</p>
    <p>${flightInfo.flightHours}</p>
    <p>${flightInfo.flightDistance}</p>
    `;

    document.getElementById('flight-info-div').innerHTML = airportData; 
}

function addDataToDestinationDiv(airport2){
    const airportData = `
    <p>${airport2.airportName}</p>
    <p>${airport2.icaoCode}</p>
    <p>${airport2.country}</p>
    <p>${airport2.continent}</p>
    <p>${airport2.latitude}</p>
    <p>${airport2.longitude}</p>
    <p>${airport2.size}</p>
    `;

    document.getElementById('destination-div').innerHTML = airportData; 
}