package base;

import manager.App;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeSuite;


import java.io.IOException;

public class TestBase {


    Logger logger = LoggerFactory.getLogger(TestBase.class);


    static App app = new App(
            System.getProperty("browser", "chromium")
    );

    @BeforeSuite
    public void setUp() throws IOException {
        app.init();
    }
}
