import org.junit.jupiter.api.*;

public class FirstTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println("Runs before all tests");
    }
    @BeforeEach
    void beforeEach() {
        System.out.println("Runs before each test");
    }
    @Test
    void searchVideoTest() {
        System.out.println("We searching some video in some browser!");
    }
    @Test
    void searchTextTest() {
        System.out.println("We searching some text in some browser!");
    }
    @AfterEach
    void afterEach() {
        System.out.println("Runs after each test");
    }
    @AfterAll
    static void afterAll() {
        System.out.println("Runs after all tests");
    }
}
