package config;

import org.aeonbits.owner.Config;
@Config.Sources({
        "classpath:config/${webPlatform}.properties"
})
public interface WebConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://dodopizza.ru/moscow")
    String baseUrl();
    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();
    @Key("browser")
    @DefaultValue("CHROME")
    String browserName();
    @Key("browserVersion")
    @DefaultValue("103")
    String browserVersion();
    @Key("remoteUrl")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub")
    String remoteUrl();
}