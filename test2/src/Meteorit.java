import ml.codeboy.engine.Game;
import ml.codeboy.engine.GameObject;
import ml.codeboy.engine.events.DestroyEvent;
import ml.codeboy.engine.exampleGames.shooter.GameObjects.Bullet;

import java.util.ArrayList;
import java.util.Random;

public class Meteorit extends GameObject{
    static ArrayList <Meteorit> meteoriten = new ArrayList<>();
    Random rand = new Random();
    int speed = rand.nextInt(50)+60;


    public Meteorit(Game game) {
        super("meteorit.png", game);
        setSize(speed);
        setCollision(true);
        meteoriten.add(this);


    }
    @Override
    protected void tick() {
        super.tick();
        addY(deltaTime * speed);
//        if (isMouseDown() && isTouching(getMousePosition())){
//            destroy();
//        }
        if (getPosition().y > game.getFrame().getHeight()-5){
            destroy();
            if (game instanceof game1)
            ((game1) game).reduceHealth();
        }
    }

    @Override
    protected void onDestruction(DestroyEvent event) {
        super.onDestruction(event);
        meteoriten.remove(this);
    }
}

