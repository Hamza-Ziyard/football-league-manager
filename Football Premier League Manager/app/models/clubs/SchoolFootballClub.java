package models.clubs;

import models.clubs.FootballClub;

import java.io.Serializable;

public class SchoolFootballClub extends FootballClub {
    private int clubIdS;
    private String nameS;

    public SchoolFootballClub() {}

    public SchoolFootballClub(int clubIdS, String nameS, String clubNameF, String clubLocationF, String ownerNameF, int activeYearsF, int noOfChampTitleF) {
        super(clubNameF, clubLocationF,ownerNameF,activeYearsF,noOfChampTitleF);
        this.clubIdS = clubIdS;
        this.nameS = nameS;
    }

    public int getClubIdS() {
        return clubIdS;
    }

    public void setClubIdS(int clubIdS) {
        this.clubIdS = clubIdS;
    }

    public String getNameS() {
        return nameS;
    }

    public void setNameS(String nameS) {
        this.nameS = nameS;
    }

}
