import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {
    @Step("Открываем страницу репозитория")
    public void openPage () {
        open("https://github.com/3007ver/git_qaguru");
    }
    @Step("Переходим во вкладку Issues")
    public void openTabIssues () {
        $("#issues-tab").click();
    }
    @Step("Проверяем, что для issue# {issueNumber} отображается название:{issueName}")
    public void checkIssueTitle (String issueNumber, String issueName) {
        $(String.format("#issue_%s_link", issueNumber)).shouldHave(text(issueName));
    }
    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
