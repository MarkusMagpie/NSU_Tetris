import java.awt.*;
import java.util.Random;

// TetrisModel class
// controls the state of game field, figure

public class TetrisModel {
    private final int width = 10;
    private final int height = 20;
    private TetroMino current_piece;
    private boolean[][] board;
    private int score;
    private boolean paused;

    public TetrisModel() {
        board = new boolean[width][height];
        SpawnPiece();
//        score = 0;
        paused = false;
    }

    private void SpawnPiece() {
        // create a single T-tetromino (randomly)
        Point[] coords = { new Point(0, 0), new Point(1, 0), new Point(2, 0), new Point(3, 0) };
        current_piece = new TetroMino(coords, Color.RED);
    }

    public void MovePieceDown() {
        if (paused) return;

        if (CanMove(current_piece, 0, 1)) {
            for (Point p : current_piece.getCoordinates()) {
                p.y += 1;
            }
        } else {
            PlacePiece();
            SpawnPiece();
            if (!CanMove(current_piece, 0, 0)) {
                System.out.println("GAME OVER at MovePieceDown");
                System.exit(0);
            }
        }
    }

    public void MovePieceLeft() {
        if (paused) return;

        if (CanMove(current_piece, -1, 0)) {
            for (Point p : current_piece.getCoordinates()) {
                p.x -= 1;
            }
        }
    }

    public void MovePieceRight() {
        if (paused) return;

        if (CanMove(current_piece, 1, 0)) {
            for (Point p : current_piece.getCoordinates()) {
                p.x += 1;
            }
        }
    }

    public void RotatePiece() {
        if (paused) return;

        current_piece.rotate();
        // check if we can't rotate, return to original position
        if (!CanMove(current_piece, 0, 0)) {
            System.out.println("Cannot rotate object");
            current_piece.rotate();
            current_piece.rotate();
            current_piece.rotate();
        }
    }

    private void PlacePiece() {
        for (Point p : current_piece.getCoordinates()) {
            if (p.x >= 0 && p.x < width && p.y >= 0 && p.y < height) {
                board[p.x][p.y] = true;
            }
        }
        ClearRows();
    }

    private void ClearRows() {
        for (int y = height - 1; y >= 0; --y) {
            boolean full_row = true;
            for (int x = 0; x < width; ++x) {
                if (!board[x][y]) {
                    full_row = false;
                    break;
                }
            }

            if (full_row) {
                score += 100;
                for (int row = y; row > 0; --row) {
                    for (int col = 0; col < width; ++col) {
                        board[col][row] = board[col][row - 1];
                    }
                }
                for (int col = 0; col < width; ++col) {
                    board[col][0] = false;
                }
                ++y;
            }
        }
    }

    private boolean CanMove(TetroMino piece, int x, int y) {
        for (Point p : piece.getCoordinates()) {
            int new_x = p.x + x;
            int new_y = p.y + y;
            if (new_x < 0 || new_x >= width || new_y >= height || new_y < 0) {
                return false;
            }
            if (board[new_x][new_y]) {
                return false;
            }
        }
        return true;
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

    // setter and getter for pause
    public void SetPause(boolean pause) {
        paused = pause;
    }

    public boolean GetPause() {
        return paused;
    }
}
