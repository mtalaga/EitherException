package pl.mt.eitherexception.domainleak.either.logic;

import io.vavr.control.Either;
import org.springframework.stereotype.Component;

@Component
public class EitherCalculator {

    public Either<DivisionError, DivisionResult> divide(int first, int second) {
        if (second == 0) {
            return Either.left(new DivisionError("Cannot divide by 0"));
        }

        return Either.right(new DivisionResult(first / second));
    }
}
