package loginTests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import models.User;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPositive extends base.TestBase {

    @Test
    public void LoginPositive(){

        User user = new User()
                .withEmail("mikeben88@gmail.com")
                .withPassword("Mikeben88")
                ;

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://ecommerce-playground.lambdatest.io/index.php");
        page.hover("//a[contains(.,'My account')][@role='button']");
        page.click("//a[contains(.,'Login')]");
        assertThat(page).hasTitle("Account Login");
        page.getByPlaceholder("E-Mail Address").type(user.getEmail());
        page.getByPlaceholder("Password").type(user.getPassword());
        page.locator("//input[@value='Login']").click();
        assertThat(page).hasTitle("My Account");

//        page.close();
//        browser.close();
//        playwright.close();
    }

}
