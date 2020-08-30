package com.mygdx.game.Buttons;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.mygdx.game.Base.ScaledButton;
import com.mygdx.game.Screens.LsScreen;
import com.mygdx.game.math.Rect;


public class MessageButton extends ScaledButton {

    private Game game;
    private static final float MARGIN = 0.05f;

    public MessageButton(TextureRegion region, Game game) {
        super(region);
        this.game = game;

    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.05f);
        setRight(worldBounds.getRight());
        setTop(worldBounds.getTop() - 0.01f);
    }

    @Override
    public void action() {
        game.setScreen(new LsScreen(game));
    }
}
