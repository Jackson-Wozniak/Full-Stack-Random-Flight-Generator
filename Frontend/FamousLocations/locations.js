fetch('http://localhost:8080/landmarks/get-all')
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
        <div class="card">
            <div id="collapse-${idx}" class="collapse show" aria-labelledby="heading-${idx}" data-parent="#accordion">
                <div class="card-body">
                    <h3>${result.name}, ${result.location}</h3>
                    <hr/>
                    <span>${result.description}</span>
                    <br/>
                    <br/>
                    <p>Airports nearby: <span>${result.airports}</span></p>
                    <img class="card-image" src="${result.imageLink}">
                </div>
            </div>
        </div>`;
    container.innerHTML += content;
    })
}
