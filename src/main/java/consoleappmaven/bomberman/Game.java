package consoleappmaven.bomberman;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * @author atsikhamirau on 18.02.2019
 */
public class Game extends Application {

    private static final int KEYBOARD_MOVEMENT_DELTA = 5;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        final Circle circle = createCircle();
        final Group group = new Group(circle);

        final Scene scene = new Scene(group, 600, 400, Color.BLACK);
        moveCircleOnKeyPress(scene, circle);

        stage.setScene(scene);
        stage.show();
    }

    private Circle createCircle() {
        final Circle circle = new Circle(200, 150, 50, Color.BLUEVIOLET);
        return circle;
    }

    private void moveCircleOnKeyPress(Scene scene, final Circle circle) {
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP:
                    circle.setCenterY(circle.getCenterY() - KEYBOARD_MOVEMENT_DELTA);
                    break;
                case RIGHT:
                    circle.setCenterX(circle.getCenterX() + KEYBOARD_MOVEMENT_DELTA);
                    break;
                case DOWN:
                    circle.setCenterY(circle.getCenterY() + KEYBOARD_MOVEMENT_DELTA);
                    break;
                case LEFT:
                    circle.setCenterX(circle.getCenterX() - KEYBOARD_MOVEMENT_DELTA);
                    break;
            }
        });
    }

}