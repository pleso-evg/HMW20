package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

public class SimpleCrossPlatformTest extends TestBase {

    @Test
    @Tag("android")
    void searchTestAndroid() {
        step("Open search field", () -> $(id("org.wikipedia.alpha:id/search_container")).click());
        step("Type 'Selenide'", () -> $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Selenide\n"));
        step("Verify search results", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @Tag("ios")
    void searchTestIos() {
        step("Open search field", () -> $(accessibilityId("Search Wikipedia")).click());
        step("Type 'Selenide'", () -> $(accessibilityId("Search Wikipedia")).sendKeys("Selenide\n"));
        step("Verify search results", () ->
                $$(accessibilityId("Page title")).shouldHave(sizeGreaterThan(0)));
    }
}