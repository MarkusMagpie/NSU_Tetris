import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Point;

// TetrisView class
// graphical display of game
// here we override paintComponent method so that we can use it to draw
//     game components + field.


public class TetrisView extends JPanel {
    private TetrisModel model;

    public TetrisView(TetrisModel model) {
        this.model = model;
        setPreferredSize(new Dimension(400, 800));
        setBackground(new Color(83, 83, 83));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        DrawBoard(g, model.GetBoard());
        DrawCurrentPiece(g, model.GetCurrentPiece());
    }

    // draw board from TetrisModel class
    // M -> V
    private void DrawBoard(Graphics g, boolean[][] board) {
        for (int x = 0; x < board.length; ++x) {
            for (int y = 0; y < board[x].length; ++y) {
                if (board[x][y]) {
                    g.setColor(Color.GRAY);
                    g.fillRect(x * 40, y * 40, 40, 40);
                }
            }
        }
    }

    private void DrawCurrentPiece(Graphics g, TetroMino piece) {
        g.setColor(piece.getColor());
        for (Point p : piece.getCoordinates()) {
            g.fillRect(p.x * 40, p.y * 40, 40, 40);
        }
    }
}
