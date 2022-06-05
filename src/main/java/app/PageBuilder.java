package app;

import pages.BetsPage;

public class PageBuilder {

    public static BetsPage buildBetsPage(App app) {
        return new BetsPage(app);
    }

}
