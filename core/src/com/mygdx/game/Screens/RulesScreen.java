package com.mygdx.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Base.BaseScreen;
import com.mygdx.game.Base.Font;
import com.mygdx.game.Sprite.Background;
import com.mygdx.game.math.Rect;

import java.sql.SQLException;


public class RulesScreen extends BaseScreen {

    private final Game game;
    private Texture bg;
    private Background background;
    private Texture backText;
    private TextureRegion region;
    private Font font;
    private static final float FSIZE = 0.0145f;

    private static final String ABOUT = "";

    public RulesScreen(Game game) {
        this.game = game;
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        font.setSize(FSIZE);
    }

    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/rulesbg.png");
        backText = new Texture("textures/aboutbut.png");
        background = new Background(bg);
        region = new TextureRegion(backText);
        //font = new Font("");
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        draw();
    }

    @Override
    public boolean keyDown(int keycode) {
        return super.keyDown(keycode);
    }

    @Override
    public boolean keyUp(int keycode) {
        return super.keyUp(keycode);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) throws SQLException, ClassNotFoundException {
        return false;
    }

    private void draw() {
        batch.begin();
        background.draw(batch);
        printInfo();
        batch.end();
    }

    public void printInfo(){
       // font.draw(batch, ABOUT, worldBounds.getLeft() + 0.01f, worldBounds.getTop() - 0.08f);
    }
}
