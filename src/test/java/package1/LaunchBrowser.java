package package1;

import com.microsoft.playwright.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LaunchBrowser {

    public static void main(String[] args){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://ecommerce-playground.lambdatest.io/index.php");
        page.hover("//a[contains(.,'My account')][@role='button']");
        page.click("//a[contains(.,'Login')]");
        assertThat(page).hasTitle("Account Login");
        page.getByPlaceholder("E-Mail Address").type("mikeben88@gmail.com");
        page.getByPlaceholder("Password").type("Mikeben88");
        page.locator("//input[@value='Login']").click();
        assertThat(page).hasTitle("My Account");

//        page.close();
//        browser.close();
//        playwright.close();
    }


}
