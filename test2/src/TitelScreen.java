import ml.codeboy.engine.Sprites;
import ml.codeboy.engine.TitleScreen;
import ml.codeboy.engine.UI.Button;

public class TitelScreen extends TitleScreen {
    public TitelScreen() {
        super("Spaceshooter");
        setBackgroundImage(Sprites.getSprite("sternenhimmel2.jpg"));
        addButton("Start Game", () -> launchGame(game1.class));
        Button b1 =  addButton("Mouse Control");
        b1.setClickAction(() -> {
            game1.isKey = !game1.isKey;
            b1.setText(game1.isKey? "Keyboard Control" : "Mouse Control");

        });
    }
}
