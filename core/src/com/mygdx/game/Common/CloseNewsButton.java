package com.mygdx.game.Common;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Base.ScaledButton;
import com.mygdx.game.Screens.LsScreen;
import com.mygdx.game.Screens.NewsScreen;
import com.mygdx.game.math.Rect;

public class CloseNewsButton extends ScaledButton {

    private static final float MARGIN = 0.05f;
    private FullNews fnews;
    private NewsScreen screen;

    public CloseNewsButton(TextureRegion region, FullNews fnews, NewsScreen screen) {
        super(region);
        this.fnews = fnews;
        this.screen = screen;

    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.05f);
        setRight(fnews.getRight() - 0.005f);
        setTop(fnews.getTop() - 0.01f);
    }

    @Override
    public void action() {
        screen.closeFullNews();
    }
}
