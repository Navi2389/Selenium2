package project4TriangleTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import project4TriangleFunction.NegativeOrNullTriangleSideException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static project4TriangleFunction.Functions.calculateArea;

public class FunctionsTests {
    @Test
    void positiveTriangleAreaCalculationTest() throws NegativeOrNullTriangleSideException {
        Assertions.assertEquals(calculateArea(3,3,3),2.23606797749979);
        //сравниваем значение в скобках со значением после запятой
    }

    @Test
    void degenerateTriangleTest(){
        assertThatExceptionOfType(NegativeOrNullTriangleSideException.class).isThrownBy(()->calculateArea(-1,4,6));
    }
}
