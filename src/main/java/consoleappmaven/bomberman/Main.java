package consoleappmaven.bomberman;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * @author atsikhamirau on 18.02.2019
 */
public class Main extends Application {

    private static final int KEYBOARD_MOVEMENT_DATA = 5;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Circle circle = new Circle(400, 250, 50, Color.BLUEVIOLET);
        Group group = new Group(circle);
        Pane pane = new Pane(group);

        Scene scene = new Scene(pane, 800, 500, Color.BLACK);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void moveCircleOnPressKey(Scene scene, Circle circle) {
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP:
                    circle.setCenterY(circle.getCenterY() - KEYBOARD_MOVEMENT_DATA);
            }
        });
    }

}
