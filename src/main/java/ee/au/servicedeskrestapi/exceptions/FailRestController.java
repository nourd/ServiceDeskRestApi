package ee.au.servicedeskrestapi.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FailRestController {
    
    @GetMapping("/exception")
    public ResponseEntity<Void> requestWithException() {
        throw new RuntimeException("Custom message - Fail");
    }

}