package MSFSFlightGenerator.customflightgen.plane;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "plane")
@Table(name = "plane")
public class Plane{

    @Id
    private String name;

    @Column(name = "speed_in_knots")
    private Integer speedInKnots;

    @Column(name= "range_in_miles")
    private Integer rangeInKnots;

    @Column(name = "standard_edition")
    private String standardEdition;

    public Plane(){
        //empty entity constructor
    }

    public Plane(String name, int speedInKnots, int rangeInKnots, String standardEdition) {
        this.name = name;
        this.speedInKnots = speedInKnots;
        this.rangeInKnots = rangeInKnots;
        this.standardEdition = standardEdition;
    }

    public String getName() {
        return name;
    }

    public int getSpeedInKnots() {
        return speedInKnots;
    }

    public int getRangeInKnots() {
        return rangeInKnots;
    }

    public String getStandardEdition() {
        return standardEdition;
    }
}
