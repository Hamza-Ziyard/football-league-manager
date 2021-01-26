package models.clubs;

public class FootballClub extends SportsClub{
    private int winsOfFClub = 0;
    private int drawsOfFClub = 0;
    private int defeatsOfFClub = 0;
    private int goalsScoredByFClub = 0;
    private int goalsReceivedByFClub = 0;
    private int matchesOfFClub = 0;
    private int pointsOfFClub = 0;

    public FootballClub(){}

    public  FootballClub(String clubNameF, String clubLocationF, String ownerNameF, int activeYearsF, int noOfChampTitleF){
        super(clubNameF, clubLocationF,ownerNameF,activeYearsF,noOfChampTitleF);
    }

    public FootballClub(String clubNameF, String clubLocationF, String ownerNameF, int activeYearsF, int noOfChampTitleF, int winsOfFClub, int drawsOfFClub, int defeatsOfFClub, int goalsScoredByFClub, int noOfGoalsReceived, int matchesOfFClub, int pointsOfFClub) {
        super(clubNameF, clubLocationF,ownerNameF,activeYearsF,noOfChampTitleF);
        this.winsOfFClub = winsOfFClub;
        this.drawsOfFClub = drawsOfFClub;
        this.defeatsOfFClub = defeatsOfFClub;
        this.goalsScoredByFClub = goalsScoredByFClub;
        this.goalsReceivedByFClub = noOfGoalsReceived;
        this.matchesOfFClub = matchesOfFClub;
        this.pointsOfFClub = pointsOfFClub;
    }

    public int getWinsOfFClub() {
        return winsOfFClub;
    }

    public void setWinsOfFClub(int winsOfFClub) {
        this.winsOfFClub += winsOfFClub;
    }

    public int getDrawsOfFClub() {
        return drawsOfFClub;
    }

    public void setDrawsOfFClub(int drawsOfFClub) {
        this.drawsOfFClub += drawsOfFClub;
    }

    public int getDefeatsOfFClub() {
        return defeatsOfFClub;
    }

    public void setDefeatsOfFClub(int defeatsOfFClub) {
        this.defeatsOfFClub += defeatsOfFClub;
    }

    public int getGoalsScoredByFClub() {
        return goalsScoredByFClub;
    }

    public void setGoalsScoredByFClub(int goalsScoredByFClub) {
        this.goalsScoredByFClub += goalsScoredByFClub;
    }

    public int getGoalsReceivedByFClub() {return goalsReceivedByFClub;}

    public void setGoalsReceivedByFClub(int goalsReceivedByFClub) {this.goalsReceivedByFClub += goalsReceivedByFClub; }

    public int getMatchesOfFClub() {return matchesOfFClub;}

    public void setMatchesOfFClub(int matchesOfFClub) {
        this.matchesOfFClub += matchesOfFClub;
    }

    public int getPointsOfFClub() {
        return pointsOfFClub;
    }

    public void setPointsOfFClub(int pointsOfFClub) {
        this.pointsOfFClub += pointsOfFClub;
    }


    @Override
    public String toString() {
        return "\n\t\t\t\t\t\t\t * Details of the Club" +
                "\n\t\t\t\t\t\t\t\tClub Name - "+ getClubNameF()+
                "\n\t\t\t\t\t\t\t\tClub Location - "+ getClubLocationF()+
                "\n\t\t\t\t\t\t\t\tClub Owner Name - "+ getOwnerNameF()+
                "\n\t\t\t\t\t\t\t\tClub Active Years - "+ getActiveYearsF()+
                "\n\t\t\t\t\t\t\t\tClub Champion Title Count - "+ getNoOfChampTitleF()
                ;
    }

}

