package properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("properties")
public class SystemPropertiesTests {

    @Test
    void test1() {
        System.setProperty("browser1", "edge");
        System.out.println(System.getProperty("browser1"));
    }
    @Test
    void test2() {
        System.out.println(System.getProperty("browser2", "safari"));
    }
    @Test
    void test3() {
        System.out.println(System.getProperty("browser3"));
    }
}
