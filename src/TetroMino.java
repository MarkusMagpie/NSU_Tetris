import java.awt.Color;
import java.awt.Point;

// Tetromino class
// represents a tetromino figure in game
// any figure has 4 blocks

// coordinates - array of points that define the figure
// color - color of the figure
// rotate - function that rotates the figure

public class TetroMino {
    private Point[] coordinates;
    private Color color;

    // constructor
    public TetroMino(Point[] coordinates, Color color) {
        this.coordinates = coordinates;
        this.color = color;
    }

    // getter functions
    public Point[] getCoordinates() {
        return coordinates;
    }

    public Color getColor() {
        return color;
    }

    public void rotate() {
        for (int i = 0; i < coordinates.length; ++i) {
            int x = coordinates[i].x;
            int y = coordinates[i].y;
            coordinates[i].x = y;
            coordinates[i].y = -x;
        }
    }
}
