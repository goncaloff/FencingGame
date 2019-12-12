package org.academiadecodigo.thunderstructs.players;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.TimeUtils;
import org.academiadecodigo.thunderstructs.Global;

public class Player implements Controls {

    private Rectangle player;
    private Texture playerImg;
    private Texture attackTexture;
    private long lastAttackTime;


    public Player() {
        playerImg = new Texture("standing-right.png");
        attackTexture = new Texture("attack-right.png");
        player = new Rectangle();
        player.width = 100;
        player.height = 100;
        player.x = Global.GAME_WIDTH / 2 - player.width / 2;
        player.y = 0;
    }

    @Override
    public void move() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            player.x -= 400 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            player.x += 400 * Gdx.graphics.getDeltaTime();
        }
        if (player.x < 0) {
            player.x = 0;
        }
        if (player.x > Global.GAME_HEIGHT) {
            player.x = Global.GAME_WIDTH - player.width;
        }
    }

    @Override
    public void attack() {

        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            setPlayerImg(attackTexture);


        }

    }

    @Override
    public void jump() {
        //troca para animação de salto
    }

    public Rectangle getPlayer() {
        return player;
    }

    public Texture getPlayerImg() {
        return playerImg;
    }

    public void setPlayer(Rectangle player) {
        this.player = player;
    }

    public void setPlayerImg(Texture playerImg) {
        this.playerImg = playerImg;
    }
}
