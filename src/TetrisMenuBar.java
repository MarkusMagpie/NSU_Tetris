import javax.swing.*;

public class TetrisMenuBar extends JMenuBar {

    public TetrisMenuBar(TetrisController controller) {
        JMenu file_menu = new JMenu("File");
        JMenuItem new_game_item = new JMenuItem("New Game");
        JMenuItem exit_item = new JMenuItem("Exit");
        JMenuItem high_scores_item = new JMenuItem("High Scores");

        file_menu.add(new_game_item);
        file_menu.add(exit_item);
        file_menu.add(high_scores_item);

        add(file_menu);
    }
}
