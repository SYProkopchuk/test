import app.App;
import org.testng.annotations.*;

public class TestBase {
    protected App app;

    @BeforeMethod
    public void setUp() {
        this.app = new App();
    }

    @AfterMethod
    public void close(){
        app.driver.quit();
    }

}
