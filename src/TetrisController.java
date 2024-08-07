import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// TetrisController class
// processes user input and updates game state
// here we override keyPressed method so that we can use it to process
//     user input

public class TetrisController implements KeyListener {
    private TetrisModel model;
    private TetrisView view;

    public TetrisController(TetrisModel model, TetrisView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                model.MovePieceLeft();
                break;
            case KeyEvent.VK_RIGHT:
                model.MovePieceRight();
                break;
            case KeyEvent.VK_DOWN:
                model.MovePieceDown();
                break;
            case KeyEvent.VK_UP:
                model.RotatePiece(); // !!!
                break;
        }
        view.repaint();
    }

    // these 2 methods must be overriden due to implementation of KeyListener
    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}
