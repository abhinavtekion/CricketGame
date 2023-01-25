import java.util.Random;

class Team{
    private int numberOfWicketsLeft;
    private int totalRuns;
    private  int numberOfBallsLeft;
    private boolean isBatting;
    private Team(){                       // Private Constructor
        numberOfWicketsLeft = 10;
        totalRuns = 0;
        numberOfBallsLeft = 100;
    }

    /*---------------Static Factory method to initialize the Team---------------*/
    public  static Team createTeam(){
        return  new Team();
    }


    public int getTotalRuns(){
        return totalRuns;
    }
    public int getNumberOfBallsLeft() {
        return numberOfBallsLeft;
    }
    public int getNumberOfWicketsLeft(){
        return numberOfWicketsLeft;
    }
    public void updateRun(){
        int min = 0;
        int max = 7;
        int range = max - min+1;
        int randomRun = (int)(Math.random() * range) + min;
        if(randomRun == 7)
              updateWickets();
        else
              totalRuns+= randomRun;

    }
    public void updateWickets(){
            numberOfWicketsLeft = numberOfWicketsLeft-1;
    }

    public void setIsBatting(boolean value){
        isBatting = value;
    }

    public boolean isTeamBatting(){
        if(isBatting== true)
              return  true;
        else
            return false;
    }


    public  void updateNumberOfBalls(){
        if(numberOfBallsLeft > 0)
            numberOfBallsLeft = numberOfBallsLeft-1;
    }
}




