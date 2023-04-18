package pl.mt.eitherexception.either.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.mt.eitherexception.either.logic.EitherCalculator;

@RestController
@RequestMapping("/either-calculator")
class EitherCalculatorController {

    private final EitherCalculator eitherCalculator;

    public EitherCalculatorController(EitherCalculator eitherCalculator) {
        this.eitherCalculator = eitherCalculator;
    }

    @GetMapping("/divide")
    public ResponseEntity<DivideResult> divide(@RequestParam int first, @RequestParam int second) {
        return eitherCalculator.divide(first, second).fold(
                left -> ResponseEntity.badRequest().body(DivideResult.error(left.error())),
                right -> ResponseEntity.ok(DivideResult.successful(right.result()))
        );
    }
}

@JsonInclude(JsonInclude.Include.NON_NULL)
record DivideResult(Integer result, String error) {
    public static DivideResult successful(int result) {
        return new DivideResult(result, null);
    }

    public static DivideResult error(String error) {
        return new DivideResult(null, error);
    }
}