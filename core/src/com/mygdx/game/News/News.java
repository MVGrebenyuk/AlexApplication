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
    public TextureRegion region;


    public NewsScreen screen;
    public Font newsFont;
    public Font titleFont;

    public Font getNewsFont() {
        return newsFont;
    }

    public void setNewsFont(Font newsFont) {
        this.newsFont = newsFont;
    }
    public void setTitleFont(Font newsFont) {
        this.titleFont = titleFont;
    }

    public News(TextureRegion region, NewsScreen screen, NewsBorder border) {
        super(region);
        this.screen = screen;
        this.newsBorder = border;
        this.region = region;
        shortcut = " ";
        description = " ";
        title = " ";
    }

    @Override
    public boolean touchDragged(Vector2 touch, int pointer) {
        return super.touchDragged(touch, pointer);
    }

    public boolean posBorder(){
        setTop(newsBorder.getTop());
        return false;
    }

    @Override
    public void resize(Rect worldBounds) {
        setSize(newsBorder.getWidth() - 0.01f, newsBorder.getHeight()/2);
            //setHeightProportion(0.1f);
            setLeft(newsBorder.getLeft() + 0.005f);
            setTop(newsBorder.getTop());
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

    public TextureRegion getRegion() {
        return region;
    }

    public NewsScreen getScreen() {
        return screen;
    }

    public NewsBorder getNewsBorder() {
        return newsBorder;
    }

    public void setNewsBorder(NewsBorder newsBorder) {
        this.newsBorder = newsBorder;
    }

    @Override
    public void action() throws SQLException, ClassNotFoundException {
        screen.showFullNews(this);
        screen.setBlock(true);
    }
}
