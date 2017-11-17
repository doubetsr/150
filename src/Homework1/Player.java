package Homework1;

public class Player {

    public char name;
    int gamesWonCount;

    public Player(){
        name = 'p';
        gamesWonCount = 0;
    }


    public Player (char inName){
        setName(inName);
        gamesWonCount = 0;
    }

    public char getName(){return name;}

    public int getGamesWonCount(){return gamesWonCount;}

    public char setName(char inName){return name = inName;}

    public int setGamesWonCount(){return gamesWonCount += 1 ;}

    public String toString() {

        String playerInfo = name+"'s has won "+ gamesWonCount +
                "games";
        return playerInfo;
    }
}
