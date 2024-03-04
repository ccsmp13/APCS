public class BlackjackPlayer extends Player {

    private double wins;
    private double losses;

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
    public void win(){
        this.wins += 1;
    }
    public void bigWin(){
        this.wins += 1.5;
    }

    public void lose(){
        this.losses += 1;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public double getWins() {
        return wins;
    }

    public double getLosses() {
        return losses;
    }
    

}
