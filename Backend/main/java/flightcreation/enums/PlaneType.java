package flightcreation.enums;

public enum PlaneType {
    PROPELLER,
    TURBOPROP,
    JET,
    AIRLINER;

    public String toString(){
        return switch(this){
            case PROPELLER -> "propeller";
            case TURBOPROP -> "turboprop";
            case JET -> "jet";
            case AIRLINER -> "airliner";
        };
    }
}
