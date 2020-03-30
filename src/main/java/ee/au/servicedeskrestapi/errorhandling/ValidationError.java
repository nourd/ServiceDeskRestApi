package ee.au.servicedeskrestapi.errorhandling;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import ee.au.servicedeskrestapi.model.*;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class ValidationError extends ApiSubError {
    private String object;
    private String field;
    private Object rejectedValue;
    private String message;

    ValidationError(String object, String message) {
        this.object = object;
        this.message = message;
    }
}