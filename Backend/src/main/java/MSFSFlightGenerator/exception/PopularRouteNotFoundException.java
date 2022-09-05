package MSFSFlightGenerator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PopularRouteNotFoundException extends RuntimeException{

    public PopularRouteNotFoundException(String message){
        super(message);
    }
}
