package manager;

import com.microsoft.playwright.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.testng.annotations.BeforeSuite;

import java.util.Properties;

public class App {
    Logger logger = LoggerFactory.getLogger(App.class);

    Properties properties;
    String browser;

    public App(String browser) {

        this.browser = browser;
        properties = new Properties();
    }

    public String getEmail() {
        return properties.getProperty("web.email");
    }
    public String getPassword() {
        return properties.getProperty("web.password");
    }

    @BeforeSuite
    public void init(){


        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();
            page.navigate("http://playwright.dev");
            System.out.println(page.title());
        }
    }



}