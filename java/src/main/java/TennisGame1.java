
public class TennisGame1 implements ITennisGame {

    private int scoreOfPlayer1 = 0;
    private int scoreOfPlayer2 = 0;
    private final String player1Name;
    private final String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            scoreOfPlayer1 += 1;
        else
            scoreOfPlayer2 += 1;
    }

    public String getScore() {
        StringBuilder score = new StringBuilder();
        if (isSamePoints()) {
            score.append(getScoreIfSamePoints());
        } else if (has4OrMore()) {
            score.append(getAdvantageOrWin());
        } else {
            score.append(getScoreName(scoreOfPlayer1));
            score.append("-");
            score.append(getScoreName(scoreOfPlayer2));
        }
        return score.toString();
    }

    private static String getScoreName(int score) {
        switch (score) {
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
            default -> throw new IllegalStateException("Unexpected value: " + score);
        }
    }

    private String getAdvantageOrWin() {
        String playerAdvantage = getLeadingPlayer(scoreOfPlayer1, scoreOfPlayer2);
        if (hasAdvantage(scoreOfPlayer1, scoreOfPlayer2)){
            return "Advantage " + playerAdvantage;
        }
        else{
            return "Win for " + playerAdvantage;
        }
    }

    private String getLeadingPlayer(int scoreOfPlayer1, int scoreOfPlayer2) {
        return scoreOfPlayer1 > scoreOfPlayer2 ? player1Name : player2Name;
    }

    private boolean hasAdvantage(int scoreOfPlayer1, int scoreOfPlayer2) {
        return scoreOfPlayer1 == scoreOfPlayer2 + 1 || scoreOfPlayer2 == scoreOfPlayer1 + 1;
    }

    private boolean has4OrMore() {
        return scoreOfPlayer1 >= 4 || scoreOfPlayer2 >= 4;
    }

    private boolean isSamePoints() {
        return scoreOfPlayer1 == scoreOfPlayer2;
    }

    private String getScoreIfSamePoints() {
        String score;
        score = switch (scoreOfPlayer1) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        };
        return score;
    }
}
