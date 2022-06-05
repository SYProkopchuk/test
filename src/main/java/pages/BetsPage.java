package pages;

import app.App;
import models.Game;
import models.Сhampionship;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class BetsPage {
    App app;

    public BetsPage(App app) {
        this.app = app;

    }

    public BetsPage open(){
        app.open("https://1xstavka.ru/en/line/football");
        app.driver.findElement(By.xpath("//a[@href='#deny']")).click();

        return this;
    }

    public List<Сhampionship> getAvailableGames() throws ParseException {
        List<WebElement> leaguesElements = app.driver.findElements(By.xpath("//div[@data-name='dashboard-champ-content']"));
        List<Сhampionship> сhampionships = new ArrayList<>();

        Iterator<WebElement> leaguesElementsIterator = leaguesElements.listIterator();
        while (leaguesElementsIterator.hasNext()) {
            WebElement currentLeague = leaguesElementsIterator.next();
            Сhampionship сhampionshipObject = new Сhampionship();

            //Get championship name
            сhampionshipObject.setName(currentLeague.findElement(By.xpath(".//a[@class='c-events__liga']")).getText());
            //Get championship games
            List<Game> games = new ArrayList<>();
            List<WebElement> gamesForCurrentLeague = currentLeague.findElements(By.xpath(".//div[@class='c-events__item c-events__item_col']"));
            Iterator<WebElement> gamesForCurrentLeagueIterator = gamesForCurrentLeague.iterator();
            while(gamesForCurrentLeagueIterator.hasNext()) {
                WebElement currentGame = gamesForCurrentLeagueIterator.next();
                Game gameObject = new Game();
                // Add event teams
                List<String> teams = new ArrayList<>();
                Iterator<WebElement> teamsIterator = currentGame.findElements(By.xpath(".//span[@class='c-events__team']")).listIterator();
                while(teamsIterator.hasNext()){
                    teams.add(teamsIterator.next().getAttribute("innerHTML").replace(" ", "").replace("\n", ""));
                }
                // Add event date
                gameObject.setDate(currentGame.findElement(By.xpath(".//div[@class='c-events__time min']//span")).getAttribute("innerHTML"));
                //Add event teams
                gameObject.setTeams(teams);
                games.add(gameObject);
                //Sort
                Collections.sort(games);
            }
            сhampionshipObject.setGames(games);
            сhampionships.add(сhampionshipObject);
        }


        return сhampionships;
    }

}
