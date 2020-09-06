package com.mygdx.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Base.Font;
import com.mygdx.game.Base.StartScreen;
import com.mygdx.game.Common.CloseNewsButton;
import com.mygdx.game.Common.FullNews;
import com.mygdx.game.Common.News;
import com.mygdx.game.Common.NewsBorder;
import com.mygdx.game.Utils.StrBuilder;
import com.mygdx.game.math.Rect;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;

import io.netty.handler.codec.serialization.ObjectDecoderInputStream;
import io.netty.handler.codec.serialization.ObjectEncoderOutputStream;

public class NewsScreen extends StartScreen {

    private Font[] newsFont;
    private News[] news;
    private News fNews = null;
    private FullNews fullNews;
    private CloseNewsButton closeNewsButton;
    private NewsBorder[] newsBorder;
    private Texture newsBorderTexture;
    private static int quantity;
    private static boolean showFullNewsFlag = false;
    private Texture[] newsTexture;
    private Texture fullNewsScreenTexture;
    private Texture closeNewsButtontexture;
    private TextureRegion newsBorderTextureRegion;
    private TextureRegion[] newsRegion;
    private TextureRegion fullNewsScreenRegion;
    private TextureRegion closeNewsButtonRegion;
    private static Socket socket;
    private static ObjectDecoderInputStream is;
    private static ObjectEncoderOutputStream os;
    private static  boolean reload = false;
    private static FileHandle handle = Gdx.files.local("/news.txt");;

    private ArrayList<ServerNews> list = new ArrayList<>();

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
               // String getNewsIcons = "/getNewsIcons";
                String getNews = "/getNews";
                os.writeObject(getNews);
                byte[] bytes = new byte[is.available()];
                bytes = (byte[]) is.readObject();
                System.out.println("Файл прочитан, размер: "+ bytes.length);
                String local = Gdx.files.getLocalStoragePath();
                System.out.println("Local path: " + local);
                handle.writeBytes(bytes, false);
                System.out.println("\n\n_______Новости загружены_____\n\n");
                reload = false;
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        newsBorderTexture = new Texture("textures/newsBorder.png");
        fullNewsScreenTexture = new Texture("textures/fullnews.png");
        closeNewsButtontexture = new Texture("textures/closebutton.png");
        newsBorderTextureRegion = new TextureRegion(newsBorderTexture);
        fullNewsScreenRegion = new TextureRegion(fullNewsScreenTexture);
        closeNewsButtonRegion = new TextureRegion(closeNewsButtontexture);
        fullNews = new FullNews(fullNewsScreenRegion, fNews);
        closeNewsButton = new CloseNewsButton(closeNewsButtonRegion, fullNews, this);
        createServerNews();
        showNews();
        setPageName("Новости");
    }

    private void createServerNews() {
        String loadShortcut = handle.readString();
        String[] loadShort = loadShortcut.split("<>");
        quantity = loadShort.length;
        System.out.println("ДЛИНА ЛОАДШОРТКА: " + loadShortcut.length());
        for(String i: loadShort) {
            list.add(new ServerNews("Title", StrBuilder.createShortDescr(i), StrBuilder.createDescr(i)));
        }

    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        fullNews.resize(worldBounds);
        closeNewsButton.resize(worldBounds);
        for(int i = 0; i<=quantity-1; i++) {
            newsBorder[i].resize(worldBounds);
            news[i].resize(worldBounds);
            newsFont[i].setSize(0.014f);
        }
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        drawl();
        for(NewsBorder i : newsBorder){
            i.update(delta);
        }
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
        for(NewsBorder i : newsBorder){
            i.touchDragged(touch, pointer, button);
        }
        closeNewsButton.touchDown(touch, pointer, button);
        return super.touchDown(touch, pointer, button);
    }

    @Override
    public boolean touchDragged(Vector2 touch, int pointer, int button) {
        for(NewsBorder i : newsBorder){
            i.touchDragged(touch, pointer, button);
        }
        return super.touchDragged(touch, pointer, button);
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) throws SQLException, ClassNotFoundException {
        for(News i: news){
            i.touchUp(touch, pointer, button);
        }
        closeNewsButton.touchUp(touch, pointer, button);
        return super.touchUp(touch, pointer, button);
    }

    public void drawl() {
        batch.begin();
        createNews();
        if(showFullNewsFlag == true) {
            fullNews.draw(batch);
            closeNewsButton.draw(batch);
            fullNews.getNews().getNewsFont().draw(batch, fullNews.getNews().getDescription(), fullNews.getLeft() + 0.04f, fullNews.getTop() - 0.3f);
        }
        batch.end();
    }

    public void createNews() {
        int count = 0;
        for(NewsBorder i: newsBorder){
            i.draw(batch);
        }
        for (News i : news) {
            i.draw(batch);
            newsFont[count].draw(batch, i.getShortcut(), i.getRight() + 0.01f, i.getTop());
            count++;
        }
    }

     public void showNews(){
         newsTexture = new Texture[quantity];
         newsRegion = new TextureRegion[quantity];
         news = new News[quantity];
         newsFont = new Font[quantity];
         newsBorder = new NewsBorder[quantity];
         for(int i = 1; i<=quantity; i++) {
             newsTexture[i-1] = new Texture("data/news" + i + ".jpg");
             newsRegion[i-1] = new TextureRegion(newsTexture[i-1]);
             newsBorder[i-1] = new NewsBorder(newsBorderTextureRegion, i);
             news[i-1] = new News(newsRegion[i-1], this, newsBorder[i-1]);
             news[i-1].setShortcut(list.get(i-1).getShortDescription());
             news[i-1].setDescription(list.get(i-1).getFullDescription());
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
