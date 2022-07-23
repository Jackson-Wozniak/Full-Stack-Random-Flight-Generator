package MSFSFlightGenerator.customflightgen.airport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "airport")
@Table(name = "airport")
public class Airport {

    @Id
    private final String icaoCode;

    @Column(name = "airport_size")
    private final String size;

    @Column(name = "airport_name")
    private final String airportName;

    @Column(name = "latitude")
    private final Double latitude;

    @Column(name = "longitude")
    private final Double longitude;

    @Column(name = "continent")
    private final String continent;

    @Column(name = "country")
    private final String country;

    @Column(name = "municipality")
    private final String municipality;

    public Airport(String icaoCode,
                   String size,
                   String airportName,
                   Double latitude,
                   Double longitude,
                   String continent,
                   String country,
                   String municipality) {
        this.icaoCode = icaoCode;
        this.size = size;
        this.airportName = airportName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.continent = continent;
        this.country = country;
        this.municipality = municipality;
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

    public String getMunicipality() {
        return municipality;
    }
}
