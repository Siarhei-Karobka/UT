package triangle;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetSquareTest {
    @DataProvider(name = "incorrectSides")
    public Object[][] IncorrectSidesData(){
        return new Object[][]{
                {0,2,2}, //сторона меньше или равну нулю
                {2,0,2},
                {2,2,0},
                {5,2,2}, //сторона больше суммы двух других сторон
                {2,5,2},
                {2,2,5},
        };
    }

    @DataProvider(name = "CorrectSides")
    public Object[][] Triangles(){
        return new Object[][]{
                {2,2,2,1.73}, // равносторонний

                {2,2,3,1.98}, // равнобедренный
                {2,3,2,1.98},
                {3,2,2,1.98},

                {2,3,4,2.90}, // обычный

                {3,4,5,6.0}, //прямоугольный
                {5,3,4,6.0},
                {4,5,3,6.0}
        };
    }

    // При вычислении площади с некорректными параметрами должно вызываться исключение
    @Test(dataProvider = "incorrectSides")
    public void ExceptionTest(double a, double b, double c) {
        Triangle triangle = new Triangle(a, b, c);
        System.out.println(triangle.getSquare());
        Assert.fail();
    }

    @Test(dataProvider = "CorrectSides")
    public void Test(double a, double b, double c,double result) {
        Triangle triangle = new Triangle(a, b, c);
        Assert.assertEquals(Math.round(triangle.getSquare() * 100.0) / 100.0, result);
    }
}
