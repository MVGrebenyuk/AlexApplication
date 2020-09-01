package com.mygdx.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Base.Font;
import com.mygdx.game.Base.StartScreen;
import com.mygdx.game.Common.CloseNewsButton;
import com.mygdx.game.Common.FullNews;
import com.mygdx.game.Common.News;
import com.mygdx.game.Utils.StrBuilder;
import com.mygdx.game.math.Rect;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

import io.netty.handler.codec.serialization.ObjectDecoderInputStream;
import io.netty.handler.codec.serialization.ObjectEncoderOutputStream;

public class NewsScreen extends StartScreen {

    private Font[] newsFont;
    private static String[] str;
    private static String[] spl;
    private News[] news;
    private News fNews = null;
    private FullNews fullNews;
    private CloseNewsButton cnb;
    private static String loadNews;
    private static int quantity;
    private static boolean showFullNewsFlag = false;
    private Texture newsTexture;
    private Texture fullNewsScreenTexture;
    private Texture closeNewsButtontexture;
    private TextureRegion newsRegion;
    private TextureRegion fullNewsScreenRegion;
    private TextureRegion closeNewsButtonRegion;
    private static Socket socket;
    private static ObjectDecoderInputStream is;
    private static ObjectEncoderOutputStream os;
    private static  boolean reload = false;


    @Override
    public void setPageName(String pageName) {
        super.setPageName(pageName);
    }

    public NewsScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        if(socket == null || reload == true) {
            try {
                socket = new Socket("192.168.0.101", 8189);
                os = new ObjectEncoderOutputStream(socket.getOutputStream());
                is = new ObjectDecoderInputStream(socket.getInputStream());
                String getNews = "/getNews";
                os.writeObject(getNews);
                loadNews = (String) is.readObject();
                System.out.println("\n\n_______Новости загружены_____\n\n");
                reload = false;
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        newsTexture = new Texture("textures/news.png");
        fullNewsScreenTexture = new Texture("textures/fullnews.png");
        closeNewsButtontexture = new Texture("textures/closebutton.png");
        newsRegion = new TextureRegion(newsTexture);
        fullNewsScreenRegion = new TextureRegion(fullNewsScreenTexture);
        closeNewsButtonRegion = new TextureRegion(closeNewsButtontexture);
        fullNews = new FullNews(fullNewsScreenRegion, fNews);
        cnb = new CloseNewsButton(closeNewsButtonRegion, fullNews, this);
        spl = loadNews.split("<>");
        quantity = Integer.parseInt(spl[0]);
        showNews();
        setPageName("Новости");
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        fullNews.resize(worldBounds);
        cnb.resize(worldBounds);
        for(int i = 0; i<=quantity-1; i++) {
            news[i].resize(worldBounds);
            newsFont[i].setSize(0.014f);
        }
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
        for(News i: news){
            i.touchDown(touch, pointer, button);
        }
        cnb.touchDown(touch, pointer, button);
        return super.touchDown(touch, pointer, button);
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) throws SQLException, ClassNotFoundException {
        for(News i: news){
            i.touchUp(touch, pointer, button);
        }
        cnb.touchUp(touch, pointer, button);
        return super.touchUp(touch, pointer, button);
    }

    public void drawl() {
        batch.begin();
        createNews();
        if(showFullNewsFlag == true) {
            fullNews.draw(batch);
            cnb.draw(batch);
            fullNews.getNews().getNewsFont().draw(batch, fullNews.getNews().getDescription(), fullNews.getLeft() + 0.01f, fullNews.getTop() - 0.3f);
        }
        batch.end();
    }

    public void createNews() {
        int count = 0;
        for (News i : news) {
            i.draw(batch);
            newsFont[count].draw(batch, i.getShortcut(), i.getRight() + 0.01f, i.getTop());
            count++;
        }
    }

     public void showNews(){
         str = new String[quantity];
         news = new News[quantity];
         newsFont = new Font[quantity];
         String[] dscrptn = new String[quantity];
         for(int i = 1; i<=quantity; i++) {
             str[i-1] = StrBuilder.createShortDescr(spl[i]);
             dscrptn[i-1] = StrBuilder.createDescr(spl[i]);
             System.out.println(str[i-1]);
             news[i-1] = new News(newsRegion, i, this);
             news[i-1].setShortcut(str[i-1]);
             news[i-1].setDescription(dscrptn[i-1]);
             newsFont[i-1] = new Font("textNews.fnt", "textNews.png");
             news[i-1].setNewsFont(newsFont[i-1]);

         }
     }

     public void showFullNews(News news){
        showFullNewsFlag = true;
        fullNews.setNews(news);
     }

    public void closeFullNews() {
        showFullNewsFlag = false;
    }
}
