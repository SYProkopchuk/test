package app;


import org.openqa.selenium.WebDriver;
import pages.BetsPage;

public class App extends Driver {

    public BetsPage betsPage;
    public WebDriver driver;

    public App(){
        this.driver = initDriver();
        betsPage = PageBuilder.buildBetsPage(this);
    }

}
