package pl.mt.eitherexception.either.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EitherCalculatorTest {

    private EitherCalculator eitherCalculator;

    @BeforeEach
    public void beforeEach() {
        eitherCalculator = new EitherCalculator();
    }

    @Test
    void whenValidValuesPassed_shouldReturnDivisionResult() {
        //Given
        var first = 4;
        var second = 2;

        //When
        var result = eitherCalculator.divide(first, second);

        //Then
        assertThat(result.isRight()).isTrue();
        assertThat(result.get()).isEqualTo(new DivisionResult(2));
    }

    @Test
    void whenDividingByZero_shouldReturnError() {
        //Given
        var first = 3;
        var second = 0;

        //When
        var result = eitherCalculator.divide(first, second);

        //Then
        assertThat(result.isLeft()).isTrue();
        assertThat(result.getLeft()).isEqualTo(new DivisionError("Cannot divide by 0"));
    }
}
