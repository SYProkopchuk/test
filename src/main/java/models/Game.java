package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Game implements Comparable<Game>{
    List<String> teams;
    Date date;

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    String dateString;

    public List<String> getTeams() {
        return teams;
    }

    public void setTeams(List<String> teams) {
        this.teams = teams;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(String date) throws ParseException {
        this.dateString = date;
        date = java.time.LocalDate.now().getYear() + "." + date;
        String pattern = "yyyy.dd.MM HH:mm";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date formattedDate = simpleDateFormat.parse(date);;

        this.date = formattedDate;
    }

    @Override
    public int compareTo(Game firstGame) {
        return getDate().compareTo(firstGame.getDate());
    }
}
