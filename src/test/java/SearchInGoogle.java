import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchInGoogle {

    @Test
    void testGoogle() {
        open("https://google.ru");
        $("[name='q']").val("selenide");
        $("[value='Поиск в Google']").click();
        $("body").shouldHave(text("Selenide: лаконичные и стабильные UI тесты на Java"));
    }

}
