package com.mygdx.game.Common;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.mygdx.game.Base.ScaledButton;
import com.mygdx.game.Screens.NewsScreen;
import com.mygdx.game.math.Rect;


public class NewsButton extends ScaledButton {

    private Game game;

    public NewsButton(TextureRegion region, Game game) {
        super(region);
        this.game = game;

    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.07f);
        setBottom(worldBounds.getBottom() + 0.01f);
    }

    @Override
    public void update(float delta) {
        super.update(delta);
    }

    @Override
    public void action() {
        game.setScreen(new NewsScreen(game));
    }

}
