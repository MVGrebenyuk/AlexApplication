package com.mygdx.game.Ads;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Base.ScaledButton;
import com.mygdx.game.math.Rect;

import java.io.IOException;

public class AdsButton extends ScaledButton {
    private Game game;

    public AdsButton(TextureRegion region, Game game) {
        super(region);
        this.game = game;

    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.1f);
        setRight(worldBounds.getLeft() + 0.20f);
        setBottom(worldBounds.getBottom());
    }

    @Override
    public void action() throws IOException {
        game.setScreen(new AdsScreen(game));
    }
}
