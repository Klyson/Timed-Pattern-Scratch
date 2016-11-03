package Screens;

import Menu.GamGame1;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScrSongOne extends InputAdapter implements Screen {

    GamGame1 game;
    private SpriteBatch batch;
    private Texture img1, img2, img3, img4;
    private Sprite sprite1, sprite2, sprite3, sprite4;
    private boolean S, g = false, p = true;;
    private BitmapFont font;
    float XMid, YMid, good = 0, eff = 0;
    int j = 0;
    private String[] ars = new String[]{"TR", "TL", "BR", "BL", "TL", "TR", "BL", "BR",};

    public ScrSongOne(GamGame1 _game) {
        this.game = _game;
    }

    @Override
    public void show() {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        XMid = Gdx.graphics.getWidth() / 2;
        YMid = Gdx.graphics.getHeight() / 2;
        font = new BitmapFont();
        batch = new SpriteBatch();
        sprite1 = new Sprite(new Texture("Red.png"));//BL
        sprite2 = new Sprite(new Texture("Blue.png"));//BR
        sprite3 = new Sprite(new Texture("green.jpg"));//TL
        sprite4 = new Sprite(new Texture("black.jpg"));//TR
        sprite1.setSize(w / 2, h / 2);
        sprite2.setSize(w / 2, h / 2);
        sprite3.setSize(w / 2, h / 2);
        sprite4.setSize(w / 2, h / 2);
        sprite3.setPosition(0, h / 2);
        sprite4.setPosition(w / 2, h / 2);
        sprite1.setPosition(0, 0);
        sprite2.setPosition(w / 2, 0);
        Gdx.input.setInputProcessor(this);
        for (int i = 0; i < 8; i++) {
            System.out.println(ars[i]);
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (j + 1 < ars.length) {
            batch.begin();
            sprite1.draw(batch);
            sprite2.draw(batch);
            sprite3.draw(batch);
            sprite4.draw(batch);
            if (ars[j].equals("TL")) {
                Gdx.gl.glClearColor(1, 0, 0, 1);
                font.draw(batch, "TL", 250, 250);
            }
            if (ars[j].equals("TR")) {
                Gdx.gl.glClearColor(0, 0, 1, 1);
                font.draw(batch, "TR", 250, 250);
            }
            if (ars[j].equals("BL")) {
                Gdx.gl.glClearColor(0, 1, 0, 1);
                font.draw(batch, "BL", 250, 250);
            }
            if (ars[j].equals("BR")) {
                Gdx.gl.glClearColor(0, 0, 0, 1);
                font.draw(batch, "BR", 250, 250);
            }
            font.draw(batch, String.valueOf(j), 200, YMid * 2);
            font.draw(batch, String.valueOf(good), 250, YMid * 2);
            font.draw(batch, String.valueOf(eff) + "%", 300, YMid * 2);
            batch.end();
        } else {
            Gdx.gl.glClearColor(0, 0, 0, 1);
            p = false;
            batch.begin();          
            font.draw(batch, "You clicked correctly " + String.valueOf(good) + " times", 250, YMid + 100);
            font.draw(batch, "Your efficiency was " + String.valueOf(eff) + "%", 250, YMid);
            batch.end();
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
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        S = false;
        if (button == Buttons.LEFT && sprite1.getBoundingRectangle().contains(screenX, screenY)
                && ars[j].equals("TL")) {
            S = true;
        }
        if (button == Buttons.LEFT && sprite2.getBoundingRectangle().contains(screenX, screenY)
                && ars[j].equals("TR")) {
            S = true;
        }

        if (button == Buttons.LEFT && sprite3.getBoundingRectangle().contains(screenX, screenY)
                && ars[j].equals("BL")) {
            S = true;
        }
        if (button == Buttons.LEFT && sprite4.getBoundingRectangle().contains(screenX, screenY)
                && ars[j].equals("BR")) {
            S = true;
        }
        if (S && p) {
            j++;
            good++;
        } else if (p){
            j++;
        }
        eff = (good / j) * 100;
        System.out.println(j);
        System.out.println(good);
        System.out.println(eff);
        System.out.println("screenX: " + screenX + " screenY " + screenY);
        return true;
    }
}