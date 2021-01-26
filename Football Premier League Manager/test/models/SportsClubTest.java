package models;

import models.clubs.FootballClub;
import models.clubs.SportsClub;
import org.junit.Test;

import static org.junit.Assert.*;

public class SportsClubTest {

    @Test
    public void getClubNameF() {
        String checkSName="everton";
        SportsClub sSportsClub = new FootballClub("everton","ruganda","kunji",87,17,8,3,2,25,12,13,27);
        assertEquals(checkSName, sSportsClub.getClubNameF());
    }

    @Test
    public void setClubNameF() {
        SportsClub sSportsClub = new FootballClub();
        String checkSName= "everton";
        sSportsClub.setClubNameF("everton");
        assertEquals(checkSName, sSportsClub.getClubNameF());
    }

    @Test
    public void getClubLocationF() {
        String checkSLoc="ruganda";
        SportsClub sSportsClub = new FootballClub("everton","ruganda","kunji",87,17,8,3,2,25,12,13,27);
        assertEquals(checkSLoc, sSportsClub.getClubLocationF());
    }

    @Test
    public void setClubLocationF() {
        SportsClub sSportsClub = new FootballClub();
        String checkSLoc= "ruganda";
        sSportsClub.setClubLocationF("ruganda");
        assertEquals(checkSLoc, sSportsClub.getClubLocationF());
    }

    @Test
    public void getOwnerNameF() {
        String checkSOwner="kunji";
        SportsClub sSportsClub = new FootballClub("everton","ruganda","kunji",87,17,8,3,2,25,12,13,27);
        assertEquals(checkSOwner, sSportsClub.getOwnerNameF());
    }

    @Test
    public void setOwnerNameF() {
        SportsClub sSportsClub = new FootballClub();
        String checkSOwner= "kunji";
        sSportsClub.setOwnerNameF("kunji");
        assertEquals(checkSOwner, sSportsClub.getOwnerNameF());
    }

    @Test
    public void getActiveYearsF() {
        int checkSActiveYear=87;
        SportsClub sSportsClub = new FootballClub("everton","ruganda","kunji",87,17,8,3,2,25,12,13,27);
        assertEquals(checkSActiveYear, sSportsClub.getActiveYearsF());
    }

    @Test
    public void setActiveYearsF() {
        SportsClub sSportsClub = new FootballClub();
        int checkSActiveYear= 87;
        sSportsClub.setActiveYearsF(87);
        assertEquals(checkSActiveYear, sSportsClub.getActiveYearsF());
    }

    @Test
    public void getNoOfChampTitleF() {
        int checkSChamp=17;
        SportsClub sSportsClub = new FootballClub("everton","ruganda","kunji",87,17,8,3,2,25,12,13,27);
        assertEquals(checkSChamp, sSportsClub.getNoOfChampTitleF());
    }

    @Test
    public void setNoOfChampTitleF() {
        SportsClub sSportsClub = new FootballClub();
        int checkSChamp= 17;
        sSportsClub.setNoOfChampTitleF(17);
        assertEquals(checkSChamp, sSportsClub.getNoOfChampTitleF());
    }
}