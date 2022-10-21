package flightcreation.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@NoArgsConstructor
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FlightGeneratorException extends RuntimeException {

    public FlightGeneratorException(String message) {
        super(message);
    }
}

