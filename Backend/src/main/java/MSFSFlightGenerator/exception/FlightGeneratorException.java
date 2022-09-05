package MSFSFlightGenerator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FlightGeneratorException extends RuntimeException {

    public FlightGeneratorException() {}

    public FlightGeneratorException(String message) {
        super(message);
    }
}

