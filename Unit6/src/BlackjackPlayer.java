public class BlackjackPlayer extends Player {

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
        if (numAces > 0) {
            while (score < 21 && numAces > 0) {
                score -= 1;
                if (score + 11  <= 21){
                    score += 11;
                    numAces--;
                } else{
                    score +=1;
                    break;
                }
            }
        }
        return score;

    }

}
