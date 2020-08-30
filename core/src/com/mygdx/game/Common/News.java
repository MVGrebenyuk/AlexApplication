package com.mygdx.game.Common;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Base.Sprite;
import com.mygdx.game.math.Rect;

import java.sql.SQLException;

public class News extends Sprite {

    private int count = 0;

    public News(TextureRegion region, int count) {
        super(region);
        this.count = count;
    }


    @Override
    public void resize(Rect worldBounds) {
        if(count == 1) {
            setHeightProportion(0.1f);
            setLeft(worldBounds.getLeft() + 0.01f);
            setTop(worldBounds.getTop() - 0.07f);
        } else if(count == 2){
            setHeightProportion(0.1f);
            setLeft(worldBounds.getLeft() + 0.01f);
            setTop(worldBounds.getTop() - 0.18f);
        }
    }

}
