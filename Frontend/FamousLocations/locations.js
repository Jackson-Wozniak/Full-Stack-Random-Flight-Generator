const apiResult = [{
    title: "New York City",
    description: "As one of the most famous cities in the world, this is a place that is sure to be worth " 
    + "a visit",
    airports: "JFK, LGA",
    picture : "https://www.travelandleisure.com/thmb/JWO4CNVDNSR-aLDBT93jVlHV1DQ=/1800x1200/filters:fill(auto,1)/new-york-city-evening-NYCTG0221-52492d6ccab44f328a1c89f41ac02aea.jpg"
},{
    title: "Hawaii",
    description: "A chance to visit the beatiful islands of hawaii, take off from one of the many airports" 
    + "and enjoy the scenery that each unique island has to offer",
    airports: "JFK, LGA",
    picture : "https://www.mercurynews.com/wp-content/uploads/2022/04/hypatia-h_0ccfb6dda3b88d3e78c45fa5e5a9883e-h_f87cf80b7191cc6744728a24f6c94c77.jpg?w=620"
}];

const container = document.getElementById('landmark-container');

apiResult.forEach((result, idx) => {
  // Create card element
const card = document.createElement('div');
card.classList = 'card-body';

  // Construct card content
const content = `
    <div class="card">
    <div class="card-header" id="heading-${idx}">
        <h5 class="mb-0">
        <button class="btn btn-link" data-toggle="collapse" data-target="#collapse-${idx}" aria-expanded="true" aria-controls="collapse-${idx}">

                </button>
        </h5>
    </div>

    <div id="collapse-${idx}" class="collapse show" aria-labelledby="heading-${idx}" data-parent="#accordion">
        <div class="card-body">

            <h5>${result.title}</h5>
            <hr/>
            <p>${result.description}</p>
            <p>${result.airports}</p>
            <img class="card-image" src="${result.picture}">
        </div>
    </div>
</div>`;

container.innerHTML += content;
})