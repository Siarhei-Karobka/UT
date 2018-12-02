package triangle;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckTriangleTest {

    @DataProvider(name = "incorrectSides")
    public Object[][] IncorrectSidesData(){
        return new Object[][]{
                {0,2,2,"a<=0"}, //сторона меньше или равну нулю
                {2,0,2,"b<=0"},
                {2,0,2,"b<=0"},
                {2,2,0,"c<=0"},
                {5,2,2,"b+c<=a"}, //сторона больше суммы двух других сторон
                {2,5,2,"a+c<=b"},
                {2,2,5,"a+b<=c"}
        };
    }

    @DataProvider(name = "CorrectSides")
    public Object[][] Triangles(){
        return new Object[][]{
                {2,2,2}, // равносторонний

                {2,2,3}, // равнобедренный
                {2,3,2},
                {3,2,2},

                {2,3,4}, // обычный

                {3,4,5}, //прямоугольный
                {5,3,4},
                {4,5,3}
        };
    }

    @Test (dataProvider = "incorrectSides")
    public void tst_checkTriangleINC (double a, double b, double c, String message) {
        Triangle triangle = new Triangle(a, b, c);
        triangle.checkTriangle();
        Assert.assertEquals(triangle.getMessage(), message);
    }

    @Test (dataProvider = "CorrectSides")
    public void tst_checkTriangleCOR (double a, double b, double c) {
        String emptyMessage = "";
        Triangle triangle = new Triangle(a, b, c);
        triangle.checkTriangle();
        Assert.assertEquals(triangle.getMessage(), emptyMessage);
    }
}
