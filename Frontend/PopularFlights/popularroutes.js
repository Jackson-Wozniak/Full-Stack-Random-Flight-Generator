const data = [{
    "departureName":"Manchester",
    "departureICAO":"KMHT",
    "destinationName":"Boston",
    "destinationICAO":"KBOS"
},
{
    "departureName":"John F Kennedy",
    "departureICAO":"JFK",
    "destinationName":"Washington Dulles",
    "destinationICAO":"WAS"
}]

data.forEach(element => {
    const html = `
    <div class="main-card">
        <p class="departure">${element.departureName} <br> ${element.departureICAO}</p>
        <div class="seperator"><hr/></div>
        <p class="destination">${element.destinationName} <br> ${element.destinationICAO}<p>
    </div>
    `;

    document.getElementById("card-container").innerHTML += html;
});