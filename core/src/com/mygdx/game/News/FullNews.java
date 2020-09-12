package com.mygdx.game.News;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Base.Sprite;
import com.mygdx.game.math.Rect;

public class FullNews extends Sprite {

    private float step = 0.11f;

    //Составляющие новостей
    public String shortcut;
    public String description;
    public String title;
    private News news;

    public FullNews(TextureRegion region, News news) {
        super(region);
        this.news = news;
    }


    @Override
    public void resize(Rect worldBounds) {
            setHeightProportion(0.9f);
            setTop(worldBounds.getTop() - 0.01f);
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

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}
