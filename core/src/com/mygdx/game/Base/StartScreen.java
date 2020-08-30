package com.mygdx.game.Base;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.mygdx.game.Base.BaseScreen;
import com.mygdx.game.Buttons.ExitButton;
import com.mygdx.game.Buttons.MessageButton;
import com.mygdx.game.Buttons.RulesButton;
import com.mygdx.game.Sprite.Background;
import com.mygdx.game.Sprite.Bubbles;
import com.mygdx.game.math.Rect;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;


public class StartScreen extends BaseScreen {

    private Game game;
    private Background background;
    private Font text;

// текстуры
    private Texture bg;
    private Texture exitText;
    private Texture lsText;
    private Texture rulesText;
    private TextureRegion regionExit;
    private TextureRegion regionRules;
    private TextureRegion lsRegion;
    private Socket socket;
    private String pageName = "HomePage";


    public void setPageName(String pageName) {
        this.pageName = pageName;
    }
//кнопки

    private RulesButton rules;
    private ExitButton exit;
    private MessageButton ls;

    public StartScreen(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        super.show();
        /*if(socket == null){
            try {
                socket = new Socket("192.168.0.101", 8189);
                System.out.println("Подключение установлено");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } */
        text = new Font("text.fnt", "text.png");
        bg = new Texture("textures/SI_Background.png");
        exitText = new Texture("textures/exitButton.png");
        rulesText = new Texture("textures/homeButton.png");
        lsText = new Texture("textures/lsImage.png");
        background = new Background(bg);
        lsRegion = new TextureRegion(lsText);
        regionRules = new TextureRegion(rulesText);
        regionExit = new TextureRegion(exitText);
        exit = new ExitButton(regionExit);
        rules = new RulesButton(regionRules, game);
        ls = new MessageButton(lsRegion, game);


    }

    @Override
    public void resize(Rect worldBounds) {
        background.resize(worldBounds);
        exit.resize(worldBounds);
        rules.resize(worldBounds);
        ls.resize(worldBounds);
        text.setSize(0.02f);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();
    }

    @Override
    public void dispose() {
        bg.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        exit.touchDown(touch, pointer, button);
        rules.touchDown(touch, pointer, button);
        ls.touchDown(touch, pointer, button);
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) throws SQLException, ClassNotFoundException {
        exit.touchUp(touch, pointer, button);
        rules.touchUp(touch, pointer, button);
        ls.touchUp(touch, pointer, button);
        return false;
    }

    private void update(float delta) {

    }


    public void draw() {
        batch.begin();
        background.draw(batch);
        exit.draw(batch);
        rules.draw(batch);
        ls.draw(batch);
        text.draw(batch, pageName, 0 - ((pageName.length()*0.015f)/2), worldBounds.getTop() - 0.01f);
        batch.end();
    }
}
