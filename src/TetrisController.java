import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

// TetrisController class
// processes user input and updates game state
// here we override keyPressed method so that we can use it to process
//     user input

public class TetrisController implements KeyListener {
    private TetrisModel model;
    private TetrisView view;
    private HighScores hs;

    public TetrisController(TetrisModel model, TetrisView view, HighScores hs) {
        this.model = model;
        this.view = view;
        this.hs = new HighScores();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (model.GetPause()) {
                ResumeGame();
            } else {
                PauseGame();
            }
        }

        if (model.GetPause()) return;

        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                model.MovePieceLeft();
                break;
            case KeyEvent.VK_A:
                model.MovePieceLeft();
                break;

            case KeyEvent.VK_RIGHT:
                model.MovePieceRight();
                break;
            case KeyEvent.VK_D:
                model.MovePieceRight();
                break;

            case KeyEvent.VK_DOWN:
                model.MovePieceDown();
                break;
            case KeyEvent.VK_S:
                model.MovePieceDown();
                break;

            case KeyEvent.VK_UP:
                model.RotatePiece(); // !!!
                break;
            case KeyEvent.VK_W:
                model.RotatePiece();
                break;

            case KeyEvent.VK_Q:
                ExitVerification();
                break;
        }
        view.repaint();
    }

    // these 2 methods must be overriden due to implementation of KeyListener
    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    public void PauseGame() {
        model.SetPause(true);
    }

    public void ResumeGame() {
        model.SetPause(false);
    }

    public void StartNewGame() {
        PauseGame();
        int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to start new game?", "New Game Confirmation", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            System.out.println("New game started");
            model.Reset();
            view.repaint();
        }
        ResumeGame();
    }

    public void ShowHighScores() {
        PauseGame();
        List<Integer> scores = hs.GetScores();
        StringBuilder sb = new StringBuilder();
        for (int score : scores) {
            sb.append(score).append("\n");
        }
        JOptionPane.showMessageDialog(view, sb.toString());
        ResumeGame();
    }

    public void ShowAbout() {
        PauseGame();
        JOptionPane.showMessageDialog(null, "Tetris by Matvey Sorokin", "About", JOptionPane.INFORMATION_MESSAGE);
        ResumeGame();
    }

    public void ExitVerification() {
        PauseGame();
        int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            System.out.println("Final score: " + model.GetScore());
            System.exit(0);
        }
        ResumeGame();
    }
}
