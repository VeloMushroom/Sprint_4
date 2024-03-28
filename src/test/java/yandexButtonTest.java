import org.junit.Rule;
import org.junit.Test;
import pages.homePage;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class yandexButtonTest {
    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    @Test
    public void yandexButtonTest() {
        homePage objHomePage = new homePage(driverFactory.getDriver());
        String url = objHomePage.clickYandexButton();
        System.out.println(url);
        assertEquals("https://dzen.ru/?yredirect=true", url);
    }
}
