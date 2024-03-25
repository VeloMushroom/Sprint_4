import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.hamcrest.CoreMatchers.containsString;
import org.hamcrest.MatcherAssert;

import java.sql.Driver;

@RunWith(Parameterized.class)
public class orderTest {
    @Rule
    public DriverFactory driverFactory = new DriverFactory();
    private final String name;
    private final String family;
    private final String data;
    private final String number;
    private final String adres;
    private final String period;
    private final String buttonChoose;
    private final int metroPoint;

    public orderTest(String buttonChoose, String name, String family, String adres, int metroPoint, String number, String data, String period) {
        this.buttonChoose = buttonChoose;
        this.name = name;
        this.adres = adres;
        this.metroPoint = metroPoint;
        this.data = data;
        this.family = family;
        this.number = number;
        this.period = period;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][] {
                {"Up","Иван", "Яковлев", "Агрозимиков 20", 4, "+79995553311", "28", "двое суток"},
                {"Down", "Владимир", "Терехов", "Новочеркасово 15", 9, "+79455039987", "01", "сутки"},
        };
    }

    @Test
    public void orderTest() {
        orderPage objOrderPage = new orderPage(driverFactory.getDriver());
        homePage objHomePage = new homePage(driverFactory.getDriver());

        if (buttonChoose == "Up") {
            objHomePage.clickOrderUpButton();
        } else objHomePage.clickOrderDownButton();

        objOrderPage.order(name, family, adres, metroPoint, number, data, period);
        MatcherAssert.assertThat(objOrderPage.headerOrderConfirm(), containsString("Заказ оформлен"));
    }
}
