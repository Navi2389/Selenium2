package project4TriangleTest;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project4TriangleFunction.TriangleFunction;

public class TriangleTest {
    TriangleFunction triangleFunction=new TriangleFunction();
    private static Logger logger= LoggerFactory.getLogger(TriangleTest.class);

    @BeforeAll
    static void beforeAll(){
        logger.info("Выполнится перед всем тестовым набором");
        //  System.out.println("вЫПОНИТСЯ ПЕРЕД ВСЕМ ТЕСТОВЫМ НАБОРОМ");
    }

    @BeforeEach
    void setUp(){
        logger.info("Выполниться перед каждым тестом");
        //System.out.println("Выполниться перед каждым тестом");
    }

    @Test
        //тест на позитивное число
    void testGivenEvenNumberWhenCheckIsEvenThenTrue(){
        boolean result= triangleFunction.main(2);
        Assertions.assertTrue(result);//проверяем
    }
    @Test
    @RepeatedTest(10)
        //тест проверит негативный кейс
    void testGivenOddNumberWhenCheckIsEvenThenFalse(){
        boolean result= triangleFunction.main(3);
        Assertions.assertFalse(result,"Проверяем, что число нечетное");//проверяем
    }

    @Test
    @DisplayName("Проверить функцию, isNumberPositive положительным числом")
    void testIsNumberPositive(){
        Assertions.assertTrue(triangleFunction.main(1));
    }

    @Test
    void testIsPrimeFunctionWithNegativeNumber(){
        Assertions.assertFalse(triangleFunction.main(-1));
    }

    @ParameterizedTest
    @ValueSource(strings={"123321","abccba"})
    void testIsPalindromePositive(int word){
        Assertions.assertTrue(triangleFunction.main(word));
    }

    @ParameterizedTest
    @CsvSource({"123321,true","123, false","12321,true"})
    void testIsPalindrome(int word, boolean result){
        Assertions.assertEquals(triangleFunction.main(word),result);
    }

    @AfterEach
    void tearDown(){
        logger.debug("Выполниться после каждого теста");
        //      System.out.println("Выполниться после каждого теста");
    }
    @AfterAll
    static void AfterAll(){
        logger.debug("Выпонится после всех тестовых наборов");
        //      System.out.println("Выпонится после всех тестовых наборов");
    }

}

