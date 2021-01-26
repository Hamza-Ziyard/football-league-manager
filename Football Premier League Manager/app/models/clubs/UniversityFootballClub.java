package models.clubs;

import models.clubs.FootballClub;

import java.io.Serializable;

public class UniversityFootballClub extends FootballClub {
    private int clubIdU;
    private String nameU;

    public UniversityFootballClub() {}

    public UniversityFootballClub(int clubIdU, String nameU, String clubNameF, String clubLocationF, String ownerNameF, int activeYearsF, int noOfChampTitleF){
        super(clubNameF, clubLocationF,ownerNameF,activeYearsF,noOfChampTitleF);
        this.clubIdU = clubIdU;
        this.nameU = nameU;
    }

    public int getClubIdU() {
        return clubIdU;
    }

    public void setClubIdU(int clubIdU) {
        this.clubIdU = clubIdU;
    }

    public String getNameU() {
        return nameU;
    }

    public void setNameU(String nameU) {
        this.nameU = nameU;
    }
}
