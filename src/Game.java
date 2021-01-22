import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.Timer;

public final class Game {
    private static Game instance = new Game();
    public static Timeline timeLeft;

    public static Game getInstance()
    {
        return instance;
    }
    public void game()
    {

    }

    private Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
        timeLeft.setCycleCount(10);
    }));
}
