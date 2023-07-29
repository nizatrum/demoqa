package telegram;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("telegram")
public class SomeTestsForTelegramNotifications {

    @Test
    void testSuccess() {
        Assertions.assertTrue(true);
    }
    @Test
    void testFailed() {
        Assertions.assertTrue(false);
    }
    @Test
    @Disabled
    void testSkiped() {
        Assertions.assertTrue(true);
    }
}
