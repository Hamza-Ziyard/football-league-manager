package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.matches.AddMatch;
import models.matches.DateComparator;
import models.clubs.FootballClub;
import models.clubs.MainComparatorClass;
import play.libs.Json;
import play.mvc.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    private final PremierLeagueManager premierLeagueManagerF = new PremierLeagueManager();

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */


//------------------------------- Passing the clubs to the front-end -------------------------------------
    public Result getClubsF() throws IOException {
        premierLeagueManagerF.recoverStats();

        PremierLeagueManager.fClubsList.sort(new MainComparatorClass());
        JsonNode jsonNode = Json.toJson(PremierLeagueManager.fClubsList);
        return ok(jsonNode).as("application/json");
    }

//------------------------------- Passing the matches to the front-end -----------------------------------
    public Result getPlayedMatchesF() throws IOException {
        premierLeagueManagerF.recoverStats();

        PremierLeagueManager.addClubsMatchList.sort(new DateComparator());
        JsonNode jsonNode = Json.toJson(PremierLeagueManager.addClubsMatchList);
        return ok(jsonNode).as("application/json");
    }

//--------------------- Passing the add random match function to the front-end --------------------------
    public Result getRandomMatchesF() throws IOException {
        premierLeagueManagerF.recoverStats();
        while (true){
            Random randomMatchFinder = new Random();
            int randDay = random(1,29);
            int randMonth = random(1,12);

            String playedDate=2020+"-"+randMonth+"-"+randDay;

            String monthString= String.valueOf(randMonth);
            String dayLength = String.valueOf(randDay);
            if (monthString.length()==1){
                playedDate=2020+"-"+"0"+randMonth+"-"+randDay;
            }
            if (dayLength.length()==1) {
                playedDate = 2020 + "-" + randMonth + "-" + "0" + randDay;
            }
            if (monthString.length()==1 && dayLength.length()==1){
                playedDate = 2020 + "-" +"0"+ randMonth + "-" + "0" + randDay;
            }

            FootballClub teamOne = getRandomClubF(PremierLeagueManager.fClubsList);
            FootballClub teamTwo = getRandomClubF(PremierLeagueManager.fClubsList);

            String clubOne = (String.valueOf(teamOne.getClubNameF()));
            String clubTwo = (String.valueOf(teamTwo.getClubNameF()));


            int maxGoals = 10;
            int teamOneScore = randomMatchFinder.nextInt(maxGoals);
            int teamTwoScore = randomMatchFinder.nextInt(maxGoals);


            if (!(teamOne.equals(teamTwo))) {
                AddMatch matchPlayed = new AddMatch(playedDate,clubOne,clubTwo,teamOneScore,teamTwoScore);
                PremierLeagueManager.addClubsMatchList.add(matchPlayed);

                if (teamOneScore == teamTwoScore) {
                    // ------------------------ If the match was drawn
                    for (FootballClub footballClub : PremierLeagueManager.fClubsList) {
                        if (footballClub.getClubNameF().equals(clubOne)) {
                            footballClub.setDefeatsOfFClub(0);
                            footballClub.setWinsOfFClub(0);
                            footballClub.setDrawsOfFClub(1);
                            footballClub.setGoalsReceivedByFClub(teamTwoScore);
                            footballClub.setGoalsScoredByFClub(teamOneScore);
                            footballClub.setMatchesOfFClub(1);
                            footballClub.setPointsOfFClub(1);
                        } else if (footballClub.getClubNameF().equals(clubTwo)) {
                            footballClub.setDefeatsOfFClub(0);
                            footballClub.setWinsOfFClub(0);
                            footballClub.setDrawsOfFClub(1);
                            footballClub.setGoalsReceivedByFClub(teamOneScore);
                            footballClub.setGoalsScoredByFClub(teamTwoScore);
                            footballClub.setMatchesOfFClub(1);
                            footballClub.setPointsOfFClub(1);
                        }
                    }
                } else if (teamOneScore > teamTwoScore) {
                    // --------------------- If team one won the game
                    for (FootballClub footballClub : PremierLeagueManager.fClubsList) {
                        if (footballClub.getClubNameF().equals(clubOne)) {
                            footballClub.setDefeatsOfFClub(0);
                            footballClub.setWinsOfFClub(1);
                            footballClub.setDrawsOfFClub(0);
                            footballClub.setGoalsReceivedByFClub(teamTwoScore);
                            footballClub.setGoalsScoredByFClub(teamOneScore);
                            footballClub.setMatchesOfFClub(1);
                            footballClub.setPointsOfFClub(3);
                        } else if (footballClub.getClubNameF().equals(clubTwo)) {
                            footballClub.setDefeatsOfFClub(1);
                            footballClub.setWinsOfFClub(0);
                            footballClub.setDrawsOfFClub(0);
                            footballClub.setGoalsReceivedByFClub(teamOneScore);
                            footballClub.setGoalsScoredByFClub(teamTwoScore);
                            footballClub.setMatchesOfFClub(1);
                            footballClub.setPointsOfFClub(0);
                        }
                    }
                } else {
                    // --------------------- If team two won the game
                    for (FootballClub footballClub : PremierLeagueManager.fClubsList) {
                        if (footballClub.getClubNameF().equals(clubOne)) {
                            footballClub.setDefeatsOfFClub(1);
                            footballClub.setWinsOfFClub(0);
                            footballClub.setDrawsOfFClub(0);
                            footballClub.setGoalsReceivedByFClub(teamTwoScore);
                            footballClub.setGoalsScoredByFClub(teamOneScore);
                            footballClub.setMatchesOfFClub(1);
                            footballClub.setPointsOfFClub(0);
                        } else if (footballClub.getClubNameF().equals(clubTwo)) {
                            footballClub.setDefeatsOfFClub(0);
                            footballClub.setWinsOfFClub(1);
                            footballClub.setDrawsOfFClub(0);
                            footballClub.setGoalsReceivedByFClub(teamOneScore);
                            footballClub.setGoalsScoredByFClub(teamTwoScore);
                            footballClub.setMatchesOfFClub(1);
                            footballClub.setPointsOfFClub(3);
                        }
                    }
                }
                break;
            }


        }

        premierLeagueManagerF.saveDataToStatFile();
        JsonNode jsonNode = Json.toJson(PremierLeagueManager.addClubsMatchList);
        return ok(jsonNode).as("application/json");
    }

    private FootballClub getRandomClubF(ArrayList<FootballClub> fClubList) {
        Random randomSelector = new Random();
        return fClubList.get(randomSelector.nextInt(fClubList.size()));
    }

    private static int random(int lowerBound, int upperBound) {
        return (lowerBound + (int) Math.round(Math.random() * (upperBound - lowerBound)));
    }

}
