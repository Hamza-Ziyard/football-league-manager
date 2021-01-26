package controllers;

import models.clubs.FootballClub;

import java.io.IOException;

public interface LeagueManager {
    void addClubToSystem(FootballClub fFootballClub);
    void deleteClubFromSystem(String fRemoveClub);
    void displayLeagueTable();
    void displayStatOfAClub(String fClubStatName);
    void addAMatchToSystem(String fMatchDate, String fTeamOneName, String fTeamTwoName, int fTeamOneGoal, int fTeamTwoGoal);
    void matchesPlayed();
    void searchMatch(String matchDate);
    void saveDataToStatFile();
    void recoverStats() throws IOException;
    void loadGUI();
    void returnToMenu();
}
