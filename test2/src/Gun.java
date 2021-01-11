import ml.codeboy.engine.Game;
import ml.codeboy.engine.GameObject;
import ml.codeboy.engine.Input;
import ml.codeboy.engine.exampleGames.shooter.GameObjects.Bullet;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Gun extends GameObject {

    private float cooldown = 0f;
    private int speed = 400;


    public Gun(Game game) {
        super("tank.png", game);

    }

    @Override
    protected void tick() {
        cooldown -=  deltaTime;

        if(game1.isKey == false) {
            if (Input.getMouseX() > getX()) {
                addX(speed * deltaTime);
            } else if (Input.getMouseX() < getX()) {
                addX(-speed * deltaTime);
            }
        }
        else {
            if (Input.isKeyDown(39) || Input.isKeyDown(KeyEvent.VK_D)) {
                addX(speed * deltaTime);
            } else if (Input.isKeyDown(37) || Input.isKeyDown(KeyEvent.VK_A)) {
                addX(-speed * deltaTime);
            }
        }
        if ((Input.isKeyDown(KeyEvent.VK_UP) || isMouseDown() || Input.isKeyDown(KeyEvent.VK_W)) && cooldown < 0) {
            shoot();
            cooldown = 0.5f;
        }

    };
    protected  void shoot(){
        Bullet bul = new Bullet(game, 0, -13){
            @Override
            protected void onCollision(GameObject other) {
                System.out.println("collision");
                destroy(other);
                destroy();
            }

            @Override
            protected void tick() {
                super.tick();
                for (Meteorit m1: Meteorit.meteoriten){
                    if (collidesWith(m1)){
                        destroy();
                        m1.destroy();
                        ((game1)Game.get()).upperScore();
                        break;

                    }
                }
            }
        };
        bul.listenForCollision(true);
        bul.setPosition(getX(), getY() - getHeight()/2);
        bul.setSize(20);
    }
}
