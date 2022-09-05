package MSFSFlightGenerator.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name= "route")
@Table(name = "route")
@Getter
@Setter
@NoArgsConstructor
public class PopularRoute {

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

    public PopularRoute(int ranking,
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
}
