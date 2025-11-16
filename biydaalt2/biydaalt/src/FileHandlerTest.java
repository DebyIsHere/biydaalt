import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.util.*;

public class FileHandlerTest {

    @Test
    public void testWriteAndReadFile() throws Exception {
        FileHandler fh = new FileHandler();
        String tempFile = "test_cars.txt";

        List<String> lines = List.of("A 111", "D 222");
        fh.writeToFile(tempFile, lines);

        List<Car> cars = fh.readFromFile(tempFile);

        assertEquals(2, cars.size());
        assertEquals("111", cars.get(0).getLicensePlate());
        assertEquals("A", cars.get(0).getAction());
    }
}