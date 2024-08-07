import javax.swing.JFrame;

// Main class
// starts game, creates MVC classes; also has main game cycle

public class Main {
    public static void main(String[] args) {
        TetrisModel model = new TetrisModel();
        TetrisView view = new TetrisView(model);
        TetrisController controller = new TetrisController(model, view);
        HighScores hs = new HighScores();

        JFrame frame = new JFrame("Tetris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 800);
        frame.add(view);
        frame.addKeyListener(controller);

        TetrisMenuBar menuBar = new TetrisMenuBar(controller);
        frame.setJMenuBar(menuBar);

        frame.setVisible(true);

        while (!model.IsGameOver()) {
            try {
                Thread.sleep(1000);
                model.MovePieceDown();
                view.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Game over!");
    }
}