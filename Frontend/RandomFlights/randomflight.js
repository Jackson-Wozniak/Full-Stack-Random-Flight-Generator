const flightParametersForm = document.getElementById('flight-parameters-form');
const randomFlightDiv = document.querySelector(".preload-random-flight-div");
const inputParametersDiv = document.getElementById('main-input-div');
const departureDiv = document.getElementById('departure-div');
const destinationDiv = document.getElementById('destination-div');
const flightInfoDiv = document.getElementById('flight-info-div');

flightParametersForm.addEventListener('submit', e => {
    e.preventDefault();

    const maxFlightHours = document.querySelector("input[name='hours']:checked").value;
    const planeType = document.querySelector("input[name='type']:checked").value;
    const parameters = JSON.stringify({"maxFlightHours" : maxFlightHours, "planeType": planeType});
    //loading screen
    inputParametersDiv.removeAttribute('class');
    inputParametersDiv.innerHTML = `
    <div class="lds-ellipsis">
        <div>
            </div>
                <div></div>
                <div></div>
            <div>
        </div>  
    </div>`;
    fetch('http://localhost:8080/api/v1/flight/custom', {
        method : "POST",
        headers: {
            'Content-Type': 'application/json',
        },
        body : parameters
    })
        .then(res => res.json())
        .then(data => {
            inputParametersDiv.remove();
            randomFlightDiv.removeAttribute('class');
            randomFlightDiv.classList.add('random-flight-div');
            departureDiv.innerHTML = formattedAirportData(data.airport1, 'departure');
            destinationDiv.innerHTML = formattedAirportData(data.airport2, 'arrival');
            flightInfoDiv.innerHTML = formattedFlightData(data);
    }).catch(function(){
        window.alert('Cannot connect to server');
        location.reload();
        return;
    });
});

function formattedFlightData(flightInfo){
    return `
        <h2><i class="fa-solid fa-earth-americas"></i>Flight Info and Plane</h2>
        <hr/>
        <p>Estimated Flight Time: <span>${flightInfo.flightHours}</span></p>
        <p>Flight Distance: <span>${flightInfo.flightDistanceInMiles} miles</span></p>
        <p>Plane: <span>${flightInfo.plane.name}</span></p>
        <p>Cruising Speed: <span>${flightInfo.plane.speedInKnots} knots</span></p>
        <p>Type of Plane: <span>${flightInfo.plane.type}</span></p>  `;
}

function formattedAirportData(airport, airportDirection){
    let regionNames = new Intl.DisplayNames(['en'], {type: 'region'});
    return `
        <h2><i class="fa-solid fa-plane-${airportDirection}"></i>${airportDirection}</h2>
        <hr/>
        <p>Airport Name: <span>${airport.airportName}</span></p>
        <p>ICAO Code: <span>${airport.icaoCode}</span></p>
        <p>Country: <span>${regionNames.of(airport.country)}</span></p>
        <p>Continent: <span>${airport.continent}</span></p>
        <p>Coordinates: <span>${airport.latitude} , ${airport.longitude}</span></p> `;
}