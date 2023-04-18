package pl.mt.eitherexception.exception.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExceptionCalculatorTest {

    private ExceptionCalculator exceptionCalculator;

    @BeforeEach
    public void beforeEach() {
        exceptionCalculator = new ExceptionCalculator();
    }

    @Test
    void whenValidValuesPassed_shouldReturnDivisionResult() {
        //Given
        var first = 4;
        var second = 2;

        //When
        var result = exceptionCalculator.divide(first, second);

        //Then
        assertThat(result).isEqualTo(new DivisionResult(2));
    }

    @Test
    void whenDividingByZero_shouldReturnError() {
        //Given
        var first = 3;
        var second = 0;

        //When Then
        //Need for special construct to catch exception
        assertThatThrownBy(() -> exceptionCalculator.divide(first, second))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Could not divide by 0");
    }
}
