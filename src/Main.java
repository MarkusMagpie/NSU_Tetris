import javax.swing.JFrame;
import java.awt.*;

// Main class
// starts game, creates MVC classes; also has main game cycle

public class Main {
    public static void main(String[] args) {
        TetrisModel model = new TetrisModel(); // M
        TetrisView view = new TetrisView(model); // V
        HighScores hs = new HighScores();
        TetrisController controller = new TetrisController(model, view, hs); // C
        ScorePanel score_panel = new ScorePanel(model);

        JFrame frame = new JFrame("Tetris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 800);
        frame.setLayout(new BorderLayout());
        frame.add(view, BorderLayout.CENTER);
        frame.add(score_panel, BorderLayout.SOUTH);
        frame.addKeyListener(controller);

        TetrisMenuBar menuBar = new TetrisMenuBar(controller);
        frame.setJMenuBar(menuBar);

        frame.setVisible(true);

        while (!model.IsGameOver()) {
            try {
                Thread.sleep(500);
                model.MovePieceDown();
                view.repaint();
                score_panel.UpdateScore();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Game over!");
    }
}