package pl.mt.eitherexception.domainleak.exception.logic;

import org.springframework.stereotype.Component;

@Component
public class ExceptionCalculator {

    public DivisionResult divide(int first, int second) {
        if (second == 0) {
            throw new ArithmeticException("Could not divide by 0");
        }

        return new DivisionResult(first / second);
    }
}
