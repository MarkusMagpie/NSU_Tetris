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
        Point center = coordinates[1];
        for (int i = 0; i < coordinates.length; ++i) {
            // 2d matrix 90 degree counter-clockwise rotation matrix
            // | 0 -1| => x = -y
            // | 1  0| => y = x
            int x = coordinates[i].x - center.x; // offset from center
            int y = coordinates[i].y - center.y;
            coordinates[i].x =center.x - y;
            coordinates[i].y = center.y + x;
        }
    }
}
