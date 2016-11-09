package Screens;

import Menu.GamGame1;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Circle;

public class ScrSongTwo extends InputAdapter implements Screen {

    GamGame1 game;
    private SpriteBatch batch;
    private Texture img1, img2, img3, img4;
    private Sprite sprite1, sprite2, sprite3, sprite4;
    private boolean S, p = true, isExit, k, t, pause = false;
    private BitmapFont font;
    private Circle circ;
    ShapeRenderer shapeRenderer;
    float XMid, YMid, good = 0, eff = 0, _good, _eff;
    int j = 0, count = 0, max = 150, _j = 0, _count, _max;
    private String[] ars = new String[]{"BR", "BL", "BR", "TL", "TR", "TL", "BL", "BR", "TR", "TL", "BR", "TR", "TL", "BR", "BL", "BR"};

    public ScrSongTwo(GamGame1 _game) {
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
        shapeRenderer = new ShapeRenderer();
        circ = new Circle(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 150);
        sprite1.setSize(w / 2, h / 2);
        sprite2.setSize(w / 2, h / 2);
        sprite3.setSize(w / 2, h / 2);
        sprite4.setSize(w / 2, h / 2);
        sprite3.setPosition(0, h / 2);
        sprite4.setPosition(w / 2, h / 2);
        sprite1.setPosition(0, 0);
        sprite2.setPosition(w / 2, 0);
        Gdx.input.setInputProcessor(this);
        System.out.println(ars.length);
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (j < ars.length && !pause) {
            p = true;
            if (_j != 0) {
                j = _j;
                count = _count;
                good = _good;
                eff = _eff;
                max = _max;
            }
            if (!t) {
                count++;
            } else if (t) {
                count = 0;
            }
            if (count == max) {
                count = 0;
                j++;
            }
            shapeRenderer.begin(ShapeType.Filled);
            batch.begin();
            sprite1.draw(batch);
            sprite2.draw(batch);
            sprite3.draw(batch);
            sprite4.draw(batch);
            if (ars[j].equals("TL")) {
                shapeRenderer.setColor(Color.GREEN);
            }
            if (ars[j].equals("TR")) {
                shapeRenderer.setColor(Color.BLACK);
            }
            if (ars[j].equals("BL")) {
                shapeRenderer.setColor(Color.RED);
            }
            if (ars[j].equals("BR")) {
                shapeRenderer.setColor(Color.BLUE);
            }
            if (j < 5) {
                max = 150;
            } else if (j >= 5 && j < 9) {
                max = 100;
            } else if (j >= 9 && j < 13) {
                max = 71;
            } else {
                max = 43;
            }
            font.draw(batch, String.valueOf(j), 200, YMid * 2);
            font.draw(batch, String.valueOf(good), 250, YMid * 2);
            font.draw(batch, String.valueOf(eff) + "%", 300, YMid * 2);
            font.draw(batch, String.valueOf(count) + " / " + String.valueOf(max), 425, YMid * 2);
            batch.end();
            shapeRenderer.circle(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 150);
            shapeRenderer.end();
        } else if (j >= ars.length) {
            Gdx.gl.glClearColor(0, 0, 0, 1);
            p = false;
//            game.nScreen = 1;
//            game.updateState();
//            dispose();
            batch.begin();
            font.draw(batch, "You clicked correctly " + String.valueOf(good) + " times out of " + String.valueOf(j), 250, YMid + 100);
            font.draw(batch, "Your efficiency was " + String.valueOf(eff) + "%", 250, YMid);
            font.draw(batch, "Press Escape to Exit", 250, YMid - 200);
            batch.end();
            if (isExit) {
                Gdx.app.exit();
            }
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
        k = false;
        if (p) {
            count = 0;
            if (button == Buttons.LEFT && sprite1.getBoundingRectangle().contains(screenX, screenY)
                    && ars[j].equals("TL")) {
                S = true;
            }
            if (button == Buttons.LEFT && sprite2.getBoundingRectangle().contains(screenX, screenY)
                    && ars[j].equals("TR") && !circ.contains(screenX, screenY)) {
                S = true;
            }
            if (button == Buttons.LEFT && sprite3.getBoundingRectangle().contains(screenX, screenY)
                    && ars[j].equals("BL") && !circ.contains(screenX, screenY)) {
                S = true;
            }
            if (button == Buttons.LEFT && sprite4.getBoundingRectangle().contains(screenX, screenY)
                    && ars[j].equals("BR") && !circ.contains(screenX, screenY)) {
                S = true;
            }
            if (!circ.contains(screenX, screenY)) {
                k = true;
            }
            if (S && k) {
                j++;
                good++;
                eff = (good / j) * 100;
            } else if (!S && k) {
                j++;
                eff = (good / j) * 100;
            }
        }
        return true;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.ESCAPE) {
            isExit = true;
        } else if (keycode == Input.Keys.SPACE) {
            pause = true;
        } else if (keycode == Input.Keys.SPACE && pause) {
            pause = false;
        }
        return false;
    }
}