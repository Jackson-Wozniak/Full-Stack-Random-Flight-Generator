package flightcreation.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "plane")
@Table(name = "plane")
@Getter
@Setter
@NoArgsConstructor
public class Plane{

    @Id
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "speed_in_knots")
    private Integer speedInKnots;

    @Column(name= "range_in_miles")
    private Integer rangeInKnots;

    @Column(name = "standard_edition")
    private String standardEdition;

    public Plane(String name,
                 String type,
                 int speedInKnots,
                 int rangeInKnots,
                 String standardEdition) {
        this.name = name;
        this.type = type;
        this.speedInKnots = speedInKnots;
        this.rangeInKnots = rangeInKnots;
        this.standardEdition = standardEdition;
    }
}
