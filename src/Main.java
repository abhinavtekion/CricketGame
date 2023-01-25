public class Main {
    public static void main(String[] args) {
        Game game = Game.createGame();
        game.startGame();
        game.result();
        game.getStatusOfGame();
    }
}