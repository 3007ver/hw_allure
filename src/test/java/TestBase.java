import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    @BeforeAll
    static void BeforeAll () {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com/3007ver/git_qaguru");
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = false;

    }
}
