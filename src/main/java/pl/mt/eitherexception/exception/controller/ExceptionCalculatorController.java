package pl.mt.eitherexception.exception.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.mt.eitherexception.exception.logic.ExceptionCalculator;

@RestController
@RequestMapping("/either-controller")
class ExceptionCalculatorController {

    private final ExceptionCalculator exceptionCalculator;

    public ExceptionCalculatorController(ExceptionCalculator exceptionCalculator) {
        this.exceptionCalculator = exceptionCalculator;
    }

    @GetMapping("/divide")
    public ResponseEntity<DivideResult> divide(@RequestParam int first, @RequestParam int second) {
        //Can something go wrong, do I know that?
        return ResponseEntity.ok(DivideResult.successful(exceptionCalculator.divide(first, second).result()));
    }
}

