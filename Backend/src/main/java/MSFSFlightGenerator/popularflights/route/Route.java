package MSFSFlightGenerator.popularflights.route;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name= "route")
@Table(name = "route")
public class Route {

    @Id
    private Integer flightRanking;

    @Column(name = "departure")
    private String departureAirport;

    @Column(name = "departureCode")
    private String departureIcao;

    @Column(name = "destination")
    private String destinationAirport;

    @Column(name = "destinationCode")
    private String destinationIcao;



    public Route(){

    }

    public Route(int ranking,
                 String departureAirport,
                 String departureIcao,
                 String destinationAirport,
                 String destinationIcao){
        this.flightRanking = ranking;
        this.departureAirport = departureAirport;
        this.departureIcao = departureIcao;
        this.destinationAirport = destinationAirport;
        this.destinationIcao = destinationIcao;
    }

    public Integer getFlightRanking() {
        return flightRanking;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getDepartureIcao() {
        return departureIcao;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public String getDestinationIcao() {
        return destinationIcao;
    }
}
