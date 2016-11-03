package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import Menu.GamGame1;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScrMainMenu extends InputAdapter implements Screen {

    GamGame1 game;
    private SpriteBatch batch;
    private boolean isSong1, isExit;
    private BitmapFont font;

    public ScrMainMenu(GamGame1 _game) {
        game = _game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        Gdx.input.setInputProcessor(this);
        font = new BitmapFont();
        Gdx.gl.glClearColor(1, 1, 1, 1);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        font.draw(batch, "Press Enter to Play Selected Song", Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        font.draw(batch, "Press Escape to Exit", Gdx.graphics.getWidth() / 2, 375);
        batch.end();
        if (isSong1) {
            game.nScreen = 1;
            game.updateState();
            dispose();
        } else if (isExit) {
            Gdx.app.exit();
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }

    @Override
    public boolean keyDown(int keycode) {
       if (keycode == Input.Keys.ENTER) {
           isSong1 = true;
       } else if (keycode == Input.Keys.ESCAPE) {
           isExit = true;
       } return false;
    }
}