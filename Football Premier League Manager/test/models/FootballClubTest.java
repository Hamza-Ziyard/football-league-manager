package models;

import models.clubs.FootballClub;
import org.junit.Test;

import static org.junit.Assert.*;

public class FootballClubTest {

    @Test
    public void getWinsOfFClub() {
        int checkFWins=8;
        FootballClub fFootballClub = new FootballClub("everton","ruganda","kunji",87,17,8,3,2,25,12,13,27);
        assertEquals(checkFWins, fFootballClub.getWinsOfFClub());
    }

    @Test
    public void setWinsOfFClub() {
        FootballClub fFootballCLub = new FootballClub();
        int checkFWins=8;
        fFootballCLub.setWinsOfFClub(8);
        assertEquals(checkFWins,fFootballCLub.getWinsOfFClub());
    }

    @Test
    public void getDrawsOfFClub() {
        int checkFDraws=3;
        FootballClub fFootballClub = new FootballClub("everton","ruganda","kunji",87,17,8,3,2,25,12,13,27);
        assertEquals(checkFDraws, fFootballClub.getDrawsOfFClub());
    }

    @Test
    public void setDrawsOfFClub() {
        FootballClub fFootballCLub = new FootballClub();
        int checkFDraws=3;
        fFootballCLub.setDrawsOfFClub(3);
        assertEquals(checkFDraws,fFootballCLub.getDrawsOfFClub());
    }

    @Test
    public void getDefeatsOfFClub() {
        int checkFDefs=2;
        FootballClub fFootballClub = new FootballClub("everton","ruganda","kunji",87,17,8,3,2,25,12,13,27);
        assertEquals(checkFDefs, fFootballClub.getDefeatsOfFClub());
    }

    @Test
    public void setDefeatsOfFClub() {
        FootballClub fFootballCLub = new FootballClub();
        int checkFDefs=5;
        fFootballCLub.setDefeatsOfFClub(5);
        assertEquals(checkFDefs,fFootballCLub.getDefeatsOfFClub());
    }

    @Test
    public void getGoalsScoredByFClub() {
        int checkFGoalsScored=25;
        FootballClub fFootballClub = new FootballClub("everton","ruganda","kunji",87,17,8,3,2,25,12,13,27);
        assertEquals(checkFGoalsScored, fFootballClub.getGoalsScoredByFClub());
    }

    @Test
    public void setGoalsScoredByFClub() {
        FootballClub fFootballCLub = new FootballClub();
        int checkFGoalsScored=25;
        fFootballCLub.setGoalsScoredByFClub(25);
        assertEquals(checkFGoalsScored,fFootballCLub.getGoalsScoredByFClub());
    }

    @Test
    public void getGoalsReceivedByFClub() {
        int checkFGoalsReceived=12;
        FootballClub fFootballClub = new FootballClub("everton","ruganda","kunji",87,17,8,3,2,25,12,13,27);
        assertEquals(checkFGoalsReceived, fFootballClub.getGoalsReceivedByFClub());
    }

    @Test
    public void setGoalsReceivedByFClub() {
        FootballClub fFootballCLub = new FootballClub();
        int checkFGoalsReceived=12;
        fFootballCLub.setGoalsReceivedByFClub(12);
        assertEquals(checkFGoalsReceived,fFootballCLub.getGoalsReceivedByFClub());
    }

    @Test
    public void getMatchesOfFClub() {
        int checkFMatches=13;
        FootballClub fFootballClub = new FootballClub("everton","ruganda","kunji",87,17,8,3,2,25,12,13,27);
        assertEquals(checkFMatches, fFootballClub.getMatchesOfFClub());
    }

    @Test
    public void setMatchesOfFClub() {
        FootballClub fFootballCLub = new FootballClub();
        int checkFMatches=13;
        fFootballCLub.setMatchesOfFClub(13);
        assertEquals(checkFMatches,fFootballCLub.getMatchesOfFClub());
    }

    @Test
    public void getPointsOfFClub() {
        int checkFPoints=27;
        FootballClub fFootballClub = new FootballClub("everton","ruganda","kunji",87,17,8,3,2,25,12,13,27);
        assertEquals(checkFPoints, fFootballClub.getPointsOfFClub());
    }

    @Test
    public void setPointsOfFClub() {
        FootballClub fFootballCLub = new FootballClub();
        int checkFPoints=27;
        fFootballCLub.setPointsOfFClub(27);
        assertEquals(checkFPoints,fFootballCLub.getPointsOfFClub());
    }
}