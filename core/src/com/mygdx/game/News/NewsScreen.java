package com.mygdx.game.News;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mygdx.game.Base.Font;
import com.mygdx.game.Base.StartScreen;
import com.mygdx.game.Utils.NotificationHandler;
import com.mygdx.game.Utils.Parameters;
import com.mygdx.game.Utils.StrBuilder;
import com.mygdx.game.math.Rect;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import io.netty.handler.codec.serialization.ObjectDecoderInputStream;
import io.netty.handler.codec.serialization.ObjectEncoderOutputStream;



public class NewsScreen extends StartScreen {

    private Font[] newsFont;
    private Font[] tetleFont;
    private News[] news;
    private News fNews = null;
    private FullNews fullNews;
    private CloseNewsButton closeNewsButton;
    private NewsBorder[] newsBorder;
    private Texture newsBorderTexture;
    public int quantity; //
    private boolean showFullNewsFlag = false; //
    private Texture[] newsTexture;
    private Texture fullNewsScreenTexture;
    private Texture closeNewsButtontexture;
    private TextureRegion newsBorderTextureRegion;
    private TextureRegion[] newsRegion;
    private TextureRegion fullNewsScreenRegion;
    private TextureRegion closeNewsButtonRegion;
    private Game game;
    public Socket socket;//
    public ObjectDecoderInputStream is;//
    public ObjectEncoderOutputStream os;//
    private boolean reload = false;//
    private FileHandle handle = Gdx.files.local("/news.txt");//
    private Vector2 supTouch;
    private boolean block = false;
    private boolean drag = false;
    private float touchY;
    public NotificationHandler notificationHandler;


    private ArrayList<ServerNews> list = new ArrayList<>();
    private List<NewsServer> listNews;

    @Override
    public void setPageName(String pageName) {
        super.setPageName(pageName);
    }

    public NewsScreen(Game game, NotificationHandler notificationHandler) {
        super(game);
        this.game = game;
        this.notificationHandler = notificationHandler;

    }


    @Override
    public void show() {
        super.show();
        try {
            runDownloadNews();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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
        setPageName("< Новости");
    }

    private void createServerNews() {
        quantity = listNews.size();
        for (int i = 0; i <= quantity - 1; i++) {
            listNews.get(i).setShortDesc(StrBuilder.createShortDescr(listNews.get(i).getShortDesc()));
            listNews.get(i).setDescription(StrBuilder.createDescr(listNews.get(i).getDescription()));
        }

    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        fullNews.resize(worldBounds);
        closeNewsButton.resize(worldBounds);
        for (int i = 0; i <= quantity - 1; i++) {
            newsBorder[i].resize(worldBounds);
            news[i].resize(worldBounds);
            newsFont[i].setSize(0.014f);
            tetleFont[i].setSize(0.016f);
        }
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        drawl();
        drawTopMenu();
        drawBottomMenu();
        for (NewsBorder i : newsBorder) {
            i.update(delta);
        }
        for (News i : news) {
            i.update(delta);
        }
    }

    public void setBlock(boolean block) {
        this.block = block;
    }

    @Override
    public void dispose() {
        super.dispose();
    }


    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        if (drag != true) {
            touchY = touch.y;
            for (News i : news) {
                if (i.pos.y < -0.31f && block == false) {
                } else {
                    i.touchDown(touch, pointer, button);
                }
            }
        }
        closeNewsButton.touchDown(touch, pointer, button);
        return super.touchDown(touch, pointer, button);
    }


    @Override
    public boolean touchDragged(Vector2 touch, int pointer) {
        if (block == false) {
            drag = true;
            if (supTouch != touch && supTouch != null) {
                Vector2 dragged = new Vector2(supTouch.sub(touch));
                for (NewsBorder i : newsBorder) {
                    i.pos.y -= dragged.y;
                    /*Работающие, но некорректно способы скроллинга */
                    //is's work!//i.pos.sub(dragged);
                    //is's work!// i.pos.y -= (supTouch.y - touch.y);
                }
                /*if(i.isMe(touch)) {
                    i.dragged(touch);
                }*/
            }
            for (News i : news) {
                i.posBorder();
            }
            if (supTouch == null) {
                supTouch = new Vector2(touch);
            } else {
                supTouch.set(touch);
            }
        }
        if (newsBorder[0].getTop() < worldBounds.getTop() - 0.15f) {
            game.setScreen(new NewsScreen(this.game, notificationHandler));
            System.out.println("Новости обновлены");
        }
        return super.touchDragged(touch, pointer);
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) throws SQLException, ClassNotFoundException, IOException {
        if (touchY == touch.y) {
            for (News i : news) {
                i.touchUp(touch, pointer, button);
            }
        }
        closeNewsButton.touchUp(touch, pointer, button);
        System.out.println("TOUCH UP");
        supTouch = null;
        drag = false;
        return super.touchUp(touch, pointer, button);
    }

    @Override
    public void draw() {
        super.draw();
    }

    public void drawl() {
        batch.begin();
        createNews();
        if (showFullNewsFlag == true) {
            fullNews.draw(batch);
            closeNewsButton.draw(batch);
            fullNews.getNews().getNewsFont().draw(batch, fullNews.getNews().getDescription(), fullNews.getLeft() + 0.04f, fullNews.getTop() - 0.3f);
        }
        batch.end();
    }

    public void createNews() {
        int count = 0;
        for (NewsBorder i : newsBorder) {
            i.draw(batch);
        }
        for (News i : news) {
            i.draw(batch);
            newsFont[count].draw(batch, i.getShortcut(), i.getLeft() + 0.05f, i.getBottom() - 0.05f);
            tetleFont[count].draw(batch, i.getTitle(), i.getLeft() + 0.01f, i.getBottom() - 0.01f);
            count++;
        }
    }

    public void showNews() {
        newsTexture = new Texture[quantity];
        newsRegion = new TextureRegion[quantity];
        news = new News[quantity];
        newsFont = new Font[quantity];
        tetleFont = new Font[quantity];
        newsBorder = new NewsBorder[quantity];
        for (int i = 1; i <= quantity; i++) {
            try {
                newsTexture[i - 1] = new Texture("data/news" + i + ".jpg");
            } catch (Exception e) {
                newsTexture[i - 1] = new Texture("data/news" + 2 + ".jpg");
            }
            newsRegion[i - 1] = new TextureRegion(newsTexture[i - 1]);
            newsBorder[i - 1] = new NewsBorder(newsBorderTextureRegion, i, newsBorder[checkNull(i - 2)]);
            news[i - 1] = new News(newsRegion[i - 1], this, newsBorder[i - 1]);
            news[i - 1].setShortcut(listNews.get(i - 1).getShortDesc());
            news[i - 1].setDescription(listNews.get(i - 1).getDescription());
            news[i - 1].setTitle(listNews.get(i - 1).getTitle());
            newsFont[i - 1] = new Font("textNews.fnt", "textNews.png");
            tetleFont[i - 1] = new Font("adsTitle.fnt", "adsTitle.png");
            news[i - 1].setNewsFont(newsFont[i - 1]);
            news[i - 1].setTitleFont(tetleFont[i - 1]);
        }
        for (int i = 1; i <= quantity; i++) {
            newsBorder[i - 1].setNextBorder(newsBorder[checkNull(i)]);
        }
    }

    public int checkNull(int i) {
        int x = i;
        if (i <= 0) {
            x = 0;
        }
        if (i >= quantity) {
            x = quantity - 1;
        }
        return x;
    }

    public void showFullNews(News news) {
        showFullNewsFlag = true;
        fullNews.setNews(news);
    }

    public void closeFullNews() {
        showFullNewsFlag = false;
    }

    private void runDownloadNews() throws IOException, ClassNotFoundException {
                socket = Parameters.socket;
                os = Parameters.os;
                is = Parameters.is;
                String getNews = "/getNews";
                os.writeObject(getNews);
                String result = (String) is.readObject();
                handle.writeBytes(result.getBytes(), false);
                System.out.println("\n\n_______Новости загружены_____\n\n");
                ObjectMapper mapper = new ObjectMapper();
                listNews = mapper.readValue(result, new TypeReference<List<NewsServer>>() {
                });
                try {
                    System.out.println(listNews.get(0).getDescription());
                } catch (Exception e) {
                    System.out.println("Новостей нет");
                }
    }

}
