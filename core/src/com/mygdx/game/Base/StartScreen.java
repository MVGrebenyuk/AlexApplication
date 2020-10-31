package com.mygdx.game.Base;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Ads.AdsButton;
import com.mygdx.game.Vote.VoteButton;
import com.mygdx.game.News.NewsButton;
import com.mygdx.game.Sprite.Background;
import com.mygdx.game.Sprite.Bottom_background;
import com.mygdx.game.Sprite.Top_background;
import com.mygdx.game.math.Rect;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;


public class StartScreen extends BaseScreen {

    private Game game;
    private Background background;
    private Top_background topBack;
    private Bottom_background bottomBack;
    private Font text;

// текстуры
    private Texture bg;
    private Texture lsText;
    private Texture rulesText;
    private Texture rupor_button;
    private Texture topbg;
    private Texture botbg;
    private TextureRegion regionRules;
    private TextureRegion lsRegion;
    private TextureRegion adsRegion;
    private Socket socket;
    private String pageName = "HomePage";


    public void setPageName(String pageName) {
        this.pageName = pageName;
    }
//кнопки

    private NewsButton rules;
    private VoteButton ls;
    private AdsButton ads;

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
        bg = new Texture("textures/loginimage.jpg");
        topbg = new Texture("textures/top_background.png");
        botbg = new Texture("textures/bottom_background.png");
        rulesText = new Texture("textures/homeButton.png");
        lsText = new Texture("textures/lsImage.png");
        rupor_button = new Texture("textures/rupor_button.png");
        background = new Background(bg);
        topBack = new Top_background(topbg);
        bottomBack = new Bottom_background(botbg);
        lsRegion = new TextureRegion(lsText);
        adsRegion = new TextureRegion(rupor_button);
        regionRules = new TextureRegion(rulesText);
        rules = new NewsButton(regionRules, game);
        ls = new VoteButton(lsRegion, game);
        ads = new AdsButton(adsRegion, game);


    }

    @Override
    public void resize(Rect worldBounds) {
        background.resize(worldBounds);
        topBack.resize(worldBounds);
        bottomBack.resize(worldBounds);
        background.resize(worldBounds);
        rules.resize(worldBounds);
        ls.resize(worldBounds);
        ads.resize(worldBounds);
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
        rules.touchDown(touch, pointer, button);
        ls.touchDown(touch, pointer, button);
        ads.touchDown(touch, pointer, button);
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) throws SQLException, ClassNotFoundException, IOException {
        rules.touchUp(touch, pointer, button);
        ls.touchUp(touch, pointer, button);
        ads.touchUp(touch, pointer, button);
        return false;
    }

    private void update(float delta) {

    }


    public void draw() {
        batch.begin();
        background.draw(batch);
        batch.end();
    }

    public void drawBottomMenu(){
        batch.begin();
        bottomBack.draw(batch);
        rules.draw(batch);
        ls.draw(batch);
        ads.draw(batch);
        batch.end();
    }

    public void drawTopMenu(){
        batch.begin();
        topBack.draw(batch);
        text.draw(batch, pageName, topBack.getLeft() + 0.01f, topBack.getTop() - 0.01f);
        batch.end();
    }
}
