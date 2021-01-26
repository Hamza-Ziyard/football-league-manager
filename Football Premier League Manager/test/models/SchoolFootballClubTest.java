package models;

import models.clubs.SchoolFootballClub;
import org.junit.Test;

import static org.junit.Assert.*;

public class SchoolFootballClubTest {

    @Test
    public void getClubIdS() {
        int checkschoolSId=123;
        SchoolFootballClub sSchoolFootballClub = new SchoolFootballClub(123,"raghil","roughy","pissini","ravikle",100,5);
        assertEquals(checkschoolSId, sSchoolFootballClub.getClubIdS());
    }

    @Test
    public void setClubIdS() {
        SchoolFootballClub sSchoolsClub = new SchoolFootballClub();
        int checkschoolSId= 123;
        sSchoolsClub.setClubIdS(123);
        assertEquals(checkschoolSId, sSchoolsClub.getClubIdS());
    }

    @Test
    public void getNameS() {
        String checkschoolSName="raghil";
        SchoolFootballClub sSchoolFootballClub = new SchoolFootballClub(123,"raghil","roughy","pissini","ravikle",100,5);
        assertEquals(checkschoolSName, sSchoolFootballClub.getNameS());
    }

    @Test
    public void setNameS() {
        SchoolFootballClub sSchoolsClub = new SchoolFootballClub();
        String checkschoolSName= "raghil";
        sSchoolsClub.setClubNameF("raghil");
        assertEquals(checkschoolSName, sSchoolsClub.getClubNameF());
    }
}