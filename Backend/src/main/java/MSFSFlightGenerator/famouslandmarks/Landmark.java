package MSFSFlightGenerator.famouslandmarks;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "landmark")
@Table(name = "landmark")
public class Landmark {

    @Id
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "description")
    private String description;

    @Column(name = "airports")
    private String airports;

    @Column(name = "link")
    private String imageLink;

    public Landmark(){

    }

    public Landmark(String name, String location, String description, String airports, String imageLink) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.airports = airports;
        this.imageLink = imageLink;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAirports() {
        return airports;
    }

    public String getImageLink() {
        return imageLink;
    }

    public String getLocation() {
        return location;
    }
}
