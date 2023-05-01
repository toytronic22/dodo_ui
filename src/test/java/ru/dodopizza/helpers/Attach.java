package ru.dodopizza.helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class Attach {
    @Attachment(value = "{attachName}", type = "image/png")
    public static void screenshotAs(String attachName) {
        ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Page source", type = "text/plain")
    public static void pageSource() {
        getWebDriver().getPageSource();
    }

    @Attachment(value = "{attachName}", type = "text/plain")
    public static void attachAsText(String attachName, String message) {
    }

    public static void browserConsoleLogs() {
        attachAsText(
                "Browser console logs",
                String.join("\n", Selenide.getWebDriverLogs(BROWSER))
        );
    }


    @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
    public static void addVideo() {
        getVideoUrl();
    }

    public static void getVideoUrl() {
        String videoUrl = Configuration.remote + Selenide.sessionId() + ".mp4";

        try {
            new URL(videoUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static String getSessionId(){
        return ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
    }
}