import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.Random;

/**
 * This class controls the UI
 */
public class ScreenSaverController {

    @FXML
    private Canvas drawingCanvas;
    final int COLOR_INDICES = 7;
    final int MAX_LINES = 100;
    final int WIDTH = 600;
    final int HEIGHT = 600;
    static int num_lines = 0;
    static double progress = 0.0;

    /**
     * This sets up the UI Controller
     */
    public void initialize()
    {
        // set height, width
        drawingCanvas.setHeight(HEIGHT);
        drawingCanvas.setWidth(WIDTH);
        GraphicsContext gc = drawingCanvas.getGraphicsContext2D();
        gc.setLineWidth(10);

        // this timer handles the drawing of each line
        AnimationTimer timer = new AnimationTimer() {
            private int xStart = 0;
            private int yStart = 0;
            private int xEnd = 0;
            private int yEnd = 0;

            // this gets called every frame
            @Override
            public void handle(long l) {

                // when we have not made progress
                if (progress == 0.0)
                {
                    Color[] colors = {Color.YELLOW, Color.BLUE, Color.RED, Color.GREEN, Color.CYAN, Color.MAGENTA, Color.ORANGE, Color.PINK};
                    Random random_generator = new Random();

                    // get random color
                    int random_color_index = random_generator.nextInt(COLOR_INDICES);
                    gc.setStroke(colors[random_color_index]);

                    // get random x pos, y pos
                    xStart = random_generator.nextInt(WIDTH);
                    xEnd = random_generator.nextInt(WIDTH);
                    yStart = random_generator.nextInt(HEIGHT);
                    yEnd = random_generator.nextInt(HEIGHT);
                }

                // draw line
                if (progress < 1)
                {
                    // increment a new line to make it appear as though the line is getting painted
                    double currentX = xStart + progress * (xEnd - xStart);
                    double currentY = yStart + progress * (yEnd - yStart);
                    gc.strokeLine(xStart, yStart, currentX, currentY);
                    progress += 0.05;
                }
                else
                {
                    // line is complete
                    progress = 0.0;
                    num_lines++;
                }

                // if we have 100 lines, clear the screen
                if (num_lines >= MAX_LINES)
                {
                    gc.clearRect(0, 0, WIDTH, HEIGHT);
                    num_lines = 0;
                }
            }
        };

        // start the timer
        timer.start();
    }

}
