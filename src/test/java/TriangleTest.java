import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class TriangleTest {

    @Test
    void triangleArea() {
        Triangle triangle = new Triangle();
        triangle.triangleArea(3, 4, 5);
        triangle.triangleArea(-2, 4, 5);
        triangle.triangleArea(10, 4, 5);
        triangle.triangleArea(0, 4, 5);

        double actual = triangle.triangleArea(3, 4, 5);
        double expected = 6;
        assertEquals(expected, actual);
    }
}