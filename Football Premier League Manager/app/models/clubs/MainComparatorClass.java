package models.clubs;

import models.clubs.FootballClub;

import java.util.Comparator;

public class MainComparatorClass implements Comparator<FootballClub> {
    @Override
    public int compare(FootballClub teamOneF,FootballClub teamTwoF) {
        //---------------- Assigns the team with the highest points on top
        if (teamOneF.getPointsOfFClub()>teamTwoF.getPointsOfFClub()){
            return -1;
        }else if (teamTwoF.getPointsOfFClub()>teamOneF.getPointsOfFClub()){
            return 1;
        }else{
            //---------------- If points are equal, the team with the highest goal difference comes on the top
            int goalDifferenceTeamOne = teamOneF.getGoalsScoredByFClub()-teamOneF.getGoalsReceivedByFClub();
            int goalDifferenceTeamTwo = teamTwoF.getGoalsScoredByFClub()-teamTwoF.getGoalsReceivedByFClub();
            if(goalDifferenceTeamOne > goalDifferenceTeamTwo)
                return -1;
            else if(goalDifferenceTeamTwo>goalDifferenceTeamOne)
                return 1;
            else {
                //---------- If points and goal differences are equal, the team played less no.of matches comes on top
                if (teamOneF.getMatchesOfFClub()<teamTwoF.getMatchesOfFClub())
                    return -1;
                else if(teamTwoF.getMatchesOfFClub()<teamOneF.getMatchesOfFClub())
                    return 1;
                else
                    //------------- If all three components are equal no change in arrangement
                    return 0;
            }
        }
    }
}
