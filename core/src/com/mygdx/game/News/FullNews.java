package com.mygdx.game.News;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
    private News doubleNews;

    public FullNews(TextureRegion region, News news) {
        super(region);
        this.news = news;
        this.doubleNews = news;
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        //news.setSize(this.getWidth()/1.5f, this.getHeight()/4f);
        news.setTop(this.getTop() - 0.03f);
        //news.setLeft(this.getLeft());
        news.draw(batch);
    }

    @Override
    public void resize(Rect worldBounds) {
            setHeightProportion(0.9f);
            setTop(worldBounds.getTop() - 0.01f);
    }

    public void returnNews(){
       // news.setSize(doubleNews.getWidth(), doubleNews.getHeight());
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
