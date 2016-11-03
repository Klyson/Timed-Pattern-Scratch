package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import Menu.GamGame1;
import Screens.ScrSongOne;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScrEndScreen implements Screen {

    GamGame1 game;
    ScrSongOne song1;
    private SpriteBatch batch;
    private BitmapFont font;

    public ScrEndScreen(GamGame1 _game) {
        game = _game;
    }

    @Override
    public void show() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        font = new BitmapFont();
        batch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        font.draw(batch, String.valueOf(song1.j), 200, 250);
        font.draw(batch, String.valueOf(song1.good), 250, 250);
        font.draw(batch, String.valueOf(song1.eff) + "%", 300, 250);
        batch.end();
        if (Gdx.input.isKeyPressed(51)) {
            Gdx.app.exit();
        }
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
    }
}
