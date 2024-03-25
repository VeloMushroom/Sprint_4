import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class scooterButtonTest {
    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    @Test
    public void scooterButtonTest() {
        homePage objHomePage = new homePage(driverFactory.getDriver());
        String url = objHomePage.clickScooterButton();
        assertEquals("https://qa-scooter.praktikum-services.ru/", url);
    }
}
