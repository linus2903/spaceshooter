import ml.codeboy.engine.Game;
import ml.codeboy.engine.GameObject;
import ml.codeboy.engine.Sprite;
import ml.codeboy.engine.Sprites;
import ml.codeboy.engine.UI.Button;
import ml.codeboy.engine.UI.UITheme;

import java.awt.*;
import java.util.Random;

public class game1 extends Game {

    public game1() {
        super("spiel", true);

        Button b2 = new Button("switch controller");
        b2.setClickAction(() -> {
            game1.isKey = !game1.isKey;
            b2.setText(game1.isKey? "Keyboard" : "Mouse");

        });
        //Color textColor, boolean rounded, int borderSize, boolean hasBorder
        b2.setPosition(70, 110);
        b2.setWidthAndHeight(120, 30);
        b2.setTheme(new UITheme(Color.BLUE, Color.WHITE, Color.red, true, 5, true));
        setBackgroundImage(Sprites.getSprite("sternenhimmel2.jpg"));
        getScheduler().scheduleTask(this::spawner, 3, 1.2);
        GameObject gun = new Gun(this);
        gun.setSize(100);
        gun.setPosition(getFrame().getWidth()/2, getFrame().getHeight() - 50);

    }
    Random random1 = new Random();
    protected void spawner() {
        int xPos = random1.nextInt(getFrame().getWidth() - 100);
        Meteorit object1 = new Meteorit(this){

        };
        object1.setPosition(xPos + 50, 0);
    }

    int score = 0;
    int health = 10;
    static boolean isKey;
    public void upperScore(){
        score++;
    };
    public void reduceHealth(){

        health--;
        if (health <= 0){
            launchGame(GameOverScreen.class);
        }

    };
    @Override
    protected void displayStats(String[] toDisplay) {
        super.displayStats(new String[]{"Fps: " + getCurrentFPS(),"score: " + score, "health: " + health});
    }


}
