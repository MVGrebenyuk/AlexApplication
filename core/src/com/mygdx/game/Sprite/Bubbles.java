package com.mygdx.game.Sprite;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Base.Sprite;
import com.mygdx.game.math.Rect;
import com.mygdx.game.math.Rnd;


public class Bubbles extends Sprite {

    private Vector2 v;
    private Rect worldBounds;


    public Bubbles(TextureRegion region) {
        super(region);
        v = new Vector2();
        float vx = Rnd.nextFloat(-0.01f, 0.01f);
        float vy = Rnd.nextFloat(0.06f, 0.01f);
        v.set(vx, vy);
        worldBounds = new Rect();
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
        setHeightProportion(0.04f);
        float posX = Rnd.nextFloat(worldBounds.getLeft(), worldBounds.getRight());
        float posY = Rnd.nextFloat(worldBounds.getBottom(), worldBounds.getTop());
        pos.set(posX, posY);
    }

    @Override
    public void update(float delta) {
        pos.mulAdd(v , delta);
        checkBounds();
    }

    private void checkBounds() {
        if (getRight() < worldBounds.getLeft()) {
            setLeft(worldBounds.getRight());
        }
        if (getLeft() > worldBounds.getRight()) {
            setRight(worldBounds.getLeft());
        }
        if (getBottom() > worldBounds.getTop()) {
            setTop(worldBounds.getBottom());
        }
    }
}
