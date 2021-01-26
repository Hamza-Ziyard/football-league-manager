package models;

import models.clubs.SchoolFootballClub;
import models.clubs.UniversityFootballClub;
import org.junit.Test;

import static org.junit.Assert.*;

public class UniversityFootballClubTest {

    @Test
    public void getClubIdU() {
        int checkUniSId=126;
        UniversityFootballClub uUniversityFootballClub = new UniversityFootballClub(126,"haghil","roughy","pissini","ravikle",100,5);
        assertEquals(checkUniSId, uUniversityFootballClub.getClubIdU());
    }

    @Test
    public void setClubIdU() {
        UniversityFootballClub uUniClub = new UniversityFootballClub();
        int checkUniSId= 126;
        uUniClub.setClubIdU(126);
        assertEquals(checkUniSId, uUniClub.getClubIdU());
    }

    @Test
    public void getNameU() {
        String checkUniUName="haghil";
        UniversityFootballClub uUniversityFootballClub = new UniversityFootballClub(126,"haghil","roughy","pissini","ravikle",100,5);
        assertEquals(checkUniUName, uUniversityFootballClub.getNameU());
    }

    @Test
    public void setNameU() {
        UniversityFootballClub uUniClub = new UniversityFootballClub();
        String checkUniSId= "haghil";
        uUniClub.setNameU("haghil");
        assertEquals(checkUniSId, uUniClub.getNameU());
    }
}