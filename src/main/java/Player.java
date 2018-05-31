public class Player {

    private String playerName;
    private Integer currentPosition = 0;

    public Player(String playerName) {
        this.playerName = playerName;
    }
     public void movePosition(Integer sumDadiPoint){
         this.currentPosition = currentPosition + sumDadiPoint;
     }

    public String currentPosition() {
        return currentPosition.toString();
    }
}
