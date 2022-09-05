package MSFSFlightGenerator.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "airport")
@Table(name = "airport")
public class Airport {

    @Id
    private String icaoCode;

    @Column(name = "airport_size", nullable = false)
    private String size;

    @Column(name = "airport_name", nullable = false)
    private String airportName;

    @Column(name = "latitude", nullable = false)
    private Double latitude;

    @Column(name = "longitude", nullable = false)
    private Double longitude;

    @Column(name = "continent", nullable = false)
    private String continent;

    @Column(name = "country", nullable = false)
    private String country;

    public Airport(){

    }

    public Airport(String icaoCode,
                   String size,
                   String airportName,
                   Double latitude,
                   Double longitude,
                   String continent,
                   String country) {
        this.icaoCode = icaoCode;
        this.size = size;
        this.airportName = airportName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.continent = continent;
        this.country = country;
    }

    public String getIcaoCode() {
        return icaoCode;
    }

    public String getSize() {
        return size;
    }

    public String getAirportName() {
        return airportName;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getContinent() {
        return continent;
    }

    public String getCountry() {
        return country;
    }
}
