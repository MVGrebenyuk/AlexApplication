package com.mygdx.game.Buttons;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Base.ScaledButton;
import com.mygdx.game.Screens.AdsScreen;
import com.mygdx.game.Screens.LsScreen;
import com.mygdx.game.math.Rect;

public class AdsButton extends ScaledButton {
    private Game game;
    private static final float MARGIN = 0.05f;
    private RulesButton but;

    public AdsButton(TextureRegion region, Game game) {
        super(region);
        this.game = game;

    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.07f);
        setRight(worldBounds.getRight() - 0.15f);
        setBottom(worldBounds.getBottom() + 0.01f);
    }

    @Override
    public void action() {
        game.setScreen(new AdsScreen(game));
    }
}
