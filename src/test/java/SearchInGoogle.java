import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchInGoogle {

    String keyWord = "selenide";

    @Test
    void yandexTest()  {
        open("https://yandex.ru");
        $x("//input[@aria-label='Запрос']").setValue("Selenide").pressEnter();
        int assertionsMatches = 0;
        for(SelenideElement element : $$x("//div[@class='organic__url-text']")){
            if(element.text().toLowerCase().contains(keyWord)){
                assertionsMatches += 1;
            }
        }
        Assertions.assertTrue(assertionsMatches >= 5,
                "Matches for search is: " + assertionsMatches + " it's less then expected (5)");
    }

    @Test
    void testGoogle() {
        open("https://google.ru");
        $("[name='q']").val("selenide");
        $("[value='Поиск в Google']").click();
        $("body").shouldHave(text("Selenide: лаконичные и стабильные UI тесты на Java"));
    }

}
