import models.Game;
import models.Сhampionship;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Tests extends TestBase {

    @Test()
    public void test() throws ParseException {
        List<Сhampionship> сhampionships = app.betsPage
                .open()
                .getAvailableGames();

        //All matches by championships (already sorted by date)
        Iterator<Сhampionship> leagueIterator = сhampionships.listIterator();
        while (leagueIterator.hasNext()){
            Сhampionship сhampionship = leagueIterator.next();
            System.out.println();
            System.out.println("=====================================");
            System.out.println("Events for " + сhampionship.getName() + ":");
            System.out.println();
            List<Game> games = сhampionship.getGames();
            Iterator<Game> gameIterator = games.listIterator();
            while (gameIterator.hasNext()){
                Game game = gameIterator.next();
                System.out.println("+++ " + game.getTeams().get(0) + " vs " + game.getTeams().get(1) + " starts at: " + game.getDateString());
            }
            System.out.println("=====================================");
        }

        //All matches sorted by date
        List<Game> allGames = сhampionships.stream().flatMap(champ -> champ.getGames().stream()).collect(Collectors.toList());
        Collections.sort(allGames);
        Iterator<Game> allGamesIterator = allGames.listIterator();
        while (allGamesIterator.hasNext()){
            Game game = allGamesIterator.next();
            System.out.println("+++ " + game.getTeams().get(0) + " vs " + game.getTeams().get(1) + " starts at: " + game.getDateString());
        }
    }

}