package model;

public class Fan {
    private int id;
    private String name;
    private String team;
    private int playerOneGoals;
    private int playerTwoGoals;
    private int playerThreeGoals;

    public Fan(String name, String team, int p1, int p2, int p3) {
        this.name = name;
        this.team = team;
        this.playerOneGoals = p1;
        this.playerTwoGoals = p2;
        this.playerThreeGoals = p3;
    }

    public double getAverageGoals() {
        return (playerOneGoals + playerTwoGoals + playerThreeGoals) / 3.0;
    }

    // Getters and setters
}
