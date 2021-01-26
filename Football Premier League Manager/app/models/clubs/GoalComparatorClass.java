package models.clubs;

import models.clubs.FootballClub;

import java.util.Comparator;

public class GoalComparatorClass implements Comparator<FootballClub> {
    @Override
    public int compare(FootballClub teamOneF, FootballClub teamTwoF) {
        if (teamOneF.getGoalsScoredByFClub()>teamTwoF.getGoalsScoredByFClub()){
            return -1;
        }else if (teamTwoF.getGoalsScoredByFClub()>teamOneF.getGoalsScoredByFClub()){
            return 1;
        }
        else {
            return 0;
        }
    }
}
