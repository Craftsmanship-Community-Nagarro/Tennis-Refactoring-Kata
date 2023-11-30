
public class TennisGame2 implements ITennisGame {
    public int player1Points = 0;
    public int player2Points = 0;

    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        if (wonByPlayer(player1Points,player2Points)) {
            return "Win for player1";
        }
        if (wonByPlayer(player2Points,player1Points)) {
            return "Win for player2";
        }
        if (player1Points > player2Points && player2Points >= 3) {
            return "Advantage player1";
        }
        if (player2Points > player1Points && player1Points >= 3) {
            return "Advantage player2";
        }
        if (isScoreTheSameAndSmallerThan3()) {
            return mapPointsToScore(player1Points) + "-All";
        }
        if (isDeuce()) {
            return "Deuce";
        }
        return mapPointsToScore(player1Points) + "-" + mapPointsToScore(player2Points);
    }

    private boolean wonByPlayer(int p1, int p2) {
        return p1 >= 4 && p1 >= p2 + 2;
    }

    private static String mapPointsToScore(int points) {
        switch (points) {
            case 0 -> {
                return "Love";
            }
            case 1 -> {
                return "Fifteen";
            }
            case 2 -> {
                return "Thirty";
            }
            case 3 -> {
                return "Forty";
            }
            default -> throw new IllegalStateException("Unexpected value: " + points);
        }
    }

    private boolean isDeuce() {
        return player1Points == player2Points && player1Points >= 3;
    }

    private boolean isScoreTheSameAndSmallerThan3() {
        return player1Points == player2Points && player1Points < 3;
    }

    public void SetP1Score(int number) {

        for (int i = 0; i < number; i++) {
            P1Score();
        }

    }

    public void SetP2Score(int number) {

        for (int i = 0; i < number; i++) {
            P2Score();
        }

    }

    public void P1Score() {
        player1Points++;
    }

    public void P2Score() {
        player2Points++;
    }

    public void wonPoint(String player) {
        if (player.equals( player1Name))
            P1Score();
        else
            P2Score();
    }
}