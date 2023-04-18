package pl.mt.eitherexception.exception.logic;

import org.springframework.stereotype.Component;

@Component
public class ExceptionCalculator {

    public DivisionResult divide(int first, int second) {
        if (second == 0) {
            //What if more than one Unchecked exception is thrown here? I need to know that.
            throw new ArithmeticException("Could not divide by 0");
        }

        return new DivisionResult(first / second);
    }
}
