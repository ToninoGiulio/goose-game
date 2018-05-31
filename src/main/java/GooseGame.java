import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GooseGame {

    List<String> gameplayers = new ArrayList();

    public String writeInstruction(String userInput) {

        if (userInput.startsWith("add")) {
            String newPlayer = extractPlayerName(userInput);

            if (isPlayerInGame(newPlayer)) {
                return newPlayer + ": already existing player";
            }

            addPlayer(newPlayer);
            return printNameOfPlayers();

        }
        if (userInput.startsWith("move")) {
            String[] contenuto = userInput.replace(",", "").split(" ");
            String playerName = contenuto[1];
            int dado1 = Integer.parseInt(contenuto[2]);
            int dado2 = Integer.parseInt(contenuto[3]);
            int playerPoint = dado1 + dado2;
            Player currentPlayer = new Player(playerName);
            currentPlayer.movePosition(playerPoint);
            return playerName + " rolls "+dado1+", " + dado2 + ". pippo moves from Start to " + currentPlayer.currentPosition();
       }
       return "";

}


    private String printNameOfPlayers() {
        String playersNames;
        if (playersInGame() == 1) {
            playersNames = "players: " + firstPlayer();
        } else {
            playersNames = "players: " + String.join(", ", gameplayers);
        }
        return playersNames;
    }

    private String firstPlayer() {
        return gameplayers.get(0);
    }

    private int playersInGame() {
        return gameplayers.size();
    }

    private void addPlayer(String player) {
        gameplayers.add(player);
    }

    private boolean isPlayerInGame(String player) {
        List<String> playerInGame = gameplayers.stream().filter(x -> x.equals(player)).collect(Collectors.toList());
        return playerInGame.size() != 0;
    }

    private String extractPlayerName(String userInput) {
        return userInput.substring("add player ".length());
    }

}
