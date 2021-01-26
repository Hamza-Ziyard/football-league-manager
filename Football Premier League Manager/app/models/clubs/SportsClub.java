package models.clubs;

import java.io.Serializable;

public abstract class SportsClub implements Serializable {
    private String clubNameF;
    private String clubLocationF;
    private String ownerNameF;
    private int activeYearsF;
    private int noOfChampTitleF;

    public SportsClub(){}

    public SportsClub(String clubNameF, String clubLocationF, String ownerNameF, int activeYearsF, int noOfChampTitleF) {
        this.clubNameF = clubNameF;
        this.clubLocationF = clubLocationF;
        this.ownerNameF = ownerNameF;
        this.activeYearsF = activeYearsF;
        this.noOfChampTitleF = noOfChampTitleF;
    }


    public String getClubNameF() {
        return clubNameF;
    }

    public void setClubNameF(String clubNameF) {
        this.clubNameF = clubNameF;
    }

    public String getClubLocationF() {
        return clubLocationF;
    }


    public void setClubLocationF(String clubLocationF) {
        this.clubLocationF = clubLocationF;
    }
    public String getOwnerNameF() {
        return ownerNameF;
    }

    public void setOwnerNameF(String ownerNameF) {
        this.ownerNameF = ownerNameF;
    }

    public int getActiveYearsF() {
        return activeYearsF;
    }

    public void setActiveYearsF(int activeYearsF) {
        this.activeYearsF = activeYearsF;
    }

    public int getNoOfChampTitleF() {
        return noOfChampTitleF;
    }

    public void setNoOfChampTitleF(int noOfChampTitleF) {
        this.noOfChampTitleF = noOfChampTitleF;
    }

}
