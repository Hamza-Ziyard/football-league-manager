package models.matches;

import java.util.Comparator;

public class DateComparator implements Comparator<AddMatch> {

    @Override
    public int compare(AddMatch teamOneF,AddMatch teamTwoF) {
        return teamOneF.getPlayedDateF().compareTo(teamTwoF.getPlayedDateF());
    }
}
