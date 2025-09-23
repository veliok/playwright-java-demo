package org.example;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void appRunsWithoutCrashing() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.firefox()
                    .launch(new BrowserType.LaunchOptions().setHeadless(true));
            assertNotNull(browser);

            browser.close();
        } catch (Exception e) {
            fail("App failed to run: " + e.getMessage());
        }
    }
}