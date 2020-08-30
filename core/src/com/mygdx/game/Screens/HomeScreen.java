package com.mygdx.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Base.Font;
import com.mygdx.game.Base.StartScreen;
import com.mygdx.game.Common.News;
import com.mygdx.game.math.Rect;

import java.sql.SQLException;

public class HomeScreen extends StartScreen {

    private Font[] newsFont;
    private String str = "Новости про жопу. В России жопа. Везде жопа. Давайте кушать какашки. Привет медвед!";
    private News[] news;
    private Texture newsTexture;
    private TextureRegion newsRegion;

    @Override
    public void setPageName(String pageName) {
        super.setPageName(pageName);
    }

    public HomeScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        createString();
        newsTexture = new Texture("textures/news.png");
        newsRegion = new TextureRegion(newsTexture);
        news = new News[5];
        news[0] = new News(newsRegion, 1);
        news[1] = new News(newsRegion, 2);
        newsFont = new Font[5];
        newsFont[0] = new Font("textNews.fnt", "textNews.png");
        newsFont[1] = new Font("textNews.fnt", "textNews.png");
        newsFont[2] = new Font("textNews.fnt", "textNews.png");
        newsFont[3] = new Font("textNews.fnt", "textNews.png");
        newsFont[4] = new Font("textNews.fnt", "textNews.png");
        setPageName("Главная страница");
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        newsFont[0].setSize(0.02f);
        newsFont[1].setSize(0.02f);
        news[0].resize(worldBounds);
        news[1].resize(worldBounds);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        drawl();
    }


    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        return super.touchDown(touch, pointer, button);
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) throws SQLException, ClassNotFoundException {
        return super.touchUp(touch, pointer, button);
    }

    public void drawl() {
        batch.begin();
        createNews();
        batch.end();
    }

    public void createNews() {
        int count = 0;
        for (News i : news)
            if (i != null) {
                i.draw(batch);
                    newsFont[count].draw(batch, str, news[count].getRight() + 0.01f, news[count].getTop());
                    count++;
                }
            }

     public void createString(){
                int cnt = 0;
                int countString = 0;
                char[] chars = str.toCharArray();
                char[] arrChar = new char[28];
                String[] charArray = new String[10];
                for (char cha : chars) {
                    if (cnt < 28) {
                        arrChar[cnt] = cha;
                        cnt++;
                    } else {
                        charArray[countString] = new String(arrChar).concat("\n");
                        countString++;
                        cnt = 0;
                        for(int y = 0; y<arrChar.length-1; y++){
                            arrChar[y] = ' ';
                        }
                        arrChar[cnt] = cha;
                        cnt = 1;
                    }
                }

                charArray[countString] = new String(arrChar);

                str  = " ";
                for (String strr : charArray) {
                    if (strr != null) {
                        str = str.concat(strr);
                    }
                }
            }
    }
