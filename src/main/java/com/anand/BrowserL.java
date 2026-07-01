package com.anand;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class BrowserL {

    public static void main(String[] args) {

        BrowserL browserL = new BrowserL();
        browserL.executeTest();
    }

    public void executeTest() {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setChannel("chrome")
                        .setHeadless(false)
                        .setSlowMo(500)
        );

        BrowserContext context = browser.newContext(
                new Browser.NewContextOptions()
                        .setViewportSize(1366, 768)
                        .setLocale("en-IN")
                        .setTimezoneId("Asia/Kolkata")
        );

        Page page = context.newPage();

        page.navigate("https://casekaro.com/");

        page.getByRole(
                AriaRole.LINK,
                new Page.GetByRoleOptions().setName("Mobile Covers")
        ).click();

        page.getByRole(
                AriaRole.TEXTBOX,
                new Page.GetByRoleOptions().setName("Search your phone model…")
        ).fill("iPhone 16 Pro");

        page.getByRole(
                AriaRole.LINK,
                new Page.GetByRoleOptions()
                        .setName("iPhone 16 Pro")
                        .setExact(true)
        ).click();

        addMaterial(page, "Hard Variant sold out or");
        addSoft(page);
        addMaterial(page, "Glass Variant sold out or");

        page.getByRole(
                AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Cart 3 items")
        ).click();

        page.locator("cart-drawer").waitFor();

        Locator cartItems = page.locator("tr.cart-item");

        if (cartItems.count() == 3) {
            System.out.println("PASS : All 3 products added successfully.");
        } else {
            System.out.println("FAIL : Expected 3 products but found " + cartItems.count());
        }

        for (int i = 0; i < cartItems.count(); i++) {

            String name = cartItems.nth(i)
                    .locator(".cart-item__name")
                    .innerText();

            String material = cartItems.nth(i)
                    .locator(".product-option dd")
                    .innerText();

            String price = cartItems.nth(i)
                    .locator(".cart-item__price-wrapper .price")
                    .innerText();

            String link = "https://casekaro.com"
                    + cartItems.nth(i)
                    .locator(".cart-item__name")
                    .getAttribute("href");

            System.out.println("----------------------");
            System.out.println("Product : " + name);
            System.out.println("Material : " + material);
            System.out.println("Price : " + price);
            System.out.println("Link : " + link);
        }

//        page.pause();

        browser.close();
        playwright.close();
    }

    public static void addMaterial(Page page, String materialText) {

        page.getByRole(
                AriaRole.BUTTON,
                new Page.GetByRoleOptions()
                        .setName("Choose options Classic Porsche 911 iPhone 16 Pro Back Cover")
        ).click();

        page.getByText(materialText).click();

        page.locator("#ProductSubmitButton-quickadd-template--19082852040822__main").click();

        page.locator("#CartDrawer-Overlay").click();
    }

    public static void addSoft(Page page) {

        page.getByRole(
                AriaRole.BUTTON,
                new Page.GetByRoleOptions()
                        .setName("Choose options Classic Porsche 911 iPhone 16 Pro Back Cover")
        ).click();

        page.getByText(
                "Soft Variant sold out or unavailable",
                new Page.GetByTextOptions().setExact(true)
        ).click();

        page.locator("#ProductSubmitButton-quickadd-template--19082852040822__main").click();

        page.locator("#CartDrawer-Overlay").click();
    }
}