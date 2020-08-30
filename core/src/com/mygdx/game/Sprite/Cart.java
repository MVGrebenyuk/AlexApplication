package com.mygdx.game.Sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Base.Sprite;
import com.mygdx.game.math.Rect;

public class Cart extends Sprite {
    public Cart(Texture texture) {
        super(new TextureRegion(texture));
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.265f);
        setTop(worldBounds.getTop() - 0.28f);
        //this.pos.set(worldBounds.pos);
    }
}
