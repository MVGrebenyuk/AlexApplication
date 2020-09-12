package com.mygdx.game.News;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Base.Font;
import com.mygdx.game.Base.ScaledButton;
import com.mygdx.game.math.Rect;

import java.sql.SQLException;

public class News extends ScaledButton {

    private int count;
    private float step = 0.11f;

    //Составляющие новостей
    public String shortcut;
    public String description;
    public String title;
    public String newsImage;
    public NewsBorder newsBorder;


    public NewsScreen screen;
    public Font newsFont;

    public Font getNewsFont() {
        return newsFont;
    }

    public void setNewsFont(Font newsFont) {
        this.newsFont = newsFont;
    }

    public News(TextureRegion region, NewsScreen screen, NewsBorder border) {
        super(region);
        this.screen = screen;
        this.newsBorder = border;
        shortcut = " ";
        description = " ";
        title = " ";
    }

    @Override
    public boolean touchDragged(Vector2 touch, int pointer) {
        return super.touchDragged(touch, pointer);
    }

    public boolean posBorder(){
        pos.y = newsBorder.pos.y;
        return false;
    }

    @Override
    public void resize(Rect worldBounds) {
        setSize(newsBorder.getWidth()/3.5f, newsBorder.getHeight()/1.5f);
            //setHeightProportion(0.1f);
            setLeft(newsBorder.getLeft() + 0.02f);
            setTop(newsBorder.getTop() - 0.03f);
    }

    public String getNewsImage() {
        return newsImage;
    }

    public void setNewsImage(String newsImage) {
        this.newsImage = newsImage;
    }

    public String getShortcut() {
        return shortcut;
    }

    public void setShortcut(String shortcut) {
        this.shortcut = shortcut;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public void action() throws SQLException, ClassNotFoundException {
        screen.showFullNews(this);
    }
}
