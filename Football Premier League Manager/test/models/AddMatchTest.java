package models;

import models.matches.AddMatch;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddMatchTest {

    @Test
    public void getTeamOneF() {
        String checkFTeamOne="everton";
        AddMatch addFMatch = new AddMatch("2020-10-10","everton","southampton",5,3);
        assertEquals(checkFTeamOne, addFMatch.getTeamOneF());
    }

    @Test
    public void setTeamOneF() {
        AddMatch addFMatch = new AddMatch();
        String checkFTeamOne= "everton";
        addFMatch.setTeamOneF("everton");
        assertEquals(checkFTeamOne, addFMatch.getTeamOneF());
    }

    @Test
    public void getTeamTwoF() {
        String checkFTeamTwo="southampton";
        AddMatch addFMatch = new AddMatch("2020-10-10","everton","southampton",5,3);
        assertEquals(checkFTeamTwo, addFMatch.getTeamTwoF());
    }

    @Test
    public void setTeamTwoF() {
        AddMatch addFMatch = new AddMatch();
        String checkFTeamTwo= "southampton";
        addFMatch.setTeamTwoF("southampton");
        assertEquals(checkFTeamTwo, addFMatch.getTeamTwoF());
    }

    @Test
    public void getTeamOneGoalsF() {
        int checkFTeamOneGoals=5;
        AddMatch addFMatch = new AddMatch("2020-10-10","everton","southampton",5,3);
        assertEquals(checkFTeamOneGoals, addFMatch.getTeamOneGoalsF());
    }

    @Test
    public void setTeamOneGoalsF() {
        AddMatch addFMatch = new AddMatch();
        int checkFTeamOneGoals= 5;
        addFMatch.setTeamOneGoalsF(5);
        assertEquals(checkFTeamOneGoals, addFMatch.getTeamOneGoalsF());
    }

    @Test
    public void getTeamTwoGoalsF() {
        int checkFTeamTwoGoals=3;
        AddMatch addFMatch = new AddMatch("2020-10-10","everton","southampton",5,3);
        assertEquals(checkFTeamTwoGoals, addFMatch.getTeamTwoGoalsF());
    }

    @Test
    public void setTeamTwoGoalsF() {
        AddMatch addFMatch = new AddMatch();
        int checkFTeamTwoGoals= 3;
        addFMatch.setTeamTwoGoalsF(3);
        assertEquals(checkFTeamTwoGoals, addFMatch.getTeamTwoGoalsF());
    }

    @Test
    public void getPlayedDateF() {
        String checkFPlayedDate="2020-10-10";
        AddMatch addFMatch = new AddMatch("2020-10-10","everton","southampton",5,3);
        assertEquals(checkFPlayedDate, addFMatch.getPlayedDateF());
    }

    @Test
    public void setPlayedDateF() {
        AddMatch addFMatch = new AddMatch();
        String checkFPlayedDate= "2020-10-10";
        addFMatch.setPlayedDateF("2020-10-10");
        assertEquals(checkFPlayedDate, addFMatch.getPlayedDateF());
    }
}