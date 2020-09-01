package com.mygdx.game.Common;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Base.Font;
import com.mygdx.game.Base.ScaledButton;
import com.mygdx.game.Base.Sprite;
import com.mygdx.game.Screens.NewsScreen;
import com.mygdx.game.math.Rect;

import java.sql.SQLException;

public class News extends ScaledButton {

    private int count;
    private float step = 0.11f;

    //Составляющие новостей
    public String shortcut;
    public String description;
    public String title;

    public NewsScreen screen;
    public Font newsFont;

    public Font getNewsFont() {
        return newsFont;
    }

    public void setNewsFont(Font newsFont) {
        this.newsFont = newsFont;
    }

    public News(TextureRegion region, int count, NewsScreen screen) {
        super(region);
        this.count = count;
        this.screen = screen;
        shortcut = " ";
        description = " ";
        title = " ";
    }


    @Override
    public void resize(Rect worldBounds) {
        if(count == 1) {
            setHeightProportion(0.1f);
            setLeft(worldBounds.getLeft() + 0.01f);
            setTop(worldBounds.getTop() - 0.07f);
        } else if(count > 1){
            setHeightProportion(0.1f);
            setLeft(worldBounds.getLeft() + 0.01f);
            setTop(worldBounds.getTop() - (0.07f + step * (count - 1)));
        } else {
            setHeightProportion(0.1f);
            setTop(worldBounds.getTop());
        }
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
