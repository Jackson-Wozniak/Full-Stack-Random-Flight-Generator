const cardContainer = document.getElementById('card-container');

fetch('http://localhost:8080/api/v1/routes/all')
    .then(res => res.json())
    .then(data => {
        console.log(data);
        showRoutes(data);
    })

function showRoutes(data){
    data.forEach(element => {
        const html = `
        <div class="main-card">
            <p class="departure">${element.departureAirport} <br> ${element.departureIcao}</p>
            <div class="seperator"><hr/></div>
            <p class="destination">${element.destinationAirport} <br> ${element.destinationIcao}<p>
        </div>
        `;

        cardContainer.innerHTML += html;
    });
}