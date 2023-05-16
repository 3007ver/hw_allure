import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class IssueNameTests extends TestBase {
    private static final String ISSUE_NUMBER = "2",
                                ISSUE_NAME = "Issue for AllureTest";
        @Test
        @DisplayName("Чистый Selenide (с Listener)")
        void testClearSelenide () {
            open("https://github.com/3007ver/git_qaguru");
            $("#issues-tab").click();
            $(String.format("#issue_%s_link", ISSUE_NUMBER)).shouldHave(text(ISSUE_NAME));
        }

        @Test
        @DisplayName("Лямбда шаги через step (name, () -> {})")
        void testLambdaSteps () {
            step("Открываем страницу репозитория", () -> {
                open("https://github.com/3007ver/git_qaguru");
            });
            step("Переходим во вкладку Issues", () -> {
                $("#issues-tab").click();
            });
            step("Проверяем, что для issue#" + ISSUE_NUMBER + " отображается название: " + ISSUE_NAME, () -> {
                $(String.format("#issue_%s_link", ISSUE_NUMBER)).shouldHave(text(ISSUE_NAME));
            });
        }
            @Test
            @DisplayName("Шаги с аннотацией @Step")
            void testWithAnnotatedSteps () {
                WebSteps steps = new WebSteps();
                steps.openPage();
                steps.openTabIssues();
                steps.checkIssueTitle(ISSUE_NUMBER, ISSUE_NAME);
                steps.attachScreenshot();
            }
        }

