package com.mygdx.game.Buttons;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Base.ScaledButton;
import com.mygdx.game.Screens.LsScreen;
import com.mygdx.game.math.Rect;


public class MessageButton extends ScaledButton {

    private Game game;

    public MessageButton(TextureRegion region, Game game) {
        super(region);
        this.game = game;

    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.05f);
        setRight(worldBounds.getRight() - 0.15f);
        setBottom(worldBounds.getBottom() + 0.02f);
    }

    @Override
    public void action() {
        game.setScreen(new LsScreen(game));
    }
}
