import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @Test
    public void testCarCreation() {
        Car car = new Car("A", "1234");
        assertEquals("1234", car.getLicensePlate());
        assertEquals("A", car.getAction());
    }

    @Test
    public void testCarToString() {
        Car car = new Car("D", "AB12");
        assertEquals("D AB12", car.toString());
    }

    @Test
    public void testCarEquals() {
        Car c1 = new Car("A", "XYZ");
        Car c2 = new Car("D", "XYZ");
        assertEquals(c1, c2);
    }

    @Test
    public void testCarHashCode() {
        Car c1 = new Car("A", "XYZ");
        Car c2 = new Car("D", "XYZ");
        assertEquals(c1.hashCode(), c2.hashCode());
    }
}
