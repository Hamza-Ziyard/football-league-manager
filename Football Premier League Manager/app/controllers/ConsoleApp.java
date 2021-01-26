package controllers;

import models.clubs.FootballClub;
import models.matches.AddMatch;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ConsoleApp {
    private final static PremierLeagueManager premierLeagueManagerF = new PremierLeagueManager();
    private final static JavaFXUI javaFXUI = new JavaFXUI();

    private final Scanner getUserInput = new Scanner(System.in);

    public void menu(){
            menuQuestions();
            switch (getUserInput.next()) {
                case "1":
                    addClubInput();
                    break;
                case "2":
                    deleteClubInput();
                    break;
                case "3":
                    premierLeagueManagerF.displayLeagueTable();
                    break;
                case "4":
                    statOfAClubInput();
                    break;
                case "5":
                    addAMatchInput();
                    break;
                case "6":
                    premierLeagueManagerF.matchesPlayed();
                    break;
                case "7":
                    searchMatchInput();
                    break;
                case "8":
                    premierLeagueManagerF.saveDataToStatFile();
                    break;
                case "9":
                    javaFXUI.launchUI();
                    break;
                case "10":
                    premierLeagueManagerF.loadGUI();
                    break;
                case "11":
                    System.out.println("\n\t\t\t\t\t----- Great to see you..Have a nice day !! -----");
                    break;
                default:
                    System.out.println("\n\t\t\t\t\t-----\tYou have entered a wrong option so please do" +
                                        " RE-ENTER in this way --->  1 / 2 / 3 / 4 / 5 / 6 / 7 / 8\t-----");
                    menu();

            }
        }


        private void menuQuestions(){
            System.out.println("\n\t\t\t\t\t\t1. Add a new Club"+
                    "\n\t\t\t\t\t\t2. Delete an Existing Club" +
                    "\n\t\t\t\t\t\t3. Display Premier League Table" +
                    "\n\t\t\t\t\t\t4. Check Statistics of a Club"+
                    "\n\t\t\t\t\t\t5. Add a Match played" +
                    "\n\t\t\t\t\t\t6. Display Matches Played"+
                    "\n\t\t\t\t\t\t7. Search for a match"+
                    "\n\t\t\t\t\t\t8. Save all entered details into a File" +
                    "\n\t\t\t\t\t\t9. Open JavaFX GUI" +
                    "\n\t\t\t\t\t\t10. Open Angular GUI"+
                    "\n\t\t\t\t\t\t11. Quit program");
            System.out.print("\n\t\t\t\t\tEnter the relevant option to continue : ");
        }

/** Contains all input and their validations **/


//--------------------------------------- Adding a Club Into the System -----------------------------------------------
        private void addClubInput(){

            System.out.print("\n\t\t\t\t\t\t  Enter Club Name : ");
            String clubNameF = getUserInput.next();
            while (true) {
                String similarFClub = " ";
                for (FootballClub fFootballClub : PremierLeagueManager.fClubsList) {
                    if (fFootballClub.getClubNameF().equals(clubNameF)) {
                        similarFClub = "found";
                        break;
                    }
                }
                if (similarFClub.equals("found")) {
                    System.out.print("\t\t\t\t\t\t\t-----  This name is already taken  -----");
                    System.out.print("\n\t\t\t\t\t\t  RE-ENTER Club Name : ");
                    clubNameF= getUserInput.next();

                } else if(!clubNameF.matches("[a-zA-Z\\s]+")) {
                    System.out.print("\t\t\t\t\t\t\t-----  Invalid  Club Name  -----");
                    System.out.print("\n\t\t\t\t\t\t  RE-ENTER Club Name : ");
                    clubNameF= getUserInput.next();
                }
                else{
                    break;
                }
            }

            System.out.print("\t\t\t\t\t\t  Enter Club Location : ");
            String clubLocF = getUserInput.next();
            while (true) {
                if (!clubLocF.matches("[a-zA-Z\\s]+")) {
                    System.out.print("\t\t\t\t\t\t\t-----  Invalid  Club Location  -----");
                    System.out.print("\n\t\t\t\t\t\t  RE-ENTER Club Location : ");
                    clubLocF = getUserInput.next();
                } else {
                    break;
                }
            }

            System.out.print("\t\t\t\t\t\t  Enter Club Owner Name : ");
            String ownerNameF = getUserInput.next();
            while (true) {
                String similarOwnerName = " ";
                for (FootballClub footballClub : PremierLeagueManager.fClubsList) {
                    if (footballClub.getOwnerNameF().equals(ownerNameF)) {
                        similarOwnerName = "found";
                        break;
                    }
                }
                if (similarOwnerName.equals("found")) {
                    System.out.print("\t\t\t\t\t\t\t-----  He is already an owner of a club  -----");
                    System.out.print("\n\t\t\t\t\t\t  RE-ENTER Owner Name : ");
                    ownerNameF= getUserInput.next();

                } else if(!ownerNameF.matches("[a-zA-Z\\s]+")) {
                    System.out.print("\t\t\t\t\t\t\t-----  Invalid  Owner Name  -----");
                    System.out.print("\n\t\t\t\t\t\t  RE-ENTER Owner Name : ");
                    ownerNameF = getUserInput.next();
                }
                else{
                    break;
                }
            }

            System.out.print("\t\t\t\t\t\t  Enter Club Active Years : ");
            String activeYearsF = getUserInput.next();
            while (true) {
                if (!activeYearsF.matches("^[0-9]*$")) {
                    System.out.print("\t\t\t\t\t\t\t-----  Invalid  Entry  -----");
                    System.out.print("\n\t\t\t\t\t\t  RE-ENTER Active Years : ");
                    activeYearsF = getUserInput.next();
                } else {
                    break;
                }
            }
            int activeYearParseF = Integer.parseInt(activeYearsF);

            System.out.print("\t\t\t\t\t\t  Enter No. of Champion Titles : ");
            String champTitlesF = getUserInput.next();
            while (true) {
                if (!champTitlesF.matches("^[0-9]*$")) {
                    System.out.print("\t\t\t\t\t\t\t-----  Invalid  Entry -----");
                    System.out.print("\n\t\t\t\t\t\t  RE-ENTER No.Of Champion titles : ");
                    champTitlesF = getUserInput.next();
                } else {
                    break;
                }
            }

            int champTitlesParseF = Integer.parseInt(champTitlesF);

            FootballClub footballClubObj = new FootballClub(clubNameF,clubLocF,ownerNameF,activeYearParseF,champTitlesParseF);

            premierLeagueManagerF.addClubToSystem(footballClubObj);
        }

//------------------------------------- Deleting a Club from the System ---------------------------------------------
        private void deleteClubInput(){
            if (PremierLeagueManager.fClubsList.size()==0){
                System.out.print("\t\t\t\t\t----- No clubs are registered to delete-----");
                menu();
            }else {
                System.out.print("\n\t\t\t\t\t\t  Enter Club Name : ");
                String removeClubF = getUserInput.next();
                while (true) {
                    String similarClub = " ";
                    for (FootballClub fFootballClub : PremierLeagueManager.fClubsList) {
                        if (fFootballClub.getClubNameF().equals(removeClubF)) {
                            similarClub = "found";
                            break;
                        }
                    }
                    if (!removeClubF.matches("[a-zA-Z\\s]+")) {
                        System.out.print("\t\t\t\t\t\t\t-----  Invalid  Club Name  -----");
                        System.out.print("\n\t\t\t\t\t\t  RE-ENTER Club Name : ");
                        removeClubF = getUserInput.next();
                    }else if (!similarClub.equals("found")) {
                        System.out.print("\t\t\t\t\t\t\t-----  There are no such club registered  -----");
                        System.out.print("\n\t\t\t\t\t\t  RE-ENTER Club Name : ");
                        removeClubF = getUserInput.next();
                    }else {
                        break;
                    }
                }
                premierLeagueManagerF.deleteClubFromSystem(removeClubF);
            }
        }


//------------------------------------ Displaying statistics of a Selected Club -------------------------------------
        private void statOfAClubInput(){
            if (PremierLeagueManager.fClubsList.size()==0){
                System.out.println("\t\t\t\t\t----- No clubs are registered to print statistics -----");
                menu();
            }else {
                System.out.print("\n\t\t\t\t\t\t Enter the club name : ");
                String clubStatNameF = getUserInput.next();
                while (true) {
                    String similarFClub = " ";
                    for (FootballClub fFootballClub : PremierLeagueManager.fClubsList) {
                        if (fFootballClub.getClubNameF().equals(clubStatNameF)) {
                            similarFClub = "found";
                            break;
                        }
                    }if (!clubStatNameF.matches("[a-zA-Z\\s]+")) {
                        System.out.print("\t\t\t\t\t\t\t-----  Invalid  Club Name  -----");
                        System.out.print("\n\t\t\t\t\t\t  RE-ENTER Club Name : ");
                        clubStatNameF = getUserInput.next();
                    }else if (!similarFClub.equals("found")) {
                        System.out.print("\t\t\t\t\t\t\t-----  There are no such club registered  -----");
                        System.out.print("\n\t\t\t\t\t\t  RE-ENTER Club Name : ");
                        clubStatNameF = getUserInput.next();
                    } else {
                        break;
                    }
                }
                premierLeagueManagerF.displayStatOfAClub(clubStatNameF);
            }
        }

//--------------------------------------- Adding a Match Into the System -----------------------------------------------
    private void addAMatchInput() {
        if (PremierLeagueManager.fClubsList.size() == 0) {
            System.out.println("\t\t\t\t\t----- No clubs to make a match -----");
            menu();
        }else if(PremierLeagueManager.fClubsList.size() == 1){
            System.out.println("\t\t\t\t\t----- Not enough clubs to make a match -----");
            menu();
        }
        else {
            System.out.print("\t\t\t\t\t\t\t Enter Team One : ");
            String teamOneNameF = getUserInput.next();
            while (true) {
                String similarFClub = " ";
                for (FootballClub fFootballClub : PremierLeagueManager.fClubsList) {
                    if (fFootballClub.getClubNameF().equals(teamOneNameF)) {
                        similarFClub = "found";
                        break;
                    }
                }
                if (similarFClub.equals("found")) {
                    break;
                } else if (!teamOneNameF.matches("[a-zA-Z\\s]+")) {
                    System.out.print("\t\t\t\t\t\t\t-----  Invalid  Team Name  -----");
                    System.out.print("\n\t\t\t\t\t\t  RE-ENTER Team Name : ");
                    teamOneNameF = getUserInput.next();
                } else {
                    System.out.print("\t\t\t\t\t\t\t-----  Team Not found in the list  -----");
                    System.out.print("\n\t\t\t\t\t\t  RE-ENTER Team Name : ");
                    teamOneNameF = getUserInput.next();
                }
            }

            System.out.print("\t\t\t\t\t\t\t Enter Team Two : ");
            String teamTwoNameF = getUserInput.next();
            while (true) {
                String similarFClub = " ";
                for (FootballClub fFootballClub : PremierLeagueManager.fClubsList) {
                    if (fFootballClub.getClubNameF().equals(teamTwoNameF)) {
                        similarFClub = "found";
                        break;
                    }
                }
                if (teamOneNameF.equals(teamTwoNameF)) {
                    System.out.print("\t\t\t\t\t\t\t-----  Same Team Name cannot be repeated -----");
                    System.out.print("\n\t\t\t\t\t\t  RE-ENTER Team Name : ");
                    teamTwoNameF = getUserInput.next();
                } else if (similarFClub.equals("found")) {
                    break;
                } else if (!teamTwoNameF.matches("[a-zA-Z\\s]+")) {
                    System.out.print("\t\t\t\t\t\t\t-----  Invalid  Team Name  -----");
                    System.out.print("\n\t\t\t\t\t\t  RE-ENTER Team Name : ");
                    teamTwoNameF = getUserInput.next();
                } else {
                    System.out.print("\t\t\t\t\t\t\t-----  Team Not found in the list  -----");
                    System.out.print("\n\t\t\t\t\t\t  RE-ENTER Team Name : ");
                    teamTwoNameF = getUserInput.next();
                }
            }


            System.out.print("\t\t\t\t\t\t\t Enter " + teamOneNameF + " Score : ");
            String teamOneScoreF = getUserInput.next();
            while (true) {
                if (!teamOneScoreF.matches("^[0-9]*$")) {
                    System.out.print("\t\t\t\t\t\t\t-----  Invalid  Team Score  -----");
                    System.out.print("\n\t\t\t\t\t\t  RE-ENTER Team Score : ");
                    teamOneScoreF = getUserInput.next();
                } else {
                    break;
                }
            }
            int teamOneGoalF = Integer.parseInt(teamOneScoreF);


            System.out.print("\t\t\t\t\t\t\t Enter " + teamTwoNameF + " Score : ");
            String teamTwoScoreF = getUserInput.next();
            while (true) {
                if (!teamTwoScoreF.matches("^[0-9]*$")) {
                    System.out.print("\t\t\t\t\t\t\t-----  Invalid  Team Score  -----");
                    System.out.print("\n\t\t\t\t\t\t  RE-ENTER Team Score : ");
                    teamTwoScoreF = getUserInput.next();
                } else {
                    break;
                }
            }

            System.out.print("\t\t\t\t\t\t\t Enter Match Date ( yyyy-mm-dd ) : ");
            String matchDateF = getUserInput.next();
            while (true) {
                SimpleDateFormat formatDateF = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    formatDateF.parse(matchDateF);
                    break;
                } catch (ParseException e) {
                    System.out.println("\t\t\t\t\t\t\t-----  Invalid  Date -----");
                    System.out.print("\n\t\t\t\t\t\t  RE-ENTER Date in this way --> ( yyyy-mm-dd ) : ");
                    matchDateF = getUserInput.next();
                }
            }

            int teamTwoGoalF = Integer.parseInt(teamTwoScoreF);
            premierLeagueManagerF.addAMatchToSystem(matchDateF, teamOneNameF, teamTwoNameF, teamOneGoalF, teamTwoGoalF);
        }
    }

//---------------------------------------- Search for a Played Match ---------------------------------------------------
    private void searchMatchInput(){
        System.out.print("\t\t\t\t\t\t\t Enter Match Date ( yyyy-mm-dd ) : ");
        String matchDateF = getUserInput.next();
        while (true) {
            String similarDate = " ";
            for (AddMatch addMatch : PremierLeagueManager.addClubsMatchList) {
                if (addMatch.getPlayedDateF().equals(matchDateF)) {
                    similarDate = "found";
                }else {
                    System.out.println("\n\t\t\t\t\t---------------- No match played in that date -----------------");
                }
                break;
            }
            if (similarDate.equals("found")) {
                break;
            } else {
                SimpleDateFormat formatDateF = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    formatDateF.parse(matchDateF);
                    break;
                } catch (ParseException e) {
                    System.out.println("\t\t\t\t\t\t\t-----  Invalid  Date -----");
                    System.out.print("\t\t\t\t\t\t  RE-ENTER Date in this way --> ( yyyy-mm-dd ) : ");
                    matchDateF = getUserInput.next();
                }
            }
        }
        premierLeagueManagerF.searchMatch(matchDateF);
    }
}
