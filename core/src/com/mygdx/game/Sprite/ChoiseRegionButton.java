package com.mygdx.game.Sprite;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Base.ScaledButton;
import com.mygdx.game.math.Rect;


public class ChoiseRegionButton extends ScaledButton {

    private Game game;

    public ChoiseRegionButton(TextureRegion region, Game game) {
        super(region);
        this.game = game;

    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.1f);
        setRight(worldBounds.getRight() - 0.01f);
        setTop(worldBounds.getTop() - 0.01f);
    }

    @Override
    public void action() {

    }
}
