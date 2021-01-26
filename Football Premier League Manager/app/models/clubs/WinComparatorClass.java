package models.clubs;

import models.clubs.FootballClub;

import java.util.Comparator;

public class WinComparatorClass implements Comparator<FootballClub> {
    @Override
    public int compare(FootballClub teamOneF, FootballClub teamTwoF) {
        if (teamOneF.getWinsOfFClub()>teamTwoF.getWinsOfFClub()){
            return -1;
        }else if (teamTwoF.getWinsOfFClub()>teamOneF.getWinsOfFClub()){
            return 1;
        }
        else {
            return 0;
        }
    }
}

