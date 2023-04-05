package drivers;

import com.codeborne.selenide.Configuration;
import config.WebConfig;
import org.aeonbits.owner.ConfigFactory;

public class DriverSettings {

    static WebConfig config = ConfigFactory.create(WebConfig.class);

    public static void configuration() {

        Configuration.baseUrl = config.baseUrl();
        Configuration.browserSize = config.browserSize();
        Configuration.browser = config.browserName();
        Configuration.browserVersion = config.browserVersion();
    }
}