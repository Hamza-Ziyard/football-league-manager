package controllers;

import java.io.IOException;

public class FootballLeagueManager{

    private final static ConsoleApp consoleAppF =new ConsoleApp();
    private final static PremierLeagueManager premierLeagueManagerF =new PremierLeagueManager();

    public static void main(String[] args) throws IOException {
        premierLeagueManagerF.recoverStats();
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t--------------------------------------------------"+
                           "\n\t\t\t\t\t\t\t\t\t\t||\t\t  Football Premier League Manager  \t\t||"+
                           "\n\t\t\t\t\t\t\t\t\t\t--------------------------------------------------");
        consoleAppF.menu();
    }
}
