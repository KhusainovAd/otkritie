import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.fail;

public class Google_test {
    final private long constantValue = 10000;
    private long searchValue;
    @Test
    void otkritieSearchByGoogle() {
        open("http://google.com");
        $(By.name("q")).setValue("Открытие").pressEnter();

        String s = $(By.id("resultStats")).getText();
        searchValue = Long.parseLong(s.replaceAll("[\\D]", ""));

        if (searchValue < constantValue) fail("Запросов: " + searchValue + " меньше чем " + constantValue);
    }
}
