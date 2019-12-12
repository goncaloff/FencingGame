package org.academiadecodigo.thunderstructs;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.thunderstructs.players.Player;

public class Game extends ApplicationAdapter {

    private SpriteBatch batch;

    private Player player;

    @Override
    public void create() {
        batch = new SpriteBatch();
        player = new Player();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(player.getPlayerImg(), player.getPlayer().x, player.getPlayer().y);
        batch.end();
        player.move();
        player.attack();
    }

    @Override
    public void dispose() {
        player.getPlayerImg().dispose();
        batch.dispose();
    }
}
