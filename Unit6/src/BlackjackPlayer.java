public class BlackjackPlayer extends Player {

    private int wins;
    private int losses;

    public BlackjackPlayer(String name) {
        super(name);
    }

    @Override
    public int getScore() {
        int numAces = 0;
        int score = 0;
        for (int i = 0; i < this.getHand().size(); i++) {
            if (this.getHand().get(i).getRank() >= 10) {
                score += 10;
            } else {
                score += this.getHand().get(i).getRank();
            }
            if (this.getHand().get(i).getRank() == 1) {
                numAces++;
            }
        }
        if (score >= 21) {
            return score;
        }
        if (numAces > 0 && score + 10 <= 21) {
            score += 10;

        }
        return score;

    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }
    

}
