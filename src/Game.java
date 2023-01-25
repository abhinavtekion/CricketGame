import java.util.Random;

class Game{
    Team team1 ;
    Team team2;

    private Game(){
        team1 = Team.createTeam();
        team2 = Team.createTeam();
    }

    public static Game createGame(){
        return  new Game();
    }
    public void toss(){
        Random r = new Random();
        boolean randomNo = r.nextBoolean();

        team1.setIsBatting(randomNo);
        team2.setIsBatting(!randomNo);

        if(team1.isTeamBatting() == true)
            System.out.println("Team 1 choose to bat first");
        else
            System.out.println("Team 2 choose to bat first");

        // assign the team 1 and team2 who are batting through random functions

    }

    public void startGame()
    {
        // keep calling random functions while all wickets go down and no of balls gets over
        // call result function to finally print which team won
        toss();
        if(team1.isTeamBatting()){                    // When team1 won the toss
            while (team1.getNumberOfBallsLeft() != 0 && team1.getNumberOfWicketsLeft()!=0)
            {
                team1.updateRun();
                team1.updateNumberOfBalls();
            }
            team1.setIsBatting(false);
            team2.setIsBatting(true);
            while (team2.getNumberOfBallsLeft() != 0 && team2.getNumberOfWicketsLeft()!=0)
            {
                team2.updateRun();
                team2.updateNumberOfBalls();
            }
        }

        else {
            while (team2.getNumberOfBallsLeft() != 0 && team2.getNumberOfWicketsLeft()!=0)
            {
                team2.updateRun();
                team2.updateNumberOfBalls();
            }
            team2.setIsBatting(false);
            team1.setIsBatting(true);
            while (team1.getNumberOfBallsLeft() != 0 && team1.getNumberOfWicketsLeft()!=0)
            {
                team1.updateRun();
                team1.updateNumberOfBalls();
            }

        }
        // Finally Game is Over
    }


    public void getStatusOfGame(){

        System.out.println("-----------Current Status of Game-------------\n");
        if(team1.isTeamBatting() == true)
        {
            System.out.println("Batting Team : Team 1");
            System.out.println("Total Runs Scored : " + team1.getTotalRuns());
            System.out.println("Total Wickets left: " + team1.getNumberOfWicketsLeft());
            System.out.println("Total Balls Left: " + team1.getNumberOfBallsLeft());
        }
        else {
            System.out.println("Batting Team : Team 2");
            System.out.println("Total Runs Scored : " + team2.getTotalRuns());
            System.out.println("Total Wickets left: " + team2.getNumberOfWicketsLeft());
            System.out.println("Total Balls Left: " + team2.getNumberOfBallsLeft());

        }


    }

    public void result(){

        if(team1.getTotalRuns() > team2.getTotalRuns())
        {
            int numberOfWicketsWonBy = team1.getNumberOfWicketsLeft() - team2.getNumberOfWicketsLeft();
            if(numberOfWicketsWonBy > 0)
                System.out.println("Team 1 won by " + numberOfWicketsWonBy + " Wickets");
            else
            {
                int numberOfBallsWinBy = Math.abs(team1.getNumberOfBallsLeft() - team2.getNumberOfWicketsLeft());
                System.out.println("Team 1 won by " + numberOfBallsWinBy + " Balls.");

            }

        }
        else if(team1.getTotalRuns() == team2.getTotalRuns())
            System.out.println("Match Draw!!");
        else {
            int numberOfWicketsWonBy = team2.getNumberOfWicketsLeft() - team1.getNumberOfWicketsLeft();
            if(numberOfWicketsWonBy > 0)
                System.out.println("Team 2 won by " + numberOfWicketsWonBy + " Wickets");
            else
            {
                int numberOfBallsWinBy = Math.abs(team2.getNumberOfBallsLeft() - team1.getNumberOfWicketsLeft());
                System.out.println("Team 2 won by " + numberOfBallsWinBy + " Balls.");

            }
        }
    }



}



