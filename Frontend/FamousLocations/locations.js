fetch('http://localhost:8080/api/v1/landmarks/all')
    .then(res => res.json())
    .then(data => {
        console.log(data);
        displayLocations(data);
    });

const container = document.getElementById('landmark-container');

function displayLocations(data){
    data.forEach((result, idx) => {
        // Create card element
    const card = document.createElement('div');
    card.classList = 'card-body';

        // Construct card content
    const content = `
        <div class="card-holder">
            <div class="card-body">
                <h3>${result.name}, ${result.location}</h3>
                <hr/>
                <span>${result.description}</span>
                <br/>
                <br/>
                <p>Airports nearby: <span>${result.airports}</span></p>
                
            </div>
            <img class="card-image" src="${result.imageLink}">
        </div>`;
    container.innerHTML += content;
    })
}
