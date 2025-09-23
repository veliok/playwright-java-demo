package org.example;

import com.microsoft.playwright.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.List;

public class App {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            BrowserType firefox = playwright.firefox();
            Browser browser = firefox.launch(new BrowserType.LaunchOptions().setHeadless(true));
        
            Page page = browser.newPage();
            page.navigate("https://kauppa.dna.fi/laitteet/puhelimet-ja-lisalaitteet/puhelimet");
            
            Locator campaignCheckbox = page.getByTestId("has-campaign-input");
            campaignCheckbox.click();
            assertThat(campaignCheckbox).isChecked();

            page.getByTestId("product-listing-name").first().waitFor();

            List<String> products = page.getByTestId("product-listing-name").allInnerTexts();
            List<String> prices = page.getByTestId("product-listing-selling-price").allInnerTexts();

            // Trim EURO symbol and whitespace
            for (int i = 0; i < prices.size(); i++) {
                prices.set(i, prices.get(i).substring(0, prices.get(i).length() - 2));
            }

            if (products.size() == prices.size()) {
                for (int i = 0; i < products.size(); i++) {
                    System.out.println(products.get(i) + " --- " + prices.get(i));
                }
            }

            playwright.close();
        }
    }
}