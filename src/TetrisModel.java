import java.awt.*;

// TetrisModel class
// controls the state of game field, figure

public class TetrisModel {
    private final int width = 10;
    private final int height = 20;
    private TetroMino current_piece;
    private boolean[][] board;
    private int score;

    public TetrisModel() {
        board = new boolean[width][height];
        SpawnPiece();
    }

    private void SpawnPiece() {
        // create a single T-tetromino
        Point[] coords = { new Point(0, 0), new Point(1, 0), new Point(2, 0), new Point(3, 0) };
        current_piece = new TetroMino(coords, Color.RED);
    }

    public void MovePieceDown() {
        for (Point p : current_piece.getCoordinates()) {
            p.y += 1;
        }
    }

    public void MovePieceLeft() {
        for (Point p : current_piece.getCoordinates()) {
            p.x -= 1;
        }
    }

    public void MovePieceRight() {
        for (Point p : current_piece.getCoordinates()) {
            p.x += 1;
        }
    }

    public void RotatePiece() {
        current_piece.rotate();
    }

    // 3 getters
    public int GetScore() {
        return score;
    }

    public TetroMino GetCurrentPiece() {
        return current_piece;
    }

    public boolean[][] GetBoard() {
        return board;
    }

    public boolean IsGameOver() {
        return false;
    }
}
