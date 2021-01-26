package controllers;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.clubs.GoalComparatorClass;
import models.matches.AddMatch;
import models.clubs.FootballClub;
import models.clubs.MainComparatorClass;
import models.clubs.WinComparatorClass;

import java.util.ArrayList;
import java.util.Random;

/**   Has the JavaFX UI of the system   **/


public class JavaFXUI extends Application {

    private final PremierLeagueManager premierLeagueManagerF = new PremierLeagueManager();

    public void launchUI() {
        Application.launch();
        premierLeagueManagerF.returnToMenu();
    }

    @Override
    public void start(Stage guiStage) throws Exception {
        guiStage = new Stage();
        TabPane leagueTabPane=new TabPane();
        Tab statsDetails=new Tab("Statistics");
        statsDetails.setClosable(false);
        statsDetails.setId("statsDetailsTab");
        Tab searchMatch=new Tab("Match ");
        searchMatch.setClosable(false);
        searchMatch.setId("searchMatchTab");


        Pane statsMainPane = new Pane();
        ScrollPane statsScrollPane = new ScrollPane();

        Label title=new Label("Football Premier League 20/21");
        title.setLayoutY(70);
        title.setLayoutX(100);
        title.setId("title1");

        Button sortBtnG = new Button("Sort by Goals");
        sortBtnG.setLayoutY(200);
        sortBtnG.setLayoutX(1100);
        sortBtnG.setId("sortBtn");
        Button sortBtnW = new Button("Sort by Wins");
        sortBtnW.setLayoutY(200);
        sortBtnW.setLayoutX(1300);
        sortBtnW.setId("sortBtn");
        Image bgImage = new Image("file:../../ui/src/assets/fx images/bgImg.jpg");
        ImageView leagueImg = new ImageView(bgImage);
        leagueImg.setFitHeight(755);
        leagueImg.setFitWidth(1600);
        leagueImg.setId("leagueImg1");
        Pane playedMatchPane = new Pane();
        ScrollPane playedMatchScrollPane = new ScrollPane();



        TextField searchBar = new TextField();
        searchBar.setPromptText(" Enter Date (YY-MM-DD) ");
        searchBar.setLayoutX(1100);
        searchBar.setLayoutY(100);
        searchBar.setId("searchBar");
        Button searchButton = new Button("Search");
        searchButton.setLayoutX(1350);
        searchButton.setLayoutY(100);
        searchButton.setId("searchButton");
        Label searchRes =new Label();
        searchRes.setLayoutX(1100);
        searchRes.setLayoutY(40);
        searchRes.setId("pastMatchLbl");
        Button addMatchBtn = new Button("Match");
        addMatchBtn.setLayoutY(300);
        addMatchBtn.setLayoutX(1200);
        addMatchBtn.setId("addMatchBtn");
        Label randomMatchDet =new Label();
        randomMatchDet.setLayoutX(1020);
        randomMatchDet.setLayoutY(350);
        randomMatchDet.setId("pastMatchLbl");
        Image bgImage2 = new Image("file:../../ui/src/assets/fx images/bgImg2.jpg");
        ImageView leagueImg2 = new ImageView(bgImage2);
        leagueImg2.setFitHeight(755);
        leagueImg2.setFitWidth(1600);
        leagueImg2.setId("leagueImg2");
        Label title2=new Label("All Matches Played");
        title2.setLayoutY(70);
        title2.setLayoutX(100);
        title2.setId("title2");

        // ------------------ Premier League Table --------------------
        TableView<FootballClub> detailsTable = new TableView<FootballClub>();
        detailsTable.setLayoutX(80);
        detailsTable.setLayoutY(250);


        TableColumn<FootballClub, String> clubName = new TableColumn<FootballClub, String>("Football Club");
        clubName.setCellValueFactory(new PropertyValueFactory<FootballClub, String>("clubNameF"));
        clubName.setMinWidth(180);

        TableColumn<FootballClub, Integer> matchScoredGoals = new TableColumn<FootballClub, Integer>("Goals Scored");
        matchScoredGoals.setCellValueFactory(new PropertyValueFactory<FootballClub, Integer>("goalsScoredByFClub"));
        matchScoredGoals.setMinWidth(180);

        TableColumn<FootballClub, Integer> matchReceivedGoals = new TableColumn<FootballClub, Integer>("Goals Received");
        matchReceivedGoals.setCellValueFactory(new PropertyValueFactory<FootballClub, Integer>("goalsReceivedByFClub"));
        matchReceivedGoals.setMinWidth(180);

        TableColumn<FootballClub, Integer> matchWinNumbers = new TableColumn<>("Matches Won");
        matchWinNumbers.setCellValueFactory(new PropertyValueFactory<FootballClub, Integer>("winsOfFClub"));
        matchWinNumbers.setMinWidth(180);

        TableColumn<FootballClub, Integer> matchLostNumbers = new TableColumn<FootballClub, Integer>("Matches Lost");
        matchLostNumbers.setCellValueFactory(new PropertyValueFactory<FootballClub, Integer>("defeatsOfFClub"));
        matchLostNumbers.setMinWidth(180);

        TableColumn<FootballClub, Integer> matchDrawNumbers = new TableColumn<FootballClub, Integer>("Matches Draw");
        matchDrawNumbers.setCellValueFactory(new PropertyValueFactory<FootballClub, Integer>("drawsOfFClub"));
        matchDrawNumbers.setMinWidth(180);

        TableColumn<FootballClub, Integer> matchTotalNumbers = new TableColumn<>("Matches Played");
        matchTotalNumbers.setCellValueFactory(new PropertyValueFactory<FootballClub, Integer>("matchesOfFClub"));
        matchTotalNumbers.setMinWidth(180);

        TableColumn<FootballClub, Integer> pointScored = new TableColumn<>("Points");
        pointScored.setCellValueFactory(new PropertyValueFactory<FootballClub, Integer>("pointsOfFClub"));
        pointScored.setMinWidth(180);


        detailsTable.getColumns().addAll(clubName,matchScoredGoals,matchReceivedGoals,matchWinNumbers,matchLostNumbers,matchDrawNumbers,matchTotalNumbers,pointScored);

        PremierLeagueManager.fClubsList.sort(new MainComparatorClass());
        for (FootballClub teamDet : PremierLeagueManager.fClubsList) {
            detailsTable.getItems().addAll(teamDet);
        }

        // ------------------- wins sort button
        sortBtnW.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                PremierLeagueManager.fClubsList.sort(new WinComparatorClass());
                for (FootballClub teamDet : PremierLeagueManager.fClubsList) {
                    detailsTable.getItems().removeAll(teamDet);
                    detailsTable.getItems().addAll(teamDet);
                }
            }
        });

        // ----------- goals sort
        sortBtnG.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                detailsTable.getItems().removeAll();
                PremierLeagueManager.fClubsList.sort(new GoalComparatorClass());
                for (FootballClub teamDet : PremierLeagueManager.fClubsList) {
                    detailsTable.getItems().removeAll(teamDet);
                    detailsTable.getItems().addAll(teamDet);
                }
            }
        });


        //------------------------- Matches Played table -------------------------------------
        TableView<AddMatch> fMatchDetailsTable = new TableView<AddMatch>();
        fMatchDetailsTable.setLayoutX(80);
        fMatchDetailsTable.setLayoutY(250);


        TableColumn<AddMatch, String> teamOne = new TableColumn<AddMatch, String>("Team One");
        teamOne.setCellValueFactory(new PropertyValueFactory<AddMatch, String>("teamOneF"));
        teamOne.setMinWidth(180);

        TableColumn<AddMatch, Integer> teamOneGoals = new TableColumn<AddMatch, Integer>("Team Goals");
        teamOneGoals.setCellValueFactory(new PropertyValueFactory<AddMatch, Integer>("teamOneGoalsF"));
        teamOneGoals.setMinWidth(180);

        TableColumn<AddMatch, Integer> teamTwo = new TableColumn<AddMatch, Integer>("Team Two");
        teamTwo.setCellValueFactory(new PropertyValueFactory<AddMatch, Integer>("teamTwoF"));
        teamTwo.setMinWidth(180);

        TableColumn<AddMatch, Integer> teamTwoGoals = new TableColumn<AddMatch, Integer>("Team Goals");
        teamTwoGoals.setCellValueFactory(new PropertyValueFactory<AddMatch, Integer>("teamTwoGoalsF"));
        teamTwoGoals.setMinWidth(180);

        TableColumn<AddMatch, Integer> playedDate = new TableColumn<AddMatch, Integer>("Played Date");
        playedDate.setCellValueFactory(new PropertyValueFactory<AddMatch, Integer>("playedDateF"));
        playedDate.setMinWidth(180);


        fMatchDetailsTable.getColumns().addAll(teamOne,teamOneGoals,teamTwo,teamTwoGoals,playedDate);

        for (AddMatch teamDet : PremierLeagueManager.addClubsMatchList) {
            fMatchDetailsTable.getItems().addAll(teamDet);
        }



        statsMainPane.getChildren().addAll(leagueImg,detailsTable,title,sortBtnG,sortBtnW);
        statsScrollPane.setContent(statsMainPane);


// ------------------------- search button function ----------------------------------------------
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String searchData = searchBar.getText();
                if (searchData.equals("")){
                    fMatchDetailsTable.getItems().clear();
                    searchRes.setText("\n\t\t --- There is no value entered ---\n");
                    for (AddMatch teamDet : PremierLeagueManager.addClubsMatchList) {
                        fMatchDetailsTable.getItems().addAll(teamDet);
                    }

                }else{
                    fMatchDetailsTable.getItems().clear();
                    for (int i = 0; i < PremierLeagueManager.addClubsMatchList.size(); i++) {
                        String searchMatch = PremierLeagueManager.addClubsMatchList.get(i).getPlayedDateF();
                        if (searchMatch.equals(searchData)) {
                            AddMatch idSearch = PremierLeagueManager.addClubsMatchList.get(i);
                            fMatchDetailsTable.getItems().addAll(idSearch);
                            searchRes.setText("\n\t\t --- Match Loaded ---\n");

                        }else {
                            searchRes.setText("\n\t\t --- No Such Date ---\n");
                        }
                    }

                }
            }
        });


//---------------------- adding random match ----------------------------------------
        addMatchBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (PremierLeagueManager.fClubsList.size() == 0 || PremierLeagueManager.fClubsList.size() == 1) {
                    randomMatchDet.setText("\n\tNo sufficient teams");
                } else {

                    while (true) {
                        Random randomMatchFinder = new Random();

                        int randDay = random(1, 29);
                        int randMonth = random(1, 12);

                        String playedDate = 2020 + "-" + randMonth + "-" + randDay;

                        String monthString = String.valueOf(randMonth);
                        String dayLength = String.valueOf(randDay);
                        if (monthString.length() == 1) {
                            playedDate = 2020 + "-" + "0" + randMonth + "-" + randDay;
                        }
                        if (dayLength.length() == 1) {
                            playedDate = 2020 + "-" + randMonth + "-" + "0" + randDay;
                        }
                        if (monthString.length() == 1 && dayLength.length() == 1) {
                            playedDate = 2020 + "-" + "0" + randMonth + "-" + "0" + randDay;
                        }


                        FootballClub teamOne = getRandomClub(PremierLeagueManager.fClubsList);
                        FootballClub teamTwo = getRandomClub(PremierLeagueManager.fClubsList);

                        String clubOne = teamOne.getClubNameF();
                        String clubTwo = teamTwo.getClubNameF();


                        int maxGoals = 10;
                        int teamOneScore = randomMatchFinder.nextInt(maxGoals);
                        int teamTwoScore = randomMatchFinder.nextInt(maxGoals);
                        String scoreOne = String.valueOf(teamOneScore);
                        String scoreTwo = String.valueOf(teamTwoScore);


                        if (!(teamOne.equals(teamTwo))) {
                            randomMatchDet.setText("\n\t\t --> Math Date : \t\t " + playedDate + "\n\n\t\t --> Teams Played : \t\n\t\t\t\t\t\t\t " + clubOne +
                                    "\tVS\t" + clubTwo +
                                    "\n\n\t\t --> Final Score : \t\t " + scoreOne + "\t:\t" + scoreTwo);

                            AddMatch matchPlayed = new AddMatch();
                            PremierLeagueManager.addClubsMatchList.add(matchPlayed);

                            if (teamOneScore == teamTwoScore) {
                                // ------------------------ If the match was drawn
                                for (FootballClub footballClub : PremierLeagueManager.fClubsList) {
                                    matchPlayed.setPlayedDateF(playedDate);
                                    matchPlayed.setTeamOneF(clubOne);
                                    matchPlayed.setTeamTwoF(clubTwo);
                                    matchPlayed.setTeamOneGoalsF(teamOneScore);
                                    matchPlayed.setTeamTwoGoalsF(teamTwoScore);
                                    if (footballClub.getClubNameF().equals(clubOne)) {
                                        footballClub.setDefeatsOfFClub(0);
                                        footballClub.setWinsOfFClub(0);
                                        footballClub.setDrawsOfFClub(1);
                                        footballClub.setGoalsReceivedByFClub(teamTwoScore);
                                        footballClub.setGoalsScoredByFClub(teamOneScore);
                                        footballClub.setMatchesOfFClub(1);
                                        footballClub.setPointsOfFClub(1);
                                    } else if (footballClub.getClubNameF().equals(clubTwo)) {
                                        footballClub.setDefeatsOfFClub(0);
                                        footballClub.setWinsOfFClub(0);
                                        footballClub.setDrawsOfFClub(1);
                                        footballClub.setGoalsReceivedByFClub(teamOneScore);
                                        footballClub.setGoalsScoredByFClub(teamTwoScore);
                                        footballClub.setMatchesOfFClub(1);
                                        footballClub.setPointsOfFClub(1);
                                    }
                                }
                            } else if (teamOneScore > teamTwoScore) {
                                // --------------------- If team one won the game
                                matchPlayed.setPlayedDateF(playedDate);
                                matchPlayed.setTeamOneF(clubOne);
                                matchPlayed.setTeamTwoF(clubTwo);
                                matchPlayed.setTeamOneGoalsF(teamOneScore);
                                matchPlayed.setTeamTwoGoalsF(teamTwoScore);
                                for (FootballClub footballClub : PremierLeagueManager.fClubsList) {
                                    if (footballClub.getClubNameF().equals(clubOne)) {
                                        footballClub.setDefeatsOfFClub(0);
                                        footballClub.setWinsOfFClub(1);
                                        footballClub.setDrawsOfFClub(0);
                                        footballClub.setGoalsReceivedByFClub(teamTwoScore);
                                        footballClub.setGoalsScoredByFClub(teamOneScore);
                                        footballClub.setMatchesOfFClub(1);
                                        footballClub.setPointsOfFClub(3);
                                    } else if (footballClub.getClubNameF().equals(clubTwo)) {
                                        footballClub.setDefeatsOfFClub(1);
                                        footballClub.setWinsOfFClub(0);
                                        footballClub.setDrawsOfFClub(0);
                                        footballClub.setGoalsReceivedByFClub(teamOneScore);
                                        footballClub.setGoalsScoredByFClub(teamTwoScore);
                                        footballClub.setMatchesOfFClub(1);
                                        footballClub.setPointsOfFClub(0);
                                    }
                                }
                            } else {
                                // --------------------- If team two won the game
                                matchPlayed.setPlayedDateF(playedDate);
                                matchPlayed.setTeamOneF(clubOne);
                                matchPlayed.setTeamTwoF(clubTwo);
                                matchPlayed.setTeamOneGoalsF(teamOneScore);
                                matchPlayed.setTeamTwoGoalsF(teamTwoScore);
                                for (FootballClub footballClub : PremierLeagueManager.fClubsList) {
                                    if (footballClub.getClubNameF().equals(clubOne)) {
                                        footballClub.setDefeatsOfFClub(1);
                                        footballClub.setWinsOfFClub(0);
                                        footballClub.setDrawsOfFClub(0);
                                        footballClub.setGoalsReceivedByFClub(teamTwoScore);
                                        footballClub.setGoalsScoredByFClub(teamOneScore);
                                        footballClub.setMatchesOfFClub(1);
                                        footballClub.setPointsOfFClub(0);
                                    } else if (footballClub.getClubNameF().equals(clubTwo)) {
                                        footballClub.setDefeatsOfFClub(0);
                                        footballClub.setWinsOfFClub(1);
                                        footballClub.setDrawsOfFClub(0);
                                        footballClub.setGoalsReceivedByFClub(teamOneScore);
                                        footballClub.setGoalsScoredByFClub(teamTwoScore);
                                        footballClub.setMatchesOfFClub(1);
                                        footballClub.setPointsOfFClub(3);
                                    }
                                }
                            }

                            fMatchDetailsTable.getItems().clear();
                            for (AddMatch teamDet : PremierLeagueManager.addClubsMatchList) {
                                fMatchDetailsTable.getItems().addAll(teamDet);
                            }

                            detailsTable.refresh();

                            break;
                        }

                    }

                }
            }

            private FootballClub getRandomClub(ArrayList<FootballClub> clubList) {
                Random randomSelector = new Random();
                return clubList.get(randomSelector.nextInt(clubList.size()));
            }


        });





        playedMatchPane.getChildren().addAll(leagueImg2,title2,searchBar,searchButton,searchRes,addMatchBtn,randomMatchDet,fMatchDetailsTable);
        playedMatchScrollPane.setContent(playedMatchPane);

        statsDetails.setContent(statsScrollPane);
        searchMatch.setContent(playedMatchScrollPane);
        leagueTabPane.getTabs().addAll(statsDetails,searchMatch);

        guiStage.setTitle("Lanka Football Premier League");
        Scene mainScene = new Scene(leagueTabPane,1600,800);
        mainScene.getStylesheets().add(JavaFXUI.class.getResource("JavaFXCSS.css").toExternalForm());
        guiStage.setScene(mainScene);
        guiStage.show();
    }

    public static int random(int lowerBound, int upperBound) {
        return (lowerBound + (int) Math.round(Math.random()
                * (upperBound - lowerBound)));
    }

}
