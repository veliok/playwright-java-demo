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

            Page page = browser.newPage();
            page.navigate("https://kauppa.dna.fi/laitteet/puhelimet-ja-lisalaitteet/puhelimet");
            assertNotNull(page.title());

            browser.close();
        } catch (Exception e) {
            fail("App failed to run: " + e.getMessage());
        }
    }
}