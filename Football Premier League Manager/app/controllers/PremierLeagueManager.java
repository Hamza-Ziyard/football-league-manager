package controllers;

import models.matches.AddMatch;
import models.clubs.FootballClub;
import models.clubs.MainComparatorClass;
import models.matches.DateComparator;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PremierLeagueManager implements LeagueManager {


    private static final ConsoleApp consoleAppF = new ConsoleApp();

    private final Scanner getFUserInput = new Scanner(System.in);

    // --------- File which stores the information of clubs and matches played
    private final File tableStatFile = new File("table.bin");

    // --------- List which stores the clubs registered to the system
    static ArrayList<FootballClub> fClubsList = new ArrayList<>();
    // --------- List which stores the matches played
    static ArrayList<AddMatch> addClubsMatchList = new ArrayList<>();

//--------------------------------------- Function of registering a club -----------------------------------------------
    @Override
    public void addClubToSystem(FootballClub fFootballClub) {
        fClubsList.add(fFootballClub);
        System.out.print("\n\t\t\t\t\t\t Football Club Added :- ");
        System.out.println(fFootballClub.toString());
        returnToMenu();
    }

//--------------------------------------- Function of deleting a club -----------------------------------------------
    @Override
    public void deleteClubFromSystem(String fRemoveClub) {
        for (int fDeleteCounter = 0; fDeleteCounter < fClubsList.size(); fDeleteCounter++) {
            if (fClubsList.get(fDeleteCounter).getClubNameF().equals(fRemoveClub)) {
                System.out.println("\n\t\t\t\t\t\t\t * Deleted Club : "+
                                    fClubsList.get(fDeleteCounter).toString()+
                                    "\n\t\t\t\t\t\t\t * Deleted Club current season statistics: "+
                                    "\n\t\t\t\t\t\t\t\t No.of Wins - "+ fClubsList.get(fDeleteCounter).getWinsOfFClub()+
                                    "\n\t\t\t\t\t\t\t\t No.of Defeats - "+ fClubsList.get(fDeleteCounter).getDefeatsOfFClub()+
                                    "\n\t\t\t\t\t\t\t\t No.of Draws - "+ fClubsList.get(fDeleteCounter).getDrawsOfFClub()+
                                    "\n\t\t\t\t\t\t\t\t Goals Scored - "+ fClubsList.get(fDeleteCounter).getGoalsScoredByFClub()+
                                    "\n\t\t\t\t\t\t\t\t Goals Received - "+ fClubsList.get(fDeleteCounter).getGoalsReceivedByFClub()+
                                    "\n\t\t\t\t\t\t\t\t Matches Played - "+ fClubsList.get(fDeleteCounter).getMatchesOfFClub()+
                                    "\n\t\t\t\t\t\t\t\t Points - "+ fClubsList.get(fDeleteCounter).getPointsOfFClub() +"\n");
                fClubsList.remove(fDeleteCounter);
                break;
            }
        }
    returnToMenu();
    }

//----------------------------------- Function of displaying the league table ------------------------------------------
    @Override
    public void displayLeagueTable() {
        System.out.println("\n\t\t\t\t\t--------------------------------------\tPremier League Table\t--------------------------------------\n");
        String alignContent = "\t| %-12s | %-13s | %12d | %13d | %12d | %12d | %14d | %14d | %9d |%n";

        System.out.format("\t+--------------+---------------+--------------+---------------+--------------+--------------+----------------+----------------+-----------+%n");
        System.out.format("\t| Club Name    | Club Location | No.of Wins   | No.of Defeats | No.of Draws  | Goals Scored | Goals Received | Matches Played |   Points  |%n");
        System.out.format("\t+--------------+---------------+--------------+---------------+--------------+--------------+----------------+----------------+-----------+%n");

        fClubsList.sort(new MainComparatorClass());
        for (FootballClub fFootballClub : fClubsList) {
                System.out.format(alignContent, fFootballClub.getClubNameF(), fFootballClub.getClubLocationF(),
                        fFootballClub.getWinsOfFClub(), fFootballClub.getDefeatsOfFClub(), fFootballClub.getDrawsOfFClub(),
                        fFootballClub.getGoalsScoredByFClub(), fFootballClub.getGoalsReceivedByFClub(), fFootballClub.getMatchesOfFClub(),
                        fFootballClub.getPointsOfFClub());
            }
        System.out.format("\t+--------------+---------------+--------------+---------------+--------------+--------------+----------------+----------------+-----------+%n");
        returnToMenu();
    }

//------------------------------- Function of displaying the statistics of a club --------------------------------------
    @Override
    public void displayStatOfAClub(String fClubStatName) {
        for (FootballClub fFootballClub : fClubsList){
            if (fFootballClub.getClubNameF().equals(fClubStatName)) {
                System.out.println("\n\t\t\t\t\t\t\t * Details of club - "+fClubStatName);
                String alignContent = "\t| %-12s | %-12s | %-13s | %12d | %13d | %12d | %12d | %14d | %14d | %9d |%n";

                System.out.format("\t+--------------+--------------+---------------+--------------+---------------+--------------+--------------+----------------+----------------+-----------+%n");
                System.out.format("\t| Club Name    | Owner Name   | Club Location | No.of Wins   | No.of Defeats | No.of Draws  | Goals Scored | Goals Received | Matches Played |   Points  |%n");
                System.out.format("\t+--------------+--------------+---------------+--------------+---------------+--------------+--------------+----------------+----------------+-----------+%n");


                System.out.format(alignContent, fFootballClub.getClubNameF(),fFootballClub.getOwnerNameF(), fFootballClub.getClubLocationF(),
                        fFootballClub.getWinsOfFClub(), fFootballClub.getDefeatsOfFClub(),
                        fFootballClub.getDrawsOfFClub(),fFootballClub.getGoalsScoredByFClub(), fFootballClub.getGoalsReceivedByFClub(),
                        fFootballClub.getMatchesOfFClub(),fFootballClub.getPointsOfFClub());

                System.out.format("\t+--------------+--------------+---------------+--------------+---------------+--------------+--------------+----------------+----------------+-----------+%n");
            }
        }
        returnToMenu();
    }

//-------------------------------- Function of adding the results of played matches ------------------------------------
    @Override
    public void addAMatchToSystem(String fMatchDate, String fTeamOneName, String fTeamTwoName, int fTeamOneGoal, int fTeamTwoGoal){

        AddMatch fMatchPlayed = new AddMatch(fMatchDate, fTeamOneName, fTeamTwoName, fTeamOneGoal, fTeamTwoGoal);
        addClubsMatchList.add(fMatchPlayed);

        if (fTeamOneGoal == fTeamTwoGoal) {
            // ------------------------ If the match was drawn
            for (FootballClub fFootballClub : fClubsList) {
                    if (fFootballClub.getClubNameF().equals(fTeamOneName)) {
                        fFootballClub.setDefeatsOfFClub(0);
                        fFootballClub.setWinsOfFClub(0);
                        fFootballClub.setDrawsOfFClub(1);
                        fFootballClub.setGoalsReceivedByFClub(fTeamTwoGoal);
                        fFootballClub.setGoalsScoredByFClub(fTeamOneGoal);
                        fFootballClub.setMatchesOfFClub(1);
                        fFootballClub.setPointsOfFClub(1);
                    } else if (fFootballClub.getClubNameF().equals(fTeamTwoName)) {
                        fFootballClub.setDefeatsOfFClub(0);
                        fFootballClub.setWinsOfFClub(0);
                        fFootballClub.setDrawsOfFClub(1);
                        fFootballClub.setGoalsReceivedByFClub(fTeamOneGoal);
                        fFootballClub.setGoalsScoredByFClub(fTeamTwoGoal);
                        fFootballClub.setMatchesOfFClub(1);
                        fFootballClub.setPointsOfFClub(1);
                    }
            }
        } else if (fTeamOneGoal > fTeamTwoGoal) {
            // --------------------- If team one won the game
            for (FootballClub fFootballClub : fClubsList) {
                    if (fFootballClub.getClubNameF().equals(fTeamOneName)) {
                        fFootballClub.setDefeatsOfFClub(0);
                        fFootballClub.setWinsOfFClub(1);
                        fFootballClub.setDrawsOfFClub(0);
                        fFootballClub.setGoalsReceivedByFClub(fTeamTwoGoal);
                        fFootballClub.setGoalsScoredByFClub(fTeamOneGoal);
                        fFootballClub.setMatchesOfFClub(1);
                        fFootballClub.setPointsOfFClub(3);
                    } else if (fFootballClub.getClubNameF().equals(fTeamTwoName)) {
                        fFootballClub.setDefeatsOfFClub(1);
                        fFootballClub.setWinsOfFClub(0);
                        fFootballClub.setDrawsOfFClub(0);
                        fFootballClub.setGoalsReceivedByFClub(fTeamOneGoal);
                        fFootballClub.setGoalsScoredByFClub(fTeamTwoGoal);
                        fFootballClub.setMatchesOfFClub(1);
                        fFootballClub.setPointsOfFClub(0);
                    }
            }
        } else {
            // --------------------- If team two won the game
            for (FootballClub fFootballClub : fClubsList) {
                    if (fFootballClub.getClubNameF().equals(fTeamOneName)) {
                        fFootballClub.setDefeatsOfFClub(1);
                        fFootballClub.setWinsOfFClub(0);
                        fFootballClub.setDrawsOfFClub(0);
                        fFootballClub.setGoalsReceivedByFClub(fTeamTwoGoal);
                        fFootballClub.setGoalsScoredByFClub(fTeamOneGoal);
                        fFootballClub.setMatchesOfFClub(1);
                        fFootballClub.setPointsOfFClub(0);
                    } else if (fFootballClub.getClubNameF().equals(fTeamTwoName)) {
                        fFootballClub.setDefeatsOfFClub(0);
                        fFootballClub.setWinsOfFClub(1);
                        fFootballClub.setDrawsOfFClub(0);
                        fFootballClub.setGoalsReceivedByFClub(fTeamOneGoal);
                        fFootballClub.setGoalsScoredByFClub(fTeamTwoGoal);
                        fFootballClub.setMatchesOfFClub(1);
                        fFootballClub.setPointsOfFClub(3);
                    }
                }
        }
        System.out.println(fMatchPlayed.toString());
        returnToMenu();

    }

//--------------------------------- Function of displaying the matches played ------------------------------------------
    @Override
    public void matchesPlayed(){
        System.out.println("\n\t\t\t\t\t--------------------------------------\tMatches Played\t--------------------------------------\n");
        String alignContent = "\t\t\t\t\t\t| %-16s | %14d | %-15s | %14d | %12s |%n";

        System.out.format("\t\t\t\t\t\t+------------------+----------------+-----------------+----------------+--------------+%n");
        System.out.format("\t\t\t\t\t\t| Team One Name    | Team One Goals | Team Two Name   | Club Two Goals | Played Date  |%n");
        System.out.format("\t\t\t\t\t\t+------------------+----------------+-----------------+----------------+--------------+%n");

        addClubsMatchList.sort(new DateComparator());
        for (AddMatch addMatchDisplay : addClubsMatchList) {
            System.out.format(alignContent, addMatchDisplay.getTeamOneF(), addMatchDisplay.getTeamOneGoalsF(),
                    addMatchDisplay.getTeamTwoF(), addMatchDisplay.getTeamTwoGoalsF(), addMatchDisplay.getPlayedDateF());
        }
        System.out.format("\t\t\t\t\t\t+-------------------+----------------+-----------------+---------------+--------------+%n");
        returnToMenu();
    }

//---------------------------------- Function of searching for a match played ------------------------------------------
    @Override
    public void searchMatch(String matchDate) {
        int count=1;
        for (AddMatch addMatch : addClubsMatchList){
            if (addMatch.getPlayedDateF().equals(matchDate)) {

                System.out.println("\n\t\t\t\t\t--------------------------------------\tMatch "+count+" on "+matchDate+"\t--------------------------------------\n");
                count++;
                String alignContent = "\t\t\t\t\t\t| %-16s | %14d | %-15s | %14d | %12s |%n";

                System.out.format("\t\t\t\t\t\t+------------------+----------------+-----------------+----------------+--------------+%n");
                System.out.format("\t\t\t\t\t\t| Team One Name    | Team One Goals | Team Two Name   | Club Two Goals | Played Date  |%n");
                System.out.format("\t\t\t\t\t\t+------------------+----------------+-----------------+----------------+--------------+%n");

                System.out.format(alignContent, addMatch.getTeamOneF(), addMatch.getTeamOneGoalsF(),
                        addMatch.getTeamTwoF(), addMatch.getTeamTwoGoalsF(), addMatch.getPlayedDateF());
                System.out.format("\t\t\t\t\t\t+-------------------+----------------+-----------------+---------------+--------------+%n");
            }
        }
        returnToMenu();
    }

//------------------------------- Function of writing the data into a binary file --------------------------------------
    @Override
    public void saveDataToStatFile() {
        try {
            File fTableStatFile = new File("table.bin");
            fTableStatFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //------- saving into the file
                ObjectOutputStream fOOS = new ObjectOutputStream(new FileOutputStream(tableStatFile));
                if (fClubsList.size() == 0) {
                    System.out.println("\n\t\t\t\t\t\t------ No clubs to be stored ------");
                } else {
                    fOOS.writeObject(fClubsList);
                    System.out.println("\n\t\t\t\t\t\t------ Data stored successfully  ------");
                }if (addClubsMatchList.size() == 0) {
                    System.out.println("\n\t\t\t\t\t\t------ No matches added to store ------");
                } else {
                    fOOS.writeObject(addClubsMatchList);
                    System.out.println("\n\t\t\t\t\t\t------ Match data stored successfully  ------");
                }
                fOOS.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        returnToMenu();
    }

//----------------------------- Function of recovering the data from the binary file -----------------------------------
    @Override
    public void recoverStats() throws IOException {
        try {
            File fTableStatFile = new File("table.bin");
            fTableStatFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //------- recover past stats
                ObjectInputStream fOIS = new ObjectInputStream(new FileInputStream(tableStatFile));
                fClubsList = (ArrayList<FootballClub>) fOIS.readObject();
                addClubsMatchList =(ArrayList<AddMatch>) fOIS.readObject();
                fOIS.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            catch (EOFException e) {
                System.out.print("");
            }
        }
    }

//------------------------------------ Function of opening the Angular GUI ---------------------------------------------
    @Override
    public void loadGUI() {
        try {
            Runtime.getRuntime().exec(new String[]{"cmd", "/c","start chrome http://localhost:4200/teams%22%7D"});
            returnToMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//------------------------------ Function of prompting the return to menu question -------------------------------------
    @Override
    public void returnToMenu() {
        System.out.print("\n\t\t\t\t\t\tDo you want to continue with main menu?");
        System.out.print("\n\t\t\t\t\t\t 1. Yes " +
                "\n\t\t\t\t\t\t 2. No");
        System.out.print("\n\t\t\t\t\t\t Enter your option: ");

        switch (getFUserInput.next()) {
            //----- will return to the main menu
            case "1":
                System.out.print("\n");
                consoleAppF.menu();
                break;
            //----- will end the program
            case "2":
                System.out.print("\n\t\t\t\t\t----- Great to see you..Have a nice day !! -----");
                break;
            //----- pop up for invalid inputs
            default:
                System.out.print("\n\t\t\t\t\t-----\tYou have entered a wrong option so please do" +
                        " RE-ENTER in this way --->  1 / 2\t----- ");
                returnToMenu();
                break;
        }
    }
}
