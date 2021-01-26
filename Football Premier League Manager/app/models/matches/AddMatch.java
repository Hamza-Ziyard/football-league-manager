package models.matches;

import java.io.Serializable;

public class AddMatch implements Serializable {
    private String teamOneF;
    private String teamTwoF;
    private int teamOneGoalsF;
    private int teamTwoGoalsF;
    private String playedDateF;

    public AddMatch(){}

    public AddMatch(String playedDateF, String teamOneF, String teamTwoF, int teamOneGoalsF, int teamTwoGoalsF) {
        this.playedDateF = playedDateF;
        this.teamOneF = teamOneF;
        this.teamTwoF = teamTwoF;
        this.teamOneGoalsF = teamOneGoalsF;
        this.teamTwoGoalsF = teamTwoGoalsF;
    }

    public String getTeamOneF() {
        return teamOneF;
    }

    public void setTeamOneF(String teamOneF) {
        this.teamOneF = teamOneF;
    }

    public String getTeamTwoF() {
        return teamTwoF;
    }

    public void setTeamTwoF(String teamTwoF) {
        this.teamTwoF = teamTwoF;
    }

    public int getTeamOneGoalsF() {
        return teamOneGoalsF;
    }

    public void setTeamOneGoalsF(int teamOneGoalsF) {
        this.teamOneGoalsF = teamOneGoalsF;
    }

    public int getTeamTwoGoalsF() {
        return teamTwoGoalsF;
    }

    public void setTeamTwoGoalsF(int teamTwoGoalsF) {
        this.teamTwoGoalsF = teamTwoGoalsF;
    }

    public String getPlayedDateF() {
        return playedDateF;
    }

    public void setPlayedDateF(String playedDateF) {
        this.playedDateF = playedDateF;
    }

    @Override
    public String toString() {
        return  "\n\t\t\t\t\t -------------------------------------------------" +
                "\n\n\t\t\t\t\t\t\t\t" +
                getTeamOneF()+"\t\tvs\t\t"+ getTeamTwoF()+
                "\n\n\t\t\t\t\t\t* "+
                getTeamOneF()+ " scored "+ getTeamOneGoalsF()+ " in total" +
                "\n\t\t\t\t\t\t* " +
                getTeamTwoF()+" scored " + getTeamTwoGoalsF()+" in total" +
                "\n\t\t\t\t\t\t* " +
                "Date Played " + getPlayedDateF();
    }
}
