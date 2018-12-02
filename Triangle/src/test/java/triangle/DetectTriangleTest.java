package triangle;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DetectTriangleTest {

    final int TR_EQUILATERAL = 1; // равносторонний
    final int TR_ISOSCELES = 2;   // равнобедренный
    final int TR_ORDYNARY = 4;    // обычный
    final int TR_RECTANGULAR = 8; // прямоугольный

    @DataProvider(name = "DetectTriangleData")
    public Object[][] Triangles(){
        return new Object[][]{
                {2,2,2,TR_EQUILATERAL}, //  равносторонний всегда является равнобедренным

                {2,2,3,TR_ISOSCELES}, // равнобедренный
                {2,3,2,TR_ISOSCELES},
                {3,2,2,TR_ISOSCELES},

                {2,3,4,TR_ORDYNARY}, // обычный

                {3,4,5,TR_RECTANGULAR}, //прямоугольный
                {5,3,4,TR_RECTANGULAR},
                {4,5,3,TR_RECTANGULAR}
        };
    }

    @Test (dataProvider = "DetectTriangleData")
    public void tst_detectTriangle(double a, double b, double c, int triangleType){
        Triangle triangle = new Triangle(a, b, c);
        Assert.assertEquals(triangle.detectTriangle(), triangleType);
    }
}
